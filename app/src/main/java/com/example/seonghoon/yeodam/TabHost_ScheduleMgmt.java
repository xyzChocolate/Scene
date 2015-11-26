package com.example.seonghoon.yeodam;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Seonghoon on 2015-11-17.
 */
public class TabHost_ScheduleMgmt extends Activity{


    private LinearLayout dynamicLayout;
    public static ArrayList<View> schedules;
    public static LayoutInflater inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_schedulemgmt);

        ThemaManager themaManager = this.getIntent().getParcelableExtra("themaManager");
        SceneManager sceneManager = this.getIntent().getParcelableExtra("sceneManager");

        dynamicLayout = (LinearLayout) findViewById(R.id.dynamic_area);

        inflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        schedules = new ArrayList<View>();




        //View child2 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
        //dynamicLayout.addView(child2);


        SharedPreferences pref_theme = getSharedPreferences("themeNum", MODE_PRIVATE);
        SharedPreferences.Editor editor_theme= pref_theme.edit();
        int themeNum = pref_theme.getInt("themeNum", -1);

        SharedPreferences pref_scene = getSharedPreferences("sceneNum", MODE_PRIVATE);
        SharedPreferences.Editor editor_scene= pref_scene.edit();
        int sceneNum = pref_scene.getInt("sceneNum", -1);

        addObject(themeNum,sceneNum);






        /*

        switch(themeNum){
            case 0://1번테마의

                switch(sceneNum){
                    default:
                        break;
                    case 0://1번scene 추가
                        View child1_1 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title1_1 = (TextView)findViewById(R.id.title);
                        title1_1.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        schedules.add(child1_1);
                        break;
                    case 1://2번scene 추가
                        View child1_2 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title1_2 = (TextView)findViewById(R.id.title);
                        title1_2.setText("테마" + (themeNum + 1) + "-" + (sceneNum + 1) + "장");
                        schedules.add(child1_2);
                        break;
                    case 2://3번scene 추가
                        View child1_3 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title1_3 = (TextView)findViewById(R.id.title);
                        title1_3.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        schedules.add(child1_3);
                        break;
                    case 3://4번scene 추가
                        View child1_4 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title1_4 = (TextView)findViewById(R.id.title);
                        title1_4.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        schedules.add(child1_4);
                        break;


                }
                break;
            case 1://2번테마의

                switch(sceneNum){
                    default:
                        break;
                    case 0://1번scene 추가
                        View child2_1 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title2_1 = (TextView)findViewById(R.id.title);
                        title2_1.setText("테마"+(themeNum+1)+" - "+(sceneNum+1)+"장");
                        dynamicLayout.addView(child2_1);
                        break;
                    case 1://2번scene 추가
                        View child2_2 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title2_2 = (TextView)findViewById(R.id.title);
                        title2_2.setText("테마"+(themeNum+1)+" - "+(sceneNum+1)+"장");
                        dynamicLayout.addView(child2_2);
                        break;
                    case 2://3번scene 추가
                        View child2_3 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title2_3 = (TextView)findViewById(R.id.title);
                        title2_3.setText("테마"+(themeNum+1)+" - "+(sceneNum+1)+"장");
                        dynamicLayout.addView(child2_3);
                        break;
                    case 3://4번scene 추가
                        View child2_4 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title2_4 = (TextView)findViewById(R.id.title);
                        title2_4.setText("테마"+(themeNum+1)+" - "+(sceneNum+1)+"장");
                        dynamicLayout.addView(child2_4);
                        break;

                }
                break;
            case 2://3번테마의

                switch(sceneNum){
                    default:
                        break;
                    case 0://1번scene 추가
                        View child3_1 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title3_1 = (TextView)findViewById(R.id.title);
                        title3_1.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        dynamicLayout.addView(child3_1);
                        break;
                    case 1://2번scene 추가
                        View child3_2 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title3_2 = (TextView)findViewById(R.id.title);
                        title3_2.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        dynamicLayout.addView(child3_2);
                        break;
                    case 2://3번scene 추가
                        View child3_3 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title3_3 = (TextView)findViewById(R.id.title);
                        title3_3.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        dynamicLayout.addView(child3_3);
                        break;
                    case 3://4번scene 추가
                        View child3_4 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title3_4  = (TextView)findViewById(R.id.title);
                        title3_4.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        dynamicLayout.addView(child3_4);
                        break;

                }
                break;
            case 3://4번테마의

                switch(sceneNum){
                    default:
                        break;
                    case 0://1번scene 추가
                        View child4_1 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title4_1  = (TextView)findViewById(R.id.title);
                        title4_1.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        dynamicLayout.addView(child4_1);
                        break;
                    case 1://2번scene 추가
                        View child4_2 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title4_2  = (TextView)findViewById(R.id.title);
                        title4_2.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        dynamicLayout.addView(child4_2);
                        break;
                    case 2://3번scene 추가
                        View child4_3 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title4_3  = (TextView)findViewById(R.id.title);
                        title4_3.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        dynamicLayout.addView(child4_3);
                        break;
                    case 3://4번scene 추가
                        View child4_4 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title4_4  = (TextView)findViewById(R.id.title);
                        title4_4.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        dynamicLayout.addView(child4_4);
                        break;

                }
                break;
            case 4://5번테마의

                switch(sceneNum){
                    default:
                        break;
                    case 0://1번scene 추가
                        View child5_1 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title5_1  = (TextView)findViewById(R.id.title);
                        title5_1.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        dynamicLayout.addView(child5_1);
                        break;
                    case 1://2번scene 추가
                        View child5_2 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title5_2  = (TextView)findViewById(R.id.title);
                        title5_2.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        dynamicLayout.addView(child5_2);
                        break;
                    case 2://3번scene 추가
                        View child5_3 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title5_3  = (TextView)findViewById(R.id.title);
                        title5_3.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        dynamicLayout.addView(child5_3);
                        break;
                    case 3://4번scene 추가
                        View child4_4 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title4_4  = (TextView)findViewById(R.id.title);
                        title4_4.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        dynamicLayout.addView(child4_4);
                        break;

                }
                break;

            case 5://6번테마의

                switch(sceneNum){
                    default:
                        break;
                    case 0://1번scene 추가
                        View child4_1 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title4_1  = (TextView)findViewById(R.id.title);
                        title4_1.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        dynamicLayout.addView(child4_1);
                        break;
                    case 1://2번scene 추가
                        View child4_2 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title4_2  = (TextView)findViewById(R.id.title);
                        title4_2.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        dynamicLayout.addView(child4_2);
                        break;
                    case 2://3번scene 추가
                        View child4_3 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title4_3  = (TextView)findViewById(R.id.title);
                        title4_3.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        dynamicLayout.addView(child4_3);
                        break;
                    case 3://4번scene 추가
                        View child4_4 = inflater.inflate(R.layout.tab_schedulemgmt_view, null);
                        TextView title4_4  = (TextView)findViewById(R.id.title);
                        title4_4.setText("테마"+(themeNum+1)+"-"+(sceneNum+1)+"장");
                        dynamicLayout.addView(child4_4);
                        break;

                }
                break;
            default:
                break;



        }
        */

        for(int idx = 0; idx<schedules.size(); idx++){
            dynamicLayout.addView(schedules.get(idx));
        }


    }
    private void addObject(int themeNum,int sceneNum){
        View schedule = inflater.inflate(R.layout.tab_schedulemgmt_list,null);
        //TextView title = (TextView)findViewById(R.id.list_title);
        //title.setText("테마 "+(themeNum+1)+" - "+(sceneNum+1)+"장");
        schedules.add(0,schedule);


    }

}
