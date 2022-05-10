package com.example.myapplication.strategy.duck.swim;


public class NotSwim implements SwimBehavior {

    @Override
    public String swim() {
        return "Swim: I cannot swim.";
    }
}
