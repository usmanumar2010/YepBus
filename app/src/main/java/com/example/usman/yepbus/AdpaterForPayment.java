package com.example.usman.yepbus;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Usman on 4/12/2017.
 */

public class AdpaterForPayment  extends BaseAdapter {

    Activity context;
    String[] emails;
    int []imag;
    String [] tv;
    String []pay;
    LayoutInflater layoutInflater;
    ArrayList<PaymentDetailsClassdDriverNav> p;

   public AdpaterForPayment(Activity applicationContext,ArrayList<PaymentDetailsClassdDriverNav> a){

       this.context = applicationContext;
        this.p=a;
    }

    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }


    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Toast.makeText(context, "helloo", Toast.LENGTH_SHORT).show();
       if (convertView == null) {
           final LayoutInflater inflater = context.getLayoutInflater();
           convertView = inflater.inflate(R.layout.payments_list_view_box, parent, false);
           Toast.makeText(context, "helloo", Toast.LENGTH_SHORT).show();

       }
        //Our viewholder object
//        final ViewHolder holder = new ViewHolder();

        //Intialized with the
       TextView t1 = (TextView) convertView.findViewById(R.id.creditCardPayment);
       TextView t2 = (TextView) convertView.findViewById(R.id.emailPayment);
       ImageView im2 = (ImageView) convertView.findViewById(R.id.creditImage);


        //Assign the data
        if(!(p.get(position).getNameofPayment().equalsIgnoreCase("Skrill")))
        {
            t1.setText(p.get(position).getAccount_Number());
        }
        t2.setText(p.get(position).getEmails());
        im2.setImageResource(p.get(position).getPaymentsImages());


        return convertView;
    }


}
