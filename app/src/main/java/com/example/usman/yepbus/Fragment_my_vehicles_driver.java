package com.example.usman.yepbus;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Usman on 4/7/2017.
 */


public class Fragment_my_vehicles_driver extends Fragment implements View.OnClickListener{
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.activity_fragment__show__more__one, container, false);

        //Search visiblility should be Gone here on ToolBar
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        android.support.v7.widget.SearchView sw=(android.support.v7.widget.SearchView) toolbar.findViewById(R.id.serchViewhere);
        sw.setVisibility(View.GONE);

        //showing my vehicles list
        RecyclerView recyclerAdapter2 = (RecyclerView) rootView.findViewById(R.id.recyclerForShowMore1);
        recyclerAdapter2.setHasFixedSize(true);
        recyclerAdapter2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerAdapter2.setAdapter(new Recycler_adpter_for_my_vehicles_driver(getActivity().getApplicationContext(), getActivity()));

        return rootView;

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), "bla bla ", Toast.LENGTH_SHORT).show();
    }
}
