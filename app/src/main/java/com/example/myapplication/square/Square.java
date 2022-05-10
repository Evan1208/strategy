package com.example.myapplication.square;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import com.example.myapplication.BaseUI;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.SquareBinding;

public class Square extends BaseUI {

    private SquareBinding mSquareBinding;
    private final StringBuilder mString = new StringBuilder();
    private final StringBuilder mIndex = new StringBuilder();
    private boolean mTriangle = false;

    public void setData(MainActivity pMainActivity){
        mMainActivity = pMainActivity;
        mSquareBinding = DataBindingUtil.setContentView(pMainActivity, R.layout.square);

        initClick();
    }

    private void initClick() {
        mSquareBinding.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int iHeight = 5;
                int iWeight = 5;
                try {
                    iHeight = Integer.parseInt(mSquareBinding.mHeight.getText().toString());
                    iWeight = Integer.parseInt(mSquareBinding.mWeight.getText().toString());
                }catch (Exception ignored) {

                }
                mTriangle = !mTriangle;
                setTriangleRevers(iHeight);
                setTriangle(iHeight, mTriangle);
                setForSquare(iHeight, iWeight);
            }

            @SuppressLint("SetTextI18n")
            private void setTriangleRevers(int pHeight) {
                mString.delete(0, mString.length());
                mIndex.delete(0, mIndex.length());
                for( int i = 0; i < pHeight; i++) {
                    mIndex.append("i=").append(i);
                    for( int j = 0; j < pHeight; j++) {
                        if( j >= (pHeight - ( i + 1) ) ) {
                            mIndex.append(", j=").append(j).append("X");
                            mString.append("*");
                        } else {
                            mIndex.append(", j=").append(j).append("_");
                            mString.append("_");
                        }
                    }
                    mIndex.append("\n");
                    mString.append("\n");
                }
                mSquareBinding.mTextView.setText(mString.toString() +"\n"+mIndex.toString());
            }

            private void setTriangle(int pHeight, boolean pBoolean) {

                mString.delete(0, mString.length());
                // step by step
                if( pBoolean) {
                    mString.append("step by step\n");
                    for (int i = 0; i < pHeight; i++) {
                        for (int j = 0; j < i; j++) {
                            mString.append("*");
                        }
                        mString.append("\n");
                    }
                } else {
                    mString.append("less by less\n");
                    for (int i = pHeight; i > 0; i--) {
                        for (int j = pHeight; j >= i; j--) {
                            mString.append("*");
                        }
                        mString.append("\n");
                    }
                }
                mSquareBinding.mTextView.setText(mString.toString());
            }

            private void setForSquare(int iHeight, int iWeight) {
                mString.delete(0, mString.length());
                for( int i=0; i < iHeight; i++) {
                    for( int j=0; j < iWeight; j++) {
                        mString.append("*");
                    }
                    mString.append("\n");
                }
                mSquareBinding.mTextView.setText(mString.toString());
            }
        });
    }
}
