package com.example.myapplication.strategy.weapon.types;

public class Fist implements Weapon{
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }
}
