package com.example.myapplication.decorator.factory

import android.util.Log

abstract class PizzaBase {

    var mName:String ?= null
    var mDough:String ?= null
    var mSauce:String ?= null
    val mToppings = arrayListOf<String>()

    fun prepare() {
        reShowMessage(mName)
        reShowMessage(mDough)
        reShowMessage(mSauce)

    }

    protected fun reShowMessage(pAny: Any?) {
        pAny?.let {
            Log.v("aaa", "any = $it")
        } ?: kotlin.run {
            Log.v("aaa", "any = null")
        }
    }

    fun bake() {
        reShowMessage("Bake for 25 minutes at 350.")
    }

    open fun cut() {
        reShowMessage("Cutting the pizza into diagonal slices.")
    }

    fun box() {
        reShowMessage("Place pizza in official PizzaStore box.")
    }

    fun reGetName(): String? {
        return mName
    }
}