package edu.msudenver.crud

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import java.lang.Exception

class CreateUpdateActivity: AppCompatActivity(), View.OnClickListener {

    var op = CREATE_OP
    var category = 0
    lateinit var db: SQLiteDatabase
    lateinit var edtName: EditText
    lateinit var edtQuantity: EditText
    lateinit var edtUnit: EditText

    companion object {
        const val CREATE_OP = 0
        const val UPDATE_OP = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_update)

        // TODO #1: get references to the view objects
        edtName = 
        val spnCategory: Spinner = 
        edtQuantity = 
        edtUnit = 

        // TODO #2: define the spinner's adapter as an ArrayAdapter of String
        spnCategory.adapter = 

        // TODO #3: get a reference to the "CREATE/UPDATE" button and sets its listener
        

        // TODO #4: get a "writable" db connection
        

        // TODO #5: gets the operation and updates the view accordingly
        
    }

    // TODO #6: insert a new shopping list item into the database
    // show a toast message saying whether the db operation was successful or not
    // call finish to resume back to the MainActivity
    override fun onClick(view: View?) {
        
    }
}