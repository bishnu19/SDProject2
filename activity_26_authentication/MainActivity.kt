package edu.msudenver.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.sql.PreparedStatement

class MainActivity : AppCompatActivity() {

    var edtEmail: EditText? = null
    var edtPassword: EditText? = null
    var btnLogin: Button? = null

    // use this method to check if a given email is valid
    fun CharSequence?.isValidEmail() = !isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

    // use this method to create users if you want
    fun createTestUser() {
        val testUser = User("morbid@gmail.com", "Morbid Mohito")
        var salt = DBHelper.getSalt()
        var password = "12345678" // not recommended!
        val saltedHashPassword = DBHelper.getHash(password + salt)
        val dbHelper = DBHelper(this)
        val db = dbHelper.writableDatabase
        db?.execSQL("""
            INSERT INTO users values ( 
                "${testUser.email}", 
                "${testUser.name}",
                "${salt}",
                "${saltedHashPassword}" )
        """)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // uncomment the following statement to create test users
        // createTestUser()

        // get reference to the views
        edtEmail = findViewById(R.id.edtEmail)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)

        // TODO: validate the email and then authenticate the user using login;
        // show an appropriate message using a Toast
        btnLogin?.setOnClickListener {
            val email = edtEmail?.text.toString()
            if (!email.isValidEmail())
                Toast.makeText(this, "Email is not valid!", Toast.LENGTH_SHORT).show()
            else {
                val password = edtPassword?.text.toString()
                try {
                    val user = login(this, email, password)
                    Toast.makeText(this, "Welcome back ${user}!", Toast.LENGTH_SHORT).show()
                }
                catch (error: Error) {
                    Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}