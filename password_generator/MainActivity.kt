package edu.msudenver.passwordgenerator


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO #1 (1 point): get the reference to the "generate" Button using findViewById
        val btnGenerate: Button = 

        btnGenerate.setOnClickListener {
            // TODO #2 (2 points): get the length of the password from the length EditText as an Integer
            val length = 

            // TODO #3 (2 points): show an appropriate Toast if length is less than 1
            if (length < 1)
                
            else {

                // TODO #4 (2 points): get the values for special, numbers, lowercase, and uppercase as Boolean
                val special   = 
                val numbers   = 
                val lowercase = 
                val uppercase = 

                // TODO #5 (2 points): show an appropriate Toast if ALL boolean options are false
                if (!special && !numbers && !lowercase && !uppercase)
                    
                else {

                    // TODO #6 (2 points): create an explicit intent for DisplayPassword activity
                    val intent = 

                    // TODO #7 (3 points): instantiate a PasswordGenerator object and add it to the intent created previously using "passwordGenerator" as the key
                    val passwordGenerator = 
                    intent.putExtra()

                    // TODO #8 (1 point): start an activity from the intent
                    
                }
            }
        }
    }
}