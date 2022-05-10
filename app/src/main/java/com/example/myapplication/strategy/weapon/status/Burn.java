package com.example.myapplication.strategy.weapon.status;

public class Burn implements LiveStatus {
    @Override
    public String status() {
        return this.getClass().getSimpleName();
    }
}
