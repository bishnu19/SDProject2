package edu.msudenver.microphone

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaRecorder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.jjoe64.graphview.GraphView
import com.jjoe64.graphview.series.DataPoint
import com.jjoe64.graphview.series.LineGraphSeries
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    var graph: GraphView? = null
    var btnStartStop: Button? = null
    var dataPoints: MutableList<DataPoint>? = null
    var mediaRecorder: MediaRecorder? = null
    var audioSampler: Job? = null

    companion object {
        const val MAX_AMPLITUDE = 32767
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO #1: use ActivityCompat.checkSelfPermission to check if the app has Manifest.permission.RECORD_AUDIO
        // if it doesn't, use ActivityCompat.requestPermission to request it, using requestCode = 1
        

        graph = findViewById(R.id.graph)

        btnStartStop = findViewById(R.id.btnStartStop)
        btnStartStop?.text = "START"
        btnStartStop?.setOnClickListener {
            if (btnStartStop?.text.toString().equals("START")) {

                // TODO #2: change the text of the button to STOP

                // TODO #3: call startAudioRecording

                // TODO #4: instantiate dataPoints

                // TODO #5: launch a coroutine that samples the amplitude at every 1/2s, creating a data point from the sample
                // save the job in audioSampler
                audioSampler = GlobalScope.launch {
                    
                }
            }
            else {

                // TODO #6: change the text of the button to START

                // TODO #7: call stopAudioRecording

                // TODO #8: cancel the audioSampler job

                // TODO #9: configure graphview to display the plot
                
            }
        }
    }

    @Suppress("DEPRECATION")
    fun startAudioRecording() {
        mediaRecorder = MediaRecorder()
        with (mediaRecorder) {
            this?.setAudioSource(MediaRecorder.AudioSource.MIC)
            this?.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP)
            this?.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT)
            this?.setOutputFile("/dev/null")
            this?.prepare()
            this?.start()
        }
    }

    fun stopAudioRecording() {
        mediaRecorder?.stop()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                )
                    Toast.makeText(this, "Permission Bluetooth Scan Granted", Toast.LENGTH_SHORT)
                        .show()
                else
                    Toast.makeText(this, "Permission Bluetooth Scan Denied", Toast.LENGTH_SHORT)
                        .show()
            }
        }
    }
}