package com.example.jinny.currentweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    public EditText EtCity;
    public TextView TvWeather;
    public Button BtOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EtCity = findViewById(R.id.et_city);
        TvWeather = findViewById(R.id.tv_weather);
        BtOK = findViewById(R.id.bt_ok);

        Retrofit retrofit = new Retrofit
                .Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .build();

        final CurrentWeatherService currentWeatherService = retrofit.create(CurrentWeatherService.class);

        BtOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentWeatherService.getWeather(EtCity.getText().toString(), "33b80c38fdcf8f150f3a496480097fb9")
                        .enqueue(new Callback<WeatherResponse>() {
                            @Override
                            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                                Log.d(TAG, "onResponse: " + response.body().weather.main);
                                String text = response.body().weather.main + "n" + response.body().weather.description;
                                TvWeather.setText(text);
                            }

                            @Override
                            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                                TvWeather.setText("Fuck off!!!");
                            }
                        });
            }
        });
    }
}
