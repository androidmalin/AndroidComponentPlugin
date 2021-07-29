package com.malin.hook

fun execute(task: () -> Unit) {
    val startTime = System.currentTimeMillis()
    task()
    println("Work took ${System.currentTimeMillis() - startTime} millis")
}


fun main() {
    execute {
        println("Working...")
    }
}