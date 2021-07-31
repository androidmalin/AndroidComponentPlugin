package com.example.lib
import org.junit.jupiter.api.Test

class DelegatedTest2 {
    interface Base {
        fun printMessage()
        fun printMessageLine()
    }

    class BaseImpl(val x: Int) : Base {
        override fun printMessage() {
            print(x)
        }

        override fun printMessageLine() {
            println(x)
        }
    }

    class Derived(b: Base) : Base by b {
        override fun printMessage() {
            println("abc")
        }
    }

    @Test
    fun main() {
        val b = BaseImpl(10)
        Derived(b).printMessage()
    }

}