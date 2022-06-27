package edu.msudenver.menusv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // show a toast when the fab is tapped
        val fabButton: FloatingActionButton = findViewById(R.id.fabCreate)
        fabButton.setOnClickListener {
            Toast.makeText(this, "Fab button was tapped!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val title = item.title.toString()
        Toast.makeText(this, "Option $title tapped!", Toast.LENGTH_LONG).show()
        return true;
    }
}