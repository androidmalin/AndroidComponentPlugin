package com.malin.hook;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ClipData;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author weishu
 * malin modify add note
 * test android15-android29 通过
 * http://weishu.me/2016/02/16/understand-plugin-framework-binder-hook/
 * http://www.520monkey.com/archives/861
 */
@SuppressLint("PrivateApi")
class BinderHookHelper {

    @SuppressLint("DiscouragedPrivateApi")
    static void hookClipboardService() throws Exception {

        final String CLIPBOARD_SERVICE = "clipboard";

        // 下面这一段的意思实际就是: ServiceManager.getService("clipboard");
        // 只不过 ServiceManager这个类是@hide的
        // package android.os;
        // public final class ServiceManager {}
        Class<?> serviceManagerClazz = Class.forName("android.os.ServiceManager");

        // ServiceManager
        // public static IBinder getService(String name) {}
        Method getServiceMethod = serviceManagerClazz.getDeclaredMethod("getService", String.class);
        getServiceMethod.setAccessible(true);

        // ServiceManager里面管理的原始的Clipboard Binder对象
        // 一般来说这是一个Binder代理对象
        // public static IBinder getService(String name) {}
        IBinder rawBinder = (IBinder) getServiceMethod.invoke(null, CLIPBOARD_SERVICE);

        // Hook 掉这个Binder代理对象的 queryLocalInterface 方法
        // 然后在 queryLocalInterface 返回一个IInterface对象, hook掉我们感兴趣的方法即可.
        IBinder hookedBinder = (IBinder) Proxy.newProxyInstance(
                serviceManagerClazz.getClassLoader(),
                new Class<?>[]{IBinder.class},
                new BinderProxyHookHandler(rawBinder)
        );

        // 把这个hook过的Binder代理对象放进ServiceManager的cache里面
        // 以后查询的时候 会优先查询缓存里面的Binder, 这样就会使用被我们修改过的Binder了
        // android.os.ServiceManager
        // private static Map<String, IBinder> sCache = new ArrayMap<String, IBinder>();
        Field sCacheField = serviceManagerClazz.getDeclaredField("sCache");
        sCacheField.setAccessible(true);

        @SuppressWarnings("unchecked")
        Map<String, IBinder> cache = (Map<String, IBinder>) sCacheField.get(null);
        if (cache == null) return;
        cache.put(CLIPBOARD_SERVICE, hookedBinder);
    }

    /**
     * 由于ServiceManager里面的sCache里面存储的 IBinder类型基本上都是BinderProxy
     * 因此, ServiceManager的使用者调用getService之后不会直接使用这个map
     * 而是先将他使用asInterface转成需要的接口
     * <p/>
     * asInterface函数的代码告诉我们, 它会先使用这个BinderPRoxy查询本进程是否有Binder对象
     * 如果有就使用本地的, 这里恰好就是一个hook点
     * <p/>
     * 我们让所有的查询都返回一个"本地Binder"对象
     * <p/>
     * 当然,这是一个假象, 我们给它返回的Binder对象自然是符合要求的(要么是本地Binder,要么是Binder代理)
     * 只不过,我们对需要hook的API做了处理
     * <p/>
     * 这个类仅仅Hook掉这个关键的 queryLocalInterface 方法
     */
    @SuppressLint("PrivateApi")
    private static class BinderProxyHookHandler implements InvocationHandler {

        private static final String TAG = "BinderProxyHookHandler";

        // 绝大部分情况下,这是一个BinderProxy对象
        // 只有当Service和我们在同一个进程的时候才是Binder本地对象
        // 这个基本不可能
        private final IBinder iBinder;

        private Class<?> stub;

        private Class<?> iInterface;

        BinderProxyHookHandler(IBinder iBinder) {
            this.iBinder = iBinder;
            try {
                this.stub = Class.forName("android.content.IClipboard$Stub");
                this.iInterface = Class.forName("android.content.IClipboard");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if ("queryLocalInterface".equals(method.getName())) {

                Log.d(TAG, "hook queryLocalInterface");


                // public interface IClipboard extends android.os.IInterface {
                //      abstract class Stub extends android.os.Binder implements android.content.IClipboard {
                //              public static android.content.IClipboard asInterface(android.os.IBinder obj) {
                //              }
                //      }
                //}
                Method asInterfaceMethod = stub.getDeclaredMethod("asInterface", IBinder.class);

                //生成本地端的中间者
                Object iClipboardObj = asInterfaceMethod.invoke(null, iBinder);


                // 这里直接返回真正被Hook掉的Service接口
                // 这里的 queryLocalInterface 就不是原本的意思了
                // 我们肯定不会真的返回一个本地接口, 因为我们接管了 asInterface方法的作用
                // 因此必须是一个完整的 asInterface 过的 IInterface对象, 既要处理本地对象,也要处理代理对象
                // 这只是一个Hook点而已, 它原始的含义已经被我们重定义了; 因为我们会永远确保这个方法不返回null
                // 让 IClipboard.Stub.asInterface 永远走到if语句的else分支里面
                return Proxy.newProxyInstance(
                        proxy.getClass().getClassLoader(),

                        // asInterface 的时候会检测是否是特定类型的接口然后进行强制转换
                        // 因此这里的动态代理生成的类型信息的类型必须是正确的

                        // 这里面Hook的是一个BinderProxy对象(Binder代理) (代理Binder的queryLocalInterface正常情况下是返回null)
                        // 因此, 正常情况下 在asInterface里面会由于BinderProxy的queryLocalInterface返回null导致系统创建一个匿名的代理对象, 这样我们就无法控制了
                        // 所以我们要伪造一个对象, 瞒过这个if检测, 使得系统把这个queryLocalInterface返回的对象透传给asInterface的返回值;
                        // 检测有两个要求, 其一: 非空, 其二, IXXInterface类型。
                        // 所以, 其实返回的对象不需要是Binder对象, 我们把它当作普通的对象Hook掉就ok(拦截这个对象里面对于IXXInterface相关方法的调用)
                        // tks  jeremyhe_cn@qq.com
                        new Class[]{this.iInterface},
                        new BinderHookHandler(iClipboardObj));
            }

            Log.d(TAG, "method:" + method.getName());
            return method.invoke(iBinder, args);
        }
    }

    public static class BinderHookHandler implements InvocationHandler {

        private static final String TAG = "BinderHookHandler";

        // 原始的Service对象 (IInterface)
        private Object iClipboard;

        BinderHookHandler(Object iClipboard) {
            try {
                this.iClipboard = iClipboard;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @TargetApi(Build.VERSION_CODES.HONEYCOMB)
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            // 把剪切版的内容替换为 "you are hooked"
            if ("getPrimaryClip".equals(method.getName())) {
                Log.d(TAG, "hook getPrimaryClip");
                return ClipData.newPlainText(null, "you are hooked");
            }

            // 欺骗系统,使之认为剪切版上一直有内容
            if ("hasPrimaryClip".equals(method.getName())) {
                Log.d(TAG, "hook hasPrimaryClip");
                return true;
            }
            return method.invoke(iClipboard, args);
        }
    }
}
