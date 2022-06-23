package edu.msudenver.multipleactivities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val txtResult: TextView = findViewById(R.id.txtResult)
        val result = intent.getBooleanExtra("result", false)
        if (result) {
            txtResult.setBackgroundColor(Color.GREEN)
            txtResult.text = "CORRECT!"
        }
        else {
            txtResult.setBackgroundColor(Color.RED)
            txtResult.text = "INCORRECT!"
        }
    }
}