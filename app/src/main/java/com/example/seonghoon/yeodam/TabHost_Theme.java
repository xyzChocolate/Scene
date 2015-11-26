package com.example.seonghoon.yeodam;

import android.app.ActivityGroup;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Seonghoon on 2015-11-11.
 */

//테마탭에 대한 ActivityGroup
public class TabHost_Theme extends ActivityGroup {

    public static TabHost_Theme ThemeTabGroup;
    private ArrayList<View> history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        history = new ArrayList<View>();
        ThemeTabGroup = this;

        ThemaManager themaManager = this.getIntent().getParcelableExtra("themaManager");
        SceneManager sceneManager = this.getIntent().getParcelableExtra("sceneManager");

        SharedPreferences pref_theme = getSharedPreferences("themeNum", MODE_PRIVATE);
        SharedPreferences.Editor editor_theme= pref_theme.edit();
        editor_theme.remove("themeNum");
        editor_theme.commit();

        SharedPreferences pref_scene = getSharedPreferences("sceneNum", MODE_PRIVATE);
        SharedPreferences.Editor editor_scene= pref_scene.edit();
        editor_scene.remove("sceneNum");
        editor_scene.commit();


        Intent intent = new Intent(TabHost_Theme.this,ThemeTab_Covers.class);
        intent.putExtra("themaManager",themaManager);
        intent.putExtra("sceneManager", sceneManager);
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
            Log.d("TabHost_Theme"+"back()",history.size()+">0");
            Toast.makeText(getApplicationContext(),"back",Toast.LENGTH_LONG).show();
            history.remove(history.size() - 1);

            if (history.size() == 0) {
                Log.d("TabHost_Theme"+"back()",history.size()+"==0");
                finish();
            } else {
                Log.d("TabHost_Theme"+"back()",history.size()+"!=0");
                setContentView(history.get(history.size() - 1));
            }
        }else{
            Log.d("TabHost_Theme"+"back()",history.size()+"<0");

            finish();
        }
    }

    //Back key에 대한 Event Handler

    @Override
    public void onBackPressed() {
        Log.d("TabHost_Theme"+"OnBakPres","called");
        ThemeTabGroup.back();
        return ;
    }

}
