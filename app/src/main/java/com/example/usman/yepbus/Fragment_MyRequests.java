package com.example.usman.yepbus;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.daasuu.bl.ArrowDirection;
import com.daasuu.bl.BubbleLayout;
import com.daasuu.bl.BubblePopupHelper;

import java.util.Random;

public class Fragment_MyRequests extends Fragment{


    RecyclerView recyclerView;
    boolean isClickedimage1=true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Search visiblility should be Gone here on ToolBar
        View rootView = inflater.inflate(R.layout.activity_fragment__my_requests, container, false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        android.support.v7.widget.SearchView sw=(android.support.v7.widget.SearchView) toolbar.findViewById(R.id.serchViewhere);
        sw.setVisibility(View.GONE);


        LinearLayout linearLayout=(LinearLayout) rootView.findViewById(R.id.backToEvent);
        LinearLayout Sorting =(LinearLayout) rootView.findViewById(R.id.sort);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_request);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerAdapterForRequests(getActivity()));

        //Back to Event layout button
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Fragment fragment = new fragmentForVehicleForevents();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.Replace, fragment);
                ft.commit();
            }
        });

        //the sorting popup on the top
        Sorting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View inflatedLayout = inflater.inflate(R.layout.bubble_list_sorting_list, null);

                final BubbleLayout bubbleLayout1 = (BubbleLayout) inflatedLayout;
                final PopupWindow popupWindow1 = BubblePopupHelper.create(getActivity().getApplicationContext(), bubbleLayout1);
                final Random random = new Random();


                if (isClickedimage1) {
                    isClickedimage1 = false;
                    int[] location = new int[2];
                    v.getLocationInWindow(location);
                    if (random.nextBoolean()) {
                        bubbleLayout1.setArrowDirection(ArrowDirection.TOP);
                    }
                    popupWindow1.showAtLocation(v, Gravity.NO_GRAVITY, location[0], v.getHeight() + location[1]);


                    TextView details=(TextView) inflatedLayout.findViewById(R.id.byName);


                    details.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            popupWindow1.dismiss();
                        }
                    });

                    TextView rating=(TextView) inflatedLayout.findViewById(R.id.byRating);
                    rating.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            popupWindow1.dismiss();
                        }
                    });


                }
                else{
                    isClickedimage1 = true;
                }


            }
        });
        return rootView;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}