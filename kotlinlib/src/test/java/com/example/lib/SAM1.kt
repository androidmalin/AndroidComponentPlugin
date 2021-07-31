package com.example.lib

import org.junit.jupiter.api.Test

/**
 * https://www.kotlincn.net/docs/reference/fun-interfaces.html
 */
class SAM1 {

    /**
     * 只有一个抽象方法的接口称为函数式接口或 SAM（单一抽象方法）接口。
     * 函数式接口可以有多个非抽象成员，但只能有一个抽象成员。
     *
     * 可以用 fun 修饰符在 Kotlin 中声明一个函数式接口。
     */
    private fun interface IntPredicate {
        fun accept(i: Int): Boolean
    }

    /**
     * 对于函数式接口，可以通过 lambda 表达式实现 SAM 转换，
     * 从而使代码更简洁、更有可读性。
     * 使用 lambda 表达式可以替代手动创建实现函数式接口的类。
     * 通过 SAM 转换，
     * Kotlin 可以将其签名与接口的单个抽象方法的签名
     * 匹配的任何 lambda 表达式
     * 转换为实现该接口的类的实例。
     *
     *
     * 通过 lambda 表达式创建一个实例
     */
    private val isEven = IntPredicate { it % 2 == 0 }

    @Test
    fun test() {
        println("Is 7 even? - ${isEven.accept(7)}")
    }
}