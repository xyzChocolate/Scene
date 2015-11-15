package com.example.seonghoon.yeodam;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Seonghoon on 2015-11-11.
 */

//테마탭에 대한 ActivityGroup
public class TabHost_ThemeTab extends ActivityGroup {

    public static TabHost_ThemeTab ThemeTabGroup;
    private ArrayList<View> history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        history = new ArrayList<View>();
        ThemeTabGroup = this;

        Intent intent = new Intent(TabHost_ThemeTab.this,ThemeTab_Covers.class);
        View view = getLocalActivityManager().startActivity("ThemeTab_Covers",
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)).getDecorView();
        replaceView(view);
    }

    //새로운 Level의 Activity를 추가하는 경우
    public void replaceView(View view){
        history.add(view);
        setContentView(view);
    }

    //Back key가 눌러졌을 경우에 대한 처리
    public void back(){
        if(history.size()>0) {
            history.remove(history.size() - 1);

            if (history.size() == 0) {
                finish();
            } else {
                setContentView(history.get(history.size() - 1));
            }
        }else{
            finish();
        }
    }

    //Back key에 대한 Event Handler

    @Override
    public void onBackPressed() {
        ThemeTabGroup.back();
        return ;
    }
}
