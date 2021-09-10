package com.malin.hook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * https://www.zybuluo.com/dodola/note/814116
 * <p>
 * http://www.zircon.me/05-07-2018/android-VirtualAPK-analysis.html
 *
 * <p>
 * https://www.notion.so/VirtualAPK-1fce1a910c424937acde9528d2acd537
 * <p>
 * https://android.googlesource.com/platform/frameworks/base/+/android-4.4.2_r2.0.1/libs/androidfw/AssetManager.cpp#155
 * <p>
 * https://android.googlesource.com/platform/frameworks/base.git/+/android-4.4.2_r2.0.1/core/jni/android_util_AssetManager.cpp
 * <p>
 * https://android.googlesource.com/platform/frameworks/base/+/android-4.4.2_r2.0.1/core/java/android/content/res/AssetManager.java#751
 * <p>
 * http://www.zircon.me/05-07-2018/android-VirtualAPK-analysis.html
 * <p>
 * [VirtualApk解决插件资源ID与宿主冲突的问题]
 * http://susion.work/2019/03/13/android%E6%BA%90%E7%A0%81%E5%88%86%E6%9E%90/%E6%8F%92%E4%BB%B6%E5%8C%96/VirtualApk%E8%A7%A3%E5%86%B3%E6%8F%92%E4%BB%B6%E8%B5%84%E6%BA%90ID%E4%B8%8E%E5%AE%BF%E4%B8%BB%E5%86%B2%E7%AA%81%E7%9A%84%E9%97%AE%E9%A2%98/
 * <p>
 * [Android资源的插件化](https://www.jianshu.com/p/e09fc4482c7b)
 */
@SuppressWarnings("JavaReflectionMemberAccess")
public class ReSourceUtil {

    @SuppressLint("PrivateApi")
    public static synchronized Resources createResources(Context hostContext, String apk) {
        Resources hostResources = hostContext.getResources();
        try {
            AssetManager assetManager = hostResources.getAssets();

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                // 我们需要将应用原来加载的地址取出来，详情见①
                // 由于我们将host的AssetManager已经destroy后，需要还原原来的地址，否则就会发生找不到资源的情况，
                // 此时需要提前将host加载的资源路径全部取出来，理论上，这个过程系统是做了一部分的，当我们调用init方法的时候
                List<String> cookieNames = new ArrayList<>();
                int stringBlockCount = (int) ReflectUtil.invoke(AssetManager.class, assetManager, "getStringBlockCount");
                Method getCookieNameMethod = AssetManager.class.getDeclaredMethod("getCookieName", Integer.TYPE);
                getCookieNameMethod.setAccessible(true);

                for (int i = 0; i < stringBlockCount; i++) {
                    String cookieName = (String) getCookieNameMethod.invoke(assetManager, new Object[]{i + 1});
                    cookieNames.add(cookieName);
                }
                ReflectUtil.invoke(AssetManager.class, assetManager, "destroy");
                ReflectUtil.invoke(AssetManager.class, assetManager, "init");

                // ②③引用：它记录了之前加载过的所有资源包中的String Pool，很多时候访问字符串是从此处来的，如果不重新构造就会导致崩溃
                ReflectUtil.setField(AssetManager.class, assetManager, "mStringBlocks", null);//②

                // 将原来的assets添加进去，有了此步骤就不用刻意添加sourceDir了
                for (String path : cookieNames) {
                    ReflectUtil.invoke(AssetManager.class, assetManager, "addAssetPath", path);
                }

                // 插入插件的资源地址
                ReflectUtil.invoke(AssetManager.class, assetManager, "addAssetPath", apk);

                ReflectUtil.invoke(AssetManager.class, assetManager, "ensureStringBlocks");//③

                // ④：过程中很重要的一步，因为后面在资源查找的时候是需要通过一个ResTable_config来获取当前手机的一些配置从而获取到准确的资源，
                // 如果不进行初始化则会出现找不到资源的崩溃
                hostResources.updateConfiguration(hostResources.getConfiguration(), hostResources.getDisplayMetrics());//此行代码非常重要④
            } else {
                ReflectUtil.invoke(AssetManager.class, assetManager, "addAssetPath", apk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hostResources;
    }
}
