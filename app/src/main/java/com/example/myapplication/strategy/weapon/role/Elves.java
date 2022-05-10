package com.example.myapplication.strategy.weapon.role;

import com.example.myapplication.strategy.weapon.status.LiveStatus;
import com.example.myapplication.strategy.weapon.types.Weapon;

public class Elves extends Role {


    @Override
    public void setWeapon(Weapon pWeapon) {
        mWeapon = pWeapon;
    }

    @Override
    public void setLiveStatus(LiveStatus pLiveStatus) {
        mLiveStatus = pLiveStatus;
    }

    @Override
    public String getRace() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String getWeaponName() {
        return mWeapon.name();
    }

    @Override
    public String getLiveStatus() {
        return mLiveStatus.status();
    }

    @Override
    public void setRoleId(long pRoleId) {
        mRoleID = pRoleId;
    }

    @Override
    public long getRoleID() {
        return mRoleID;
    }

    @Override
    public Weapon getWeaponData() {
        return mWeapon;
    }
}
