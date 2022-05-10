package com.example.myapplication.decorator.beverage;

public abstract class Beverage {
    protected String mDescription = "Unknown Beverage";

    public String getDescription(){
        return mDescription;
    }

    public void setDescription(Class<? extends Beverage> pClass){
        mDescription = pClass.getSimpleName();
    }

    public abstract double cost();
}

