package com.example.administrator.bankapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Activity_add_account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_account);

        TextView title_text = (TextView) findViewById(R.id.activity_title_text);
        title_text.setText("添加账户");
    }

}
