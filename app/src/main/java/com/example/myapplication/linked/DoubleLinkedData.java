package com.example.myapplication.linked;

import android.util.Log;

import com.example.myapplication.linked.linkedbase.DoubleLinkedList;
import com.example.myapplication.linked.linkedbase.LinkedData;

import java.util.ArrayList;

public class DoubleLinkedData extends LinkedBase {

    public DoubleLinkedData() {
        mOriginalMyNumber = new DoubleLinkedList();
    }

    public void setData() {
        mOriginalMyNumber = new DoubleLinkedList();
        //Head
        LinkedData iNewMyNumber = mOriginalMyNumber;
        LinkedData iPreAddressNoteConnectNextMyNumber = mOriginalMyNumber;

        iNewMyNumber.setNumber(1);
        iNewMyNumber = new DoubleLinkedList();
        iNewMyNumber.setNumber(2);

        ((DoubleLinkedList)iPreAddressNoteConnectNextMyNumber).mNextMyNumber = iNewMyNumber;
        ((DoubleLinkedList) iNewMyNumber).mPreMyNumber = iPreAddressNoteConnectNextMyNumber;
        iPreAddressNoteConnectNextMyNumber = iNewMyNumber;

        for(int i=3; i<10; i++) {
            iNewMyNumber = new DoubleLinkedList();
            iNewMyNumber.setNumber(i);
            ((DoubleLinkedList)iPreAddressNoteConnectNextMyNumber).mNextMyNumber = iNewMyNumber;
            ((DoubleLinkedList) iNewMyNumber).mPreMyNumber = iPreAddressNoteConnectNextMyNumber;
            iPreAddressNoteConnectNextMyNumber = iNewMyNumber;

        }
        iNewMyNumber = null;
        iPreAddressNoteConnectNextMyNumber = null;

        showData();
        addPreData(11, 7);
        addPreData(12, 1);
        addNextData(13, 3);
        addNextData(15, 9);

    }



    @Override
    protected void addPreData(int pInsertNumber, int pIndex) {
        Log.v("aaa","*****************************");
        Log.v("aaa","Pre pInsertNumber="+pInsertNumber+", pIndex="+pIndex);
        mOriginalMyNumber.insertPre(pInsertNumber, pIndex, this);
        showData();
    }

    @Override
    protected void addNextData(int pInsertNumber, int pIndex) {
        Log.v("aaa","*****************************");
        Log.v("aaa","Next pInsertNumber="+pInsertNumber+", pIndex="+pIndex);
        mOriginalMyNumber.insertNext(pInsertNumber, pIndex, this);
        showData();
    }


    private void showData() {
        LinkedData iNewMyNumber = mOriginalMyNumber;
        do{
            Log.v("aaa","number next= " + iNewMyNumber.getNumber());
            if( ((DoubleLinkedList) iNewMyNumber).mNextMyNumber == null) {
                break;
            }
            iNewMyNumber = ((DoubleLinkedList) iNewMyNumber).mNextMyNumber;

        }while (true);
        Log.v("aaa","*****************************");

        while(iNewMyNumber != null) {
            Log.v("aaa","number ore= " + iNewMyNumber.getNumber());
            iNewMyNumber = ((DoubleLinkedList)iNewMyNumber).mPreMyNumber;
        }
    }
}


