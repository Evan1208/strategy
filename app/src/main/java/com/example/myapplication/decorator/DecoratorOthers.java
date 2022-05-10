package com.example.myapplication.decorator;

import android.content.Context;
import android.util.Log;

import com.example.myapplication.R;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecoratorOthers {

    public void showFile(Context pContext) {
        InputStream inputStream = pContext.getResources().openRawResource(R.raw.reading);
        FilterInputStream iIn = new ToLowerCase(new BufferedInputStream(inputStream));
        StringBuilder iStringBuilder = new StringBuilder();
        do {
            try {
                int iC = iIn.read();
                if( iC < 0) {
                    break;
                }
                iStringBuilder.append((char)iC);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } while (true);
        Log.v("aaa","iStringBuilder=" + iStringBuilder.toString());
    }

}

class ToLowerCase extends FilterInputStream {


    protected ToLowerCase(InputStream pIn) {
        super(pIn);
    }

    @Override
    public int read() throws IOException {
        int iC = super.read();
        if( iC == -1) {
            return iC;
        } else {
            return Character.toLowerCase((char)iC);
        }
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int iResult = super.read(b, off, len);
        if( b != null ) {
            int iTotal = off+len;
            for( int i = off; i < iTotal; i++) {
                b[i] = (byte) Character.toLowerCase((char) b[i]);
            }
        }
        return iResult;
    }
}