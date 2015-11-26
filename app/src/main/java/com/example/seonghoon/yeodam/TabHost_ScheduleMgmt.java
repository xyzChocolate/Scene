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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Seonghoon on 2015-11-17.
 */
public class TabHost_ScheduleMgmt extends Activity{

    private Integer[] mThumbIds = {
            R.drawable.th1_1,R.drawable.th1_2,R.drawable.th1_3,R.drawable.th1_4,
            R.drawable.th2_1,R.drawable.th2_2,R.drawable.th2_3,R.drawable.th2_4,
            R.drawable.th3_1,R.drawable.th3_2,R.drawable.th3_3,R.drawable.th3_4,
            R.drawable.th4_1,R.drawable.th4_2,R.drawable.th4_3,R.drawable.th4_4,
            R.drawable.th5_1,R.drawable.th5_2,R.drawable.th5_3,R.drawable.th5_4,
            R.drawable.th6_1,R.drawable.th6_2,R.drawable.th6_3,R.drawable.th6_4,



    };

    private TextView title;
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


        String[] theme_scene = readFile();
        if(theme_scene!=null){
            int numOfData = (theme_scene.length)/2;
            addObject(numOfData,theme_scene);

        }






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
    private void addObject(int numOfData,String[] theme_scene){

        int themeNum ;
        int sceneNum ;

        for(int i=0 ; i<numOfData; i++){
            View schedule = inflater.inflate(R.layout.tab_schedulemgmt_view,null);
            TextView title = (TextView)schedule.findViewById(R.id.title);

            themeNum = Integer.parseInt(theme_scene[i*2]);
            sceneNum = Integer.parseInt(theme_scene[i*2+1]);
            title.setText("테마" + themeNum + " - " + (sceneNum + 1));

            ImageView img1 = (ImageView)schedule.findViewById(R.id.scheduleview_1);
            img1.setImageResource(mThumbIds[4 * ( themeNum- 1)]);
            ImageView img2 = (ImageView)schedule.findViewById(R.id.scheduleview_2);
            img2.setImageResource(mThumbIds[4*(themeNum-1)+1]);
            ImageView img3 = (ImageView)schedule.findViewById(R.id.scheduleview_3);
            img3.setImageResource(mThumbIds[4*(themeNum-1)+2]);
            ImageView img4 = (ImageView)schedule.findViewById(R.id.scheduleview_4);
            //img4.setImageResource(mThumbIds[4*(themeNum-1)+3]);


            schedules.add(0, schedule);
        }



    }
    //파일을 읽는다
    public static String[] readFile() {

        byte[] b = new byte[1024];
        try {

            FileInputStream input = new FileInputStream("/data/data/com.example.seonghoon.yeodam/files/cache/cartsave1.txt");
            StringBuilder builder = new StringBuilder();
            int ch;
            while ((ch = input.read()) != -1) {
                builder.append((char) ch);
            }
            String result = builder.toString();

            return parseString(result);

        } catch (IOException ioe) {

        }
        return null;
    }
    public static String[] parseString(String inputString){

        return inputString.split("[,\n]");

    }
}
