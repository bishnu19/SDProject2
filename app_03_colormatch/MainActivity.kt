package edu.msudenver.colormatch

/*
 * CS3013 - Mobile App Dev. - Summer 2022
 * Instructor: Thyago Mota
 * Student(s):
 * Description: App 03 - MainActivity (controller) class
 */

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnLongClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var dbHelper: DBHelper

    // TODO #1: create the ScoreHolder inner class
    private inner class ScoreHolder(view: View): RecyclerView.ViewHolder(view) {
        
    }

    // TODO #2: create the ScoreAdapter inner class
    // a score adapter binds scores from a list to holder objects in a recycler view
    private inner class ScoreAdapter(var scores: List<Score>, var onLongClickListener: View.OnLongClickListener): RecyclerView.Adapter<ScoreHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
            view.setOnLongClickListener(onLongClickListener)
            return ScoreHolder(view)
        }

        override fun onBindViewHolder(holder: ScoreHolder, position: Int) {
            
        }

        override fun getItemCount(): Int {
            return scores.size
        }
    }

    // TODO #3: populate the recycler view
    // this function should query the database for all of the scores; then uses a list to update the recycler view's adapter
    // don't forget to call "sort()" on your list so the items are displayed in the correct order
    fun populateRecyclerView() {
        
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DBHelper(this)

        // TODO #4: create and populate the recycler view
        

        // TODO #5: initialize the floating action button
        val fabCreate: FloatingActionButton = findViewById(R.id.fabCreate)
        fabCreate.setOnClickListener {
            
        }
    }

    override fun onResume() {
        super.onResume()
        populateRecyclerView()
    }

    // TODO #6: delete the long tapped item after a yes/no confirmation dialog
    override fun onLongClick(view: View?): Boolean {

        class MyDialogInterfaceListener(val id: Int): DialogInterface.OnClickListener {
            override fun onClick(dialogInterface: DialogInterface?, which: Int) {
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    try {
                        
                    } catch (ex: Exception) {

                    }
                }
            }
        }

        if (view != null) {
            val id = view.findViewById<TextView>(R.id.txtId).text.toString().toInt()
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setMessage("Are you sure you want to delete this score?")
            alertDialogBuilder.setPositiveButton("Yes", MyDialogInterfaceListener(id))
            alertDialogBuilder.setNegativeButton("No", MyDialogInterfaceListener(id))
            alertDialogBuilder.show()
            return true
        }
        return false
    }
}