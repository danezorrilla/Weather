package com.example.weather.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.R
import com.example.weather.model.Forecast
import com.example.weather.model.WeatherResponse
import com.example.weather.view.adpater.ForecastAdapter
import com.example.weather.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.activity_forecast.*

class ForecastActivity : AppCompatActivity(), ForecastAdapter.DetailsInterface {

    private lateinit var weatherViewModel: WeatherViewModel
    private lateinit var weatherObserver: Observer<WeatherResponse>
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    lateinit var cityName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
        weatherObserver = Observer { weatherResponse -> displayLocationWeather(weatherResponse) }

        toolbar = findViewById(R.id.include_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbar.setNavigationOnClickListener { finish() }

        val bundle = intent.extras
        val name = bundle?.getString("city name")
        if (name != null) {
            cityName = name
        }
        supportActionBar?.title = name

        weatherObserver.let {
            if (name != null) {
                weatherViewModel.getLocationWeatherResponse(name)
                    .observe(this, it)
            }
        }

    }

    private fun displayLocationWeather(weatherResponse: WeatherResponse){
        for(i in weatherResponse.list.indices) {
            location_forecast_list.layoutManager = LinearLayoutManager(this)
            location_forecast_list.adapter = ForecastAdapter(weatherResponse, this)
        }

    }

    override fun getDetails(forecast: Forecast) {
        val temp: String = forecast.forecastTemp
        val feel: String = forecast.forecastFeel
        val main: String = forecast.forecastMain
        val desc: String = forecast.forecastDesc

        intent = Intent(this, DetailsActivity::class.java)
        val bundle = Bundle()
        bundle.putString("name", cityName)
        bundle.putString("forecast temp", temp)
        bundle.putString("forecast feel", feel)
        bundle.putString("forecast main", main)
        bundle.putString("forecast desc", desc)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}