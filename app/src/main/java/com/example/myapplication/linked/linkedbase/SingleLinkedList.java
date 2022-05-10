package com.example.myapplication.linked.linkedbase;

import com.example.myapplication.linked.LinkedBase;

public class SingleLinkedList extends LinkedData {

    public LinkedData mNextMyNumber = null;

    @Override
    public void setNumber(int pNumber) {
        mNumber = pNumber;
    }

    @Override
    public int getNumber() {
        return mNumber;
    }

    @Override
    public boolean insertPre(int pInsertNumber, int pIndex, LinkedBase pOriginalMyNumber) {
        LinkedFindData<LinkedData, LinkedData, Boolean> iPare = findData(pIndex);
        if( iPare.first == null && iPare.second == null) {
            return false;
        }
        setLinkedConnect(iPare, pOriginalMyNumber, mTypePre, pInsertNumber);

        return true;
    }

    @Override
    public boolean insertNext(int pInsertNumber, int pIndex, LinkedBase pOriginalMyNumber) {
        LinkedFindData<LinkedData, LinkedData, Boolean> iPare = findData(pIndex);

        if( iPare.first == null && iPare.second == null) {
            return false;
        }

        setLinkedConnect(iPare, pOriginalMyNumber, mTypeNext, pInsertNumber);

        return true;
    }

    @Override
    protected void setLinkedConnect(LinkedFindData<LinkedData, LinkedData, Boolean> pPare, LinkedBase pOriginalMyNumber, int pTypePreOrNext, int pInsertNumber) {
        SingleLinkedList iInsertData = new SingleLinkedList();
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
                ((SingleLinkedList)iPreNote).mNextMyNumber = iInsertData;
                iInsertData.mNextMyNumber = iNextNote;
            }
        } else if( mTypeNext == pTypePreOrNext){
            //放置後面
            if (iHead) {
                ((SingleLinkedList)iNextNote).mNextMyNumber = iInsertData;
            } else {
                iPreNote = iNextNote;
                iNextNote = ((SingleLinkedList)iNextNote).mNextMyNumber;
                ((SingleLinkedList)iPreNote).mNextMyNumber = iInsertData;
                iInsertData.mNextMyNumber = iNextNote;
            }
        }
    }

    @Override
    protected LinkedFindData<LinkedData, LinkedData, Boolean> findData(int pIndex) {

        LinkedData iNextNote = mNextMyNumber;

        LinkedData iPreNote = this;
        boolean iFoundTheNumber = false;
        boolean iHead = false;

        //找尋位置
        if( pIndex == mNumber) { //起始位置
            iHead = true;
            iFoundTheNumber = true;
        } else { //巡換檢查
            while( iNextNote != null) {
                if( iNextNote.getNumber() == pIndex) {
                    iFoundTheNumber = true;
                    break;
                }
                iPreNote =  iNextNote;
                iNextNote = ((SingleLinkedList)iNextNote).mNextMyNumber;
            }
        }
        if( !iFoundTheNumber) {
            iPreNote = null;
            iNextNote = null;
        }
        return new LinkedFindData<>(iPreNote, iNextNote, iHead);
    }

}


