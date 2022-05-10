package com.example.myapplication.strategy.weapon.status;

public class Poison implements LiveStatus {
    @Override
    public String status() {
        return this.getClass().getSimpleName();
    }
}
