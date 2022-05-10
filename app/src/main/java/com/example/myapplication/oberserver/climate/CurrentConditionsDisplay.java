package com.example.myapplication.oberserver.climate;

import android.util.Log;

import com.example.myapplication.oberserver.climate.inter.DisplayElement;
import com.example.myapplication.oberserver.climate.inter.Observer;
import com.example.myapplication.oberserver.climate.inter.Subject;

public class CurrentConditionsDisplay extends BaseDevice implements Observer, DisplayElement {
    private float mTemperature;
    private float mHumidity;
    private final Subject mWeatherData;


    CurrentConditionsDisplay(Subject weatherData) {
        mWeatherData = weatherData;
        register();
    }

    @Override
    void register() {
        mWeatherData.registerObserver(this);
    }

    @Override
    void remove() {
        mWeatherData.removeObserver(this);
    }

    @Override
    public void display() {
        Log.v("aaa","Current conditions: " +
                mTemperature + ", F degrees and " +
                mHumidity + "% humidity.");
    }

    @Override
    public void update(float pTemperature, float pHumidity, float pPressure) {
        mTemperature = pTemperature;
        mHumidity = pHumidity;
        display();
    }


}
