package com.example.administrator.bankapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class morepage_Fragment  extends Fragment {

    private View mView;

    private List<More_element> moreActivity_List = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //注意View对象的重复使用，以便节省资源
        if(mView == null) {
            mView = inflater.inflate(R.layout.morepage_layout,container,false);
        }

        addmorepage(mView);
        return mView;
    }

    public void addmorepage(View view) {
        moreActivity_List.clear();

        More_element one = new More_element("扫码签名", R.mipmap.gengduo_icon_transaction_signature);
        moreActivity_List.add(one);
        More_element two = new More_element("银行公告", R.mipmap.gengduo_03);
        moreActivity_List.add(two);
        More_element fre = new More_element("安全提示", R.mipmap.gengduo_08);
        moreActivity_List.add(fre);
        More_element four = new More_element("网点地图", R.mipmap.gengduo_10);
        moreActivity_List.add(four);
        More_element five = new More_element("微信银行", R.mipmap.gengduo_12);
        moreActivity_List.add(five);
        More_element six = new More_element("软件更新", R.mipmap.gengduo_16);
        moreActivity_List.add(six);

        More_Adapter adapter = new More_Adapter(
                view.getContext(), R.layout.more_item, moreActivity_List);
        ListView listView = (ListView) view.findViewById(R.id.more_List);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                More_element more_element = moreActivity_List.get(i);
                Toast.makeText(view.getContext(),
                        more_element.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}