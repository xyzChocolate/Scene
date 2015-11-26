package com.example.seonghoon.yeodam;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Seonghoon on 2015-11-26.
 */
public class ScheduleTab_Content extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_schedulemgmt_view);

        int themeNum =getIntent().getExtras().getInt("themeNum");
        int sceneNum =getIntent().getExtras().getInt("sceneNum");
        TextView title = (TextView)findViewById(R.id.title);
        //title.setText();

    }
}
