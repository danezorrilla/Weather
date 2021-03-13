package com.example.weather.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.weather.R
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        toolbar = findViewById(R.id.include_details)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        toolbar.setNavigationOnClickListener { finish() }

        val bundle = intent.extras
        val name = bundle?.getString("name")
        val temp = bundle?.getString("forecast temp")
        val feel = bundle?.getString("forecast feel")
        val main = bundle?.getString("forecast main")
        val desc = bundle?.getString("forecast desc")

        supportActionBar?.title = name

        location_forecast_temp.text = temp
        location_forecast_feels_like.text = "Feels Like: $feel"
        location_forecast_main.text = main
        location_forecast_desc.text = desc
    }
}