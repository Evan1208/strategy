package com.example.myapplication.strategy.duck.colleague.yichen;

//題目：有個產品為 Duck 並延伸出了三種不同的Duck,
// Model duck, Wood duck, White duck
// 並 都有 Quack, Fly, and Show的功能
//
// Duck產品延伸出不同的Duck -->implements
// 延伸出來3個Duck都有共同的功能-->extends


import android.util.Log;

class DuckFunction{
    public void Quack()
    { Log.v("aaa","Quack"); }
    public void Fly()
    { Log.v("aaa","Fly"); }
    public void Show()
    { Log.v("aaa","Show"); }
}

interface Duck { void DuckDifferent(); }

class ModelDuck extends DuckFunction implements Duck {
    @Override
    public void DuckDifferent() {
        Log.v("aaa","Model duck");
    }
//    public void DuckDifferent(){
//        Log.v("aaa","Model duck");
//    }
}
class Woodduck extends DuckFunction implements Duck{
    @Override
    public void DuckDifferent() {
        Log.v("aaa","Wood duck");
    }
//    public void DuckDifferent(){
//        Log.v("aaa","Wood duck");
//    }
}
class Whiteduck  implements Duck{
    @Override
    public void DuckDifferent() {
        Log.v("aaa","White duck");
    }
//    public void DuckDifferent(){
//        Log.v("aaa","White duck");
//    }
}
public class Main{
    public static void main(String[] args){
        Duck d = new ModelDuck();
        d.DuckDifferent();
        DuckFunction df = new ModelDuck();
        df.Quack();

    }
}
