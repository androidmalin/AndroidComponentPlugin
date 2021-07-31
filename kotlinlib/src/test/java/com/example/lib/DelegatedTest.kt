package com.example.lib

import org.junit.jupiter.api.Test

class DelegatedTest {

    /**
     * 由委托实现
     * 委托模式已经证明是实现继承的一个很好的替代方式
     *
     * 而 Kotlin 可以零样板代码地原生支持它。
     * Derived 类可以通过将其所有公有成员都委托给指定对象来实现一个接口 Base：
     */
    interface Base {
        fun print()
    }

    class BaseImpl(val x: Int) : Base {
        override fun print() {
            println(x)
        }
    }

    class Derived(b: Base) : Base by b

    @Test
    fun main() {
        val b = BaseImpl(10)
        Derived(b).print()
    }

}