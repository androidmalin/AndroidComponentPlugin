package com.malin.hook

import org.junit.jupiter.api.Test

class Lambda {


    /**
     * accumulator 累加器
     * combine 合并
     * initial 最初的
     * element 元素
     */
    /**
     * 高阶函数是将函数作为参数或返回函数的函数。
     * 高阶函数的一个很好的例子是集合的函数式编程习惯用法fold。
     * 它接受一个初始累加器值和一个组合函数，
     * 并通过将当前累加器值与每个集合元素连续组合来构建其返回值，每次替换累加器值：
     */


    private fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (acc: R, nextElement: T) -> R
    ): R {
        var accumulator: R = initial
        for (element: T in this) {
            accumulator = combine(accumulator, element)
        }
        return accumulator
    }

    @Test
    fun test() {
        val items = listOf(1, 2, 3, 4, 5)
        val fold = items.fold(0, { acc: Int, i: Int ->
            acc + i
        })
        println(fold)
    }


    /**
     * 在上面的代码中，combine参数具有功能类型 (R, T) -> R，所以它接受一个函数，
     * 它的类型两个参数R和T返回类型的值R。
     *
     * 它在循环内被调用for，然后将返回值分配给accumulator。
     * 要调用fold，您需要将函数类型的实例作为参数传递给它，
     * 并且 lambda 表达式（在下面更详细地描述）在高阶函数调用站点中广泛用于此目的：
     */
    @Test
    fun test1() {
        val items = listOf(1, 2, 3, 4, 5)

        // Lambdas are code blocks enclosed in curly braces.
        val fold = items.fold(0, {
            // When a lambda has parameters, they go first, followed by '->'
                acc: Int, i: Int ->
            print("acc = $acc, i = $i, ")
            val result = acc + i
            println("result = $result")
            // The last expression in a lambda is considered the return value:
            result
        })
        println(fold)
    }

    /**
     * 一个 lambda 表达式总是被花括号包围
     */
    private fun testLambda() {
        val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    }
}