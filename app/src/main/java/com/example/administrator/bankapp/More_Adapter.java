package com.example.administrator.bankapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class More_Adapter extends ArrayAdapter <More_element> {

    private int ResourceId;

    public More_Adapter(Context context, int textviewResourceId,
                               List<More_element> objects){
        super(context,textviewResourceId,objects);
        ResourceId = textviewResourceId;
    }

    public View getView(int position, View convertview, ViewGroup parent){
        More_element moreActivity = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(ResourceId,parent,false);

        ImageView moreActivityImage = (ImageView) view.findViewById(R.id.more_item_image);
        TextView moreActivityText = (TextView) view.findViewById(R.id.more_item_text);

        moreActivityImage.setImageResource(moreActivity.getImageid());
        moreActivityText.setText(moreActivity.getName());
        return view;
    }

}


