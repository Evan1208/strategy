package com.example.myapplication.strategy.duck.colleague.paul;

public class Duck {
    public String quack = "";
    public String fly = "";
    public String show = "";

    public void showDuck() {
        Model_duck duck1 = new Model_duck();
        Wood_duck duck2 = new Wood_duck();
        White_duck duck3 = new White_duck();
        duck1.Fly(fly);
        duck2.Show(show);
        duck3.Quack(quack);
    }
}


class Model_duck implements DuckAction {

    @Override
    public String Quack(String str) {
        return "呱呱";
    }

    @Override
    public String Fly(String str) {
        return "咻咻咻";
    }

    @Override
    public String Show(String str) {
        return "探頭";
    }
}


class Wood_duck implements DuckAction {

    @Override
    public String Quack(String str) {

        return "嘎嘎";
    }

    @Override
    public String Fly(String str) {

        return "啪啪啪";
    }

    @Override
    public String Show(String str) {

        return "歪腰";
    }
}

class White_duck implements DuckAction {

    @Override
    public String Quack(String str) {

        return "啊啊";
    }

    @Override
    public String Fly(String str) {

        return "發發發";
    }

    @Override
    public String Show(String str) {

        return "踏步";
    }
}





