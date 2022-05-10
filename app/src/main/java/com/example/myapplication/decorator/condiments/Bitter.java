package com.example.myapplication.decorator.condiments;

import com.example.myapplication.decorator.CondimentDecorator;
import com.example.myapplication.decorator.beverage.Beverage;

public class Bitter extends CondimentDecorator {

    public Bitter(Beverage pBeverage) {
        super(pBeverage);
        setCondiment(this.getClass());
    }

    @Override
    public String getDescription() {
        return mBeverage.getDescription() + "," + getCondiment();
    }

    @Override
    public double cost() {
        return .20 + mBeverage.cost();
    }
}
