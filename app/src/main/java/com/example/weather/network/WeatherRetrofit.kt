package com.example.weather.network

import com.example.weather.model.WeatherResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRetrofit {

    private var weatherAPI: WeatherAPI = createWeatherAPI(createRetrofitInstance())

    private fun createRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createWeatherAPI(retrofit: Retrofit): WeatherAPI{
        return retrofit.create(WeatherAPI::class.java)
    }

    fun getLocationWeather(cityName: String): Call<WeatherResponse> {
       return weatherAPI.getCityWeather(cityName, "65d00499677e59496ca2f318eb68c049")
    }

}