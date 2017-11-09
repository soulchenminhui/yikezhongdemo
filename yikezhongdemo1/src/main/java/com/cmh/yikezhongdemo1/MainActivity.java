package com.cmh.yikezhongdemo1;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.cmh.yikezhongdemo1.Fragment.Crosstalk;
import com.cmh.yikezhongdemo1.Fragment.Recommend;
import com.cmh.yikezhongdemo1.Fragment.Video;
import com.cmh.yikezhongdemo1.databinding.ActivityMainBinding;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private Recommend recommend;
    private Crosstalk crosstalk;
    private Video video;
    private FragmentManager manager;
    private SlidingMenu slidingMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        //得到管理者
        initView();
        manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fram,recommend);
        transaction.add(R.id.fram,crosstalk);
        transaction.add(R.id.fram,video);
        transaction.show(recommend);
        transaction.hide(crosstalk);
        transaction.hide(video);
        transaction.commit();
        mainBinding.tabMenu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.btn_1:
                        FragmentTransaction transaction1 = manager.beginTransaction();
                        transaction1.show(recommend);
                        transaction1.hide(crosstalk);
                        transaction1.hide(video);
                        transaction1.commit();
                        mainBinding.myView.getMyview_title().setText("推荐");
                        break;
                    case R.id.btn_2:
                        FragmentTransaction transaction2 = manager.beginTransaction();
                        transaction2.show(crosstalk);
                        transaction2.hide(recommend);
                        transaction2.hide(video);
                        transaction2.commit();
                        mainBinding.myView.getMyview_title().setText("我是傻子");
                        break;
                    case R.id.btn_3:
                        FragmentTransaction transaction3 = manager.beginTransaction();
                        transaction3.show(video);
                        transaction3.hide(crosstalk);
                        transaction3.hide(recommend);
                        transaction3.commit();
                        mainBinding.myView.getMyview_title().setText("视频");
                        break;
                    default:
                        break;
                }
            }
        });
        SlidingMenuView();
        initState();
    }
    public void initView(){
        recommend = new Recommend();
        crosstalk = new Crosstalk();
        video = new Video();
    }
    //沉浸式
    private void initState() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
    //slidingmenu的配置
    public void SlidingMenuView(){
        //侧拉布局slidingmenu
        slidingMenu = new SlidingMenu(this);
        slidingMenu.setMode(SlidingMenu.LEFT);
//        slidingMenu.setTouchModeBehind(SlidingMenu.LEFT);
        //依附在当前界面
        slidingMenu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);
        slidingMenu.setBehindOffset(180);
        View view = View.inflate(this, R.layout.activity_newsleft, null);
        slidingMenu.setMenu(view);
    }
}
