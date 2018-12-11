package com.example.belikov.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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

    private String[] data = {"+10","+11","+9","+12","+10","+11","+10","+12","+8","+9"};
    private List<String> dataList = new ArrayList<>(Arrays.asList(data));
    HistoryAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actitvity_history_list);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // Эта установка служит для повышения производительности системы
        recyclerView.setHasFixedSize(true);

        // Будем работать со встроенным менеджером
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Установим адаптер

        adapter = new HistoryAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }

    public void onClickMoreDays(View view){
        Random rnd = new Random(System.currentTimeMillis());
// Получаем случайное число в диапазоне от min до max (включительно)
        int number = 5 + rnd.nextInt(10);
        dataList.add("+" + number);
        adapter.notifyDataSetChanged();
    }
}
