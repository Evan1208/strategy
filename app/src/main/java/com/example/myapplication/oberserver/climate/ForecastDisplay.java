package com.example.myapplication.oberserver.climate;

import android.util.Log;

import com.example.myapplication.oberserver.climate.inter.DisplayElement;
import com.example.myapplication.oberserver.climate.inter.Observer;

public class ForecastDisplay extends BaseDevice implements Observer, DisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;
    private final WeatherData weatherData;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        register();
    }
    @Override
    public void update(float temp, float humidity, float pressure) {
        lastPressure = currentPressure;
        currentPressure = pressure;

        display();
    }
    @Override
    public void display() {
        if (currentPressure > lastPressure) {
            Log.v("aaa","Forecast: Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            Log.v("aaa","Forecast: More of the same");
        } else if (currentPressure < lastPressure) {
             Log.v("aaa","Forecast: Watch out for cooler, rainy weather");
        }
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