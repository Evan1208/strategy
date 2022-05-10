package com.example.myapplication.strategy.duck;


import com.example.myapplication.strategy.duck.fly.FlyNoWay;
import com.example.myapplication.strategy.duck.fly.FlyRocketPowered;
import com.example.myapplication.strategy.duck.quack.MuteQuack;
import com.example.myapplication.strategy.duck.swim.NotSwim;
import com.example.myapplication.strategy.duck.type.Duck;
import com.example.myapplication.strategy.duck.type.MallardDuck;
import com.example.myapplication.strategy.duck.type.ModelDuck;
import com.example.myapplication.strategy.duck.type.StoneDuck;

import java.util.ArrayList;

public class DuckData {
    // strategy pattern
    // 使用封裝的方式, 將資料與物件分別包裝
    // Has-a is better than Is-a.
    // 了解各運算邏輯, 此做法好維護
    private final ArrayList<Duck> mArrayDuck = new ArrayList<>();


    public DuckData() {
        for( int i=0 ; i < 20; i++) {
            DuckUtil mDuckUtil = new DuckUtil();
            Duck iMallard = new MallardDuck(mDuckUtil.mMallardDuck);

            Duck iModel = new ModelDuck(mDuckUtil.mModelDuck);
            iModel.setFlyBehavior(new FlyRocketPowered());

            Duck iStone = new StoneDuck(mDuckUtil.mStoneDuck);
            iStone.setFlyBehavior(new FlyNoWay());
            iStone.setQuackBehavior(new MuteQuack());
            iStone.setSwimBehavior(new NotSwim());


            mArrayDuck.add(iMallard);
            mArrayDuck.add(iModel);
            mArrayDuck.add(iStone);
        }
    }

    public ArrayList<Duck> getDuckData() {
        return mArrayDuck;
    }

}
