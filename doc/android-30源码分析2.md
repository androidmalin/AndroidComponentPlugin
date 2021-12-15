android-30源码分析
~/sdk/sources/android-30/

探究 ContextWrapper中 Context mBase 成员变量的值

### 1.ActivityThread
```java
private Activity performLaunchActivity(ActivityClientRecord r, Intent customIntent){//line: [3330]
    LoadedApk#makeApplication(false, mInstrumentation) //line: [3370]
}
```

### 2.LoadedApk ==> new ContextImpl
```java
public Application makeApplication(boolean a,Instrumentation i){//line: [1196]
    ContextImpl appContext = ContextImpl.createAppContext(mActivityThread, this);//line: [1232]
    mInstrumentation#newApplication(cl, appClass, appContext);//line: [1236]
}
```

### 3.Instrumentation
```java
public Application newApplication(ClassLoader cl, String className, Context context){//line: [1154]
    Application app = getFactory(context.getPackageName()).instantiateApplication(cl, className);//line: [1157]
    app.attach(context);//line: [1159]
}
```

### 4.Application
```java
final void attach(Context context){//line: [350]
    //调用父类ContextWrapper#attachBaseContext()方法
    attachBaseContext(context);//line: [351]
}
```

### 5.ContextWrapper
```java
Context mBase;//line: [63]
protected void attachBaseContext(Context base){//line: [76]
     mBase = base;//line: [80]
}
```
到此为止, 我们知道了`mBase`的实例是`LoadedApk`中生成的`ContextImpl`对象