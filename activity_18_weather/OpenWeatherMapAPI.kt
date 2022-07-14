package edu.msudenver.weather

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapAPI {

    @GET("forecast")
    fun forecast(@Query("q") q: String, @Query("units") units: String, @Query("appid") appid: String): Call<Response>

    companion object {
        val BASE_URL = "https://api.openweathermap.org/data/2.5/"

        fun create(): OpenWeatherMapAPI {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(OpenWeatherMapAPI::class.java)
        }
    }
}