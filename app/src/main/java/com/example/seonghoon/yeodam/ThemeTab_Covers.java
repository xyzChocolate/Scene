package com.example.seonghoon.yeodam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Seonghoon on 2015-11-06.
 */
public class ThemeTab_Covers extends Activity{


    private Intent intent;

    //이미지들 담는 배열
    private Integer[] mThumbIds = {
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4,
            R.drawable.p5,
            R.drawable.p6
    };

    //화면측정
    DisplayMetrics mMetrics;
    ImageButton findBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_theme_cover);


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

            //Toast.makeText(ThemeTab_Covers.this,parent.getAdapter().getItem(position).toString(),
            //Toast.LENGTH_LONG).show();
            switch(position){
                case 0:
                    //Toast.makeText(ThemeTab_Covers.this,"가을동화클릭클릭",Toast.LENGTH_SHORT).show();
                    intent = new Intent(ThemeTab_Covers.this,ThemeTab_Content.class);
                    intent.putExtra("position",0);
                    view = TabHost_Theme.ThemeTabGroup.getLocalActivityManager()
                            .startActivity("Theme_Content",intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                            .getDecorView();

                    TabHost_Theme.ThemeTabGroup.replaceView(view);

                    break;
                case 1:
                    //Toast.makeText(ThemeTab_Covers.this,"어린가을동화클릭",Toast.LENGTH_SHORT).show();
                    intent = new Intent(ThemeTab_Covers.this,ThemeTab_Content.class);
                    intent.putExtra("position",1);
                    view = TabHost_Theme.ThemeTabGroup.getLocalActivityManager()
                            .startActivity("Theme_Content",intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                            .getDecorView();

                    TabHost_Theme.ThemeTabGroup.replaceView(view);
                    break;
                case 2:
                    //Toast.makeText(ThemeTab_Covers.this,"베토벤바이러스",Toast.LENGTH_SHORT).show();
                    intent = new Intent(ThemeTab_Covers.this,ThemeTab_Content.class);
                    intent.putExtra("position",2);
                    view = TabHost_Theme.ThemeTabGroup.getLocalActivityManager()
                            .startActivity("Theme_Content",intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                            .getDecorView();

                    TabHost_Theme.ThemeTabGroup.replaceView(view);
                    break;

                case 3:
                    //Toast.makeText(ThemeTab_Covers.this,"꺄♡ 갓설현 눌렀쪙",Toast.LENGTH_SHORT).show();
                    intent = new Intent(ThemeTab_Covers.this,ThemeTab_Content.class);
                    intent.putExtra("position",3);
                    view = TabHost_Theme.ThemeTabGroup.getLocalActivityManager()
                            .startActivity("Theme_Content",intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                            .getDecorView();

                    TabHost_Theme.ThemeTabGroup.replaceView(view);
                    break;
                case 4:
                    //Toast.makeText(ThemeTab_Covers.this,"정욱이 클릭됬쪙",Toast.LENGTH_SHORT).show();
                    intent = new Intent(ThemeTab_Covers.this,ThemeTab_Content.class);
                    intent.putExtra("position",4);
                    view = TabHost_Theme.ThemeTabGroup.getLocalActivityManager()
                            .startActivity("Theme_Content",intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                            .getDecorView();

                    TabHost_Theme.ThemeTabGroup.replaceView(view);
                    break;
                case 5:
                    //Toast.makeText(ThemeTab_Covers.this,"캬 간지남 두명",Toast.LENGTH_SHORT).show();
                    intent = new Intent(ThemeTab_Covers.this,ThemeTab_Content.class);
                    intent.putExtra("position",5);
                    view = TabHost_Theme.ThemeTabGroup.getLocalActivityManager()
                            .startActivity("Theme_Content",intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                            .getDecorView();

                    TabHost_Theme.ThemeTabGroup.replaceView(view);
                    break;


            }
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

}
