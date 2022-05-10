package com.example.myapplication.linked;

import android.util.Log;

import com.example.myapplication.linked.linkedbase.LinkedData;
import com.example.myapplication.linked.linkedbase.SingleLinkedList;

public class SingleLinkedData extends LinkedBase {

    public SingleLinkedData() {
        mOriginalMyNumber = new SingleLinkedList();
    }

    public void setData() {
        //Head
        LinkedData iNewMyNumber = mOriginalMyNumber;
        LinkedData iPreAddressNoteConnectNextMyNumber = mOriginalMyNumber;

        iNewMyNumber.setNumber(1);
        iNewMyNumber = new SingleLinkedList();
        iNewMyNumber.setNumber(2);

        ((SingleLinkedList)iPreAddressNoteConnectNextMyNumber).mNextMyNumber = (SingleLinkedList) iNewMyNumber;
        iPreAddressNoteConnectNextMyNumber = iNewMyNumber;

        for(int i=3; i<10; i++) {
            iNewMyNumber = new SingleLinkedList();
            iNewMyNumber.setNumber(i);
            ((SingleLinkedList)iPreAddressNoteConnectNextMyNumber).mNextMyNumber = (SingleLinkedList) iNewMyNumber;
            iPreAddressNoteConnectNextMyNumber = iNewMyNumber;
        }
        iNewMyNumber = null;
        iPreAddressNoteConnectNextMyNumber = null;

        iNewMyNumber = mOriginalMyNumber;

        while(iNewMyNumber != null) {
            Log.v("aaa","number = " + iNewMyNumber.getNumber());
            iNewMyNumber = ((SingleLinkedList)iNewMyNumber).mNextMyNumber;
        }
        addPreData(11, 7);
        addPreData(12, 1);
        addNextData(13, 3);
        addNextData(15, 9);
        Log.v("aaa","*****************************");
    }



    @Override
    protected void addPreData(int pInsertNumber, int pIndex) {
        Log.v("aaa","*****************************");
        Log.v("aaa","Pre pInsertNumber="+pInsertNumber+", pIndex="+pIndex);
        boolean isOK = mOriginalMyNumber.insertPre(pInsertNumber, pIndex, this);
        LinkedData iNewMyNumber = mOriginalMyNumber;
        while(iNewMyNumber != null) {
            Log.v("aaa","number = " + iNewMyNumber.getNumber());
            iNewMyNumber = ((SingleLinkedList)iNewMyNumber).mNextMyNumber;
        }
    }

    @Override
    protected void addNextData(int pInsertNumber, int pIndex) {
        Log.v("aaa","*****************************");
        Log.v("aaa","Next pInsertNumber="+pInsertNumber+", pIndex="+pIndex);
        boolean isOK = mOriginalMyNumber.insertNext(pInsertNumber, pIndex, this);
        LinkedData iNewMyNumber = mOriginalMyNumber;
        while(iNewMyNumber != null) {
            Log.v("aaa","number = " + iNewMyNumber.getNumber());
            iNewMyNumber = ((SingleLinkedList)iNewMyNumber).mNextMyNumber;
        }
    }


}


