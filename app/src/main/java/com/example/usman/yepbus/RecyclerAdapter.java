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

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    //    private final View.OnClickListener mOnClickListener = new MyOnClickListener();
    private Context context;
    boolean isClickedimage1 = true;
    FragmentManager fragmentManager;
    Activity activity;

    RecyclerAdapter(Context con, Activity activity) {
        context = con;
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_child_or_row, parent, false));
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

        public ViewHolder(View itemView) {
            super(itemView);

            //info=(TextView) itemView.findViewById(R.id.info_text);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.overflow_image_events);
            RelativeLayout card = (RelativeLayout) itemView.findViewById(R.id.whole_list);
            imageView.setOnClickListener(this);

            card.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.overflow_image_events) {


                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View inflatedLayout = inflater.inflate(R.layout.bubble_layout_event_list, null);

                final BubbleLayout bubbleLayout1 = (BubbleLayout) inflatedLayout;
                final PopupWindow popupWindow1 = BubblePopupHelper.create(context.getApplicationContext(), bubbleLayout1);
                final Random random = new Random();


                if (isClickedimage1) {
                    isClickedimage1 = false;
                    int[] location = new int[2];
                    v.getLocationInWindow(location);
                    if (random.nextBoolean()) {
                        bubbleLayout1.setArrowDirection(ArrowDirection.TOP);
                    }
                    popupWindow1.showAtLocation(v, Gravity.NO_GRAVITY, location[0], v.getHeight() + location[1]);


                    TextView details = (TextView) inflatedLayout.findViewById(R.id.bbtextView7);


                    details.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(context.getApplicationContext(), "Details is Clicked", Toast.LENGTH_SHORT).show();

                            Fragment fragment = new fragement_event_location_details();
                            FragmentManager fm = activity.getFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            ft.replace(R.id.Replace, fragment);
                            ft.commit();
                            popupWindow1.dismiss();

                        }
                    });


                } else {
                    isClickedimage1 = true;
                }

            } else {


                if (v.getId() == R.id.whole_list)
                    Toast.makeText(context.getApplicationContext(), "this is a next Acitivity", Toast.LENGTH_SHORT).show();
                String a = "u";
                Fragment fragment = new fragement_event_location_details();
                FragmentManager fm = activity.getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.Replace, fragment);
                ft.commit();
            }

        }
    }


}
