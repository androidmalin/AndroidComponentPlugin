package com.example.lib

import org.junit.jupiter.api.Test

class SAM {

    fun interface IntPredicate {
        fun accept(i: Int): Boolean
    }

    /**
     * 如果不使用 SAM 转换，那么你需要像这样编写代码：
     * 创建一个类的实例
     */
    private val isEven = object : IntPredicate {
        override fun accept(i: Int): Boolean {
            return i % 2 == 0
        }
    }

    @Test
    fun test() {
        println("Is 7 even? - ${isEven.accept(7)}")
    }
}