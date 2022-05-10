package com.example.myapplication.oberserver.climate;

import com.example.myapplication.oberserver.climate.inter.Observer;
import com.example.myapplication.oberserver.climate.inter.Subject;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private final ArrayList<Observer> mObservers = new ArrayList<>();
    private float mTemperature;
    private float mHumidity;
    private float mPressure;

    WeatherData(){
        mObservers.clear();
    }


    public void measurementsChange(){
        notifyObservers();
    }

    public void setMeasurements(float pTemperature, float pHumidity, float pPressure) {
        mHumidity = pHumidity;
        mPressure = pPressure;
        mTemperature = pTemperature;
        measurementsChange();
    }


    //---------interface---------------
    @Override
    public void registerObserver(Observer o) {
        mObservers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int iIndex = mObservers.indexOf(o);
        if( iIndex >= 0) {
            mObservers.remove(iIndex);
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer iObserver : mObservers) {
            iObserver.update(mTemperature, mHumidity, mPressure);
        }
    }


}
