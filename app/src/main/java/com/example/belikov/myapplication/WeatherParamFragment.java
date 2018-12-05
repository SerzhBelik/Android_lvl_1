package com.example.belikov.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WeatherParamFragment extends Fragment {
    private static final String TEXT = "Get weather";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.weather_param, container, true);
        TextView weatherParam = v.findViewById(R.id.w_param);
        Parcel parcel = (Parcel) getActivity().getIntent().getExtras().getSerializable(TEXT);
        weatherParam.setText(parcel.weatherArr[parcel.currentPosition]);

        return v;
    }

}
