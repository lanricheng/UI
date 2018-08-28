package com.example.administrator.bankapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Activity_phone_recharge extends AppCompatActivity implements View.OnClickListener{

    private TextView charge1;
    private TextView charge2;

    private CustomViewPager recharge_viewPager;         //Fragment Viewplayer对象

    private telephone_bili_page fragment_1;
    private flow_rate_page      fragment_2;

    private TextView huafei;
    private TextView liuliang;

    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_recharge);

        TextView title_text = (TextView) findViewById(R.id.activity_title_text);
        title_text.setText("手机充值");

        // 默认软键盘不弹出
        getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        charge1 = (TextView) findViewById(R.id.phone_recharge_huafei);
        charge1.setOnClickListener(this);

        charge2 = (TextView) findViewById(R.id.phone_recharge_liuliang);
        charge2.setOnClickListener(this);

        charge1.setBackgroundColor(Color.parseColor("#dcdcdc"));
        charge2.setBackgroundColor(Color.parseColor("#ffffff"));

        initView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.phone_recharge_huafei:
                charge1.setBackgroundColor(Color.parseColor("#dcdcdc"));
                charge2.setBackgroundColor(Color.parseColor("#ffffff"));
                recharge_viewPager.setCurrentItem(0, true);
                break;
            case R.id.phone_recharge_liuliang:
                charge1.setBackgroundColor(Color.parseColor("#ffffff"));
                charge2.setBackgroundColor(Color.parseColor("#dcdcdc"));
                recharge_viewPager.setCurrentItem(1, true);
                break;
                default:
                    break;
        }
    }

    private void initView() {
        recharge_viewPager = (CustomViewPager) findViewById(R.id.phone_recharge_viewpager);

        recharge_viewPager.setScanScroll(false);      //禁止滑动

        //创建Fragment对象及集合
        fragment_1 = new telephone_bili_page();
        fragment_2 = new flow_rate_page();

        //将Fragment对象添加到list中
        list = new ArrayList<>();
        list.add(fragment_1);
        list.add(fragment_2);

        //给viewPager设置适配器，以显示内容
        Activity_phone_recharge.MyViewPagerAdapter adapter =
                new Activity_phone_recharge.MyViewPagerAdapter(getSupportFragmentManager());
        recharge_viewPager.setAdapter(adapter);

        //设置Viewpager第一次显示的页面
        recharge_viewPager.setCurrentItem(0, true);

        //设置ViewPager页面监听
     //   recharge_viewPager.addOnPageChangeListener(this);

    }          //Fragment初始化

    //创建ViewPager盛放Fragment的适配器类
    public class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        //返回每个position对应的Fragment对象
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        //返回list的长度，也就是Fragment对象的个数
        @Override
        public int getCount() {
            return list.size();
        }

    }

}
