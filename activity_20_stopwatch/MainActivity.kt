package edu.msudenver.stopwatch

/*
 * CS3013 - Mobile App Dev. - Summer 2022
 * Instructor: Thyago Mota
 * Description: Activity 20 - MainActivity
 */

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

// note that MainActivity implements OnStopwatchListener
class MainActivity : AppCompatActivity(), OnStopwatchListener {

    var stopwatch: Stopwatch? = null
    var txtTime: TextView? = null
    var btnStart: Button? = null
    var btnStop: Button? = null
    var btnReset: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO #1: get the reference to txtTime
        txtTime = findViewById(R.id.txtTime)

        // TODO #2: get the reference to btnStart
        btnStart = findViewById(R.id.btnStart)

        // TODO #3: get the reference to btnStop; set "isEnabled" to false
        btnStop = findViewById(R.id.btnStop)
        btnStop?.isEnabled = false

        // TODO #4: get the reference to btnReset; set "isEnabled" to false
        btnReset = findViewById(R.id.btnReset)
        btnReset?.isEnabled = false

        // TODO #5: write the onClickListener handler for btnStart
        // if Stopwatch hasn't been initialized, initialize it, setting MainActivity as its onStopwatchListener; then launch a (global scope) coroutine
        // else, call play on stopwatch
        // on either case, set isEnabled on btnStart and btnReset to false; on btnStop to true
        btnStart?.setOnClickListener{
            if (stopwatch == null) {
                stopwatch = Stopwatch()
                stopwatch?.setOnStopwatchListener(this)
                GlobalScope.launch {
                    withContext(Dispatchers.Main) {
                        stopwatch?.run()
                    }
                }
            }
            else
                stopwatch?.play()
            btnStart?.isEnabled = false
            btnReset?.isEnabled = false
            btnStop?.isEnabled = true
        }

        // TODO #6: write the onClickListener handler for btnStop, which pauses the stopwatch and change isEnabled property of the buttons accordingly
        btnStop?.setOnClickListener{
            stopwatch?.pause()
            btnStart?.isEnabled = true
            btnReset?.isEnabled = true
            btnStop?.isEnabled = false
        }

        // TODO #7: write the onClickListener handler for btnReset, which resets the stopwatch and change isEnabled property of the buttons accordingly; txtTime's text needs to be reset to
        btnReset?.setOnClickListener{
            stopwatch?.reset()
            txtTime?.setText(stopwatch.toString())
            btnReset?.isEnabled = false
        }
    }

    // TODO #8: update txtTime's text with stopwatch's toString
    override fun onStopwatchChanged(stopwatch: Stopwatch) {
        txtTime?.setText(stopwatch.toString())
    }
}