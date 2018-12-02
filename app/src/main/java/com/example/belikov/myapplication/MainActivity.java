package com.example.belikov.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;

import android.widget.Switch;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private static final String TAG = "Weather";
    private static final String TEXT = "Get weather";
    private String[] weather_en = {"sunny", "partially cloudy", "cloudy", "rainy"};
    private String[] weather_ru = {"солнечно", "переменная облачность", "облачно", "осадки"};
    private String[] weather = weather_en;
    private String[]temperature = {"0 - +10", "+10 - +15", "+ 15 - +10", "> +25"};
    private String[]wind_ru = {"0 - 3 м/с", "3 - 5 м/с", "5 - 10 м/с", "> 10 м/с"};
    private String[]wind_en = {"0 - 3 mps", "3 - 5 mps", "5 - 10 mps", "> 10 mps"};
    private String[]wind = wind_en;
    private String[]humidity = {"0 - 20%", "20 - 50%", "50 - 80%", "> 80%"};

    Spinner spinner;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;

    private Switch aSwitch = null;
    private Locale locale;
    private String lang = "en";
    private Bundle savedInstanceState;
    private static boolean flag = false;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.savedInstanceState = savedInstanceState;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

//        if (savedInstanceState != null) {
//            lang = savedInstanceState.getString("lang");
//            wind = savedInstanceState.getStringArray("wind");
//            weather = savedInstanceState.getStringArray("weather");
//        }


        String instanceState;
        if (savedInstanceState == null){
            instanceState = "Первый запуск!";
        }
        else{
            instanceState = "Повторный запуск!";
        }


        aSwitch = findViewById(R.id.switch1);
        if (aSwitch != null) {
            aSwitch.setOnCheckedChangeListener(this);
        }

        if (Locale.getDefault().getLanguage().equals("ru")){
            weather = weather_ru;
            wind = wind_ru;
            aSwitch.setChecked(true);
        } else {
            weather = weather_en;
            wind = wind_en;
            aSwitch.setChecked(false);
        }

        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, instanceState + " - onCreate()");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, weather);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, temperature);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, wind);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, humidity);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);

        spinner.setAdapter(adapter);
        spinner1.setAdapter(adapter1);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);

        spinner.setSelection(0);
        spinner1.setSelection(0);
        spinner2.setSelection(0);
        spinner3.setSelection(0);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Parcel parcel = new Parcel();
                parcel.city = findViewById(R.id.editText1).toString();
                parcel.weather = spinner.getSelectedItem().toString();
                parcel.temperature = spinner1.getSelectedItem().toString();
                parcel.wind = spinner2.getSelectedItem().toString();
                parcel.humidity = spinner3.getSelectedItem().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(TEXT, parcel);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "onStart()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "onStop()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "onDestroy()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onDestroy()");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Toast.makeText(getApplicationContext(), "onSaveInstanceState()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onSaveInstanceState()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "onPause()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "onResume()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(), "onRestoreInstanceState()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onRestoreInstanceState()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        startActivityForResult(new Intent(this, MainActivity.class), 0);
        Toast.makeText(getApplicationContext(), "onRestart()", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onRestart()");
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


        if (isChecked){
            if (Locale.getDefault().getLanguage().equals("ru")) return;
            setLocale("ru");


        }
        if (!isChecked){
            if (Locale.getDefault().getLanguage().equals("en")) return;
            setLocale("en");


        }

        startActivityForResult(new Intent(this, MainActivity.class), 0);

    }

    private void setLocale(String lang){
        this.lang = lang;
        locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration, null);
    }
}
