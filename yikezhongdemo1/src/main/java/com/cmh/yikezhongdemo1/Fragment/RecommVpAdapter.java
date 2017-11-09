package com.cmh.yikezhongdemo1.Fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 陈敏慧
 * Created by d on 2017/11/8.
 */

class RecommVpAdapter extends FragmentPagerAdapter{
    private List<String> list;
    private List<Fragment> fragments;
    private FragmentManager fragmentManager;

    public RecommVpAdapter(List<String> list,List<Fragment> fragments, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.list = list;
        this.fragments=fragments;
        this.fragmentManager = fragmentManager;
    }

    public RecommVpAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
