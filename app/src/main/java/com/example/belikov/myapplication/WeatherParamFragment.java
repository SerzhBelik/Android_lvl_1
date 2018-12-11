package com.example.belikov.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WeatherParamFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.weather_param, container, true);
        TextView weatherParam = v.findViewById(R.id.w_param);
        String[] params = getResources().getStringArray(R.array.Weather);
        MyParcel parcel = getActivity().getIntent().getParcelableExtra(MainActivity.TEXT);
        weatherParam.setText(params[parcel.currentPosition] + "\n" + parcel.weatherArr[parcel.currentPosition]);
        return v;
    }

//    public void onClickHistory(View view){
//
//    }
}