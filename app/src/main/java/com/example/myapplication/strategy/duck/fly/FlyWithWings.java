package com.example.myapplication.strategy.duck.fly;

import android.util.Log;

public class FlyWithWings implements FlyBehavior{

    @Override
    public String fly() {
        return "I'm flying!!";
    }
}
