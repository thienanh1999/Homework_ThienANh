package com.example.jinny.musicapp;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RegisterService {
    @POST("register")
    Call<Register.RegisterRespone> register(@Body Register.RegisterRequest registerRequest);
} 