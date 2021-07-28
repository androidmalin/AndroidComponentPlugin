package com.malin.hook

import org.junit.jupiter.api.Test

class FunctionTest {

    @Test
    fun testJavaCall() {
        val obj = JavaObject()
        val any = obj["xx"]
        println(any)
    }

    /**
     * 函数声明
     * Kotlin 中的函数使用 fun 关键字声明：
     */
    private fun commonFunction(x: Int): Int {
        return 2 * x
    }

    /**
     * 参数
     * 函数参数使用 Pascal 表示法定义，即 name: type。参数用逗号隔开。
     *
     * 默认参数
     * 函数参数可以有默认值，当省略相应的参数时使用默认值。与其他语言相比，这可以减少重载数量：
     */
    private fun commonFunctionArg(b: Array<Byte>, off: Int = 0) {

    }

    @Test
    fun test2() {
        //使用默认值 num = 0
        foo(baz = 1)
    }

    private fun foo(num: Int = 0, baz: Int) {
        /*……*/
        println("num=$num baz=$baz")
    }


    /**
     * 如果在默认参数之后的最后一个参数是 lambda 表达式，
     * 那么它既可以作为具名参数在括号内传入，也可以在括号外传入
     */
    @Test
    fun test3() {
        fooLambda(num = 1, qux = { println("111") })
        fooLambda(qux = { println("222") })
        fooLambda { println("333") }
    }


    private fun fooLambda(num: Int = 0, qux: () -> Unit) {
        /*……*/
        println("num=$num")
        qux()
    }


    @Test
    fun test() {
        //调用函数使用传统的方法：
        println(commonFunction(10))
        println(commonFunction(11))

        //调用成员函数使用点表示法：

        //参数
        //函数参数使用 Pascal 表示法定义， 即 name: type。
        //参数用逗号隔开。 每个参数必须有显式类型：
        //fun powerOf(number: Int, exponent: Int): Int { /*……*/ }

    }

}