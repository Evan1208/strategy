package com.example.myapplication.linked.linkedbase;

import com.example.myapplication.linked.LinkedBase;

public class DoubleLinkedList extends SingleLinkedList {

    public LinkedData mPreMyNumber = null;


    @Override
    public boolean insertPre(int pInsertNumber, int pIndex, LinkedBase pOriginalMyNumber) {
        LinkedFindData<LinkedData, LinkedData, Boolean> iPare = super.findData(pIndex);
        if( iPare.first == null && iPare.second == null) {
            return false;
        }
        setLinkedConnect(iPare, pOriginalMyNumber, mTypePre, pInsertNumber);
        return false;
    }

    @Override
    public boolean insertNext(int pInsertNumber, int pIndex, LinkedBase pOriginalMyNumber) {
        LinkedFindData<LinkedData, LinkedData, Boolean> iPare = super.findData(pIndex);
        if( iPare.first == null && iPare.second == null) {
            return false;
        }
        setLinkedConnect(iPare, pOriginalMyNumber, mTypeNext, pInsertNumber);

        return false;
    }

    @Override
    protected void setLinkedConnect(LinkedFindData<LinkedData, LinkedData, Boolean> pPare,
                                    LinkedBase pOriginalMyNumber, int pTypePreOrNext, int pInsertNumber) {

        DoubleLinkedList iInsertData = new DoubleLinkedList();
        iInsertData.setNumber(pInsertNumber);
        boolean iHead = pPare.third;
        LinkedData iPreNote = pPare.first;
        LinkedData iNextNote = pPare.second;
        // 放置前面
        if( mTypePre == pTypePreOrNext) {
            if (iHead) {
                pOriginalMyNumber.mOriginalMyNumber = iInsertData;
                iInsertData.mNextMyNumber = this;
            } else {
                ((DoubleLinkedList)iPreNote).mNextMyNumber = iInsertData;
                iInsertData.mPreMyNumber = iPreNote;
                iInsertData.mNextMyNumber = iNextNote;
                ((DoubleLinkedList)iNextNote).mPreMyNumber = iInsertData;
            }
        } else if( mTypeNext == pTypePreOrNext){//放置後面
            if (iHead) {
                ((DoubleLinkedList)iNextNote).mNextMyNumber = iInsertData;
                iInsertData.mPreMyNumber = iNextNote;
            } else {
                // 需要調整位置(因為位置放後面, 所以需要更動位置)
                iPreNote = iNextNote;
                iNextNote = ((DoubleLinkedList)iNextNote).mNextMyNumber;
                //
                ((DoubleLinkedList)iPreNote).mNextMyNumber = iInsertData;
                iInsertData.mPreMyNumber = iPreNote;
                iInsertData.mNextMyNumber = iNextNote;
                if( iNextNote != null) {
                    ((DoubleLinkedList) iNextNote).mPreMyNumber = iInsertData;
                }
            }
        }
    }
}
