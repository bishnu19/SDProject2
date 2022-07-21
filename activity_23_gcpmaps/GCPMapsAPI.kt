package edu.msudenver.gcpmaps

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface GCPMapsAPI {

    @GET("staticmap")
    fun staticmap(
        @Query("key") key: String,
        @Query("zoom") zoom: Int,
        @Query ("size") size: String,
        @Query ("markers") markers: String): Call<ResponseBody>

    companion object {
        val BASE_URL = "https://maps.googleapis.com/maps/api/"

        fun create(): GCPMapsAPI {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(GCPMapsAPI::class.java)
        }
    }
}