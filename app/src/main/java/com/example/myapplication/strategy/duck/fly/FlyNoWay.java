package com.example.myapplication.strategy.duck.fly;

import android.util.Log;

public class FlyNoWay implements FlyBehavior {
    @Override
    public String fly() {
        return "I can't fly!";
    }
}
