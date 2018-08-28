package com.example.administrator.bankapp;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class TitleLayout extends RelativeLayout implements View.OnClickListener{

    private ImageView back_Img;

    public TitleLayout(Context context, AttributeSet attrs){
        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.activity_title,this);

        back_Img = (ImageView) findViewById(R.id.title_back_img);
        back_Img.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.title_back_img:
                ((Activity) getContext()).finish();
                break;
            default:
                break;
        }
    }

}
