package com.example.myapplication.strategy.weapon.status;

public class Health implements LiveStatus {
    @Override
    public String status() {
        return this.getClass().getSimpleName();
    }
}
