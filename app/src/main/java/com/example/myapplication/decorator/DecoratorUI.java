package com.example.myapplication.decorator;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.databinding.CoffeeShopMainBinding;
import com.example.myapplication.decorator.beverage.Beverage;
import com.example.myapplication.decorator.coffee.Espresso;
import com.example.myapplication.decorator.coffee.HouseBlend;
import com.example.myapplication.decorator.condiments.Bitter;
import com.example.myapplication.decorator.condiments.Mocha;
import com.example.myapplication.decorator.condiments.Soy;
import com.example.myapplication.decorator.condiments.Whip;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

public class DecoratorUI {
    private final MainActivity mMainActivity;

    private CoffeeShopUtil mCoffeeShopUtil;
    private final CoffeeShopMainBinding mCoffeeShopMainBinding;

    public DecoratorUI(MainActivity pMainActivity){
        mMainActivity = pMainActivity;
        mCoffeeShopMainBinding = DataBindingUtil.setContentView(mMainActivity, R.layout.coffee_shop_main);
        initData();
        initViewData();
        initClick();
    }

    private void initClick() {
        mCoffeeShopMainBinding.mSure.setOnClickListener(v ->{
                Beverage iB =  ((CoffeeShopAdapter) Objects.requireNonNull(mCoffeeShopMainBinding.mRecyclerView.getAdapter()))
                        .getBeverage();
                showData(iB.getDescription(), ""+iB.cost());
            }
        );

        mCoffeeShopMainBinding.mCancel.setOnClickListener(v -> {
            showData("", "");
            ((CoffeeShopAdapter) Objects.requireNonNull(mCoffeeShopMainBinding.mRecyclerView.getAdapter())).initData();
        });
    }

    private void initViewData() {
        CoffeeShopData mCoffeeShopData = new CoffeeShopData(mCoffeeShopUtil);
        mCoffeeShopMainBinding.mRecyclerView.setHasFixedSize(true);
        GridLayoutManager iGridLayoutManager = new GridLayoutManager(mMainActivity,2);
        CoffeeShopAdapter iCoffeeShopAdapter = new CoffeeShopAdapter(mCoffeeItf, mCoffeeShopData, iGridLayoutManager);
        mCoffeeShopMainBinding.mRecyclerView.setLayoutManager(iGridLayoutManager);
        mCoffeeShopMainBinding.mRecyclerView.setAdapter(iCoffeeShopAdapter);
        iCoffeeShopAdapter.setData(mCoffeeShopUtil.getAllData());


    }

    private void initData() {
        mCoffeeShopUtil = new CoffeeShopUtil(mMainActivity);
    }


    private final CoffeeItf mCoffeeItf = pBeverage -> showData(pBeverage.getDescription(), "");


    @SuppressLint("SetTextI18n")
    private void showData(String pDescription, String pMoney) {
        if( pMoney == null) {
            mCoffeeShopMainBinding.mShowDuck.setText(pDescription);
        } else {
            mCoffeeShopMainBinding.mShowDuck.setText(pDescription +"\n"+pMoney);
        }
    }


    //-----interface--------
    interface CoffeeItf {
        void getBeverage(Beverage pBeverage);
    }
}

class CoffeeShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final ArrayList<String> mCoffeeData = new ArrayList<>();
    private DecoratorUI.CoffeeItf mCoffeeItf;
    private final int mTypeTitle = 1;
    private final int mTypeData = 2;
    private Beverage mBeverage;
    private boolean mCoffeeIsOrder = false;
    private CoffeeShopData mCoffeeShopData;


    public CoffeeShopAdapter(DecoratorUI.CoffeeItf pCoffeeItf, CoffeeShopData pCoffeeShopData, GridLayoutManager pGridLayoutManager) {
        mCoffeeItf = pCoffeeItf;
        mCoffeeShopData = pCoffeeShopData;

        pGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if( mCoffeeShopData.checkData(position, mCoffeeData)) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
    }


    public void setData(ArrayList<String> pAllData) {
        mCoffeeData.clear();
        mCoffeeData.addAll(pAllData);
        notifyDataSetChanged();
    }

    public Beverage getBeverage() {
        return mBeverage;
    }

    public void initData() {
        mBeverage = null;
        mCoffeeIsOrder = false;
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        if(mCoffeeShopData.checkData(position, mCoffeeData)) {
            return mTypeTitle;
        } else {
            return mTypeData;
        }
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        if( mTypeData == viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_data, parent, false);
            return new CoffeeDataViewHolder(view);
        } else if(mTypeTitle == viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_title, parent, false);
            return new CoffeeTitleViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_title, parent, false);
            return new CoffeeTitleViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {

        if (position >= mCoffeeData.size()) {
            return;
        }
        boolean iShow = mCoffeeShopData.coffeeIsNotOrder(mCoffeeIsOrder, position, mCoffeeData);

        if( iShow) {
            holder.itemView.setVisibility(View.VISIBLE);
            if (holder instanceof CoffeeDataViewHolder) {
                CoffeeDataViewHolder iCoffeeDataViewHolder = (CoffeeDataViewHolder) holder;
                iCoffeeDataViewHolder.mCoffeeName.setText(mCoffeeData.get(position));
                iCoffeeDataViewHolder.mCoffeeName.setTag(mCoffeeData.get(position));
                iCoffeeDataViewHolder.mCoffeeName.setOnClickListener(mClick);
            } else {
                CoffeeTitleViewHolder iCoffeeDataViewHolder = (CoffeeTitleViewHolder) holder;
                iCoffeeDataViewHolder.mCoffeeTitle.setText(mCoffeeData.get(position));
            }
        } else {
            holder.itemView.setVisibility(View.GONE);
        }
    }


    private final View.OnClickListener mClick = v -> {
        if( v.getTag() != null) {
            String iD = v.getTag().toString();
            mBeverage = mCoffeeShopData.checkCoffee(iD, mBeverage);
            if( mBeverage != null && mCoffeeItf != null) {
                mCoffeeItf.getBeverage(mBeverage);
                if(!mCoffeeIsOrder) {
                    mCoffeeIsOrder = true;
                    notifyDataSetChanged();
                }
            }
        }
    };

    @Override
    public int getItemCount() {
        return mCoffeeData.size();
    }

    static class CoffeeDataViewHolder extends RecyclerView.ViewHolder {
        TextView mCoffeeName;

        public CoffeeDataViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            initView();
        }

        private void initView() {
            mCoffeeName = itemView.findViewById(R.id.mCoffeeData);
        }
    }

    static class CoffeeTitleViewHolder extends RecyclerView.ViewHolder {
        TextView mCoffeeTitle;

        public CoffeeTitleViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            initView();
        }

        private void initView() {
            mCoffeeTitle = itemView.findViewById(R.id.mCoffeeTitle);
        }
    }
}

class CoffeeShopData {

    String mCheckStr;
    private int mCondimentIndex = -1;
    private final CoffeeShopUtil mCoffeeShopUtil;

    public CoffeeShopData(CoffeeShopUtil pCoffeeShopUtil) {
        mCoffeeShopUtil = pCoffeeShopUtil;
        mCheckStr = mCoffeeShopUtil.getMTypeCondiment();
    }

    public Beverage checkCoffee(String pString, Beverage pBeverage) {
        if( mCoffeeShopUtil.getMTypeEspresso().equals(pString)) {
            pBeverage = new Espresso();
        } else if( mCoffeeShopUtil.getMTypeHouseBlend().equals(pString)) {
            pBeverage = new HouseBlend();
        } else if( mCoffeeShopUtil.getMTypeMocha().equals(pString)) {
            pBeverage = new Mocha(pBeverage);
        } else if( mCoffeeShopUtil.getMTypeSoy().equals(pString)) {
            pBeverage = new Soy(pBeverage);
        } else if( mCoffeeShopUtil.getMTypeWhip().equals(pString)){
            pBeverage = new Whip(pBeverage);
        } else if( mCoffeeShopUtil.getMTypeBitter().equals(pString)) {
            pBeverage = new Bitter(pBeverage);
        }
        return pBeverage;
    }

    public boolean coffeeIsNotOrder(boolean mCoffeeIsOrder, int position, ArrayList<String> mCoffeeData) {

        if( mCoffeeIsOrder) {
            return true;
        }
        // 已抓到調味品真實位置
        if( mCondimentIndex != -1 && position >= mCondimentIndex) {
            return false;
        }
        // 尚未抓到調味品真實位置
        if(mCoffeeData.get(position).equals(mCheckStr)) {
            mCondimentIndex = position;
            return false;
        } else {
            return true;
        }
    }

    public boolean checkData(int pIndex, ArrayList<String> pCoffeeData) {
        return mCoffeeShopUtil.getMTypeCoffee().equals(pCoffeeData.get(pIndex)) ||
                mCoffeeShopUtil.getMTypeCondiment().equals(pCoffeeData.get(pIndex));
    }
}