package com.example.seonghoon.yeodam;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Seonghoon on 2015-11-17.
 */
public class TabHost_ScheduleMgmt extends ListActivity{

    private String[] teamMember = {"김슬범","김정욱","김준영","조성훈","김슬빵","홍병우교수님","김쥬뇽","설현★"};
    private TextView selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_schedulemgmt);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, teamMember));

        selected=(TextView)findViewById(R.id.selected);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        selected.setText("Selected Item : "+teamMember[position]);
    }
}
