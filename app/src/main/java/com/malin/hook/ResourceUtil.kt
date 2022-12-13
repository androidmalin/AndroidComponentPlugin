package com.malin.hook

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.AssetManager
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.util.DisplayMetrics

/**
 * 插件可以访问宿主的资源.
 * 插件调用宿主资源则需要将宿主的APK和插件的APK一起添加到同一个AssetManager里.
 * https://www.zybuluo.com/dodola/note/814116
 * https://www.notion.so/VirtualAPK-1fce1a910c424937acde9528d2acd537
 * https://android.googlesource.com/platform/frameworks/base/+/android-4.4.2_r2.0.1/libs/androidfw/AssetManager.cpp#155
 * https://android.googlesource.com/platform/frameworks/base.git/+/android-4.4.2_r2.0.1/core/jni/android_util_AssetManager.cpp
 * https://android.googlesource.com/platform/frameworks/base/+/android-4.4.2_r2.0.1/core/java/android/content/res/AssetManager.java#751
 * http://www.zircon.me/05-07-2018/android-VirtualAPK-analysis.html
 * [VirtualApk解决插件资源ID与宿主冲突的问题](https://github.com/SusionSuc/AdvancedAndroid/tree/master/plugin/VirtualApk/)
 * [Android资源的插件化](https://www.jianshu.com/p/e09fc4482c7b)
 */
object ResourceUtil {
    fun createResources(hostContext: Context, apk: String?): Resources? {
        val version: Int = Build.VERSION.SDK_INT
        val resource: Resources? = when {
            version < Build.VERSION_CODES.LOLLIPOP -> { // 15 <= api < 21
                getPluginResourceForAndroidL(hostContext, apk)
            }
            version < Build.VERSION_CODES.N -> { // 21 <= api < 24
                getPluginResourceForAndroidM(hostContext, apk)
            }
            else -> { // 24 <= api < 32
                getPluginResourceForAndroidS(hostContext, apk)
            }
        }
        return resource
    }

    // Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP
    private fun getPluginResourceForAndroidL(hostContext: Context, apk: String?): Resources {
        val hostResources = hostContext.resources
        val assetManager = hostResources!!.assets
        val assetManagerClazz: Class<*> = assetManager.javaClass
        // 我们需要将应用原来加载的地址取出来，详情见①
        // 由于我们将host的AssetManager已经destroy后，需要还原原来的地址，否则就会发生找不到资源的情况，
        // 此时需要提前将host加载的资源路径全部取出来，理论上，这个过程系统是做了一部分的，当我们调用init方法的时候
        val cookieNames: MutableList<String> = ArrayList()

        // private native final int getStringBlockCount();
        val stringBlockCount = assetManagerClazz.getDeclaredMethod("getStringBlockCount")
            .also { it.isAccessible = true }.invoke(assetManager) as Int

        // public native final String getCookieName(int cookie);
        val getCookieNameMethod =
            AssetManager::class.java.getDeclaredMethod("getCookieName", Integer.TYPE)
                .also { it.isAccessible = true }

        for (i in 0 until stringBlockCount) {
            cookieNames.add(getCookieNameMethod.invoke(assetManager, i + 1) as String)
        }

        // private native final void destroy();
        assetManagerClazz.getDeclaredMethod("destroy").also { it.isAccessible = true }
            .invoke(assetManager)

        // private native final void init();
        assetManagerClazz.getDeclaredMethod("init").also { it.isAccessible = true }
            .invoke(assetManager)

        // ②③引用：它记录了之前加载过的所有资源包中的String Pool，很多时候访问字符串是从此处来的，如果不重新构造就会导致崩溃
        // private StringBlock mStringBlocks[] = null;
        assetManagerClazz.getDeclaredField("mStringBlocks")
            .also { it.isAccessible = true }[assetManager] = null //②

        // public final int addAssetPath(String path) {...}
        @SuppressLint("DiscouragedPrivateApi")
        val addAssetPathMethod =
            assetManagerClazz.getDeclaredMethod("addAssetPath", String::class.java)
                .also { it.isAccessible = true }

        // 将原来的assets添加进去，有了此步骤就不用刻意添加sourceDir了
        for (path in cookieNames) {
            addAssetPathMethod.invoke(assetManager, path)
        }

        // 插入插件的资源地址
        addAssetPathMethod.invoke(assetManager, apk)

        // final void ensureStringBlocks() {} //③
        assetManagerClazz.getDeclaredMethod("ensureStringBlocks")
            .also { it.isAccessible = true }.invoke(assetManager)

        // 4：过程中很重要的一步，因为后面在资源查找的时候是需要通过一个ResTable_config来获取当前手机的一些配置从而获取到准确的资源，
        // 如果不进行初始化则会出现找不到资源的崩溃
        @Suppress("DEPRECATION")
        hostResources.updateConfiguration(
            hostResources.configuration,
            hostResources.displayMetrics
        ) //此行代码非常重要4.

        return hostResources
    }

    @SuppressLint("DiscouragedPrivateApi")
    private fun getPluginResourceForAndroidM(
        hostContext: Context,
        pluginPath: String?,
    ): Resources? {
        try {
            val assetManager = AssetManager::class.java.newInstance()
            assetManager.javaClass.getDeclaredMethod("addAssetPath", String::class.java)
                .also { it.isAccessible = true }
                .invoke(assetManager, pluginPath)
            val superRes = hostContext.resources

            @Suppress("DEPRECATION")
            return Resources(assetManager, superRes.displayMetrics, superRes.configuration)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        return null
    }

    @SuppressLint("DiscouragedPrivateApi")
    private fun getPluginResourceForAndroidS(context: Context, pluginPath: String?): Resources? {
        try {
            //1.调用assetManager.addAssetPath(pluginPath);
            val assetManager = AssetManager::class.java.newInstance()
            assetManager.javaClass.getDeclaredMethod("addAssetPath", String::class.java)
                .also { it.isAccessible = true }
                .invoke(assetManager, pluginPath)
            val superRes = context.resources

            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                //Resources#public void setImpl(ResourcesImpl impl) {}
                @SuppressLint("PrivateApi")
                val displayAdjustmentsClazz = Class.forName("android.view.DisplayAdjustments")

                val displayAdjustmentsObj = displayAdjustmentsClazz.getDeclaredConstructor()
                    .also { it.isAccessible = true }.newInstance()

                // new ResourcesImpl(AssetManager assets, DisplayMetrics metrics, Configuration config, DisplayAdjustments displayAdjustments) {}
                @SuppressLint("PrivateApi")
                val resourcesImplClazz = Class.forName("android.content.res.ResourcesImpl")
                val resourcesImplConstructor = resourcesImplClazz.getDeclaredConstructor(
                    AssetManager::class.java,
                    DisplayMetrics::class.java,
                    Configuration::class.java,
                    displayAdjustmentsClazz
                ).also { it.isAccessible = true }

                val resourcesImplObj = resourcesImplConstructor.newInstance(
                    assetManager,
                    superRes.displayMetrics,
                    superRes.configuration,
                    displayAdjustmentsObj
                )

                //private Resources() {}
                val resourcesClazz = Class.forName("android.content.res.Resources")
                val resourcesObj =
                    resourcesClazz.getDeclaredConstructor().also { it.isAccessible = true }
                        .newInstance()

                // Resources.java
                // public void setImpl(ResourcesImpl impl) {}
                // resources.setImpl(ResourcesImpl impl){}
                resourcesClazz.getDeclaredMethod("setImpl", resourcesImplClazz)
                    .also { it.isAccessible = true }
                    .invoke(resourcesObj, resourcesImplObj)

                resourcesObj as Resources
            } else {
                @Suppress("DEPRECATION")
                Resources(assetManager, superRes.displayMetrics, superRes.configuration)
            }
        } catch (e: Throwable) {
            e.printStackTrace()
        }
        return null
    }
}
