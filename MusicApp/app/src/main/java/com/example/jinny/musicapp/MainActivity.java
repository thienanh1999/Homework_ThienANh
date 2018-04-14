package com.example.jinny.musicapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. tao 1 con retrofit
        Retrofit retrofit = new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://qkserver1.herokuapp.com/api/")
                .build();

        //2. tao object request + response

        //3. tao 1 interface khai bao request

        //4. call
        RegisterService registerService = retrofit.create(RegisterService.class);
        registerService.register(new Register().new RegisterRequest("thienanh123", "thienanh1","stu"))
                .enqueue(new Callback<Register.RegisterRespone>() {
                    @Override
                    public void onResponse(Call<Register.RegisterRespone> call, Response<Register.RegisterRespone> response) {
                        Log.d(TAG, "onResponse: " + response.body().message);
                    }

                    @Override
                    public void onFailure(Call<Register.RegisterRespone> call, Throwable t) {

                    }
                });

        //Call Login
        LoginService loginService = retrofit.create(LoginService.class);
        loginService.login(new Login().new LoginRequest("thienanh", "thienanh1"))
                .enqueue(new Callback<Login.LoginResponse>() {
                    @Override
                    public void onResponse(Call<Login.LoginResponse> call, Response<Login.LoginResponse> response) {
                        Log.d(TAG, "onLoginResponse: " + response.body().success);
                    }

                    @Override
                    public void onFailure(Call<Login.LoginResponse> call, Throwable t) {

                    }
                });
    }
}
