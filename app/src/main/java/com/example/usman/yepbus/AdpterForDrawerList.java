package com.example.usman.yepbus;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.content;
import static android.R.id.list;
import static android.R.id.message;

/**
 * Created by Usman on 3/21/2017.
 */

public class AdpterForDrawerList extends BaseAdapter {

    public String[] myMenu;
    Activity context;
    TextView textView;
    private static LayoutInflater inflater=null;

//    public AdpterForDrawerList(Activity applicationContext, String[] menuListItems) {
//        super(applicationContext,R.layout.custom_adapter_for_navigation_drawer,menuListItems);
//        this.context = applicationContext;
//
//        this.myMenu = menuListItems;
//
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//
//        LayoutInflater layoutInflater=context.getLayoutInflater();
//        View rowView=layoutInflater.inflate(R.layout.activity_custom_list,null);
//        TextView tv=(TextView) rowView.findViewById(R.id.editText2);
//        ImageView im=(ImageView) rowView.findViewById(R.id.imageView4);
//
//        tv.setText(myMenu[position]);
//        return rowView;
//    }

    AdpterForDrawerList(Activity context)
    {
        this.context=context;
        myMenu=context.getResources().getStringArray(R.array.myMenuDrawer);
         inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return myMenu.length;
    }

    @Override
    public Object getItem(int position) {
        return myMenu[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View vi=convertView;
        if(convertView==null)
             vi = inflater.inflate(R.layout.custom_adapter_for_navigation_drawer, null);
        textView = (TextView) vi.findViewById(R.id.textFordrawer);
        textView.setText(myMenu[position]);

        return vi;
    }
}
