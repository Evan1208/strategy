package com.example.myapplication.oberserver.climate;

public class WeatherStationI {

    public void testWeatherData() {
        WeatherData iWeatherData = new WeatherData();


        CurrentConditionsDisplay iCurrentConditionsDisplay =
                new CurrentConditionsDisplay(iWeatherData);
        StatisticsDisplay iStatisticsDisplay =
                new StatisticsDisplay(iWeatherData);
        ForecastDisplay iForecastDisplay =
                new ForecastDisplay(iWeatherData);

        iWeatherData.setMeasurements(80, 65, 30.4f);
        iWeatherData.setMeasurements(82, 70, 29.2f);
        iWeatherData.setMeasurements(78, 90, 29.2f);
    }

    public void testWeatherDataObserver() {
        WeatherDataUseObservable iWeatherData = new WeatherDataUseObservable();


        CurrentConditionsDisplayObserver iCurrentConditionsDisplay =
                new CurrentConditionsDisplayObserver(iWeatherData);
        StatisticsDisplayObserver iStatisticsDisplay =
                new StatisticsDisplayObserver(iWeatherData);
        ForecastDisplayObserver iForecastDisplay =
                new ForecastDisplayObserver(iWeatherData);

        iWeatherData.setMeasurements(80, 65, 30.4f);
        iWeatherData.setMeasurements(82, 70, 29.2f);
        iWeatherData.setMeasurements(78, 90, 29.2f);
    }
}
