package com.example.belikov.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

class MyParcel implements Parcelable {
    public String city;
    public String weather;
    public String temperature;
    public String wind;
    public String humidity;
    public int currentPosition;
    public String[] weatherArr = new String[3];

    protected MyParcel(android.os.Parcel in) {
        city = in.readString();
        weather = in.readString();
        temperature = in.readString();
        wind = in.readString();
        humidity = in.readString();
        currentPosition = in.readInt();
        weatherArr = in.createStringArray();
    }

    public MyParcel (String city, String weather, String temperature, String wind, String humidity, int currentPosition){
        this.city = city;
        this.weather = weather;
        this.temperature = temperature;
        this.wind = wind;
        this.humidity = humidity;
        this.currentPosition = currentPosition;
    }

    public static final Creator<MyParcel> CREATOR = new Creator<MyParcel>() {
        @Override
        public MyParcel createFromParcel(android.os.Parcel in) {
            return new MyParcel(in);
        }

        @Override
        public MyParcel[] newArray(int size) {
            return new MyParcel[size];
        }
    };

    private void setWeatherArr (){
        weatherArr[0] = temperature;
        weatherArr[1] = wind;
        weatherArr[2] = humidity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeString(city);
        dest.writeString(weather);
        dest.writeString(temperature);
        dest.writeString(wind);
        dest.writeString(humidity);
        dest.writeInt(currentPosition);
        setWeatherArr();
        dest.writeStringArray(weatherArr);
    }

}
