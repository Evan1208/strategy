package com.example.myapplication.linked.linkedbase;

import com.example.myapplication.linked.LinkedBase;

public abstract class LinkedData {

    protected int mNumber = 0;
    protected final int mTypeNext = 1;
    protected final int mTypePre = 2;

    public abstract void setNumber(int pNumber);
    public abstract int getNumber();
    public abstract boolean insertPre(int pInsertNumber, int pIndex, LinkedBase pOriginalMyNumber);
    public abstract boolean insertNext(int pInsertNumber, int pIndex, LinkedBase pOriginalMyNumber);
    protected abstract void setLinkedConnect(LinkedFindData<LinkedData, LinkedData, Boolean> pPare,
                                        LinkedBase pOriginalMyNumber, int pTypePreOrNext, int pInsertNumber);
    protected abstract LinkedFindData<LinkedData, LinkedData, Boolean> findData(int pIndex);
}

