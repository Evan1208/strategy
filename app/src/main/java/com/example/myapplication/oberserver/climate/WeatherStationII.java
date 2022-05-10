package com.example.myapplication.oberserver.climate;

import java.util.ArrayList;

public class WeatherStationII {
    private final WeatherData mWeatherData = new WeatherData();
    private final ArrayList<BaseDevice> mAllDevices = new ArrayList<>();

    public void testWeatherData() {
        addCurrentConditionsDisplay();
        addStatisticsDisplay();
        addForecastDisplay();
        mWeatherData.setMeasurements(80, 65, 30.4f);
        mWeatherData.setMeasurements(82, 70, 29.2f);
        mWeatherData.setMeasurements(78, 90, 29.2f);
    }

    public void remove() {
        if( mAllDevices.size() > 0) {
            mAllDevices.get(0).remove();
        }
    }

    public void addCurrentConditionsDisplay() {
        mAllDevices.add(new CurrentConditionsDisplay(mWeatherData));
    }

    public void addStatisticsDisplay() {
        mAllDevices.add(new StatisticsDisplay(mWeatherData));
    }

    public void addForecastDisplay() {
        mAllDevices.add(new ForecastDisplay(mWeatherData));
    }
}
