### Android上简单实现Activity和Service的插件化, 启动未在AndroidManifest.xml中注册的Activity,Service;

| 版本\组件 | Activity | Service |
| :----: | :----:  | :----: |
| android15 | ✅ | ✅ |
| android16 | ✅ | ✅ |
| android17 | ✅ | ✅ |
| android18 | ✅ | ✅ |
| android19 | ✅ | ✅ |
| android20 | ✅ | ✅ |
| android21 | ✅ | ✅ |
| android22 | ✅ | ✅ |
| android23 | ✅ | ✅ |
| android24 | ✅ | ✅ |
| android25 | ✅ | ✅ |
| android26 | ✅ | ✅ |
| android27 | ✅ | ✅ |
| android28 | ✅ | ✅ |
| android29 | ✅ | ✅ |

✅表示测试通过.

适配了Android4-10,四大组件中的Activity和Service的插件化; 要彻底搞清楚代码,需要提前掌握的知识点如下:
0. [反射的使用1](https://blog.csdn.net/gdutxiaoxu/article/details/68947735)
1. [反射的使用2](https://www.geeksforgeeks.org/reflection-in-java/)
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

4. Hook AMS和Hook Instrumentation两种方式的区别?

5. [为什么偶尔出现pre-verified异常?](https://github.com/wequick/Small/wiki/Android-FAQ)
这个问题属于dex热修复范畴。首先出现这个问题的充分条件：
    (1) 一个“独善其身”的A.dex（所有的类引用都在本dex内，没有跨dex调用）
    (2) 另一个B.dex包含(1)中的某个类XiaoMing
    (3) 一个类加载器同时加载了(1)跟(2)，查找时(2)优先于(1)
当程序试图调用XiaoMing时，在B中发现了，但是回头一看XiaoMing早已被A包养了。遂崩溃。
通常我们并不满足(1)。插件并非独立的，或多或少依赖于宿主包或者公共库，难以“独善其身”，无法被打上CLASS_ISPREVERIFIED标签。
当出现这个问题时，请确认在不同的插件中是否引用了同一个第三方库或者其不同版本。


### 参考文章列表
1. [Android：学习AIDL，这一篇文章就够了(上)](https://blog.csdn.net/luoyanglizi/article/details/51980630)
2. [Android：学习AIDL，这一篇文章就够了(下)](https://blog.csdn.net/luoyanglizi/article/details/52029091)
3. [大白话说Java反射：入门、使用、原理](https://www.cnblogs.com/chanshuyi/p/head_first_of_reflection.html)
4. [Android 插件化原理解析——Hook机制之AMS&PMS](http://weishu.me/2016/03/07/understand-plugin-framework-ams-pms-hook/)
5. [Android系统篇之----Hook系统的AMS服务实现应用启动的拦截功能](http://www.520monkey.com/archives/867)
6. [Android插件化的兼容性（中）：Android P的适配](https://www.cnblogs.com/Jax/p/9521305.html)
7. [Android Hook Activity 的几种姿势](https://blog.csdn.net/gdutxiaoxu/article/details/81459910)
