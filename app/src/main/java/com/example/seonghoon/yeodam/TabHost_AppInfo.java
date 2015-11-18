package com.example.seonghoon.yeodam;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Seonghoon on 2015-11-17.
 */
public class TabHost_AppInfo extends Activity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_appinfo);
        /*
        DisplayMetrics mMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager)getApplicationContext()
                .getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(mMetrics);

        ImageView img = (ImageView)findViewById(R.id.appinfo_img);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) img.getLayoutParams();
        params.width = mMetrics.widthPixels;
        params.height = mMetrics.heightPixels;

        img.setLayoutParams(params);

        */

    }
}
