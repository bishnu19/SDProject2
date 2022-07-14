package edu.msudenver.nutrionix

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.*

const val BASE_URL = "https://trackapi.nutritionix.com/v2/natural/"
const val XAPP_ID  = ""
const val XAPP_KEY = ""

data class NutritionInfo(
    var foods: Array<Food>
)

data class Food(
    val food_name: String,
    var brand_name: String,
    var serving_qty: Int,
    var serving_unit: String,
    var serving_weight_grams: Int,
    var nf_calories: Double,
    var nf_total_fat: Double,
    var nf_saturated_fat: Double,
    var nf_cholesterol: Double,
    var nf_sodium: Double,
    var nf_total_carbohydrate: Double,
    var nf_dietary_fiber: Double,
    var nf_sugars: Double,
    var nf_protein: Double,
    var nf_potassium: Double,
    var nf_p: Double)

data class Data(
    var query: String,
)

interface NutritionixAPI {

    @POST("nutrients")
    fun nutrients(
        @Header("x-app-id") xappId: String,
        @Header("x-app-key") xappKey: String,
        @Body data: Data
    ): Call<NutritionInfo>
}

fun main() {
    // creates a retrofit Nutritionix API builder
    val apiBuilder = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    // TODO #1: use the API builder to create an API client
    

    // asks the user for food item to query
    val sc = Scanner(System.`in`)
    print("? ")
    val query = sc.nextLine()
    val data = Data(query)

    // TODO #2: make a synchronous call to the API, saving the response
    

    // if response is successful
    if (response.isSuccessful) {

        // TODO #3: get the response and display the name of each food constituent followed by its number of calories
        // example: "prime rib" has/have 289.85 calories for 3 oz
        
    }
    // else, if response is unsuccessful
    else
        println(response.message())
}