package study.coroutine.example

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    doSomething()
}

fun printHello() = println("hello")

// suspend 함수에서 coroutineScope를 사용하면 스레드를 차단하지 않고 실행시킬 수 있다.
suspend fun doSomething() = coroutineScope {

    launch {
        delay(200)
        println("world")
    }

    launch {
        printHello()
    }
}