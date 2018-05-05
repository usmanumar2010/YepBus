package com.example.usman.yepbus;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Usman on 2/23/2017.
 */

public class MyAdapter extends ArrayAdapter<String> {
    Activity context;
    String[] countryNames;
    int []imag;

    public MyAdapter(Activity applicationContext, int[] m, String[] countryNames) {
        super(applicationContext,R.layout.activity_custom_list,countryNames);
        this.context = applicationContext;
        this.imag = m;
        this.countryNames = countryNames;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();
        View rowView=layoutInflater.inflate(R.layout.activity_custom_list,null);
        TextView tv=(TextView) rowView.findViewById(R.id.editText2);
        ImageView im=(ImageView) rowView.findViewById(R.id.imageView4);

        tv.setText(countryNames[position]);
        im.setImageResource(imag[position]);
        return rowView;
    }


}
