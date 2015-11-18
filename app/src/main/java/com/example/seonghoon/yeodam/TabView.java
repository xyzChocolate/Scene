package com.example.seonghoon.yeodam;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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


    public TabView(Context context, int drawable, int background){

        super(context);

        //Tab Image Setting
        image = new ImageView(context);
        //image.setImageResource(drawable);
        image.setBackgroundResource(background);


        setOrientation(LinearLayout.HORIZONTAL);
        addView(image);



    }


}
