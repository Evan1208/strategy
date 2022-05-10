package com.example.myapplication.decorator.factory.newyork

import com.example.myapplication.decorator.factory.PizzaBase

class NYCheese : PizzaBase() {


    init {
        mName = "NY Style Sauce and Cheese Pizza"
        mDough = "Thin Crust Dough"
        mSauce = "Marinara Sauce"
        mToppings.add("Grated Reggiano Cheese.")
    }

}