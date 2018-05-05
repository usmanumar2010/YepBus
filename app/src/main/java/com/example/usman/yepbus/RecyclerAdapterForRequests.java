package com.example.usman.yepbus;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.daasuu.bl.ArrowDirection;
import com.daasuu.bl.BubbleLayout;
import com.daasuu.bl.BubblePopupHelper;
import com.whinc.widget.ratingbar.RatingBar;

import java.util.Random;


/**
 * Created by Usman on 3/28/2017.
 */

public class RecyclerAdapterForRequests extends RecyclerView.Adapter<RecyclerAdapterForRequests.ViewHolder> {
    Activity activity;

    RecyclerAdapterForRequests(Activity c) {
        activity = c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_my_request_for_driver, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView info;
        boolean isClickedimage1 = true;


        public ViewHolder(View itemView) {
            super(itemView);
            // info=(TextView) itemView.findViewById(R.id.info_text);
            LinearLayout menuIsClicked = (LinearLayout) itemView.findViewById(R.id.clickMenuRequest);
            RatingBar ratingBar2 = new RatingBar(activity);
            ratingBar2.setClickRating(false);
            ratingBar2.setTouchRating(false);
            ratingBar2.setCount(3);

            ImageButton tickMark = (ImageButton) itemView.findViewById(R.id.imageView6);
            ImageButton crossMark = (ImageButton) itemView.findViewById(R.id.crossMarkhere);
            TextView view_Full=(TextView)  itemView.findViewById(R.id.View_Full);

            menuIsClicked.setOnClickListener(this);
            crossMark.setOnClickListener(this);
            tickMark.setOnClickListener(this);
            view_Full.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.imageView6) {
                Toast.makeText(activity, "Tick is Clicked", Toast.LENGTH_SHORT).show();
            } else if (v.getId() == R.id.crossMarkhere) {
                Toast.makeText(activity, "cross is Clicked", Toast.LENGTH_SHORT).show();
            }
            else if(v.getId()==R.id.View_Full){
                Toast.makeText(activity, "View Full is Clicked is Clicked", Toast.LENGTH_SHORT).show();
            }else if (v.getId()==R.id.clickMenuRequest) {
                LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View inflatedLayout = inflater.inflate(R.layout.request_overflow_menu_bubble_layout, null);

                final BubbleLayout bubbleLayout1 = (BubbleLayout) inflatedLayout;
                final PopupWindow popupWindow1 = BubblePopupHelper.create(activity.getApplicationContext(), bubbleLayout1);
                final Random random = new Random();


                if (isClickedimage1) {
                    isClickedimage1 = false;
                    int[] location = new int[2];
                    v.getLocationInWindow(location);
                    if (random.nextBoolean()) {
                        bubbleLayout1.setArrowDirection(ArrowDirection.TOP);
                    }
                    popupWindow1.showAtLocation(v, Gravity.NO_GRAVITY, location[0], v.getHeight() + location[1]);


                    TextView blockRider = (TextView) inflatedLayout.findViewById(R.id.blockRider);
                    TextView name = (TextView) inflatedLayout.findViewById(R.id.report);
                    TextView options = (TextView) inflatedLayout.findViewById(R.id.options);


                    blockRider.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(activity.getApplicationContext(), "Block Rider is clicked", Toast.LENGTH_SHORT).show();

                            popupWindow1.dismiss();
                        }
                    });


                    name.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(activity.getApplicationContext(), "report is clicked", Toast.LENGTH_SHORT).show();

                            popupWindow1.dismiss();
                        }
                    });

                    options.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(activity.getApplicationContext(), "options is clicked", Toast.LENGTH_SHORT).show();

                            popupWindow1.dismiss();
                        }
                    });


                } else {
                    isClickedimage1 = true;
                }
            }


        }


    }

}
