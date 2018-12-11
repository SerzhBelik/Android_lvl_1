package com.example.belikov.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyParcel parcel = getIntent().getParcelableExtra(MainActivity.TEXT);

        TextView city = findViewById(R.id.city);
        TextView weather = findViewById(R.id.weather_type);
        TextView temperature = findViewById(R.id.temperature);
        TextView wind = findViewById(R.id.wind);
        TextView humidity = findViewById(R.id.humidity);
        TextView perssure = findViewById(R.id.perssure);
        String tomorrow = getResources().getString(R.string.tomorrow);

        city.setText(city.getText() + " " + parcel.getCity());
        weather.setText(tomorrow + " " + parcel.getWeather());
        temperature.setText(temperature.getText() + " " + parcel.getTemperature());
        wind.setText(wind.getText() + " " + parcel.getWind());
        humidity.setText(humidity.getText() + " " + parcel.getHumidity());
        perssure.setText(perssure.getText() + " " + parcel.getPressure());

        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск!";
        }
        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, instanceState + " - onCreate()");
    }
}