package study.coroutine.example

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {

    val flow = simple()
    println(flow)
    flow.collect(::println) // collect를 사용해야 flow가 동작한다.
}

fun simple(): Flow<Int> = flow {

    println("Flow started")

    for (i in 1..3) {
        delay(100)
        emit(i) // flow는 emit을 통해 메시지를 통제한다.
    }
}