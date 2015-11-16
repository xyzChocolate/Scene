package com.example.seonghoon.yeodam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Seonghoon on 2015-11-12.
 */
public class ThemeTab_Content extends FragmentActivity implements View.OnClickListener {


    static final int NUM_ITEM = 6;
    private ViewPager mPager;       //ViewPager
    private ViewPagerAdapter mAdapter;
    private Button back_btn;        //뒤로가기 버튼
    private Intent intent;
    private static View.OnClickListener mButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.view_more_1:
                    Toast.makeText(v.getContext(), "자세히보기가 눌렸네요", Toast.LENGTH_LONG).show();
                    break;
                case R.id.addplan_1:
                    Toast.makeText(v.getContext(), "일정추가가 눌렸네요", Toast.LENGTH_LONG).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_theme_content);
        initLayout();

        //선택된 테마의 인덱스 값 받아오기
        intent = getIntent();
        int reqNewFragmentIndex = intent.getExtras().getInt("position");
        Log.i("받은값",reqNewFragmentIndex+"");

        //선택된 테마의 자세히보기로 옮기기
        //fragmentReplace(reqNewFragmentIndex);
        setCurretItem(reqNewFragmentIndex);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplication(), "뒤로가기가 눌렸네요", Toast.LENGTH_LONG).show();

        switch(v.getId()){
        //뒤로가기눌렀을떄
            case R.id.back_button:
                TabHost_Theme parent = (TabHost_Theme)getParent();
                parent.onBackPressed();
                break;

        }

    }
    //initiateLayout
    private void initLayout(){


        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.viewpager);
        mPager.setAdapter(mAdapter);


        back_btn = (Button)findViewById(R.id.back_button);
        back_btn.setOnClickListener(this);
    }

    private void setCurretItem(int index){
        if(index == 0){
            mPager.setCurrentItem(0);

        }else if(index == 1){
            mPager.setCurrentItem(1);
        }else if(index == 2){
            mPager.setCurrentItem(2);
        }else if(index == 3){
            mPager.setCurrentItem(3);
        }else if(index == 4){
            mPager.setCurrentItem(4);
        }else if(index == 5){
            mPager.setCurrentItem(5);
        }else{
            mPager.setCurrentItem(6);
        }

    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {

        //private LayoutInflater mLayoutInflater;

        public ViewPagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);

        }


        //페이지 개수
        @Override
        public int getCount() {
            return NUM_ITEM;
        }

        //position index의 페이지 가져오기
        @Override
        public Fragment getItem(int position) {
            return ArrayFragment.newInstance(position);
        }

    }
    public static class ArrayFragment extends Fragment{

        int mPosition;


        static ArrayFragment newInstance(int position){
            ArrayFragment f = new ArrayFragment();

            Bundle args = new Bundle();
            args.putInt("position", position);
            f.setArguments(args);

            return f;
        }


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mPosition = getArguments() != null? getArguments().getInt("position"):0;

        }

        //fragment UI

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.tab_theme_content_fragment,container,false);
            View tv = v.findViewById(R.id.text_fragment);
            setTxt((TextView)tv);


            v.findViewById(R.id.view_more_1).setOnClickListener(mButtonClick);
            v.findViewById(R.id.addplan_1).setOnClickListener(mButtonClick);

            return v;
        }
        public void setTxt(TextView view){
            view.setText((mPosition+1)+"번탭");
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
