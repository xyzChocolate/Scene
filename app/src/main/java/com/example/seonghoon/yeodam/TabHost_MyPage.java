package com.example.seonghoon.yeodam;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

/**
 * Created by Seonghoon on 2015-11-17.
 */
public class TabHost_MyPage extends FragmentActivity{

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_mypage);


        GridView gridView = (GridView)findViewById(R.id.photogrid2);
        gridView.setAdapter(new ImageAdapter(this));
        gridView.setOnItemClickListener(gridviewOnItemClickListener);



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
                    Toast.makeText(getApplicationContext(),"가을동화클릭클릭",Toast.LENGTH_SHORT).show();

                    break;
                case 1:
                    Toast.makeText(getApplicationContext(),"어린가을동화클릭",Toast.LENGTH_SHORT).show();

                    break;
                case 2:
                    Toast.makeText(getApplicationContext(),"베토벤바이러스",Toast.LENGTH_SHORT).show();
                    break;

                case 3:
                    Toast.makeText(getApplicationContext(),"꺄♡ 갓설현 눌렀쪙",Toast.LENGTH_SHORT).show();

                    break;
                case 4:
                    Toast.makeText(getApplicationContext(),"정욱이 클릭됬쪙",Toast.LENGTH_SHORT).show();

                    break;
                case 5:
                    Toast.makeText(getApplicationContext(),"캬 간지남 두명",Toast.LENGTH_SHORT).show();

                    break;


            }
        }
    };



    public class ImageAdapter extends BaseAdapter {
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
