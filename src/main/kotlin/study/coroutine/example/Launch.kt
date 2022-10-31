package study.coroutine.example

import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit> {

    launch {
        delay(500) // 코루틴이 제공하는 delay는 스레드를 차단하지 않고 일시 중단한다.
        println("World")
    }

    println("Hello")

    val job1 = launch {
        val elapsedTime = measureTimeMillis {
            delay(150)
        }
        println("async task-1 $elapsedTime ms")
    }
    job1.cancel() // launch를 취소할 수 있다.

    val job2 = launch(start = CoroutineStart.LAZY) {
        val elapsedTime = measureTimeMillis {
            delay(100)
        }
        println("async task-2 $elapsedTime ms")
    }
    job2.start() // launch를 실행할 시점에 호출할 수 있다. (start를 호출하지 않으면 launch는 동작하지 않는다.)
}