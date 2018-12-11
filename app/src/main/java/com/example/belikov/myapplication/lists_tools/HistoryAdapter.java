package com.example.belikov.myapplication.lists_tools;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.belikov.myapplication.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private List<String> dataList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }

    public HistoryAdapter(List<String> dataList) {
        this.dataList = dataList;
    }

    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        ViewHolder vh = new ViewHolder((TextView) v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Object[] data = dataList.toArray();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, position - data.length);
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
        String datetime = dateformat.format(c.getTime());
        holder.textView.setText(datetime + ": " + data[position]);

    }

    @Override
    public int getItemCount() {
        return dataList.toArray().length;
    }
}
