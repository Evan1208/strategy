package com.example.myapplication.oberserver.climate;

import com.example.myapplication.oberserver.climate.inter.Observer;
import com.example.myapplication.oberserver.climate.inter.Subject;

import java.util.ArrayList;
import java.util.Observable;

public class WeatherDataUseObservable extends Observable {
    private float mTemperature;
    private float mHumidity;
    private float mPressure;

    WeatherDataUseObservable(){

    }

    public void measurementsChange(){
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float pTemperature, float pHumidity, float pPressure) {
        mHumidity = pHumidity;
        mPressure = pPressure;
        mTemperature = pTemperature;
        measurementsChange();
    }

    public float getHumidity() {
        return mHumidity;
    }

    public float getPressure() {
        return mPressure;
    }

    public float getTemperature() {
        return mTemperature;
    }
}
