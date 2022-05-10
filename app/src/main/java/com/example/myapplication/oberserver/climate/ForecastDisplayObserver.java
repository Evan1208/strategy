package com.example.myapplication.oberserver.climate;

import android.util.Log;

import com.example.myapplication.oberserver.climate.inter.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplayObserver implements Observer, DisplayElement {
    private float currentPressure = 29.92f;
    private float lastPressure;
    private Observable mObservable;

    public ForecastDisplayObserver(Observable weatherData) {
        this.mObservable = weatherData;
        mObservable.addObserver(this);
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
    public void update(Observable o, Object arg) {
        if( o instanceof WeatherDataUseObservable) {
            WeatherDataUseObservable iWeatherDataUseObservable = (WeatherDataUseObservable) o;
            lastPressure = currentPressure;
            currentPressure = iWeatherDataUseObservable.getPressure();
            display();
        }
    }
}