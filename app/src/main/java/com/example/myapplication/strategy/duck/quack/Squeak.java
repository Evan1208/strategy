package com.example.myapplication.strategy.duck.quack;

import android.util.Log;

public class Squeak implements QuackBehavior{
    @Override
    public String quack() {
        return "Squeak!";
    }
}
