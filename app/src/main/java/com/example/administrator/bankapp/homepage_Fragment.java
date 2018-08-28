package com.example.administrator.bankapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class homepage_Fragment extends Fragment implements ViewPager.OnPageChangeListener{

    private View mView;

    private ViewPager     homepageviewPager;    //viewpager
    private ImageView[]   tips;                 //索引imageview数组
    private ImageView[]   mImageViews;          //imageview数组
    private int[]         imgIdArray ;          //image id

    private int Gridviewimg[] = {
            R.mipmap.service_icon_01, R.mipmap.service_icon_13, R.mipmap.service_icon_04,
            R.mipmap.service_icon_05, R.mipmap.service_icon_02,
            R.mipmap.homepage_icon_mobilephonerecharge,
    };
    private String GridviewText[] = {"账户查询", "手机号转账", "行内转账",
            "跨行转账", "明细查询", "手机充值"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //注意View对象的重复使用，以便节省资源
        if(mView == null) {
            mView = inflater.inflate(R.layout.homepage_layout,container,false);
        }
        addhomepage(mView);
        addhomepageviewplayer(mView);
        return mView;
    }

    public void addhomepage(View view){
        GridView gridview = (GridView) view.findViewById(R.id.homepagegridview);

        //生成动态数组，并且转入数据
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < GridviewText.length+1; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            if(i<GridviewText.length) {
                map.put("ItemImage", Gridviewimg[i]);//添加img
                map.put("ItemText", GridviewText[i]);//添加text
                lstImageItem.add(map);
            }
            if(i == GridviewText.length){
                map.put("ItemImage", R.mipmap.button_add);//添加img
                map.put("ItemText", "");//添加text
                lstImageItem.add(map);
            }
        }


//生成适配器的ImageItem <====> 动态数组的元素，两者一一对应
        SimpleAdapter saImageItems = new SimpleAdapter(view.getContext(), //没什么解释
                lstImageItem,//数据来源
                R.layout.service_item,//night_item的XML实现

                //动态数组与ImageItem对应的子项
                new String[]{"ItemImage", "ItemText"},

                //ImageItem的XML文件里面的一个ImageView,两个TextView ID
                new int[]{R.id.ItemImage, R.id.ItemText});
//添加并且显示
        gridview.setAdapter(saImageItems);

        gridview.setOnItemClickListener(new ItemClickListener());
    }                //添加gridview

    public void addhomepageviewplayer(View view){
        ViewGroup homepagegroup =   (ViewGroup) view.findViewById(R.id.homepageviewGroup);
        homepageviewPager       =   (ViewPager) view.findViewById(R.id.homepageviewPager);

        //载入图片资源ID
        imgIdArray = new int[]{R.drawable.lifeimg, R.drawable.lifeimg,
                R.drawable.lifeimg, R.drawable.lifeimg};

        if(tips == null) {
            //将点点加入到ViewGroup中
            tips = new ImageView[imgIdArray.length];
            for (int i = 0; i < tips.length; i++) {
                ImageView imageView = new ImageView(view.getContext());
                imageView.setLayoutParams(new ViewGroup.LayoutParams(5, 5));
                tips[i] = imageView;
                if (i == 0) {
                    tips[i].setBackgroundResource(R.mipmap.lock_pattern_node_pressed);
                } else {
                    tips[i].setBackgroundResource(R.mipmap.lock_pattern_node_normal);
                }

                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                layoutParams.leftMargin = 5;
                layoutParams.rightMargin = 5;
                homepagegroup.addView(imageView, layoutParams);
            }
        }


        //将图片装载到数组中
        mImageViews = new ImageView[imgIdArray.length];
        for(int i=0; i<mImageViews.length; i++){
            ImageView imageView = new ImageView(view.getContext());
            mImageViews[i] = imageView;
            imageView.setBackgroundResource(imgIdArray[i]);
        }

        //设置Adapter
        homepageviewPager.setAdapter(new MyAdapter());
        //设置监听，主要是设置点点的背景
        homepageviewPager.setOnPageChangeListener(this);
        //设置ViewPager的默认项, 设置为长度的100倍，这样子开始就能往左滑动
        homepageviewPager.setCurrentItem((mImageViews.length) * 100);
    }      //添加viewplayer

    public class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            //     ((ViewPager)container).removeView(mImageViews[position % mImageViews.length]);
        }

        /**
         * 载入图片进去，用当前的position 除以 图片数组长度取余数是关键
         */
        @Override
        public Object instantiateItem(View container, int position) {
            try {
                ((ViewPager)container).addView(mImageViews[position % mImageViews.length], 0);
            }catch(Exception e){
                //handler something
            }
            return mImageViews[position % mImageViews.length];
        }
    }

    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    public void onPageSelected(int arg0) {
        //Toast.makeText(MainActivity.this,""+position,Toast.LENGTH_SHORT).show();
        setImageBackground(arg0 % mImageViews.length);
    }

    private void setImageBackground(int selectItems){
        for(int i=0; i<tips.length; i++){
            if(i == selectItems){
                tips[i].setBackgroundResource(R.mipmap.lock_pattern_node_pressed);
            }else{
                tips[i].setBackgroundResource(R.mipmap.lock_pattern_node_normal);
            }
        }
    }

    public void onPageScrollStateChanged(int arg0) {

    }

    //当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件
    class ItemClickListener implements AdapterView.OnItemClickListener {

        public void onItemClick(AdapterView<?> arg0,//The AdapterView where the click happened
                                View arg1,//The view within the AdapterView that was clicked
                                int arg2,//The position of the view in the adapter
                                long arg3//The row id of the item that was clicked
        ) {
            //在本例中arg2=arg3
            HashMap<String, Object> item = (HashMap<String, Object>) arg0.getItemAtPosition(arg2);
            String event_name = (String) item.get("ItemText");
            select_onclick_event(event_name);
        }
    }

    public void select_onclick_event(String event_name){
        switch(event_name){
            case "账户查询":
                Intent Account_inquiry = new Intent(mView.getContext(),Activity_Account_inquiry.class);
                startActivity(Account_inquiry);
                break;
            case "手机号转账":
                Intent Phone_number_transfer = new Intent(mView.getContext(),Activity_Mobile_Phone_number_transfer.class);
                startActivity(Phone_number_transfer);
                break;
            case "行内转账":
                Intent inner_bank_transfer = new Intent(mView.getContext(),Activity_inner_bank_transfer.class);
                startActivity(inner_bank_transfer);
                break;
            case "跨行转账" :
                Intent inter_bank_transfer = new Intent(mView.getContext(),Activity_inter_bank_transfer.class);
                startActivity(inter_bank_transfer);
                break;
            case "明细查询" :
                Intent detailed_inquiry = new Intent(mView.getContext(),Activity_detailed_inquiry.class);
                startActivity(detailed_inquiry);
                break;
            case "手机充值" :
                Intent phone_recharge = new Intent(mView.getContext(),Activity_phone_recharge.class);
                startActivity(phone_recharge);
                default:
                    break;
        }
    }

}