package com.example.myapplication.strategy.duck.type;

import com.example.myapplication.strategy.duck.fly.FlyNoWay;
import com.example.myapplication.strategy.duck.quack.Quack;
import com.example.myapplication.strategy.duck.swim.Swim;

public class StoneDuck extends Duck {

    public StoneDuck(String pStoneDuck) {
        mFlyBehavior = new FlyNoWay();
        mQuackBehavior = new Quack();
        mSwimBehavior = new Swim();
        setDuckName(pStoneDuck);
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
