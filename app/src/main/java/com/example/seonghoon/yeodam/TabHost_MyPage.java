package com.example.seonghoon.yeodam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Seonghoon on 2015-11-17.
 */
public class TabHost_MyPage extends FragmentActivity{

    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    ImageView img5;
    ImageView img6;
    TextView progress_1;
    TextView progress_2;
    TextView progress_3;
    TextView progress_4;
    TextView progress_5;
    TextView progress_6;

    int th1;
    int th2;
    int th3;
    int th4;
    int th5;
    int th6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_mypage_test);

        img1 = (ImageView)findViewById(R.id.theme_1_over);
        Drawable alpha1 = img1.getBackground();
        progress_1 = (TextView)findViewById(R.id.theme_1_progress);

        img2 = (ImageView)findViewById(R.id.theme_2_over);
        Drawable alpha2 = img1.getBackground();
        progress_2 = (TextView)findViewById(R.id.theme_2_progress);

        img3 = (ImageView)findViewById(R.id.theme_3_over);
        Drawable alpha3 = img1.getBackground();
        progress_3 = (TextView)findViewById(R.id.theme_3_progress);

        img4 = (ImageView)findViewById(R.id.theme_4_over);
        Drawable alpha4 = img1.getBackground();
        progress_4 = (TextView)findViewById(R.id.theme_4_progress);

        img5 = (ImageView)findViewById(R.id.theme_5_over);
        Drawable alpha5 = img1.getBackground();
        progress_5 = (TextView)findViewById(R.id.theme_5_progress);

        img6 = (ImageView)findViewById(R.id.theme_6_over);
        Drawable alpha6 = img1.getBackground();
        progress_6 = (TextView)findViewById(R.id.theme_6_progress);

        th1=0;
        th2=0;
        th3=0;
        th4=0;
        th5=0;
        th6=0;

        String[] data = readFile();

        if(data != null){
            for(int i=0; i<data.length/2;i++){
                switch(data[i*2]){
                    case "1":
                        th1++;
                        break;
                    case "2":
                        th2++;
                        break;
                    case "3":
                        th3++;
                        break;
                    case "4":
                        th4++;
                        break;
                    case "5":
                        th5++;
                        break;
                    case "6":
                        th6++;
                        break;
                }
            }
        }


        if(th1 == 0) {
            alpha1.setAlpha(0);
            progress_1.setText("0%");
        } else if(th1 ==1){
            alpha1.setAlpha(25);
            progress_1.setText("25%");
        } else if(th1 ==2){
            alpha1.setAlpha(50);
            progress_1.setText("50%");
        } else if(th1 ==3){
            alpha1.setAlpha(75);
            progress_1.setText("75%");
        } else{
            alpha1.setAlpha(100);
            progress_1.setText("100%");
        }

        if(th2 == 0) {
            alpha2.setAlpha(0);
            progress_2.setText("0%");
        } else if(th2 ==1){
            alpha2.setAlpha(25);
            progress_2.setText("25%");
        } else if(th2 ==2){
            alpha2.setAlpha(50);
            progress_2.setText("50%");
        } else if(th2 ==3){
            alpha2.setAlpha(75);
            progress_2.setText("75%");
        } else{
            alpha2.setAlpha(100);
            progress_2.setText("100%");
        }


        if(th3 == 0) {
            alpha3.setAlpha(0);
            progress_3.setText("0%");
        } else if(th3 ==1){
            alpha3.setAlpha(25);
            progress_3.setText("25%");
        } else if(th3 ==2){
            alpha3.setAlpha(50);
            progress_3.setText("50%");
        } else if(th3 ==3){
            alpha3.setAlpha(75);
            progress_3.setText("75%");
        } else{
            alpha3.setAlpha(100);
            progress_3.setText("100%");
        }


        if(th4 == 0) {
            alpha4.setAlpha(0);
            progress_4.setText("0%");
        } else if(th4 ==1){
            alpha4.setAlpha(25);
            progress_4.setText("25%");
        } else if(th4 ==2){
            alpha4.setAlpha(50);
            progress_4.setText("50%");
        } else if(th4 ==3){
            alpha4.setAlpha(75);
            progress_4.setText("75%");
        } else{
            alpha4.setAlpha(100);
            progress_4.setText("100%");
        }

        if(th5 == 0) {
            alpha5.setAlpha(0);
            progress_5.setText("0%");
        } else if(th5 ==1){
            alpha5.setAlpha(25);
            progress_5.setText("25%");
        } else if(th5 ==2){
            alpha5.setAlpha(50);
            progress_5.setText("50%");
        } else if(th5 ==3){
            alpha5.setAlpha(75);
            progress_5.setText("75%");
        } else{
            alpha5.setAlpha(100);
            progress_5.setText("100%");
        }

        if(th6 == 0) {
            alpha6.setAlpha(0);
            progress_6.setText("0%");
        } else if(th6 ==1){
            alpha6.setAlpha(25);
            progress_6.setText("25%");
        } else if(th6 ==2){
            alpha6.setAlpha(50);
            progress_6.setText("50%");
        } else if(th6 ==3){
            alpha6.setAlpha(75);
            progress_6.setText("75%");
        } else{
            alpha6.setAlpha(100);
            progress_6.setText("100%");
        }


    }

    //파일을 읽는다
    public static String[] readFile() {

        byte[] b = new byte[1024];
        try{

            FileInputStream input = new FileInputStream("/data/data/com.example.seonghoon.yeodam/files/cache/cartsave1.txt");
            StringBuilder builder = new StringBuilder();
            int ch;
            while((ch = input.read()) != -1){
                builder.append((char)ch);
            }
            return parseString(builder.toString());


        }catch (IOException ioe){

        }
        return null;
    }

    public static String[] parseString(String inputString){

        return inputString.split("[,\n]");

    }


}
