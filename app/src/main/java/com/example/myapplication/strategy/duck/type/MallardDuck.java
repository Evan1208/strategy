package com.example.myapplication.strategy.duck.type;

import com.example.myapplication.strategy.duck.fly.FlyWithWings;
import com.example.myapplication.strategy.duck.quack.Quack;
import com.example.myapplication.strategy.duck.swim.Swim;

public class MallardDuck extends Duck {


    public MallardDuck(String pMallardDuck) {
        setDuckName(pMallardDuck);
    }

    @Override
    public String display() {
        return mDisplay;
    }

    @Override
    public String getDuckName() {
        return mDuckName;
    }
}
