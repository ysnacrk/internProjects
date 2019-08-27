package com.example.apiapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestInterface {

    @GET("data/2.5/forecast?id=738648&APPID=992887431e830fab3a03686793189122")
    Call<WeatherApp> getInfo();
}
