package com.example.lib

import org.junit.jupiter.api.Test

class DelegateTest3 {
    interface Base {
        val message: String
        fun print()
    }

    class BaseImpl(val x: Int) : Base {
        override val message = "BaseImpl: x = $x"
        override fun print() {
            println(message)
        }
    }

    class Derived(b: Base) : Base by b {
        // 在 b 的 `print` 实现中不会访问到这个属性
        override val message = "Message of Derived"
    }

    /**
     * 以这种方式重写的成员不会在委托对象的成员中调用
     * 委托对象的成员只能访问其自身对接口成员实现
     */
    @Test
    fun main() {
        val b = BaseImpl(10)
        val derived = Derived(b)
        derived.print()
        println(derived.message)
    }
}