package com.example.seonghoon.yeodam;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import java.util.ArrayList;

/**
 * Created by Seonghoon on 2015-11-08.
 */
public class Unused_HomeFeatureLayout extends HorizontalScrollView {
    private static final int SWIPE_MIN_DISTANCE = 5;
    private static final int SWIPTE_THRESHOLD_VELOCITY = 300;

    private ArrayList mItems = null;
    private GestureDetector mGestureDetector;
    private int mActiveFeature = 0;


    public Unused_HomeFeatureLayout(Context context, AttributeSet attrs, int defStyle){
        super(context,attrs,defStyle);
    }

    public Unused_HomeFeatureLayout(Context context, AttributeSet attrs){
        super(context);
    }

    public Unused_HomeFeatureLayout(Context context){
        super(context);
    }

    public void setFeatureItems(ArrayList items) {

        LinearLayout internalWrapper = new LinearLayout(getContext());
        internalWrapper.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        internalWrapper.setOrientation(LinearLayout.HORIZONTAL);
        addView(internalWrapper);
        this.mItems = items;
        for (int i = 0; i < items.size(); i++) {
            LinearLayout featureLayout = (LinearLayout) View.inflate(this.getContext(), R.layout.homefeature, null);

            //create the view for each screen in the scroll view
            internalWrapper.addView(featureLayout);
        }


        setOnClickListener((OnClickListener) new onTouchHandler());
        mGestureDetector = new GestureDetector(new MyGestureDetector());
    }

   class onTouchHandler implements OnTouchListener{

       @Override
       public boolean onTouch(View v, MotionEvent event) {

           //if the user swipes
           if(mGestureDetector.onTouchEvent(event)){
               return true;
           }
           else if(event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_CANCEL){
               int scrollX = getScrollX();
               int featureWidth = v.getMeasuredWidth();
               mActiveFeature = ((scrollX+(featureWidth/2))/featureWidth);
               int scrollTo = mActiveFeature*featureWidth;
               smoothScrollTo(scrollTo,0);
               return true;
           }else{
               return false;
           }


       }
   }

    class MyGestureDetector extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

            try {
                //right to left
                if(e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE&& Math.abs(velocityX) > SWIPTE_THRESHOLD_VELOCITY){
                    int featureWidth = getMeasuredWidth();
                    mActiveFeature = (mActiveFeature < (mItems.size()-1))? mActiveFeature+1 : mItems.size()-1;
                    smoothScrollTo(mActiveFeature*featureWidth,0);
                    return true;
                }else if(e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPTE_THRESHOLD_VELOCITY){
                    int featureWidth = getMeasuredWidth();
                    mActiveFeature = (mActiveFeature > 0)? mActiveFeature-1 : 0;
                    smoothScrollTo(mActiveFeature*featureWidth,0);
                    return true;

                }
            }catch (Exception e){
                Log.d("Fling", "There was an Error processing the Fling event :" +e.getMessage());
            }
            return false;


        }
    }

}
