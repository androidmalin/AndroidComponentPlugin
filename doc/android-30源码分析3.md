android-30源码分析
~/sdk/sources/android-30/

探究 ContextWrapper中 Context mBase 成员变量的值
a.准备
0.
 getApplicationContext().startActivity(intent);


1.
Context.java
`public abstract void startActivity(Intent intent);`
`startActivity`是抽象方法,需要找到它的实现方法.
实现方法在`ContextWrapper.java`中

2.ContentWrapper.java
```java
Context mBase;
@Override
public void startActivity(Intent intent) {
   mBase.startActivity(intent);
}
```
在`ContentWrapper`中`startActivity`方法调用了`mBase`的`startActivity`方法.
查看`mBase`被声明为`Context`类型了,而`Context`是一个抽象类.

在`ContentWrapper`类中查看代码, 寻找mBase初始化的地方,在源码注释出,可以找到是在
`attachBaseContext`方法处初始化的.
```java
Context mBase;
protected void attachBaseContext(Context base) {
   mBase = base;
}
```

3.现在需要跟踪`ContentWrapper`类`attachBaseContext(Context base)`方法的调用流程了.

4.下面通过debug, 设置断点, 逆向查看出调用关系链条.
请看content2.md文章分析.正向调用流程.