package edu.msudenver.recview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.DateFormat
import java.text.SimpleDateFormat
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    val dateFormat = SimpleDateFormat("MM/dd/yyyy")

    // TODO #1: create the ActivityHolder (inner) class
    private inner class ActivityHolder(view: View): RecyclerView.ViewHolder(view) {
        
    }

    private inner class ActivityAdapter(var activities: List<Activity>): RecyclerView.Adapter<ActivityHolder>() {

        // TODO #2: complete the onCreateViewHolder method override
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityHolder {
            return null
        }

        // TODO #3: complete the onBindViewHolder method override
        // notes:
        // * date should be displayed in month/day/4-year digit format (hint: use the given "dateFormat"
        // * distance and time should be rounded up to 2 decimals
        // * units for distance and time should be miles and min., respectively
        // * units for pace should be min./mile
        override fun onBindViewHolder(holder: ActivityHolder, position: Int) {
            
        }

        override fun getItemCount(): Int {
            return activities.size
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val activities = listOf<Activity>(
            Activity(dateFormat.parse("07/06/2022"), 6.21, 70.0),
            Activity(dateFormat.parse("07/03/2022"), 6.21, 90.5),
            Activity(dateFormat.parse("06/10/2022"), 26.2, 245.0),
            Activity(dateFormat.parse("07/06/2020"), 6.21, 150.15),
            Activity(dateFormat.parse("03/03/2020"), 13.1, 200.0)
        ).sorted()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ActivityAdapter(activities)
    }
}