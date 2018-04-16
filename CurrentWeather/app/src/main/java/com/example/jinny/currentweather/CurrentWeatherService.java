package com.example.jinny.currentweather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CurrentWeatherService {
    @GET("weather")
    Call<WeatherResponse> getWeather(@Query("q") String city,@Query("APPID") String APPID);
} 