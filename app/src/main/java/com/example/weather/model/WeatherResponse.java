
package com.example.weather.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherResponse {

    @SerializedName("list")
    @Expose
    private java.util.List<com.example.weather.model.List> list = null;

    public java.util.List<com.example.weather.model.List> getList() {
        return list;
    }

    public void setList(java.util.List<com.example.weather.model.List> list) {
        this.list = list;
    }

}
