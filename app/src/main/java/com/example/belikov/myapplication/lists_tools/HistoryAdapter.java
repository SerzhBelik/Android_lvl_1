package com.example.belikov.myapplication.lists_tools;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.belikov.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private List<String> dataList;

    // Этот класс хранит связь между данными и элементами View
    // Сложные данные могут потребовать несколько View на
    // Один пункт списка
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Каждый пункт списка в нашем случае это строка
        public TextView textView;

        public ViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }

    // Передаем в конструктор источник данных
    // В нашем случае это массив, но может быть и запросом к БД
    public HistoryAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    // Создать новый элемент пользовательского интерфейса
    // Запускается менеджером
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Создаем новый элемент пользовательского интерфейса
        // Через Inflater
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        // Здесь можно установить всякие параметры
        ViewHolder vh = new ViewHolder((TextView) v);
        return vh;
    }

    // Заменить данные в пользовательском интерфейсе
    // Вызывается менеджером
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Получить элемент из источника данных (БД, интернет...)
        // Вынести на экран используя ViewHolder
        Object[] data = dataList.toArray();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, position - data.length);
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
        String datetime = dateformat.format(c.getTime());
        holder.textView.setText(datetime + ": " + data[position]);

    }

    // Вернуть размер данных, вызывается менеджером
    @Override
    public int getItemCount() {
        return dataList.toArray().length;
    }
}
