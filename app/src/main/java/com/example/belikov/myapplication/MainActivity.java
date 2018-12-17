package com.example.belikov.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String TEXT_CONTENT = "В 2014 году Google представила новый подход к дизайну приложений. " +
            "Это была попытка сделать единообразный интерфейс для всех приложений Google и Android. " +
            "Интерфейс, который выглядел бы одинаково, независимо от того, где работает приложение: " +
            "на телефоне, планшете или компьютере. Материальный дизайн основан на образе бумаги на экране. " +
            "Ее называют квантовой или цифровой. Бумага тонкая, плоская, но расположена в трехмерном пространстве, " +
            "имеет тени и двигается. В таком образе предстают объекты интерфейса, " +
            "а анимация показывает пользователю, что происходит. Чрезмерная анимация не нужна, " +
            "Потому что никому не интересно ждать, пока окно с сообщением налетается по экрану.\n";
//    В 2014 году Google представила новый подход к дизайну приложений. Это была попытка сделать единообразный интерфейс для всех приложений Google и Android. Интерфейс, который выглядел бы одинаково, независимо от того, где работает приложение: на телефоне, планшете или компьютере.
//    Материальныйериальный дизайн основан на образе бумаги на экране. Ее называют квантовой или цифровой. Бумага тонкая, плоская, но расположена в трехмерном пространстве, имеет тени и двигается. В таком образе предстают объекты интерфейса, а анимация показывает пользователю, что происходит. Чрезмерная анимация не нужна, потому что никому никому не интересно ждать, пока окно с сообщением налетается по экрану.
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        TextView content = findViewById(R.id.content);
//        content.setText(TEXT_CONTENT);

        FloatingActionButton fab = findViewById(R.id.fab);
        // Обработка нажатия на плавающую кнопку
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Здесь вылетит Snackbar
                Snackbar.make(view, "Вы нажали на плавающую кнопку", Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Размещение меню в action bar
        // если он присутствует.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        return super.onOptionsItemSelected(item);
    }
}