package com.cmh.yikezhongdemo1.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cmh.yikezhongdemo1.R;

import java.util.ArrayList;

/**
 * 陈敏慧
 * Created by d on 2017/11/6.
 * 推荐
 */

public class Recommend extends Fragment{

    private View inflate;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.recommend, null);
        tabinit();
        return inflate;
    }

    private void tabinit() {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Fragment> fragments = new ArrayList<>();
        list.add("热门");
        list.add("关注");
        fragments.add(new RecommFragment1());
        fragments.add(new RecommFragment2());
        TabLayout recomm_tab=inflate.findViewById(R.id.recomm_tab);
        ViewPager recomm_vp=inflate.findViewById(R.id.recomm_vp);
        RecommVpAdapter recommVpAdapter = new RecommVpAdapter(list,fragments,getActivity().getSupportFragmentManager());
        recomm_vp.setAdapter(recommVpAdapter);
       // recomm_tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        recomm_tab.setupWithViewPager(recomm_vp);
    }
}
