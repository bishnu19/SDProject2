package edu.msudenver.multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGo: Button = findViewById(R.id.btnGo)
        btnGo.setOnClickListener {
            val rgChoices: RadioGroup = findViewById(R.id.rgChoices)
            val rbChecked: RadioButton = findViewById(rgChoices.checkedRadioButtonId)
            val rbCorrect: RadioButton = findViewById(R.id.rbCorrect)
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("result", rbChecked == rbCorrect)
            startActivity(intent)
//            if  (rbChecked == rbCorrect) {
//                val intent = Intent(this, CorrectActivity::class.java)
//                startActivity(intent)
//            }
//            else {
//                val intent = Intent(this, IncorrectActivity::class.java)
//                startActivity(intent)
//            }
        }
    }
}

