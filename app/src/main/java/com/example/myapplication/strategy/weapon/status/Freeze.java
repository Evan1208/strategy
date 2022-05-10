package com.example.myapplication.strategy.weapon.status;

public class Freeze implements LiveStatus {
    @Override
    public String status() {
        return this.getClass().getSimpleName();
    }
}
