package com.example.belikov.myapplication;

import android.os.Parcelable;

class MyParcel implements Parcelable {
    public String city;
    public String weather;
    public String temperature;
    public String wind;
    public String humidity;
    public String pressure;
    public int currentPosition;
    public String[] weatherArr = new String[4];

    protected MyParcel(android.os.Parcel in) {
        city = in.readString();
        weather = in.readString();
        temperature = in.readString();
        wind = in.readString();
        humidity = in.readString();
        pressure = in.readString();
        currentPosition = in.readInt();
        weatherArr = in.createStringArray();
        }

    public MyParcel (String city, String weather, String temperature, String wind, String humidity, String pressure, int currentPosition){
        this.city = city;
        this.weather = weather;
        this.temperature = temperature;
        this.wind = wind;
        this.humidity = humidity;
        this.pressure = pressure;
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
        weatherArr[3] = pressure;
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
        dest.writeString(pressure);
        dest.writeInt(currentPosition);
        setWeatherArr();
        dest.writeStringArray(weatherArr);
    }

}
