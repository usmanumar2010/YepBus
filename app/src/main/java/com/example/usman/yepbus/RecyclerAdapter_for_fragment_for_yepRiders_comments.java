package com.example.usman.yepbus;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Usman on 4/4/2017.
 */

public class RecyclerAdapter_for_fragment_for_yepRiders_comments  extends RecyclerView.Adapter<RecyclerAdapter_for_fragment_for_yepRiders_comments.ViewHolder>{

    //    private final View.OnClickListener mOnClickListener = new MyOnClickListener();
    private Context context;
    boolean isClickedimage1=true;
    FragmentManager fragmentManager;
    Activity activity;

    RecyclerAdapter_for_fragment_for_yepRiders_comments(Context con,Activity activity){
        context=con;
        this.activity=activity;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new RecyclerAdapter_for_fragment_for_yepRiders_comments.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.comments_of_yepdrivers_for_drivers,parent,false));
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