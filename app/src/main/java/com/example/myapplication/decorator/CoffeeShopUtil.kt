package com.example.myapplication.decorator

import android.content.Context
import com.example.myapplication.R
import kotlin.collections.ArrayList

class CoffeeShopUtil(mContext: Context) {


    private val mCoffeesArray = arrayListOf<String>()
    private val mCondimentsArray = arrayListOf<String>()
    private val mAllString = arrayListOf<String>()
    val mTypeCoffee = "Coffee"
    //需注意  string資料與此資料需對稱
    val mTypeEspresso = "Espresso"
    val mTypeHouseBlend = "HouseBlend"

    val mTypeCondiment = "Condiment"
    val mTypeMocha = "Mocha"
    val mTypeSoy = "Soy"
    val mTypeWhip = "Whip"
    val mTypeBitter = "Bitter"


    init {
        mCoffeesArray.addAll(listOf<String>(*mContext.resources.getStringArray(R.array.Coffee)))
        mCondimentsArray.addAll(listOf<String>(*mContext.resources.getStringArray(R.array.Condiments)))
        mCoffeesArray.add(0, mTypeCoffee);
        mCondimentsArray.add(0, mTypeCondiment)
        mAllString.addAll(mCoffeesArray)
        mAllString.addAll(mCondimentsArray)
    }

    fun getAllData(): ArrayList<String> {
        return mAllString
    }
}
