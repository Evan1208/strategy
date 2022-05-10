package com.example.myapplication.strategy.weapon.types;

public class Axe implements Weapon{
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }
}
