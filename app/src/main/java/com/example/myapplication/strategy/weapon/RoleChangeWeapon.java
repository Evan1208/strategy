package com.example.myapplication.strategy.weapon;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MyApplication;
import com.example.myapplication.R;
import com.example.myapplication.databinding.RoleChangeWeaponBinding;
import com.example.myapplication.strategy.weapon.role.Role;
import com.example.myapplication.strategy.weapon.types.Weapon;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class RoleChangeWeapon extends AppCompatActivity {

    private final RoleData mRoleData = new RoleData();
    private RoleChangeWeaponBinding mRoleChangeWeaponBinding;
    private Role mSelectRole;
    private Weapon mOriginWeapon;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRoleChangeWeaponBinding = DataBindingUtil.setContentView(this, R.layout.role_change_weapon);
        mSelectRole = ((MyApplication) getApplication()).mSelectRole;
        mOriginWeapon = mSelectRole.getWeaponData();
        setUi();
        initData();
        initClick();
    }

    private void initData() {
        RoleChangeWeaponAdapter mRoleCreateAdapter = new RoleChangeWeaponAdapter(mItfRoleData);
        GridLayoutManager iGridLayoutManager = new GridLayoutManager(this,2);
        mRoleChangeWeaponBinding.mRecyclerView.setLayoutManager(iGridLayoutManager);
        mRoleChangeWeaponBinding.mRecyclerView.setAdapter(mRoleCreateAdapter);

        mRoleCreateAdapter.setData(mRoleData.getWeapons(), mSelectRole.getWeaponName());
    }

    private void initClick() {
        mRoleChangeWeaponBinding.mSure.setOnClickListener(v -> {
            setResult(mRoleData.ResultCodeRoleChangeWeapons, null);
            finish();
        });

        mRoleChangeWeaponBinding.mCancel.setOnClickListener(v -> {
            mSelectRole.setWeapon(mOriginWeapon);
            finish();
        });
    }

    @SuppressLint("SetTextI18n")
    private void setUi() {
        mRoleChangeWeaponBinding.mAge.setText("Age:"+mSelectRole.mAge);
        mRoleChangeWeaponBinding.mName.setText("Name:"+mSelectRole.mName);
        mRoleChangeWeaponBinding.mHeight.setText("Height:"+mSelectRole.mHeight);
        mRoleChangeWeaponBinding.mWeapon.setText("Weapon:"+mSelectRole.getWeaponName());
        mRoleChangeWeaponBinding.mLiveStatus.setText("LiveStatus:"+mSelectRole.getLiveStatus());
        mRoleChangeWeaponBinding.mRace.setText("Race:"+mSelectRole.getRace());
    }

    private void setWeapon(Weapon pWeapon) {
        mSelectRole.setWeapon(pWeapon);
        setUi();
    }


    private final RoleCreate.ItfRoleData mItfRoleData = new RoleCreate.ItfRoleData() {

        @Override
        public void setNewWeapon(Weapon pWeapon) {
            setWeapon(pWeapon);
        }
    };

}

class RoleChangeWeaponAdapter extends RecyclerView.Adapter<RoleChangeWeaponAdapter.RoleWeapon> {

    private ArrayList<Weapon> mWeapons = new ArrayList<>();
    private final RoleCreate.ItfRoleData mItfRoleData;
    private int mSelect = -1;

    public RoleChangeWeaponAdapter(RoleCreate.ItfRoleData pItfRoleData) {
        mItfRoleData = pItfRoleData;
    }

    public void setData(ArrayList<Weapon> pRoleData, String pSelectWeapon){
        mWeapons = pRoleData;
        int iSize = pRoleData.size();
        for( int i=0; i < iSize; i++) {
            if( pSelectWeapon.equals(pRoleData.get(i).name())) {
                mSelect = i;
                break;
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public RoleWeapon onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.role_data, parent, false);
        return new RoleWeapon(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RoleWeapon holder, int position) {
        holder.mRoleData.setText(mWeapons.get(position).name());
        holder.mRoleData.setTag(position);


        if( mSelect == position) {
            holder.mBackGround.setBackgroundResource(R.color.select);
        } else {
            holder.mBackGround.setBackgroundResource(0);
        }

        holder.mRoleData.setOnClickListener(v -> {
            if( v.getTag() != null) {
                int iPosition = Integer.parseInt(v.getTag().toString());
                mSelect = iPosition;
                mItfRoleData.setNewWeapon(mWeapons.get(iPosition));
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mWeapons.size();
    }

    static class RoleWeapon extends RecyclerView.ViewHolder {
        TextView mRoleData;
        LinearLayout mBackGround;

        public RoleWeapon(@NonNull @NotNull View itemView) {
            super(itemView);
            initView();
        }
        private void initView() {
            mBackGround = itemView.findViewById(R.id.mBackGround);
            mRoleData = itemView.findViewById(R.id.mRoleData);
        }
    }

}
