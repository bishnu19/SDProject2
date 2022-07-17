package edu.msudenver.accelerometer

import android.content.Context
import android.hardware.*
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), SensorEventListener {

    var sensorManager: SensorManager? = null
    var accel: Sensor? = null
    var txtX: TextView? = null
    var txtY: TextView? = null
    var txtZ: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtX = findViewById(R.id.txtX)
        txtY = findViewById(R.id.txtY)
        txtZ = findViewById(R.id.txtZ)

        // TODO: get a reference to the sensor manager

        // TODO: get a reference to the accelerometer sensor

        // TODO: register the sensor event listener
    }

    override fun onSensorChanged(event: SensorEvent?) {
        print("onSensorChanged!")
        if (event != null) {
            val values = event.values
            txtX?.text = "x: ${values[0]}"
            txtY?.text = "y: ${values[1]}"
            txtZ?.text = "z: ${values[2]}"
        }
        else
            println("event is null!")
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }
}