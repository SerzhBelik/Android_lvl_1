package com.example.belikov.myapplication;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;

public class WeatherFragment extends ListFragment {

    int currentPosition = 0;    // Текущая позиция (выбранный параметр погоды)
    private static final String TEXT = "Get weather";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getActivity().getApplicationContext(), "onCreateView()", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Weather,
                android.R.layout.simple_list_item_activated_1);

        setListAdapter(adapter);

        if (savedInstanceState != null) {

            currentPosition = savedInstanceState.getInt("WeatherParam", 0);
        }

        Toast.makeText(getActivity().getApplicationContext(), "onActivityCreated()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("WeatherParam", currentPosition);
        Toast.makeText(getActivity().getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        currentPosition = position;
        showWeatherParam();
    }

    private void showWeatherParam() {

            getListView().setItemChecked(currentPosition, true);

            MyParcel parcel = getActivity().getIntent().getParcelableExtra(MainActivity.TEXT);
            parcel.currentPosition = currentPosition;


            Intent intent = new Intent();
            intent.setClass(getActivity(),WeatherParam.class);
            intent.putExtra(TEXT, parcel);
            startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getActivity().getApplicationContext(), "onDestroyView()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Toast.makeText(getActivity().getApplicationContext(), "onAttach()", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getActivity().getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity().getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity().getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        Toast.makeText(getActivity().getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity().getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getActivity().getApplicationContext(), "onDetach()", Toast.LENGTH_SHORT).show();
    }
}