package com.example.usman.yepbus;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daasuu.bl.ArrowDirection;
import com.daasuu.bl.BubbleLayout;
import com.daasuu.bl.BubblePopupHelper;

import java.util.Random;

public class RecyclerAdapterForComments extends RecyclerView.Adapter<RecyclerAdapterForComments.ViewHolder>{

//    private final View.OnClickListener mOnClickListener = new MyOnClickListener();
private Context context;
        boolean isClickedimage1=true;
        FragmentManager fragmentManager;
        Activity activity;

        RecyclerAdapterForComments(Context con,Activity activity){
        context=con;
        this.activity=activity;
        }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new RecyclerAdapterForComments.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.comments_for_driver,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {


//        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        final View inflatedLayout = inflater.inflate(R.layout.comments_for_driver, null);



        return 2;
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