package com.example.myapplication.decorator.coffee;

import com.example.myapplication.decorator.beverage.Beverage;

public class Espresso extends Beverage {

    public Espresso() {
        setDescription(this.getClass());
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
