package edu.msudenver.passwordgenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class DisplayPassword : AppCompatActivity() {

    var passwordGenerator: PasswordGenerator? = null
    var txtPasswd: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_password)

        // if there is no saved instance state, get the reference to the PasswordGenerator object from the intent
        if (savedInstanceState == null) {
            passwordGenerator = intent.getSerializableExtra("passwordGenerator") as PasswordGenerator?
            // TODO #1 (2 points): use the reference to generate a new password
            // hint: since "passwordGenerator" is nullable, you have to use the "?." operator when making method calls
            
        }
        // otherwise, get the reference to the PasswordGenerator object from the saved instance state
        else
            passwordGenerator = savedInstanceState.getBundle("passwordGenerator") as PasswordGenerator?

        // get the reference to the TextView that displays the password
        txtPasswd = findViewById(R.id.txtPasswd)

        // TODO #2 (3 points): update the TextView with the last generated password
        // hint: PasswordGenerator has a property named "password" that saves the last generated password
        txtPasswd?.text = 

        // set a "click" listener on the TextView
        txtPasswd?.setOnClickListener {
            // TODO #3 (0 points): copy the code you wrote for TO-DO's #1 and #2
            

        }

        // get the reference to the "send" Button
        val btnSend: Button = findViewById(R.id.btSend)

        // set a "click" listener on the Button
        btnSend.setOnClickListener {
            // TODO #4 (5 points): create an ACTION_SEND implicit intent with the password in the Intent.EXTRA_TEXT
            // the intent's type should be "text/plain"
            // start an activity from the intent
            val intent = 
            intent.putExtra()
            intent.type = 
            =
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("passwordGenerator", passwordGenerator)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        passwordGenerator = savedInstanceState.getSerializable("passwordGenerator") as PasswordGenerator?
        // TODO #5 (0 points): copy the code you wrote for TO-DO's #2
        
    }
}