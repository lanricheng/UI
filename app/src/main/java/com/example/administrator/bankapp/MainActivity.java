package com.example.administrator.bankapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener, ViewPager.OnPageChangeListener {

    private CustomViewPager viewPager;         //Fragment Viewplayer对象

    private RelativeLayout right_layout;

    private SlidingLayout slidingLayout;       //侧滑布局对象，用于通过手指滑动将左侧的菜单布局进行显示或隐藏。
    private Button        menuButton;          //menu按钮，点击按钮展示左侧布局，再点击一次隐藏左侧布局。

    Button home_pack_button;
    Button life_button;
    Button service_button;
    Button more_button;

    private homepage_Fragment fragment_1;
    private lifepage_Fragment fragment_2;
    private servicepage_Fragment fragment_3;
    private morepage_Fragment fragment_4;

    private List<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addbuttonclick();
        initView();
        slidingMenu();

    }

    private void slidingMenu(){

        slidingLayout = (SlidingLayout) findViewById(R.id.slidingLayout);   //滑动布局对象
        menuButton = (Button) findViewById(R.id.menuButton);                //菜单栏按钮

        right_layout = findViewById(R.id.content);
        // 将监听滑动事件绑定在right_Layout上
        slidingLayout.setScrollEvent(right_layout);

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {                              //菜单栏按钮响应
                // 实现点击一下menu展示左侧布局，再点击一下隐藏左侧布局的功能
                if (slidingLayout.isLeftLayoutVisible()) {
                    slidingLayout.scrollToRightLayout();
                } else {
                    slidingLayout.scrollToLeftLayout();
                }
            }
        });
    }        //滑动控制左侧菜单栏

    private void initView() {
        viewPager = (CustomViewPager) findViewById(R.id.viewpager);

      //  viewPager.setScanScroll(false);      //禁止滑动

        //找到四个按钮
        home_pack_button = (Button) findViewById(R.id.homepage);
        life_button = (Button) findViewById(R.id.life);
        service_button = (Button) findViewById(R.id.service);
        more_button = (Button) findViewById(R.id.more);

        //创建Fragment对象及集合
        fragment_1 = new homepage_Fragment();
        fragment_2 = new lifepage_Fragment();
        fragment_3 = new servicepage_Fragment();
        fragment_4 = new morepage_Fragment();

        //将Fragment对象添加到list中
        list = new ArrayList<>();
        list.add(fragment_1);
        list.add(fragment_2);
        list.add(fragment_3);
        list.add(fragment_4);

        //给viewPager设置适配器，以显示内容
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        //设置Viewpager第一次显示的页面
        viewPager.setCurrentItem(0, true);

        //设置按钮点击监听
        home_pack_button.setOnClickListener(this);
        life_button.setOnClickListener(this);
        service_button.setOnClickListener(this);
        more_button.setOnClickListener(this);

        //设置ViewPager页面监听
        viewPager.addOnPageChangeListener(this);

    }          //Fragment初始化

    public void finish() {
        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
        viewGroup.removeAllViews();
        super.finish();
    }

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

    public void addbuttonclick() {
        home_pack_button = (Button) findViewById(R.id.homepage);
        home_pack_button.setOnClickListener(this);
        life_button = (Button) findViewById(R.id.life);
        life_button.setOnClickListener(this);
        service_button = (Button) findViewById(R.id.service);
        service_button.setOnClickListener(this);
        more_button = (Button) findViewById(R.id.more);
        more_button.setOnClickListener(this);
    }                //添加按钮监听

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.homepage:
                Empty();
                home_pack_button.setBackground(
                        this.getResources().getDrawable(R.mipmap.navigationbar_button_homepage_select));
                viewPager.setCurrentItem(0, true);
                break;
            case R.id.life:
                Empty();
                life_button.setBackground(
                        this.getResources().getDrawable(R.mipmap.navigationbar_button_life_select));
                viewPager.setCurrentItem(1, true);
                break;
            case R.id.service:
                Empty();
                service_button.setBackground(
                        this.getResources().getDrawable(R.mipmap.navigationbar_button_service_select));
                viewPager.setCurrentItem(2, true);
                break;
            case R.id.more:
                Empty();
                more_button.setBackground(
                        this.getResources().getDrawable(R.mipmap.navigationbar_button_more_select));
                viewPager.setCurrentItem(3, true);
                break;
            default:
                break;
        }
    }              //按钮点击事件

    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    public void onPageSelected(int arg0) {
        switch (arg0){
            case 0:
                Empty();
                home_pack_button.setBackground(
                        this.getResources().getDrawable(R.mipmap.navigationbar_button_homepage_select));
                break;
            case 1:
                Empty();
                life_button.setBackground(
                        this.getResources().getDrawable(R.mipmap.navigationbar_button_life_select));
                break;
            case 2:
                Empty();
                service_button.setBackground(
                        this.getResources().getDrawable(R.mipmap.navigationbar_button_service_select));
                break;
            case 3:
                Empty();
                more_button.setBackground(
                        this.getResources().getDrawable(R.mipmap.navigationbar_button_more_select));
                break;
                default:
                    break;
        }
    }         //页面变动监听

    public void onPageScrollStateChanged(int arg0) {

    }

    public void Empty() {
        home_pack_button.setBackground(
                this.getResources().getDrawable(R.mipmap.navigationbar_button_homepage_unselect));
        life_button.setBackground(
                this.getResources().getDrawable(R.mipmap.navigationbar_button_life_unselect));
        service_button.setBackground(
                this.getResources().getDrawable(R.mipmap.navigationbar_button_service_unselect));
        more_button.setBackground(
                this.getResources().getDrawable(R.mipmap.navigationbar_button_more_unselect));
    }                           //刷新底部状态栏

}