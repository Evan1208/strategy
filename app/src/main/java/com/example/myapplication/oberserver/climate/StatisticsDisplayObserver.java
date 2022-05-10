package com.example.myapplication.oberserver.climate;

import android.util.Log;

import com.example.myapplication.oberserver.climate.inter.DisplayElement;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplayObserver implements Observer, DisplayElement {
    private float maxTemp = 0.0f;
    private float minTemp = 200;
    private float tempSum = 0.0f;
    private int numReadings;
    private Observable mObservable;

    public StatisticsDisplayObserver(Observable pObservable) {
        this.mObservable = pObservable;
        mObservable.addObserver(this);
    }

    @Override
    public void display() {
         Log.v("aaa","Avg/Max/Min temperature = " + (tempSum / numReadings)
                + "/" + maxTemp + "/" + minTemp);
    }

    @Override
    public void update(Observable o, Object arg) {
        if( o instanceof WeatherDataUseObservable) {
            WeatherDataUseObservable iWeatherDataUseObservable = (WeatherDataUseObservable) o;
            float iTemp = iWeatherDataUseObservable.getTemperature();
            tempSum += iTemp;
            numReadings++;

            if (iTemp > maxTemp) {
                maxTemp = iTemp;
            }

            if (iTemp < minTemp) {
                minTemp = iTemp;
            }
            display();
        }
    }
}