package com.example.administrator.bankapp;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity_detailed_inquiry extends AppCompatActivity {

    private List<Detailed_inquiry_list_element> detailed_inquiry_list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_inquiry);

        TextView title_text = (TextView) findViewById(R.id.activity_title_text);
        title_text.setText("明细查询");

        TextView title_textright = (TextView) findViewById(R.id.activity_title_textright);
        title_textright.setText("筛选");

        // 默认软键盘不弹出
        getWindow().setSoftInputMode( WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        add_list();

    }

    public void add_list(){

        detailed_inquiry_list.clear();

        Detailed_inquiry_list_element one = new Detailed_inquiry_list_element
                ("2018-08-08","二维码支付",20.00);
        detailed_inquiry_list.add(one);

        Detailed_inquiry_list_element two = new Detailed_inquiry_list_element
                ("2018-08-08","网银支付",0.01);
        detailed_inquiry_list.add(two);

        Detailed_inquiry_list_element fre = new Detailed_inquiry_list_element
                ("2018-08-09","二维码支付",2.00);
        detailed_inquiry_list.add(fre);

        for(int i=0;i<5;i++){
            detailed_inquiry_list.add(fre);
        }

        detailed_inquiry_Adapter adapter = new detailed_inquiry_Adapter(
                this, R.layout.detailed_inquiry_item, detailed_inquiry_list);

        ListView listView = (ListView) findViewById(R.id.detailed_inquiry_Listview);
        listView.setAdapter(adapter);

    }

}
