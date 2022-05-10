package com.example.myapplication.strategy.duck.quack;

import android.util.Log;

public class Quack implements QuackBehavior {

    @Override
    public String quack() {
        return "Sound: Quack!!";
    }
}
