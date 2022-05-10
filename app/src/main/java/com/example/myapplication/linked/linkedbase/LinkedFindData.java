package com.example.myapplication.linked.linkedbase;

public class LinkedFindData<A, B, C> {
    public final A first;
    public final B second;
    public final C third;

    public LinkedFindData(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static <A, B, C> LinkedFindData<A, B, C> create(A a, B b, C c) {
        return new LinkedFindData<>(a, b, c);
    }
}
