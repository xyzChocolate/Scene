package com.example.seonghoon.yeodam;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Seonghoon on 2015-11-12.
 */
public class ThemeTab_Content_6 extends FragmentActivity implements View.OnClickListener {


    static final int NUM_ITEM = 4;
    private ViewPager mPager;       //
    private ViewPagerAdapter mAdapter;
    private Button back_btn;        //뒤로가기 버튼
    private Intent intent;
    private ImageView page_1_icon;
    private ImageView page_2_icon;
    private ImageView page_3_icon;
    private ImageView page_4_icon;
    private Drawable Selected_icon;
    private Drawable notSelecteed_icon;
    private static ThemaManager themaManager;
    private static SceneManager sceneManager;
    private static int reqNewFragmentIndex;
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_theme_content);
        initLayout();

        //선택된 테마의 인덱스 값 받아오기
        intent = getIntent();
        reqNewFragmentIndex = intent.getExtras().getInt("position");
        themaManager = this.getIntent().getParcelableExtra("themaManager");
        sceneManager = this.getIntent().getParcelableExtra("sceneManager");

        //테마정보저장
        preferences = getSharedPreferences("themeNum", MODE_PRIVATE);
        editor = preferences.edit();
        //이미 가지고 있는 테마넘버 지우고
        editor.remove("themeNum");
        editor.commit();
        //현재 테마 저장
        editor.putInt("themeNum", 5);//6번테마
        editor.commit();
        preferences = getSharedPreferences("sceneNum", MODE_PRIVATE);
        editor = preferences.edit();
        editor.remove("sceneNum");
        editor.commit();




        Log.i("받은값",reqNewFragmentIndex+"");

        //선택된 테마의 자세히보기로 옮기기
        //fragmentReplace(reqNewFragmentIndex);
        //setCurretItem(reqNewFragmentIndex);

        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){ //아이템이 변경되면
            //아이템이 선택이 되었으면
            @Override
            public void onPageSelected(int position) {
                switch (position){

                    case 0: //첫번째 페이지
                        page_1_icon.setImageDrawable(Selected_icon);
                        page_2_icon.setImageDrawable(notSelecteed_icon);
                        page_3_icon.setImageDrawable(notSelecteed_icon);
                        page_4_icon.setImageDrawable(notSelecteed_icon);
                        break;

                    case 1: //두번째 페이지
                        page_1_icon.setImageDrawable(notSelecteed_icon);
                        page_2_icon.setImageDrawable(Selected_icon);
                        page_3_icon.setImageDrawable(notSelecteed_icon);
                        page_4_icon.setImageDrawable(notSelecteed_icon);
                        break;

                    case 2: //세번째 페이지
                        page_1_icon.setImageDrawable(notSelecteed_icon);
                        page_2_icon.setImageDrawable(notSelecteed_icon);
                        page_3_icon.setImageDrawable(Selected_icon);
                        page_4_icon.setImageDrawable(notSelecteed_icon);
                        break;

                    case 3: //네번째 페이지
                        page_1_icon.setImageDrawable(notSelecteed_icon);
                        page_2_icon.setImageDrawable(notSelecteed_icon);
                        page_3_icon.setImageDrawable(notSelecteed_icon);
                        page_4_icon.setImageDrawable(Selected_icon);
                        break;
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffest, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplication(), "뒤로가기가 눌렸네요", Toast.LENGTH_SHORT).show();

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

        Selected_icon = ContextCompat.getDrawable(this, R.drawable.selected);
        notSelecteed_icon = ContextCompat.getDrawable(this, R.drawable.not_selected);

        page_1_icon = (ImageView)findViewById(R.id.page_1_icon);
        page_2_icon = (ImageView)findViewById(R.id.page_2_icon);
        page_3_icon = (ImageView)findViewById(R.id.page_3_icon);
        page_4_icon = (ImageView)findViewById(R.id.page_4_icon);

        page_1_icon.setImageDrawable(Selected_icon);
        page_2_icon.setImageDrawable(notSelecteed_icon);
        page_3_icon.setImageDrawable(notSelecteed_icon);
        page_4_icon.setImageDrawable(notSelecteed_icon);


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
        }else {
            mPager.setCurrentItem(4);
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
        int mSceneNumber;
        String[] sceneInfo;

        public TextView title;
        public TextView subtitle;
        public TextView hashTag;

        public ImageView image;
        public TextView content;

        public Button more;
        public Button addPlan;


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
            mSceneNumber = 20;
            //SceneData Index
            sceneInfo = getThemeInfo(mSceneNumber);

        }
        //fragment UI


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


            View view = inflater.inflate(R.layout.tab_theme_content_fragment, container, false);

            Drawable drawable = ContextCompat.getDrawable( getContext(), R.drawable.p1);

            title = (TextView)view.findViewById(R.id.fragment_title);
            title.setText("#"+(mPosition+1)+"장");
            subtitle = (TextView)view.findViewById(R.id.fragment_subtitle);


            hashTag = (TextView)view.findViewById(R.id.fragment_hash_tag);

            image = (ImageView)view.findViewById(R.id.theme_content_img);
            image.setImageDrawable(drawable);

            content = (TextView)view.findViewById(R.id.text_fragment);

            more = (Button)view.findViewById(R.id.view_more_1);
            more.findViewById(R.id.view_more_1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ThemeTab_Content_1","자세히보기 버튼 클릭");
                    Intent intent = new Intent().setClass(getContext(),ThemeTab_Content_More.class);
                    intent.putExtra("ThemeNum",reqNewFragmentIndex);
                    intent.putExtra("mPosition",mPosition);
                    intent.putExtra("SceneInfo",sceneInfo);
                    startActivity(intent);

                }
            });

            addPlan = (Button)view.findViewById(R.id.addplan_1);
            addPlan.findViewById(R.id.addplan_1).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("ThemeTab_Content_6","일정추가 버튼 클릭");
                    editor.putInt("sceneNum", mPosition);
                    editor.commit();
                    writeFile(mPosition);
                    Toast.makeText(getContext(),"일정이 추가되었습니다.",Toast.LENGTH_SHORT).show();
                }
            });





            //Scene View
            switch(mPosition){
                case 0:
                    subtitle.setText(sceneManager.getOneScene(20).getSceneName());
                    hashTag.setText(sceneManager.getOneScene(20).getHashTag());
                    content.setText(sceneManager.getOneScene(20).getSceneStroy());
                    drawable = ContextCompat.getDrawable( getContext(), R.drawable.th6_1);
                    image.setImageDrawable(drawable);
                    break;
                case 1:
                    subtitle.setText(sceneManager.getOneScene(21).getSceneName());
                    hashTag.setText(sceneManager.getOneScene(21).getHashTag());
                    content.setText(sceneManager.getOneScene(21).getSceneStroy());
                    drawable = ContextCompat.getDrawable( getContext(), R.drawable.th6_2);
                    image.setImageDrawable(drawable);
                    break;
                case 2:
                    subtitle.setText(sceneManager.getOneScene(22).getSceneName());
                    hashTag.setText(sceneManager.getOneScene(22).getHashTag());
                    content.setText(sceneManager.getOneScene(22).getSceneStroy());
                    drawable = ContextCompat.getDrawable( getContext(), R.drawable.th6_3);
                    image.setImageDrawable(drawable);
                    break;
                case 3:
                    subtitle.setText(sceneManager.getOneScene(23).getSceneName());
                    hashTag.setText(sceneManager.getOneScene(23).getHashTag());
                    content.setText(sceneManager.getOneScene(23).getSceneStroy());
                    drawable = ContextCompat.getDrawable( getContext(), R.drawable.th6_4);
                    image.setImageDrawable(drawable);
                    break;

            }

            return view;

        }
        public String[] getThemeInfo(int mSceneNumber){
            String[]  info = new String[24];

            for(int i=0 ; i<24; i++){
                info[i] = new String();
            }

            for(int i=0;i<4; i++) {

                info[i * 6] = sceneManager.getOneScene(mSceneNumber).getSceneName();
                info[i * 6 + 1] = sceneManager.getOneScene(mSceneNumber).getHashTag();
                info[i * 6 + 2] = sceneManager.getOneScene(mSceneNumber).getSceneMission();
                info[i * 6 + 3] = sceneManager.getOneScene(mSceneNumber).getSceneStroy();
                info[i * 6 + 4] = sceneManager.getOneScene(mSceneNumber).getSceneInfo();
                info[i * 6 + 5] = sceneManager.getOneScene(mSceneNumber).getFoodGuide();

                mSceneNumber++;
            }

            return info;


        }
    }

    //파일을 만들어서 쓴다.
    public static void writeFile(int mPosition) {
        String dirPath = "/data/data/com.example.seonghoon.yeodam/files/cache";
        File file = new File(dirPath);

        if(!file.exists()) {

            file.mkdirs();
            file.setReadable(true,false);
        }

        String saveString = "6,"+mPosition+"\n";
        File savefile = new File(dirPath+"/cartsave1.txt");

        try{
            FileOutputStream fos = new FileOutputStream(savefile,true);
            fos.write(saveString.getBytes());
            fos.close();
        }catch (IOException ioe){

        }


    }

    //파일을 읽는다
    public static void readFile() {

        byte[] b = new byte[1024];
        try{

            FileInputStream input = new FileInputStream("/data/data/com.example.seonghoon.yeodam/files/cache/cartsave.txt");
            StringBuilder builder = new StringBuilder();
            int ch;
            while((ch = input.read()) != -1){
                builder.append((char)ch);
            }

        }catch (IOException ioe){

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
