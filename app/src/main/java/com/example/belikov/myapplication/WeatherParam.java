package com.example.belikov.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class WeatherParam extends AppCompatActivity {
//  private int position;
  MyParcel parcel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.param_fragment);

    parcel = getIntent().getParcelableExtra(MainActivity.TEXT);
//  position = parcel.currentPosition;

  }

  public void onClickHistory(View view){
    Intent intent = new Intent(this, HistoryList.class);
    intent.putExtra(MainActivity.TEXT, parcel);
    startActivity(intent);

  }
}