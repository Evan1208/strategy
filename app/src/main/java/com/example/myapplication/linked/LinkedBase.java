package com.example.myapplication.linked;

import com.example.myapplication.linked.linkedbase.LinkedData;

public abstract class LinkedBase {
    public LinkedData mOriginalMyNumber;
    protected abstract void addPreData(int pInsertNumber, int pIndex);
    protected abstract void addNextData(int pInsertNumber, int pIndex);
}

