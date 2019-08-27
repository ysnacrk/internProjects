package com.example.apiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView text;
    TextView tempratureText;
    TextView description;
    TextView max_temp;
    TextView min_temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.city_name);
        tempratureText = findViewById(R.id.temprature);
        description = findViewById(R.id.description);
        max_temp = findViewById(R.id.max_temp);
        min_temp = findViewById(R.id.min_temp);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RestInterface rest = retrofit.create(RestInterface.class);
        Call<WeatherApp> call = rest.getInfo();

        call.enqueue(new Callback<WeatherApp>() {

            @Override
            public void onResponse(Call<WeatherApp> call, Response<WeatherApp> response) {

                if (response.isSuccessful()) {

                    WeatherApp post = response.body();

                    String content = post.getCity().getName();
                    Double content2 = post.getWeatherList().get(1).getMain().getTemp();
                    String content3 = post.getWeatherList().get(1).getWeathers().get(0).getDescription();
                    String temporary = content3.substring(0,1).toUpperCase() + content3.substring(1);

                    int celcius = (int)(content2 - 273.15);
                    content += " " +"/" + " " + post.getCity().getCountry();

                    text.setText(content);
                    tempratureText.setText( String.valueOf(celcius) + "\u02DA" );
                    description.setText(temporary);
                    celcius = (int)(post.getWeatherList().get(0).getMain().getTempMax() - 273.15);
                    max_temp.setText("Highest temperature : " +" "+celcius);
                    celcius = (int)(post.getWeatherList().get(0).getMain().getTempMin() - 273.15);
                    min_temp.setText("Lowest temperature: "+" "+ celcius);
                }

            }

            @Override
            public void onFailure(Call<WeatherApp> call, Throwable t) {
                text.setText(t.getMessage());
            }
        });
    }
}
