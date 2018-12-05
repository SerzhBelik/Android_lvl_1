package com.example.belikov.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class WeatherParam extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE) {
//            // Если устройство перевернули в альбомную ориентацию, то надо эту activity закрыть
//            finish();
//            return;
//        }

        if (savedInstanceState == null) {
//            super.onCreate(savedInstanceState);
            setContentView(R.layout.param_fragment);
        }
    }
}
