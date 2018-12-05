package com.example.belikov.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class WeatherParamFragment extends Fragment {
    private static final String TEXT = "Get weather";

//    // Фабричный метод создает фрагмент и передает параметр
//    public static WeatherParamFragment create(int index) {
//        WeatherParamFragment w = new WeatherParamFragment();    // создание

//        // Передача параметра
//        Bundle args = new Bundle();
//        args.putInt("index", index);
//        w.setArguments(args);
//        return w;
//    }

    // Получить индекс из списка (фактически из параметра)
    public int getIndex() {
        int index = getArguments().getInt("index", 0);
        return index;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        TextView weaterParam = (TextView) getActivity().findViewById(R.id.)
        View v = inflater.inflate(R.layout.weather_param, container, true);
        TextView weatherParam = v.findViewById(R.id.w_param);
        Parcel parcel = (Parcel) getActivity().getIntent().getExtras().getSerializable(TEXT);
        weatherParam.setText(parcel.weatherArr[parcel.currentPosition]);
//        savedInstanceState.getInt("index");
        return v;

        // Определить какой герб надо показать, и показать его
//        ImageView coatOfArms = new ImageView(getActivity());

        // Получить из ресурсов массив указателей на изображения гербов
//        TypedArray imgs = getResources().obtainTypedArray(R.array.coatofarms_imgs);
//        // Выбрать по индексу подходящий
//        coatOfArms.setImageResource(imgs.getResourceId(getIndex(), -1));
//        return coatOfArms;                                  // Вместо макета используем сразу картинку

    }

}
