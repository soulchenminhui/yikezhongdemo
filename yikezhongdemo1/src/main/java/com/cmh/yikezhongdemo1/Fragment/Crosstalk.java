package com.cmh.yikezhongdemo1.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cmh.yikezhongdemo1.R;

/**
 * 陈敏慧
 * Created by d on 2017/11/6.
 * 段子
 */

public class Crosstalk extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.crosstalk, null);
        return inflate;
    }
}

