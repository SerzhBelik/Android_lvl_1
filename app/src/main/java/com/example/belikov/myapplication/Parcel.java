package com.example.belikov.myapplication;

import java.io.Serializable;

public class Parcel implements Serializable {
    public String city;
    public String weather;
    public String temperature;
    public String wind;
    public String humidity;
    public int currentPosition;
    public String[] weatherArr = new String[3];

    public void setWeatherArr (){
        weatherArr[0] = temperature;
        weatherArr[1] = wind;
        weatherArr[2] = humidity;
    }
}
