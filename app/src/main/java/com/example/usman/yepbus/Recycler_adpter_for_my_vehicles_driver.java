package com.example.usman.yepbus;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daasuu.bl.ArrowDirection;
import com.daasuu.bl.BubbleLayout;
import com.daasuu.bl.BubblePopupHelper;

import java.util.Random;


/**
 * Created by Usman on 3/22/2017.
 */

public class Recycler_adpter_for_my_vehicles_driver extends RecyclerView.Adapter<Recycler_adpter_for_my_vehicles_driver.ViewHolder> {

    //    private final View.OnClickListener mOnClickListener = new MyOnClickListener();
    private Context context;
    boolean isClickedimage1 = true;
    FragmentManager fragmentManager;
    Activity activity;

    Recycler_adpter_for_my_vehicles_driver(Context con, Activity activity) {
        context = con;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_of_vehicles, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 4;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView info;

        public ViewHolder(View itemView) {
            super(itemView);

            //info=(TextView) itemView.findViewById(R.id.info_text);
            LinearLayout linearLayout=(LinearLayout) itemView.findViewById(R.id.viewDetailsOfCar);

            linearLayout.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            if(v.getId()==R.id.viewDetailsOfCar)
            {
                Toast.makeText(context, "view details is clicked", Toast.LENGTH_SHORT).show();
                Fragment fragment = new Fragment_invidual_vehicle_detail();
                FragmentManager fm = activity.getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.Replace, fragment);
                ft.commit();
            }
        }
    }


}
