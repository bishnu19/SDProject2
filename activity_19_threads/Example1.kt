/*
 * CS3013 - Mobile App Dev. - Summer 2022
 * Instructor: Thyago Mota
 * Description: Activity 19 - Example 1
 */

import java.util.*

fun main() {

    val t1 = Runnable {
        for (i in 1..10) {
            println(i)
            Thread.sleep(1000)
        }
    }

    val t2 = Runnable {
        for (i in charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j')) {
            println(i)
            Thread.sleep(500)
        }
    }

    Thread(t1).start()
    Thread(t2).start()

    Scanner(System.`in`).nextLine()
}