package com.example.myapplication.strategy.duck.quack;

import android.util.Log;

public class MuteQuack implements QuackBehavior {
    @Override
    public String quack() {
        return "Silence";
    }
}
