package edu.msudenver.weather

data class Response(
    var code: String,
    var message: Int,
    var cnt: Int,
    var list: Array<ForecastData>,
    var city: CityData
)

data class ForecastData(
    var dt: Long,
    var main: MainWeatherData,
    var dt_txt: String
)

data class MainWeatherData(
    var temp: Double,
    var feels_like: Double,
    var temp_min: Double,
    var temp_max: Double,
    var pressure: Long,
    var sea_level: Long,
    var grnd_level: Long,
    var humidity: Long,
    var temp_kf: Double
)

data class CityData(
    val id: Long,
    val name: String,
    var coord: Coordinate,
    val country: String,
    val population: Long,
    val timezone: Long,
    val sunrise: Long,
    val sunset: Long
)

data class Coordinate(
    val lat: Double,
    var lon: Double
)

