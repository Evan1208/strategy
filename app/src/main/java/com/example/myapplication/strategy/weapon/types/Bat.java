package com.example.myapplication.strategy.weapon.types;

public class Bat implements Weapon{
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }
}
