package edu.msudenver.stopwatch

/*
 * CS3013 - Mobile App Dev. - Summer 2022
 * Instructor: Thyago Mota
 * Description: Activity 20 - Stopwatch
 */

import kotlinx.coroutines.*

interface OnStopwatchListener {
    fun onStopwatchChanged(stopwatch: Stopwatch)
}

class Stopwatch {
    private var counter = 0L
    private var paused = false
    private var onStopwatchListener: OnStopwatchListener? = null

    companion object {
        const val MAX_COUNTER: Long = 99 * 6000
    }

    @Synchronized
    fun isPaused(): Boolean { return paused }

    @Synchronized
    fun pause(): Unit {
        paused = true
    }

    @Synchronized
    fun play(): Unit {
        paused = false
    }

    @Synchronized
    fun reset(): Unit {
        counter = 0
    }

    fun setOnStopwatchListener(onStopwatchListener: OnStopwatchListener): Unit {
        this.onStopwatchListener = onStopwatchListener
    }

    @Synchronized
    override fun toString(): String {
        val minutes = counter / 6000
        val seconds = (counter - minutes * 6000) / 100
        val remain = counter - minutes * 6000 - seconds * 100
        return "${minutes.toString().padStart(2, '0')}:${seconds.toString().padStart(2, '0')}:${remain.toString().padStart(2, '0')}"
    }

    suspend fun run(): Unit {
        while (true) {
            if (isPaused())
                delay(1000L)
            else {
                counter++
                if (counter == MAX_COUNTER)
                    counter = 0
                onStopwatchListener?.onStopwatchChanged(this)
                delay(10L)
            }
        }
    }
}