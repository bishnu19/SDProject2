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
        var txtId: TextView = view.findViewById(R.id.txtId)
        val txtDescription: TextView = view.findViewById(R.id.txtDescription)
        val txtVisitedDate: TextView = view.findViewById(R.id.txtVisitedDate)
        val txtCoordinates: TextView = view.findViewById(R.id.txtCoordinates)
    }

    // TODO #2: implement the LocationAdapter class
    private inner class LocationAdapter(var locations: List<Location>, var onClickListener: View.OnClickListener, var onLongClickListener: View.OnLongClickListener): RecyclerView.Adapter<LocationHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
            view.setOnClickListener(onClickListener)
            view.setOnLongClickListener(onLongClickListener)
            return LocationHolder(view)
        }

        override fun onBindViewHolder(holder: LocationHolder, position: Int) {
            val location = locations[position]
            holder.txtId.text = location.id.toString()
            holder.txtDescription.text = location.description
            holder.txtVisitedDate.text = DBHelper.USA_FORMAT.format(location.visitedDate)
            val latitude = (location.latitude * 1000).toInt() / 1000f
            val longitude = (location.longitude * 1000).toInt() / 1000f
            holder.txtCoordinates.text = "(${latitude}, ${longitude})"
        }

        override fun getItemCount(): Int {
            return locations.size
        }
    }

    // TODO #3: implement the function
    fun populateRecyclerView() {
        val db = dbHelper.readableDatabase
        val locations = mutableListOf<Location>()
        val cursor = db.query(
            "locations",
            arrayOf<String>("rowid, description, visited_date, latitude, longitude"),
            null,
            null,
            null,
            null,
            null
        )
        with (cursor) {
            while (moveToNext()) {
                val id          = getInt(0)
                val description = getString(1)
                val visitedDate = DBHelper.ISO_FORMAT.parse(getString(2))
                val latitude    = getDouble(3)
                val longitude   = getDouble(4)
                val location = Location(id, description, visitedDate, latitude, longitude)
                locations.add(location)
            }
        }
        recyclerView.adapter = LocationAdapter(locations, this, this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DBHelper(this)

        // TODO #4: create and populate the recycler view
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        populateRecyclerView()

        val fabCreate: FloatingActionButton = findViewById(R.id.fabCreate)
        // TODO #5: transition to CreateLocationActivity
        fabCreate.setOnClickListener {
            val intent = Intent(this, CreateLocationActivity::class.java)
            startActivity(intent)
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
            val txtId: TextView = view.findViewById(R.id.txtId)
            val id = txtId.text.toString().toInt()
            val intent = Intent(this, DisplayLocationActivity::class.java)
            intent.putExtra("id", id)
            startActivity(intent)
        }
    }

    // TODO #7: delete the location identified by "id"
    override fun onLongClick(view: View?): Boolean {
        class MyDialogInterfaceListener(val id: Int): DialogInterface.OnClickListener {
            override fun onClick(dialogInterface: DialogInterface?, which: Int) {
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    try {
                        val db = dbHelper.writableDatabase
                        db.execSQL("""
                            DELETE FROM locations
                            WHERE rowid = ${id}
                        """)
                        populateRecyclerView()
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