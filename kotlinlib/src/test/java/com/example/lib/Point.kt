package com.example.lib

/**
 * 这个是刚才上面例子中使用到的Point类，
 * 上面也说到解构声明的变量最后都要调用对象的componentN 方法，
 * 所以要想让一个类的对象支持解构声明，就必须实现componentN 方法，
 * 同时方法前需要加上operator关键字。
 * data class 自动实现了相关方法支持解构声明，
 * 所以data class 实际上自动生成了很多方法，
 * 在Android开发中有方法数限制，需要注意。
 */
class Point(var x: Int, var y: Int) {

    operator fun component1() = x

    operator fun component2() = y
}