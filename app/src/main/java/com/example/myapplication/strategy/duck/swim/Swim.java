package com.example.myapplication.strategy.duck.swim;


public class Swim implements SwimBehavior {


    @Override
    public String swim() {
        return "Swim: I can swim.";
    }
}
