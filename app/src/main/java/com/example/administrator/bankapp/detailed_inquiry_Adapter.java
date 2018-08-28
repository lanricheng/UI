package com.example.administrator.bankapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class detailed_inquiry_Adapter extends ArrayAdapter<Detailed_inquiry_list_element> {

    private int ResourceId;

    public detailed_inquiry_Adapter(Context context, int textviewResourceId,
                        List<Detailed_inquiry_list_element> objects){
        super(context,textviewResourceId,objects);
        ResourceId = textviewResourceId;
    }

    public View getView(int position, View convertview, ViewGroup parent){

        Detailed_inquiry_list_element payActivity = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(ResourceId,parent,false);

        TextView pay_time  = (TextView) view.findViewById(R.id.detailed_inquiry_item_time);
        TextView pay_value = (TextView) view.findViewById(R.id.detailed_inquiry_item_money) ;
        TextView pay_style = (TextView) view.findViewById(R.id.detailed_inquiry_item_paystyle);

        pay_time.setText(payActivity.getPayTime());
        pay_value.setText(""+payActivity.getPayValue());
        pay_style.setText(payActivity.getPayStyle());

        return view;
    }

}
