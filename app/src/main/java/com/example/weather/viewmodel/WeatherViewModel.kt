package com.example.weather.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.model.WeatherResponse
import com.example.weather.network.WeatherRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel: ViewModel() {

    private var weatherRetrofit: WeatherRetrofit =  WeatherRetrofit()
    private var weatherResponseMutableLiveData = MutableLiveData<WeatherResponse>()

    fun getLocationWeatherResponse(name: String): MutableLiveData<WeatherResponse>{
        weatherRetrofit.getLocationWeather(name).enqueue(object : Callback<WeatherResponse>{
            override fun onResponse(call: Call<WeatherResponse>,
                                    response: Response<WeatherResponse>
            ) {
                if(response.isSuccessful && response.body() != null){
                    weatherResponseMutableLiveData.value = response.body()
                } else{
                    Log.d("TAG_X", "Return Null")
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.d("TAG_X", t.localizedMessage)
            }
        })
        return weatherResponseMutableLiveData
    }

}