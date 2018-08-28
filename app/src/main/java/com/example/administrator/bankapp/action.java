package com.example.administrator.bankapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class action extends AppCompatActivity {

    Handler handler=new Handler();
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action);

        handler.post(runnable);
    }

    Runnable runnable = new Runnable() {
        public void run() {
            handler.postDelayed(this, 1000);
            count++;
            if(count==3){
                Intent intent = new Intent(action.this,MainActivity.class);
                startActivity(intent);
                action.this.finish();
            }
        }
    };

}
