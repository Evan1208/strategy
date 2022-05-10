package com.example.myapplication.strategy.weapon.types;

public class WoodStick implements Weapon{
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }
}
