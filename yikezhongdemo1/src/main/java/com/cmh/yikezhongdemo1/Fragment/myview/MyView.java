package com.cmh.yikezhongdemo1.Fragment.myview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmh.yikezhongdemo1.R;

/**
 * 陈敏慧
 * Created by d on 2017/11/6.
 */

public class MyView extends LinearLayout{

    private ImageView myview_touxiang;
    private ImageView myview_bianji;
    private RelativeLayout relative;
    private TextView myview_title;

    public MyView(Context context) {
        this(context,null);
        initview(context);

    }

    public TextView getMyview_title() {
        return myview_title;
    }

    public void setMyview_title(TextView myview_title) {
        this.myview_title = myview_title;
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
        //创建数据类型
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        float dimension = typedArray.getDimension(R.styleable.MyView_title_size, 20);
        String string = typedArray.getString(R.styleable.MyView_title_content);
        int color = typedArray.getColor(R.styleable.MyView_title_color, Color.WHITE);
        initview(context);

        //针对控件进行设置
        myview_title.setText("");
        myview_title.setTextSize(dimension);
        myview_title.setTextColor(color);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initview(context);
    }

    public void initview(Context context){
        //找控件
        LayoutInflater.from(context).inflate(R.layout.myview_item,this,true);
        myview_touxiang = findViewById(R.id.myview_touxisng);
        myview_bianji = findViewById(R.id.myview_bianji);
        relative = findViewById(R.id.relative);
        myview_title = findViewById(R.id.myview_title);
    }
}
