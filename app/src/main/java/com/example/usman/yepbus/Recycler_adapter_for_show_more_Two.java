package com.example.usman.yepbus;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Usman on 4/6/2017.
 */

public class Recycler_adapter_for_show_more_Two extends RecyclerView.Adapter<Recycler_adapter_for_show_more_Two.ViewHolder>  {

    private Context context;
    boolean isClickedimage1=true;
    FragmentManager fragmentManager;
    Activity activity;

    Recycler_adapter_for_show_more_Two(Context con,Activity activity){
        context=con;
        this.activity=activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new Recycler_adapter_for_show_more_Two.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.comments_for_driver,parent,false));

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return 7;
    }







    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView info;

        public ViewHolder(View itemView) {
            super(itemView);

            //info=(TextView) itemView.findViewById(R.id.info_text);
//            ImageView imageView = (ImageView) itemView.findViewById(R.id.overflow_image_events);
//            RelativeLayout card = (RelativeLayout) itemView.findViewById(R.id.whole_list);
//            imageView.setOnClickListener(this);
//
//            card.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


        }
    }
}
