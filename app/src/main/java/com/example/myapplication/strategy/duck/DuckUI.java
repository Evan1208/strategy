package com.example.myapplication.strategy.duck;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.strategy.duck.type.Duck;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class DuckUI {
    private final MainActivity mMainActivity;


    private TextView mShowDuck;
    private DuckAdapter mDuckAdapter;
    private final DuckData mDuckData = new DuckData();
    private final StringBuffer mStringBuffer = new StringBuffer();


    public DuckUI(MainActivity pMainActivity){
        pMainActivity.setContentView(R.layout.duck_main);
        mMainActivity = pMainActivity;
        initView();
        initData();
    }

    private void initData() {
        ArrayList<Duck> iArray = mDuckData.getDuckData();
        mDuckAdapter.setData(iArray);
    }

    private void initView() {
        mShowDuck = mMainActivity.findViewById(R.id.mShowDuck);
        RecyclerView mRecyclerView = mMainActivity.findViewById(R.id.mRecyclerView);

        GridLayoutManager iGridLayoutManager = new GridLayoutManager(mMainActivity,2);

        mDuckAdapter = new DuckAdapter(pDuck -> {
            if( pDuck != null) {
                mStringBuffer.delete(0, mStringBuffer.length());
                mStringBuffer.append(pDuck.display());
                mStringBuffer.append("\n").append(pDuck.performQuack());
                mStringBuffer.append("\n").append(pDuck.performFly());
                mStringBuffer.append("\n").append(pDuck.preformSwim());
                mShowDuck.setText(mStringBuffer.toString());
            }
        });
        mRecyclerView.setLayoutManager(iGridLayoutManager);
        mRecyclerView.setAdapter(mDuckAdapter);
    }

    interface DuckDataItf {
        void  getDuck(Duck pDuck);
    }
}



class DuckAdapter extends RecyclerView.Adapter<DuckAdapter.ViewHolder> {

    private ArrayList<Duck> mDuckDataArray = new ArrayList<>();
    private DuckUI.DuckDataItf mDuckData;

    public DuckAdapter(DuckUI.DuckDataItf duckData) {
        mDuckData = duckData;
    }

    public void setData(ArrayList<Duck> duckData) {
        mDuckDataArray = duckData;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.duck_button, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int position) {
        if( position < mDuckDataArray.size()) {
            holder.mDuckName.setText(mDuckDataArray.get(position).getDuckName());
            holder.mDuckName.setTag(position);
            holder.mDuckName.setOnClickListener(mClick);
        }
    }

    private final View.OnClickListener mClick = v -> {
        if( v.getTag() != null) {
            int iIndex;
            String iD = v.getTag().toString();
            if( Character.isDigit(iD.charAt(0))) {
                iIndex = Integer.parseInt(iD);
                mDuckData.getDuck(mDuckDataArray.get(iIndex));
            }
        }
    };

    @Override
    public int getItemCount() {
        return mDuckDataArray.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mDuckName;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            initView();
        }

        private void initView() {
            mDuckName = itemView.findViewById(R.id.mDuckName);
        }
    }
}
