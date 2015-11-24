package com.example.seonghoon.yeodam;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    //Called when the activity is first created
    TabHost mTab;
    ImageView iv;


    int Tab_Unclicked[] = {R.drawable.icon_03_theme,R.drawable.icon_01_schedule,R.drawable.icon_04_maos,
            R.drawable.icon_02_mytravel,R.drawable.icon_05_info};
    int Tab_Clicked[] = {R.drawable.icon_clicked_03,R.drawable.icon_clicked_01,R.drawable.icon_clicked_04,
                        R.drawable.icon_clicked_02,R.drawable.icon_clicked_05};


    //raw 파일 이름으로 inputStream을 받아오는 매소드
    public InputStream getInputStream(String string) {
        InputStream ins = getResources().openRawResource(getResources().getIdentifier(string,"raw",getPackageName()));
        return ins;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(Color.parseColor("#00CCCB"));
        }


        //각 함수의 매니저를 호출
        SceneManager sceneManager = new SceneManager();
        ThemaManager themaManager = new ThemaManager();
        LocationManager locationManager = new LocationManager();
        PlanManager planManager = new PlanManager();
        try {
            sceneManager.read(getInputStream("scenedata"));

            themaManager.readRelation(getInputStream("themarelation"));
            planManager.readRelation(getInputStream("planrelation"));
            themaManager.read(getInputStream("themadata"));
            planManager.read(getInputStream("plandata"));
            locationManager.read(getInputStream("locationdata"));




        } catch(IOException ioe) {

        } catch(ParseException pe) {


        }

        //TabActivity의 getTabHost() 는 "@android:id/tabhost"를
        // id로 갖는 TabHost를 얻어옴
        mTab = getTabHost();


        //**findViewByid할 경우 setup 필요
        //mTab.setup();
        //Intent intent = new Intent()


        //TabSpec클래스 탭버튼, 탭내용을 관리하는 Container
        //탭 내용을 관리하는 객체인 TabSpec를 생성해서 Tabspec 객체를 TabHost에 추가


        //탭 버튼의 캡션과 아이콘
        //**CustomedTabView
        // spec.setIndicator(new TabView(this,R.drawable.photo,R.string.tab1)).setContent(R.id.view01);

        /**
         * Customed TabView만들기
         */



        //** 첫번째 탭
        TabHost.TabSpec tab1_spec = mTab.newTabSpec("tab1");
        Intent intent1 = new Intent();
        //호출하는 클래스 this, 호출되는 클래스 ThemeTab_Cover
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent1.setClass(this, TabHost_Theme.class);
        intent1.putExtra("themaManager",themaManager);
        intent1.putExtra("sceneManager",sceneManager);
        //제목
        tab1_spec.setIndicator(new TabView(this,Tab_Unclicked[0],R.drawable.tab1_bg));
        tab1_spec.setContent(intent1);
        mTab.addTab(tab1_spec);

        //** 두번째 탭->ScheduleMgmt
        Intent intent2 = new Intent();
        intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent2.setClass(this, TabHost_ScheduleMgmt.class);
        intent2.putExtra("planNameList", planManager.getAllPlanName());
        TabHost.TabSpec tab2_spec = mTab.newTabSpec("tab2");
        tab2_spec.setIndicator(new TabView(this,Tab_Unclicked[1],R.drawable.tab2_bg));
        tab2_spec.setContent(intent2);
        mTab.addTab(tab2_spec);

        //** 세번째 탭->Surroundings
        TabHost.TabSpec tab3_spec = mTab.newTabSpec("tab3");
        Intent intent3 = new Intent();
        intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent3.setClass(this, TabHost_Surroundings.class);
        tab3_spec.setIndicator(new TabView(this,Tab_Unclicked[2],R.drawable.tab3_bg));
        tab3_spec.setContent(intent3);
        mTab.addTab(tab3_spec);

        //** 네번째 탭->MyPage
        TabHost.TabSpec tab4_spec = mTab.newTabSpec("tab4");
        Intent intent4 = new Intent();
        intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent4.setClass(this, TabHost_MyPage.class);
        tab4_spec.setIndicator(new TabView(this,Tab_Unclicked[3],R.drawable.tab4_bg));
        tab4_spec.setContent(intent4);
        mTab.addTab(tab4_spec);

        //** 다섯번째탭->AppInfo
        TabHost.TabSpec tab5_spec = mTab.newTabSpec("tab5");
        Intent intent5 = new Intent();
        intent5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent5.setClass(this, TabHost_AppInfo.class);
        tab5_spec.setIndicator(new TabView(this,Tab_Unclicked[4],R.drawable.tab5_bg));
        tab5_spec.setContent(intent5);
        mTab.addTab(tab5_spec);




        //Tab색깔 바꾸기
        for(int i=0; i < mTab.getTabWidget().getChildCount();i++)
        {
            //mTab.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#00CCBC"));
            //mTab.getTabWidget().getChildAt(i).getLayoutParams().height = 200;
        }

        //mTab.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor("#D4F4FA"));

        /*
        //탭 선택시 리스너
        mTab.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {

                //이미지 초기화
                for(int i = 0; i<mTab.getTabWidget().getChildCount();i++){
                    iv = (ImageView)mTab.getTabWidget().getChildAt(i).findViewById(android.R.id.icon);
                    iv.setImageDrawable(getResources().getDrawable(Tab_Unclicked[i]));
                }

                //선택된 탭 처리


                    if(tabId == "tab1"){
                        iv = (ImageView)mTab.getTabWidget().getChildAt(0).findViewById(android.R.id.icon);
                        iv.setImageDrawable(getResources().getDrawable(Tab_Clicked[0]));

                    }else if(tabId == "tab2"){
                        iv = (ImageView)mTab.getTabWidget().getChildAt(1).findViewById(android.R.id.icon);
                        iv.setImageDrawable(getResources().getDrawable(Tab_Clicked[1]));

                    }else if(tabId == "tab3"){
                        iv = (ImageView)mTab.getTabWidget().getChildAt(2).findViewById(android.R.id.icon);
                        iv.setImageDrawable(getResources().getDrawable(Tab_Clicked[2]));

                    }else if(tabId == "tab4"){
                        iv = (ImageView)mTab.getTabWidget().getChildAt(3).findViewById(android.R.id.icon);
                        iv.setImageDrawable(getResources().getDrawable(Tab_Clicked[3]));

                    }else{
                        iv = (ImageView)mTab.getTabWidget().getChildAt(4).findViewById(android.R.id.icon);
                        iv.setImageDrawable(getResources().getDrawable(Tab_Clicked[4]));

                    }






            }
        });

        */
        //실행시 처음 보여지는 Tab index 설정
        mTab.getTabWidget().setCurrentTab(0);
        mTab.getTabWidget().getChildAt(0).setSelected(true);


        //Array
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,R.array.company,
                        android.R.layout.simple_gallery_item);

        //GridView
        //GridView gridView = (GridView)findViewById(R.id.GridView01);
        //gridView.setAdapter(adapter);


        for (int tab = 0; tab < mTab.getTabWidget().getChildCount(); ++tab) {

            //mTab.getTabWidget().getChildAt(tab).getLayoutParams().;

        }



    }

    //H/W 뒤로가기버튼 Handler
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d("MainActvty"+"keydown()","called");
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
                Log.d("MainActvty"+"keycode_back","called");
                new AlertDialog.Builder(this)
                        .setTitle("종료")
                        .setMessage("정말로 종료하시겠습니까?")
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .setNegativeButton("아니오", null).show();
                return false;
            case KeyEvent.KEYCODE_HOME:
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onBackPressed() {
        Log.d("MainActvty"+"Onbackpre","called");
    }
}