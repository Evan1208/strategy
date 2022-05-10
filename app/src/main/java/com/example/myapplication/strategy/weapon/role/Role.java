package com.example.myapplication.strategy.weapon.role;

import com.example.myapplication.strategy.weapon.status.Health;
import com.example.myapplication.strategy.weapon.status.LiveStatus;
import com.example.myapplication.strategy.weapon.types.Fist;
import com.example.myapplication.strategy.weapon.types.Weapon;

import java.io.Serializable;

public abstract class Role implements Serializable {
    protected LiveStatus mLiveStatus = new Health();
    protected Weapon mWeapon = new Fist();
    protected long mRoleID;

    Role() {
        mRoleID = System.currentTimeMillis();
    }

    public String mName;
    public int mAge;
    public int mHeight;


    public abstract void setWeapon(Weapon pWeapon);
    public abstract void setLiveStatus(LiveStatus pLiveStatus);

    public abstract String getRace();
    public abstract Weapon getWeaponData();
    public abstract String getWeaponName();
    public abstract String getLiveStatus();

    public abstract void setRoleId(long pRoleId);
    public abstract long getRoleID();
}