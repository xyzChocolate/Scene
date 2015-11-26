package com.example.seonghoon.yeodam;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Seonghoon on 2015-11-24.
 */
public class ThemeTab_Content_More extends Activity {

    int themeNum;
    int sceneNum;
    String[] sceneInfo;

    TextView followMe_sub;
    TextView more_info;
    TextView food_info;
    TextView surroundings_info;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTheme(R.style.Theme_Transparent);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,
                WindowManager.LayoutParams.FLAG_BLUR_BEHIND);

        setContentView(R.layout.tab_theme_content_more);




        //사용자가 선택한 테마번호
        themeNum = this.getIntent().getExtras().getInt("ThemeNum");
        //버튼을 누른 scene번호
        sceneNum = this.getIntent().getExtras().getInt("mPosition");
        //Scene정보
        sceneInfo = this.getIntent().getExtras().getStringArray("SceneInfo");



        followMe_sub = (TextView)findViewById(R.id.content_more1_followMe_sub);
        more_info = (TextView)findViewById(R.id.content_more3_moreInfo);
        food_info = (TextView)findViewById(R.id.content_more4_foodInfo);
        surroundings_info = (TextView)findViewById(R.id.content_more5_surroundingsInfo);



        //
        followMe_sub.setText(sceneInfo[sceneNum*6+2]);
        more_info.setText(sceneInfo[sceneNum*6+4]);
        food_info.setText(sceneInfo[sceneNum*6+5]);
        surroundings_info.setText("주변정보");


        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        Point size = new Point();

        display.getSize(size);
        int width = size.x;
        int height = size.y;

        width = (int) ( width * 0.98 ); //Display 사이즈의 98%
        height = (int) ( height * 0.80 );  //Display 사이즈의 80%

        getWindow().getAttributes().width = width;
        getWindow().getAttributes().height = height;






        ImageButton close = (ImageButton)findViewById(R.id.close_more);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
