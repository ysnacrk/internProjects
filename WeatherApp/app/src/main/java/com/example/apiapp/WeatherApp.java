package com.example.apiapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherApp {

    @SerializedName("city")
    @Expose
    private City city;

    @SerializedName("list")
    @Expose
    private List<WeatherList> weatherList;

    public List<WeatherList> getWeatherList() {
        return weatherList;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
