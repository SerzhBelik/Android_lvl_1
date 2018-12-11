package com.example.belikov.myapplication;

import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.belikov.myapplication.lists_tools.HistoryAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HistoryList extends AppCompatActivity {

    private String[] dataTemp = {"+10","+11","+9","+12","+10","+11","+10","+12","+8","+9"};
    private String[] dataWind = {"5 м/с","3 м/с","4 м/с","1 м/с","2 м/с","0 м/с","3 м/с","7 м/с","5м/с","3м/с"};
    private String[] dataHumid = {"60%","62%","70%","58%","78%","85%","60%","80%","55%","67%"};
    private String[] dataPres = {"755 мм рт. ст.","756 мм рт. ст.","758 мм рт. ст.","760 мм рт. ст.",
            "762 мм рт. ст.","755 мм рт. ст.","753 мм рт. ст.","750 мм рт. ст.","755 мм рт. ст.","756 мм рт. ст."};
    private List<String> dataList;
    HistoryAdapter adapter;
    int currentPosition;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actitvity_history_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // Эта установка служит для повышения производительности системы
        recyclerView.setHasFixedSize(true);

        // Будем работать со встроенным менеджером
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Установим адаптер

        setDataList();
        adapter = new HistoryAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }

    public void onClickMoreDays(View view){


        String s = newElement(currentPosition);
        dataList.add(0, s);
        adapter.notifyDataSetChanged();
    }

    private void setDataList(){
        MyParcel parcel = getIntent().getParcelableExtra(MainActivity.TEXT);
        currentPosition = parcel.currentPosition;
        switch (currentPosition){
            case 0:
                dataList = new ArrayList<>(Arrays.asList(dataTemp));
                break;
            case 1:
                dataList = new ArrayList<>(Arrays.asList(dataWind));
                break;
            case 2:
                dataList = new ArrayList<>(Arrays.asList(dataHumid));
                break;
            case 3:
                dataList = new ArrayList<>(Arrays.asList(dataPres));
                break;
        }
    }

    private String newElement(int currentPosition){
        String s = null;
        Random rnd = new Random(System.currentTimeMillis());
        switch (currentPosition){
            case 0:
                s = "+" + 5 + (rnd.nextInt(10));
                break;
            case 1:
                s = ((rnd.nextInt(10))) + " м/с";
                break;
            case 2:
                s = (20 + (rnd.nextInt(80))) + "%";
                break;
            case 3:
                s = (740 + (rnd.nextInt(40))) + " мм рт. ст.";
                break;
        }
        return s;
    }
}
