package com.example.administrator.bankapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class servicepage_Fragment  extends Fragment{

    private View mView;
    private List<Fragment> list;

    private int Gridviewimg[] = {
            R.mipmap.service_icon_01, R.mipmap.service_icon_04, R.mipmap.service_icon_05,
            R.mipmap.service_icon_13, R.mipmap.service_icon_11, R.mipmap.service_icon_02,
            R.mipmap.service_icon_08, R.mipmap.service_icon_09, R.mipmap.service_icon_06,
            R.mipmap.service_icon_03, R.mipmap.service_icon_23, R.mipmap.service_icon_nfc,
            R.mipmap.service_icon_16, R.mipmap.service_icon_17,
            R.mipmap.service_icon_transfer_cancellation, R.mipmap.service_icon_14,
    };
    private String GridviewText[] = {"账户查询", "行内转账", "跨行转账", "手机号转账", "当面付",
            "明细查询", "转账查询", "储蓄服务", "常用收款人", "信用卡", "云闪付", "IC卡充值", "股金查询",
            "个人贷款", "转账撤销", "电子回单验证"};

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //注意View对象的重复使用，以便节省资源
        if(mView == null) {
            mView = inflater.inflate(R.layout.servicepage_layout,container,false);
        }
        addServicepage(mView);
        return mView;
    }

    public void addServicepage(View view) {

        GridView gridview = (GridView) view.findViewById(R.id.gridview);

//生成动态数组，并且转入数据
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < GridviewText.length; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", Gridviewimg[i]);//添加img
            map.put("ItemText", GridviewText[i]);//添加text
            lstImageItem.add(map);
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
//添加消息处理
        gridview.setOnItemClickListener(new ItemClickListener());

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
            //显示所选Item的ItemText
            //  setTitle((String)item.get("ItemText"));

            Toast.makeText(getView().getContext(), (String) item.get("ItemText"), Toast.LENGTH_SHORT).show();
        }
    }

}
