/*
 * CS3013 - Mobile App Dev. - Summer 2022
 * Instructor: Thyago Mota
 * Description: Activity 19 - Example 2
 */

import kotlinx.coroutines.*

fun main() {
    runBlocking {

        launch {
            for (i in 1..10) {
                println(i)
                delay(1000)
            }
        }

        launch {
            for (i in charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j')) {
                println(i)
                delay(500)
            }
        }
    }
}