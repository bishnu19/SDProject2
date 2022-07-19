package edu.msudenver.gcpmaps

/*
 * CS3013 - Mobile App Dev. - Summer 2022
 * Instructor: Thyago Mota
 * Description: Activity 23 - MainActivity
 */

import android.content.*
import androidx.appcompat.app.*
import android.os.*
import android.view.*
import android.widget.*
import androidx.recyclerview.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var dbHelper: DBHelper

    // TODO #1: implement the LocationHolder class
    private inner class LocationHolder(view: View): RecyclerView.ViewHolder(view) {
        
    }

    // TODO #2: implement the LocationAdapter class
    private inner class LocationAdapter(var locations: List<Location>, var onClickListener: View.OnClickListener, var onLongClickListener: View.OnLongClickListener): RecyclerView.Adapter<LocationHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationHolder {
            return null
        }

        override fun onBindViewHolder(holder: LocationHolder, position: Int) {
            
        }

        override fun getItemCount(): Int {
            return locations.size
        }
    }

    // TODO #3: implement the function
    fun populateRecyclerView() {
        val db = dbHelper.readableDatabase
        val locations = mutableListOf<Location>()
        
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DBHelper(this)

        // TODO #4: create and populate the recycler view
        

        val fabCreate: FloatingActionButton = findViewById(R.id.fabCreate)
        // TODO #5: transition to CreateLocationActivity
        fabCreate.setOnClickListener {
            
        }
    }

    // this method is called when CreateLocationActivity finishes
    override fun onResume() {
        super.onResume()
        populateRecyclerView()
    }

    // TODO #6: transition to DisplayLocationActivity (passing the location's "id")
    override fun onClick(view: View?) {
        if (view != null) {
            
        }
    }

    // TODO #7: delete the location identified by "id"
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
            alertDialogBuilder.setMessage("Are you sure you want to delete the location?")
            alertDialogBuilder.setPositiveButton("Yes", MyDialogInterfaceListener(id))
            alertDialogBuilder.setNegativeButton("No", MyDialogInterfaceListener(id))
            alertDialogBuilder.show()
            return true
        }
        return false    }
}