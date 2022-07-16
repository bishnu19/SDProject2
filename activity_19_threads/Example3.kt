/*
 * CS3013 - Mobile App Dev. - Summer 2022
 * Instructor: Thyago Mota
 * Description: Activity 19 - Example 3
 */

class Counter {

    private var c = 0

    fun increment() {
        c++;
    }

    fun decrement() {
        c--;
    }

    fun value(): Int { return c; }
}

fun main() {

    val counter = Counter()

    val incRun = Runnable {
        for (i in 1..100) {
            counter.increment()
            Thread.sleep(10)
        }
    }

    val decRun = Runnable {
        for (i in 1..100) {
            counter.decrement()
            Thread.sleep(15)
        }
    }


    val incThread = Thread(incRun)
    val decThread = Thread(decRun)

    incThread.start()
    decThread.start()

    incThread.join()
    decThread.join()

    println("Counter value is ${counter.value()}")
}