package com.example.myapplication.decorator.coffee;

import com.example.myapplication.decorator.beverage.Beverage;

public class HouseBlend extends Beverage {

    public HouseBlend() {
        this.setDescription(this.getClass());
    }

    @Override
    public double cost() {
        return .89;
    }
}
