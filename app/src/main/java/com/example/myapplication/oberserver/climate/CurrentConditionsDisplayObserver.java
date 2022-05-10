package com.example.myapplication.oberserver.climate;

import android.util.Log;

import com.example.myapplication.oberserver.climate.inter.DisplayElement;
import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplayObserver implements Observer, DisplayElement {
    private float mTemperature;
    private float mHumidity;
    private Observable mObservable;


    CurrentConditionsDisplayObserver(Observable weatherData) {
        mObservable = weatherData;
        mObservable.addObserver(this);
    }

    @Override
    public void display() {
        Log.v("aaa","Current conditions: " +
                mTemperature + ", F degrees and " +
                mHumidity + "% humidity.");
    }

    @Override
    public void update(Observable o, Object arg) {
        if( o instanceof WeatherDataUseObservable) {
            WeatherDataUseObservable iWeatherDataUseObservable = (WeatherDataUseObservable) o;
            mTemperature = iWeatherDataUseObservable.getTemperature();
            mHumidity = iWeatherDataUseObservable.getHumidity();
            display();
        }
    }
}
