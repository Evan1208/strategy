package com.example.myapplication.decorator;

import com.example.myapplication.decorator.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {
    protected Beverage mBeverage;
    private String mCondiment;

    public CondimentDecorator(Beverage pBeverage) {
        mBeverage = pBeverage;
    }

    protected void setCondiment(Class<? extends Beverage> pClass){
        mCondiment = pClass.getSimpleName();
    }

    protected String getCondiment(){
        return mCondiment;
    }

    public abstract String getDescription();
}
