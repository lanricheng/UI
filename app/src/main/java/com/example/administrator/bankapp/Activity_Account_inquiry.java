package com.example.administrator.bankapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Activity_Account_inquiry extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_inquiry);

        TextView title_text = (TextView) findViewById(R.id.activity_title_text);
        title_text.setText("账户查询");

        RelativeLayout layout_add = findViewById(R.id.account_activity_add);
        layout_add.setOnClickListener(this);

        ImageView      message_img = findViewById(R.id.account_activity_card);
        message_img.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.account_activity_card:
                Intent intent = new Intent(Activity_Account_inquiry.this,
                        Activity_inquiry.class);
                startActivity(intent);
                break;
            case R.id.account_activity_add:
                Intent intent2 = new Intent(Activity_Account_inquiry.this,
                        Activity_add_account.class);
                startActivity(intent2);
                break;
                default:
                    break;
        }
    }
}