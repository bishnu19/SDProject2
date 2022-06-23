package edu.msudenver.reminder

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import java.io.FileNotFoundException

class MainActivity : AppCompatActivity() {

    companion object {
        const val FILE_NAME = "reminder.txt"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO #1: use the persistency file to update the EditText
        val edt2Save: EditText = findViewById(R.id.edt2Save)


        // TODO #2: set the button's listener to save the EditText's content to persistency file
        val btnSave: Button = findViewById(R.id.btnSave)
        btnSave.setOnClickListener {

        }
    }
}