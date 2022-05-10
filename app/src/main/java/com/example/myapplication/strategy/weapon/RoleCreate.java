package com.example.myapplication.strategy.weapon;

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
import com.example.myapplication.databinding.RoleCreateBinding;
import com.example.myapplication.strategy.weapon.role.Human;
import com.example.myapplication.strategy.weapon.role.Role;
import com.example.myapplication.strategy.weapon.types.Weapon;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

public class RoleCreate extends AppCompatActivity{

    private final RoleData mRoleData = new RoleData();
    private RoleCreateBinding mRoleCreateBinding;
    private Role mSelectRole;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRoleCreateBinding = DataBindingUtil.setContentView(this, R.layout.role_create);
        initData();
        initClick();
    }

    private void initData() {
        RoleCreateAdapter mRoleCreateAdapter = new RoleCreateAdapter(mItfRoleData);
        GridLayoutManager iGridLayoutManager = new GridLayoutManager(this,2);
        mRoleCreateBinding.mRecyclerView.setLayoutManager(iGridLayoutManager);
        mRoleCreateBinding.mRecyclerView.setAdapter(mRoleCreateAdapter);

        mRoleCreateAdapter.setData(mRoleData.getRoleData());

//        mSelectRole = mRoleData.getRoleData().get(0);
//        mSelectRole.mAge = 18;
//        mSelectRole.mHeight = 24;
//        mSelectRole.mName = "Test";
//        mSelectRole.setRoleId(System.currentTimeMillis());
//        ((MyApplication) this.getApplication()).mSelectRole = mSelectRole;
//        setResult(mRoleData.ResultCodeRoleCreate, null);
//        finish();
    }

    private void initClick() {
        mRoleCreateBinding.mSure.setOnClickListener(v -> {
            if(checkData()) {
                setResult(mRoleData.ResultCodeRoleCreate, null);
                finish();
            }
        });

        mRoleCreateBinding.mCancel.setOnClickListener(v -> finish());
    }

    private boolean checkData() {
        String iAge = mRoleCreateBinding.mAge.getText().toString().trim();
        String iName = mRoleCreateBinding.mName.getText().toString();
        String iHeight = mRoleCreateBinding.mHeight.getText().toString().trim();

        if( iAge.length() == 0 ) {
            return false;
        }

        if( iName.length() == 0) {
            return false;
        }

        if( iHeight.length() == 0) {
            return false;
        }

        if( mSelectRole == null) {
            return false;
        }

        mSelectRole.mAge = Integer.parseInt(iAge);
        mSelectRole.mHeight = Integer.parseInt(iHeight);
        mSelectRole.mName = iName;
        mSelectRole.setRoleId(System.currentTimeMillis());
        ((MyApplication) this.getApplication()).mSelectRole = mSelectRole;
        return true;
    }


    private void setUi(Role pRole) {
        mSelectRole = pRole;
        mRoleCreateBinding.mRace.setText(pRole.getRace());
        mRoleCreateBinding.mWeapon.setText(pRole.getWeaponName());
        mRoleCreateBinding.mLiveStatus.setText(pRole.getLiveStatus());
    }


    private final ItfRoleData mItfRoleData = new ItfRoleData() {
        @Override
        public void getRoleData(Role pRole) {
            setUi(pRole);
        }
    };

    interface ItfRoleData {
        default void getRoleData(Role pRole) {

        }

        default void changeRoleWeapon(Role pRole) {

        }

        default void setNewWeapon(Weapon pWeapon) {

        }
    }
}

class RoleCreateAdapter extends RecyclerView.Adapter<RoleCreateAdapter.RoleItem> {

    private ArrayList<Role> mRoleData = new ArrayList<>();
    private final RoleCreate.ItfRoleData mItfRoleData;
    private int mSelect = -1;

    public RoleCreateAdapter(RoleCreate.ItfRoleData pItfRoleData) {
        mItfRoleData = pItfRoleData;
    }

    public void setData(ArrayList<Role> pRoleData){
        mRoleData = pRoleData;
    }

    @NonNull
    @NotNull
    @Override
    public RoleItem onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.role_data, parent, false);
        return new RoleItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RoleItem holder, int position) {
        holder.mRoleData.setText(mRoleData.get(position).getRace());
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
                mItfRoleData.getRoleData(mRoleData.get(iPosition));
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRoleData.size();
    }

    static class RoleItem extends RecyclerView.ViewHolder {
        TextView mRoleData;
        LinearLayout mBackGround;

        public RoleItem(@NonNull @NotNull View itemView) {
            super(itemView);
            initView();
        }
        private void initView() {
            mBackGround = itemView.findViewById(R.id.mBackGround);
            mRoleData = itemView.findViewById(R.id.mRoleData);
        }
    }

}
