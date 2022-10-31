package study.coroutine.example

import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        println("Hello")
        println(Thread.currentThread().name)
    }

    println("World")
    println(Thread.currentThread().name)
}