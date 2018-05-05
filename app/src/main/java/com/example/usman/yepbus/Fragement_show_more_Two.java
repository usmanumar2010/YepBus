package com.example.usman.yepbus;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragement_show_more_Two extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        //Search visiblility should be Gone here on ToolBar
        final View rootView = inflater.inflate(R.layout.activity_fragement_show_more__two, container, false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        android.support.v7.widget.SearchView sw=(android.support.v7.widget.SearchView) toolbar.findViewById(R.id.serchViewhere);
        sw.setVisibility(View.GONE);

        //comments of yepRiders
        RecyclerView recyclerAdapter2 = (RecyclerView) rootView.findViewById(R.id.recyclerForShowMore2);
        recyclerAdapter2.setHasFixedSize(true);
        recyclerAdapter2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerAdapter2.setAdapter(new Recycler_adapter_for_show_more_Two(getActivity().getApplicationContext(), getActivity()));

        return rootView;
    }

    @Override
    public void onClick(View v) {

    }
}