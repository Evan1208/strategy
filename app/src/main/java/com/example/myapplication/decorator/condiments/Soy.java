package com.example.myapplication.decorator.condiments;

import com.example.myapplication.decorator.beverage.Beverage;
import com.example.myapplication.decorator.CondimentDecorator;

public class Soy extends CondimentDecorator {

    public Soy(Beverage pBeverage) {
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
