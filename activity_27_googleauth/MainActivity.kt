package edu.msudenver.googleauthentication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task


class MainActivity : AppCompatActivity() {

    var gsiClient: GoogleSignInClient? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO #1: enter your client's ID
        val gsiOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestIdToken("").requestEmail().build()

        // TODO #2: get a Google sign-in client using the above options
        gsiClient = 

        // TODO #3: get a reference to the sign-in button
        val signInButton = 

        // TODO #4: get a sign-in intent from the sign-in client and start an external sign-in activity with the intent
        signInButton.setOnClickListener {
            
        }
    }

    // this method is how you will get notified when Google gets back to you
    // unfortunately I keep getting an exception
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task?.result
                if (account != null)
                    Toast.makeText(this, "Welcome back ${account.displayName}", Toast.LENGTH_SHORT).show()
            } catch (ex: Exception) {
                Toast.makeText(this, ex.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }
}