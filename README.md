### Android ams hook, 启动未在AndroidManifest.xml中注册的Activity

适配了Android4-9,要彻底搞清楚代码,需要提前掌握的知识点如下:
1. [反射的使用](https://blog.csdn.net/gdutxiaoxu/article/details/68947735)
2. [泛型](https://blog.csdn.net/s10461/article/details/53941091)
3. [动态代理](https://blog.csdn.net/u011784767/article/details/78281384)
4. [AIDL通信](https://blog.csdn.net/luoyanglizi/article/details/51980630)
5. [Activity启动流程以及其中涉及到的两次跨进程通信](https://blog.csdn.net/jiangwei0910410003/article/details/52549333)
6. [Handler消息处理机制](https://blog.csdn.net/guolin_blog/article/details/9991569)
7. [Activity启动拦截](https://blog.csdn.net/jiangwei0910410003/article/details/52550147)


### 问题思考
1. 如何确保我们启动的未注册的Activity,有正常的Activity的生命周期?

[源码探索系列29---插件化基础之启动插件的Activity](http://sanjay-f.github.io/2016/04/01/%E6%BA%90%E7%A0%81%E6%8E%A2%E7%B4%A2%E7%B3%BB%E5%88%9729---%E6%8F%92%E4%BB%B6%E5%8C%96%E5%9F%BA%E7%A1%80%E4%B9%8B%E5%90%AF%E5%8A%A8%E6%8F%92%E4%BB%B6%E7%9A%84Activity/)

2. 从整体宏观的角度看,我们到底做了什么?

3. 对PackageManager的hook,为什么要hook两个地方

[hook技术(三)对AMS&PMS进行Hook](https://blog.csdn.net/wangwei708846696/article/details/79525467)

```java
@Override
public PackageManager getPackageManager() {
    if (mPackageManager != null) {
        return mPackageManager;
    }
    IPackageManager pm = ActivityThread.getPackageManager();
    if (pm != null) {
        return (mPackageManager = new ApplicationPackageManager(this, pm));
    }
    return null;
}
```

由于系统的执行肯定在我们代码之前，所以系统先生成了一个pm，这个是原生的pm然后保存在ApplicationPackageManager中，
使得以后使用ContextImp.getPackageManager()都返回这个IPackageManager 对象。
就算我们后来替换了ActivityThread.getPackageManager()，但是也不影响mPackageManager 里面之前包装好的。
所以我们还需要改变mPackageManager 里面的原来的pm对象。



### 参考文章列表
1. [Android：学习AIDL，这一篇文章就够了(上)](https://blog.csdn.net/luoyanglizi/article/details/51980630)
2. [Android：学习AIDL，这一篇文章就够了(下)](https://blog.csdn.net/luoyanglizi/article/details/52029091)
3. [大白话说Java反射：入门、使用、原理](https://www.cnblogs.com/chanshuyi/p/head_first_of_reflection.html)
4. [Android 插件化原理解析——Hook机制之AMS&PMS](http://weishu.me/2016/03/07/understand-plugin-framework-ams-pms-hook/)
5. [Android系统篇之----Hook系统的AMS服务实现应用启动的拦截功能](https://blog.csdn.net/jiangwei0910410003/article/details/52550147)
6. [Android插件化的兼容性（中）：Android P的适配](https://www.cnblogs.com/Jax/p/9521305.html)
7. [Android Hook Activity 的几种姿势](https://blog.csdn.net/gdutxiaoxu/article/details/81459910)
