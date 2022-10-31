package study.coroutine.example

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun sum(a: Int, b: Int) = a + b

fun main() = runBlocking<Unit> {

    val result1: Deferred<Int> = async {
        delay(100)
        sum(1, 3)
    }

    println("result1: ${result1.await()}") // async의 결과를 가져오고자 할 경우 await을 사용하면 된다.

    val result2: Deferred<Int> = async {
        delay(100)
        sum(2, 5)
    }

    println("result2: ${result2.await()}")
}