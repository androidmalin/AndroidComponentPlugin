package com.malin.hook

import android.app.Application
import android.content.Context
import android.os.Build
import android.util.Log
import com.malin.plugin.impl.PluginImpl
import org.chickenhook.restrictionbypass.Unseal
import org.lsposed.hiddenapibypass.HiddenApiBypass

class MApplication : Application() {
    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)
        unseal(false)
    }

    override fun onCreate() {
        super.onCreate()
        PluginImpl.init(context = baseContext, instrumentation = false, firstMode = true)
    }

    private fun unseal(boolean: Boolean = true) {
        if (boolean) {
            try {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                    HiddenApiBypass.addHiddenApiExemptions("");
                }
            } catch (e: Throwable) {
                e.printStackTrace()
                Log.e(PluginImpl::class.java.simpleName, "Unable to unseal hidden api access", e)
            }
        } else {
            try {
                Unseal.unseal()
            } catch (e: Throwable) {
                e.printStackTrace()
                Log.e(PluginImpl::class.java.simpleName, "Unable to unseal hidden api access", e)
            }
        }
    }
}
