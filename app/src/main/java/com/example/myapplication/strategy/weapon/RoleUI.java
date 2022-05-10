package com.example.myapplication.strategy.weapon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.BaseUI;
import com.example.myapplication.MainActivity;
import com.example.myapplication.MyApplication;
import com.example.myapplication.R;
import com.example.myapplication.databinding.RoleUiBinding;
import com.example.myapplication.strategy.weapon.role.Role;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RoleUI extends BaseUI {

    private final RoleData mRoleData = new RoleData();
    private RoleUiBinding mRoleUiBinding= null;
    private ActivityResultLauncher<Intent> mActivityResultLauncher;
    private RoleUIAdapter mRoleUIAdapter;

    public void setData(MainActivity pMainActivity){
        mMainActivity = pMainActivity;
        mRoleUiBinding = DataBindingUtil.setContentView(pMainActivity, R.layout.role_ui);
        CallBack iX = new CallBack();
        mActivityResultLauncher = mMainActivity.registerForActivityResult(iX, result -> {

            Role iRole =  ((MyApplication) pMainActivity.getApplication()).mSelectRole;
            ((MyApplication) pMainActivity.getApplication()).mSelectRole = null;

            if (iRole == null) {
                return;
            }

            if( result == mRoleData.ResultCodeRoleCreate) {
                mRoleUIAdapter.setData(iRole);
            } else if( result == mRoleData.ResultCodeRoleChangeWeapons) {
                if( mRoleUiBinding.mAge.getTag() != null) {
                    long iRoleId = Long.parseLong(mRoleUiBinding.mAge.getTag().toString());
                    if (iRole.getRoleID() == iRoleId) {
                        showData(iRole);
                    }
                }
                mRoleUIAdapter.notifyDataSetChanged();
            }
        });
        initData();
        initClick();
    }


    private void initData() {

        mRoleUIAdapter = new RoleUIAdapter(new RoleCreate.ItfRoleData() {
            @Override
            public void getRoleData(Role pRole) {
                showData(pRole);
            }

            @Override
            public void changeRoleWeapon(Role pRole) {
                ((MyApplication) mMainActivity.getApplication()).mSelectRole = pRole;
                Intent iIntent = new Intent(mMainActivity, RoleChangeWeapon.class);
                mActivityResultLauncher.launch(iIntent);
            }
        });
        LinearLayoutManager iLinearLayoutManager = new LinearLayoutManager(mMainActivity);
        mRoleUiBinding.mRecyclerView.setLayoutManager(iLinearLayoutManager);
        mRoleUiBinding.mRecyclerView.setAdapter(mRoleUIAdapter);
    }

    @SuppressLint("SetTextI18n")
    private void showData(Role pRole) {
        mRoleUiBinding.mAge.setTag(pRole.getRoleID());
        mRoleUiBinding.mAge.setText("Age:"+pRole.mAge);
        mRoleUiBinding.mName.setText("Name:"+pRole.mName);
        mRoleUiBinding.mHeight.setText("Height:"+pRole.mHeight);
        mRoleUiBinding.mWeapon.setText("Weapon:"+pRole.getWeaponName());
        mRoleUiBinding.mLiveStatus.setText("LiveStatus:"+pRole.getLiveStatus());
        mRoleUiBinding.mRace.setText("Race:"+pRole.getRace());
    }

    private void initClick() {
        mRoleUiBinding.mCreate.setOnClickListener(v -> {
            Intent iIntent = new Intent(mMainActivity, RoleCreate.class);
            mActivityResultLauncher.launch(iIntent);
        });
    }
}


class RoleUIAdapter extends RecyclerView.Adapter<RoleUIAdapter.RoleItem> {

    private final ArrayList<Role> mRoleData = new ArrayList<>();
    private final RoleCreate.ItfRoleData mItfRoleData;
    private int mSelect = -1;

    public RoleUIAdapter(RoleCreate.ItfRoleData pItfRoleData) {
        mItfRoleData = pItfRoleData;
    }

    public void setData(Role pRole){
        mRoleData.add(pRole);
        notifyDataSetChanged();
    }


    @NonNull
    @NotNull
    @Override
    public RoleItem onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.role_show_create_data, parent, false);
        return new RoleItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RoleItem holder, int position) {
        holder.mRace.setText(mRoleData.get(position).getRace());
        holder.mLiveStatus.setText(mRoleData.get(position).getLiveStatus());
        holder.mWeapon.setText(mRoleData.get(position).getWeaponName());

        if( mSelect == position) {
            holder.mBackGround.setBackgroundResource(R.color.select);
        }else {
            holder.mBackGround.setBackgroundResource(0);
        }

        holder.mBackGround.setTag(position);
        holder.mBackGround.setOnClickListener(v -> {
            if( v.getTag() != null) {
                mSelect = Integer.parseInt(v.getTag().toString());
                mItfRoleData.getRoleData(mRoleData.get(mSelect));
                notifyDataSetChanged();
            }
        });

        holder.mBackGround.setOnLongClickListener(v -> {
            if( v.getTag() != null) {
                int iSelect = Integer.parseInt(v.getTag().toString());
                mItfRoleData.changeRoleWeapon(mRoleData.get(iSelect));
            }
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return mRoleData.size();
    }

    static class RoleItem extends RecyclerView.ViewHolder {
        TextView mRace;
        TextView mWeapon;
        TextView mLiveStatus;
        LinearLayout mBackGround;

        public RoleItem(@NonNull @NotNull View itemView) {
            super(itemView);
            initView();
        }
        private void initView() {
            mRace = itemView.findViewById(R.id.mRace);
            mWeapon = itemView.findViewById(R.id.mWeapon);
            mLiveStatus = itemView.findViewById(R.id.mLiveStatus);
            mBackGround = itemView.findViewById(R.id.mBackGround);
        }
    }
}

class CallBack extends ActivityResultContract<Intent, Integer>{

    @NonNull
    @NotNull
    @Override
    public Intent createIntent(@NonNull @NotNull Context context, Intent input) {
        return input;
    }

    @Override
    public Integer parseResult(int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent intent) {
        return resultCode;
    }
}