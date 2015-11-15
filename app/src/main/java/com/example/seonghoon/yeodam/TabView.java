package com.example.seonghoon.yeodam;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Seonghoon on 2015-11-06.
 */

//탭 꾸미기
//To make Cutomed Tab
public class TabView extends LinearLayout {

    ImageView image;
    TextView text;

    public TabView(Context context, int drawable, int label){

        super(context);

        //Tab Image Setting
        image = new ImageView(context);
        image.setImageResource(drawable);

        //Tab Label Setting
        text = new TextView(context);
        text.setText(getResources().getString(label));

        setOrientation(LinearLayout.HORIZONTAL);
        addView(image);
        addView(text);
        //this.setBackground(intent);

    }

    public ImageView getImageView(){
        return image;
    }

    public TextView getTextView() {
        return text;
    }
}
