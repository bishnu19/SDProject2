package edu.msudenver.randomnumbergenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: get a reference to the textview
        var txtRandomNumber: TextView = findViewById(R.id.txtRandomNumber)

        // TODO: write the for the "onClickListener"
        // 1a get a reference to the edittext "from"
        // 1b extract the "from" integer value
        // 2a get a reference to the edittext "to"
        // 2b extract the "to" integer value
        // 3 generate a random number in "from" until "to" + 1
        // 4 update the textview
        txtRandomNumber.setOnClickListener {
                val edtFrom: EditText = findViewById(R.id.edtFrom)
                val numFrom = Integer.valueOf(edtFrom.text.toString())
                val edtTo: EditText = findViewById(R.id.edtTo)
                val numTo = Integer.valueOf(edtTo.text.toString())
                val randomNumber = Random.nextInt(numFrom, numTo + 1)
                txtRandomNumber.text = randomNumber.toString()
            }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val txtRandomNumber: TextView = findViewById(R.id.txtRandomNumber)
        val randomNumber = Integer.valueOf(txtRandomNumber.text.toString())
        outState.putInt("randomNumber", randomNumber)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val txtRandomNumber: TextView = findViewById(R.id.txtRandomNumber)
        txtRandomNumber.text = savedInstanceState.getInt("randomNumber").toString()
    }
}

