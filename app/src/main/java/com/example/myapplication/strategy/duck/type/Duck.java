package com.example.myapplication.strategy.duck.type;

import com.example.myapplication.strategy.duck.fly.FlyBehavior;
import com.example.myapplication.strategy.duck.fly.FlyWithWings;
import com.example.myapplication.strategy.duck.quack.Quack;
import com.example.myapplication.strategy.duck.quack.QuackBehavior;
import com.example.myapplication.strategy.duck.swim.Swim;
import com.example.myapplication.strategy.duck.swim.SwimBehavior;

public abstract class Duck {
    FlyBehavior mFlyBehavior;
    QuackBehavior mQuackBehavior;
    SwimBehavior mSwimBehavior;
    String mDuckName;
    String mDisplay;

    public Duck() {
        mQuackBehavior = new Quack();
        mFlyBehavior = new FlyWithWings();
        mSwimBehavior = new Swim();
    }

    public void setFlyBehavior(FlyBehavior pFb) {
        mFlyBehavior = pFb;
    }

    public void setQuackBehavior(QuackBehavior pQb) {
        mQuackBehavior = pQb;
    }

    public void setSwimBehavior(SwimBehavior pSb) {
        mSwimBehavior = pSb;
    }

    public String performFly() {
        return mFlyBehavior.fly();
    }

    public String performQuack() {
        return mQuackBehavior.quack();
    }

    public String preformSwim() {
        return mSwimBehavior.swim();
    }

    protected void setDuckName(String pMallardDuck) {
        mDuckName = pMallardDuck;
        mDisplay = String.format("name is %s",mDuckName);
    }

    public abstract String display();
    public abstract String getDuckName();
}
