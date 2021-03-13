package com.example.weather.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weather.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        lookup_city_weather.setOnClickListener {
            getLocationWeather()
        }
    }

    private fun getLocationWeather(){
        val cityName = enter_city_name.text
        intent = Intent(this, ForecastActivity::class.java)
        val bundle = Bundle()
        bundle.putString("city name", cityName.toString())
        intent.putExtras(bundle)
        startActivity(intent)
        enter_city_name.text = null
    }


}