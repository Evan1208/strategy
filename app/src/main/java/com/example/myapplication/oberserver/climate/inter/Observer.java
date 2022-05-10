package com.example.myapplication.oberserver.climate.inter;

public interface Observer {
    void update(float pTemperature, float pHumidity, float pPressure);
}
