package com.example.myapplication.decorator.factory.chicago

import com.example.myapplication.decorator.factory.PizzaBase

class ChicagoCheese : PizzaBase() {


    init {
        mName = "Chicago Style Deep Dish Cheese Pizza"
        mDough = "Extra Thick Crust Dough"
        mSauce = "Plum Tomato Sauce"
        mToppings.add("Shredded Mozzarella Cheese.")
    }

    override fun cut() {
        reShowMessage("Cutting the pizza into square slices.")
    }

}