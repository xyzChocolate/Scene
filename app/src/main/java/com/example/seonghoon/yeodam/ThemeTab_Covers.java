package com.example.seonghoon.yeodam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Seonghoon on 2015-11-06.
 */
public class ThemeTab_Covers extends Activity{


    private Intent intent;
    private ThemaManager themaManager;
    private SceneManager sceneManager;

    //이미지들 담는 배열
    private Integer[] mThumbIds = {
            R.drawable.th1,
            R.drawable.th2,
            R.drawable.th3,
            R.drawable.th4,
            R.drawable.th5,
            R.drawable.th6,

    };

    //화면측정
    DisplayMetrics mMetrics;
    ImageButton findBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_theme_cover);


        themaManager = this.getIntent().getParcelableExtra("themaManager");
        sceneManager = this.getIntent().getParcelableExtra("sceneManager");

        GridView gridView = (GridView)findViewById(R.id.photogrid);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(gridviewOnItemClickListener);

        findBtn = (ImageButton)findViewById(R.id.findBtn);
        findBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "찾기버튼눌렀쪄요?우쮸쮸쮸", Toast.LENGTH_LONG).show();
                //findBtn.clearAnimation();
            }
        });

        //깜박이는 애니메이션
        /*
        Animation animation = new AlphaAnimation(1,0);
        animation.setDuration(700);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);


        findBtn.startAnimation(animation);
         */

        mMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(mMetrics);
    }

    private GridView.OnItemClickListener gridviewOnItemClickListener
            = new GridView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            switch (position){
                case 0:
                    intent = new Intent(ThemeTab_Covers.this,ThemeTab_Content_1.class);
                    intent.putExtra("position",position);
                    intent.putExtra("themaManager",themaManager);
                    intent.putExtra("sceneManager", sceneManager);
                    break;
                case 1:
                    intent = new Intent(ThemeTab_Covers.this,ThemeTab_Content_2.class);
                    intent.putExtra("position",position);
                    intent.putExtra("themaManager",themaManager);
                    intent.putExtra("sceneManager", sceneManager);
                    break;
                case 2:
                    intent = new Intent(ThemeTab_Covers.this,ThemeTab_Content_3.class);
                    intent.putExtra("position",position);
                    intent.putExtra("themaManager",themaManager);
                    intent.putExtra("sceneManager", sceneManager);
                    break;
                case 3:
                    intent = new Intent(ThemeTab_Covers.this,ThemeTab_Content_4.class);
                    intent.putExtra("position",position);
                    intent.putExtra("themaManager",themaManager);
                    intent.putExtra("sceneManager", sceneManager);
                    break;
                case 4:
                    intent = new Intent(ThemeTab_Covers.this,ThemeTab_Content_5.class);
                    intent.putExtra("position",position);
                    intent.putExtra("themaManager",themaManager);
                    intent.putExtra("sceneManager", sceneManager);
                    break;
                case 5:
                    intent = new Intent(ThemeTab_Covers.this,ThemeTab_Content_6.class);
                    intent.putExtra("position",position);
                    intent.putExtra("themaManager",themaManager);
                    intent.putExtra("sceneManager", sceneManager);
                    break;

            }




            view = TabHost_Theme.ThemeTabGroup.getLocalActivityManager()
                    .startActivity("Theme_Content",intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                    .getDecorView();

            TabHost_Theme.ThemeTabGroup.replaceView(view);



            Log.d("YEODAM" + "ThemeTab", "Tap position: " + position);
        }

    };



    public class ImageAdapter extends BaseAdapter{
        private Context mContext;

        public ImageAdapter(Context c){

            mContext =c;

        }
        public int getCount(){
            return mThumbIds.length;
        }

        public Object getItem(int position){
            return mThumbIds[position];
        }

        public long getItemId(int position){
            return position;
        }

        //create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent){

            int rowWidth =  mMetrics.widthPixels/2 ;

            ImageView imageView;
            if(convertView == null){
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(rowWidth,rowWidth));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setPadding(1,1,1,1);

            }else{
                imageView = (ImageView) convertView;
            }

            imageView.setImageResource(mThumbIds[position]);
            return imageView;
        }

    }

    @Override
    public void onBackPressed() {
        Log.d("ThemeTab_Covers"+"back","onback called");
        super.onBackPressed();
    }
}
