package com.example.seonghoon.yeodam;

import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity {

    //Called when the activity is first created
    TabHost mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TabActivity의 getTabHost() 는 "@android:id/tabhost"를
        // id로 갖는 TabHost를 얻어옴
        mTab = getTabHost();

        //**findViewByid할 경우 setup 필요
        //mTab.setup();
        //Intent intent = new Intent()


        //TabSpec클래스 탭버튼, 탭내용을 관리하는 Container
        //탭 내용을 관리하는 객체인 TabSpec를 생성해서 Tabspec 객체를 TabHost에 추가
        TabHost.TabSpec spec = mTab.newTabSpec("tag");

        //탭 버튼의 캡션과 아이콘
        //**CustomedTabView
        // spec.setIndicator(new TabView(this,R.drawable.photo,R.string.tab1)).setContent(R.id.view01);

        //** 첫번째 탭
        Intent intent = new Intent();
        //호출하는 클래스 this, 호출되는 클래스 ThemeTab_Cover
        intent.setClass(this, TabHost_ThemeTab.class);
        //제목
        spec.setIndicator("여행테마탐험");
        spec.setContent(intent);
        mTab.addTab(spec);

        //** 두번째 탭
        spec = mTab.newTabSpec("tag");
        spec.setIndicator("일정관리");
        spec.setContent(R.id.view02);
        mTab.addTab(spec);

        //** 세번째 탭
        spec = mTab.newTabSpec("tag");
        Intent intent1 = new Intent();
        intent1.setClass(this,FragmentPageSupport.class);
        spec.setIndicator("주변여행지");
        spec.setContent(intent1);
        mTab.addTab(spec);

        //** 네번째 탭
        spec = mTab.newTabSpec("tag");
        spec.setIndicator("마이페이지");
        spec.setContent(R.id.view01);
        mTab.addTab(spec);
        //** 다섯번째탭
        spec = mTab.newTabSpec("tag");
        spec.setIndicator("앱정보");
        spec.setContent(R.id.view05);
        mTab.addTab(spec);



        /*
        //Tab색깔 바꾸기
        for(int i=0; i < mTab.getTabWidget().getChildCount();i++)
        {
            mTab.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#D9E5FF"));
        }

        //mTab.getTabWidget().getChildAt(1).setBackgroundColor(Color.parseColor("#D4F4FA"));
        */

        //실행시 처음 보여지는 Tab index 설정
        mTab.getTabWidget().setCurrentTab(0);

        //Array
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,R.array.company,
                        android.R.layout.simple_gallery_item);

        //GridView
        GridView gridView = (GridView)findViewById(R.id.GridView01);
        gridView.setAdapter(adapter);


        for (int tab = 0; tab < mTab.getTabWidget().getChildCount(); ++tab) {

            mTab.getTabWidget().getChildAt(tab).getLayoutParams().height = 120;

        }



    }
    //H/W 뒤로가기버튼 Handler
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK:
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

}