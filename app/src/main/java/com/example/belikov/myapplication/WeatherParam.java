package com.example.belikov.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class WeatherParam extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.param_fragment);
    MyParcel parcel = getIntent().getParcelableExtra(MainActivity.TEXT);
    Toast.makeText(getApplicationContext(), "onCreate(), " + parcel.weatherArr[1], Toast.LENGTH_SHORT).show();
  }
}