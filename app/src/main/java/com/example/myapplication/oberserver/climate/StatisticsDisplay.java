package com.example.myapplication.oberserver.climate;

import android.util.Log;

import com.example.myapplication.oberserver.climate.inter.DisplayElement;
import com.example.myapplication.oberserver.climate.inter.Observer;

public class StatisticsDisplay extends BaseDevice implements Observer, DisplayElement {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;
    private WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        register();
    }


    @Override
    public void update(float temp, float humidity, float pressure) {
        tempSum += temp;
        numReadings++;

        if (temp > maxTemp) {
            maxTemp = temp;
        }

        if (temp < minTemp) {
            minTemp = temp;
        }

        display();
    }

    @Override
    public void display() {
        Log.v("aaa","Avg/Max/Min temperature = " + (tempSum / numReadings)
                + "/" + maxTemp + "/" + minTemp);
    }

    @Override
    void register() {
        weatherData.registerObserver(this);
    }

    @Override
    void remove() {
        weatherData.removeObserver(this);
    }
}