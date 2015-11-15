package com.example.seonghoon.yeodam;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Seonghoon on 2015-11-13.
 */
public class ThemeTab_Content_One extends Fragment implements View.OnClickListener{

    TextView txtView;
    ImageView imageView;
    Button more;
    Button addPlan;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.theme_content_fragment, container, false);

        Drawable drawable = getResources().getDrawable(R.drawable.p1);

        txtView = (TextView)view.findViewById(R.id.text_fragment);

        imageView = (ImageView)view.findViewById(R.id.theme_content_img);
        imageView.setImageDrawable(drawable);

        more = (Button)view.findViewById(R.id.view_more_1);
        more.setOnClickListener(this);

        addPlan = (Button)view.findViewById(R.id.addplan_1);
        addPlan.setOnClickListener(this);
        return view;
    }
    public void setText(TextView textview){
        textview.setText("#");
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(),v.getId()+"",Toast.LENGTH_LONG).show();
        switch (v.getId()){
            case R.id.view_more_1:
                Toast.makeText(getActivity(),"자세히 안보여줄꼰똉?헤헤",Toast.LENGTH_LONG).show();
                break;
            case R.id.addplan_1:
                Toast.makeText(getActivity(),"귀찮아 일정안담을래",Toast.LENGTH_LONG).show();
                break;
        }

    }
}
