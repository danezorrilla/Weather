package com.example.weather.network

import com.example.weather.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

    // https://api.openweathermap.org/data/2.5/forecast?q=Atlanta&appid=

    @GET("data/2.5/forecast")
    fun getCityWeather(@Query("q") searchQuery: String,
                       @Query("appid") apiKey: String): Call<WeatherResponse>
}