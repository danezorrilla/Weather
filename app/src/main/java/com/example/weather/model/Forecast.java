package com.example.weather.model;

public class Forecast {

    private String forecastTemp;

    private String forecastFeel;

    private  String forecastMain;

    private String forecastDesc;

    public String getForecastTemp() {
        return forecastTemp;
    }

    public void setForecastTemp(String forecastTemp) {
        this.forecastTemp = forecastTemp;
    }

    public String getForecastFeel() {
        return forecastFeel;
    }

    public void setForecastFeel(String forecastFeel) {
        this.forecastFeel = forecastFeel;
    }

    public String getForecastMain() {
        return forecastMain;
    }

    public void setForecastMain(String forecastMain) {
        this.forecastMain = forecastMain;
    }

    public String getForecastDesc() {
        return forecastDesc;
    }

    public void setForecastDesc(String forecastDesc) {
        this.forecastDesc = forecastDesc;
    }

    public Forecast(String forecastTemp, String forecastFeel, String forecastMain, String forecastDesc) {
        this.forecastTemp = forecastTemp;
        this.forecastFeel = forecastFeel;
        this.forecastMain = forecastMain;
        this.forecastDesc = forecastDesc;
    }
}
