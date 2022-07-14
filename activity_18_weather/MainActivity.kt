package edu.msudenver.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity(), Callback<Response> {

    lateinit var recyclerView: RecyclerView

    private inner class ForecastDataHolder(view: View): RecyclerView.ViewHolder(view) {
        val txtDateTime: TextView = view.findViewById(R.id.txtDateTime)
        val txtTemp: TextView = view.findViewById(R.id.txtTemp)
    }

    private inner class ForecastDataAdapter(var list: Array<ForecastData>): RecyclerView.Adapter<ForecastDataHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastDataHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
            return ForecastDataHolder(view)
        }

        override fun onBindViewHolder(holder: ForecastDataHolder, position: Int) {
            val forecastData = list[position]
            holder.txtDateTime.text = forecastData.dt_txt
            holder.txtTemp.text = "Min: " + forecastData.main.temp_min.toString() + " - Max: " + forecastData.main.temp_max.toString()
        }

        override fun getItemCount(): Int {
            return list.size
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val openWeatherMapAPI = OpenWeatherMapAPI.create()
        val q = getString(R.string.q)
        val units = getString(R.string.units)
        val appid = getString(R.string.appid)
        val call = openWeatherMapAPI.forecast(q, units, appid)
        call.enqueue(this)
    }

    override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
        val list = response.body()?.list
        if (list != null)
            recyclerView.adapter = ForecastDataAdapter(list)
    }

    override fun onFailure(call: Call<Response>, t: Throwable) {
        TODO("Not yet implemented")
    }
}