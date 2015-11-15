package com.example.seonghoon.yeodam;

import android.graphics.drawable.Drawable;
import android.media.Image;

/**
 * Created by Seonghoon on 2015-11-12.
 */


//DataStructiure of ThemeInfo

public class ThemeInfo {

    //drawable 객체
    Drawable drawable;
    //테마제목
    String head;
    //테마 간략 설명내용
    String contents;
    //테마여행때 할일
    String[] quests;

    public ThemeInfo(Drawable drawable,String head,String contents,String[] quests){

        this.drawable = drawable;
        this.head = head;
        this.contents = contents;
        this.quests = quests;

    }

    public Drawable getDrawable(){
        return drawable;
    }
    public String getHead(){
        return head;
    }
    public String getContents(){
        return contents;
    }
    public String[] getQuests(){
        return quests;
    }
}
