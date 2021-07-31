package com.example.lib

class Task {
    fun run(step2: () -> Unit, step3: () -> Unit) {
        step1()
        step2()
        step3()
    }

    fun step1() {}
}