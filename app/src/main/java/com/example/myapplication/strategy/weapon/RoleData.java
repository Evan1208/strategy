package com.example.myapplication.strategy.weapon;


import com.example.myapplication.strategy.weapon.role.Elves;
import com.example.myapplication.strategy.weapon.role.Human;
import com.example.myapplication.strategy.weapon.role.Insect;
import com.example.myapplication.strategy.weapon.role.Role;
import com.example.myapplication.strategy.weapon.types.Axe;
import com.example.myapplication.strategy.weapon.types.Bat;
import com.example.myapplication.strategy.weapon.types.ChopStick;
import com.example.myapplication.strategy.weapon.types.Fist;
import com.example.myapplication.strategy.weapon.types.Gun;
import com.example.myapplication.strategy.weapon.types.Knife;
import com.example.myapplication.strategy.weapon.types.Weapon;
import com.example.myapplication.strategy.weapon.types.WoodStick;

import java.util.ArrayList;

public class RoleData {

    public int ResultCodeRoleCreate = 1111;
    public int ResultCodeRoleChangeWeapons = 1112;

    public ArrayList<Role> getRoleData() {
        ArrayList<Role> iRole = new ArrayList<>();
        iRole.add(new Human());
        iRole.add(new Elves());
        iRole.add(new Insect());
        iRole.add(new Elves());
        return iRole;
    }

    public ArrayList<Weapon> getWeapons() {
        ArrayList<Weapon> iWeapon = new ArrayList<>();
        iWeapon.add(new Axe());
        iWeapon.add(new Bat());
        iWeapon.add(new ChopStick());
        iWeapon.add(new Fist());
        iWeapon.add(new Gun());
        iWeapon.add(new Knife());
        iWeapon.add(new WoodStick());
        return iWeapon;
    }

}
