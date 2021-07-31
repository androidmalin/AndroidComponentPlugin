package com.example.lib

class Result(val result: Int, val status: String) {

    operator fun component1() = result

    operator fun component2() = status
}