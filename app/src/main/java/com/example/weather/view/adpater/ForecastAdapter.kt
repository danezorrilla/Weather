package com.example.weather.view.adpater

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.model.Forecast
import com.example.weather.model.WeatherResponse
import kotlinx.android.synthetic.main.weather_response_layout.view.*
import java.text.DecimalFormat

class ForecastAdapter(private val weatherResponse: WeatherResponse,
                      private val detailsInterface: DetailsInterface):
    RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder>() {

    private val df = DecimalFormat("#")

    interface DetailsInterface {
        fun getDetails(forecast: Forecast)
    }

    class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var responseDesc: TextView = itemView.response_desc
        var responseTemp: TextView = itemView.response_temp
        var weatherCardView: ConstraintLayout = itemView.weather_cardview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.weather_response_layout,
            parent, false
        )
        return ForecastViewHolder(view)
    }

    override fun getItemCount(): Int {
        return weatherResponse.list.size
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val tempInF = df.format(convertToF(weatherResponse.list[position].main.temp))
        val feelInF = df.format(convertToF(weatherResponse.list[position].main.feelsLike))
        holder.responseDesc.text = weatherResponse.list[position].weather[0].main
        holder.responseTemp.text = "Temp: $tempInF"
        holder.weatherCardView.setOnClickListener {

            val forecastMain = weatherResponse.list[position].weather[0].main
            val forecastDesc = weatherResponse.list[position].weather[0].description
            val bundle = Bundle()
            bundle.putString("forecast temp", tempInF)
            bundle.putString("forecast feel", feelInF)
            bundle.putString("forecast main", forecastMain)
            bundle.putString("forecast desc", forecastDesc)

            val newForecast = Forecast(tempInF, feelInF, forecastMain, forecastDesc)
            detailsInterface.getDetails(newForecast)

        }

    }

    private fun convertToF(kelvin: Double): Double{
        return (kelvin - 273.15) * 9/5 + 32
    }
}