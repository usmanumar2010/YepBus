package com.example.usman.yepbus;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class Fragment_invidual_vehicle_detail extends Fragment implements View.OnClickListener {

    RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.activity_fragment_invidual_vehicle_detail, container, false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        android.support.v7.widget.SearchView sw=(android.support.v7.widget.SearchView) toolbar.findViewById(R.id.serchViewhere);
        sw.setVisibility(View.GONE);


       recyclerView = (RecyclerView) rootView.findViewById(R.id.gridViewForVehicles);
        int numberOfColumns = 3;
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numberOfColumns));
        Recycler_adapter_grid_images_of_vehicles adapter = new Recycler_adapter_grid_images_of_vehicles(getActivity().getApplicationContext(),getActivity());
        recyclerView.setAdapter(adapter);


        return rootView;

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), "bla bla ", Toast.LENGTH_SHORT).show();
    }
}
