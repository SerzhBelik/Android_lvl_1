package com.example.belikov.myapplication;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class WeatherFragment extends ListFragment {

    int currentPosition = 0;    // Текущая позиция (выбранный параметр погоды)
    private static final String TEXT = "Get weather";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
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
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("WeatherParam", currentPosition);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        currentPosition = position;
        showWeatherParam();
    }

    private void showWeatherParam() {

            getListView().setItemChecked(currentPosition, true);

            Parcel parcel = (Parcel) getActivity().getIntent().getExtras().getSerializable(TEXT);
            parcel.currentPosition = currentPosition;


            Intent intent = new Intent();
            intent.setClass(getActivity(),WeatherParam.class);
            intent.putExtra(TEXT, parcel);
            startActivity(intent);
    }
}