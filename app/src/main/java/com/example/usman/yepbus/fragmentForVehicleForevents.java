package com.example.usman.yepbus;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class fragmentForVehicleForevents extends Fragment implements View.OnClickListener {

    RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.activity_fragment_for_vehicle_forevents, container, false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        android.support.v7.widget.SearchView sw=(android.support.v7.widget.SearchView) toolbar.findViewById(R.id.serchViewhere);
        sw.setVisibility(View.GONE);

        recyclerView=(RecyclerView) rootView.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerAdapter(getActivity().getApplicationContext(),getActivity()));

        Button button=(Button) rootView.findViewById(R.id.createEvent);
        button.setOnClickListener(this);


        return rootView;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.createEvent)
        {
            Fragment fragment = new CreateAnEvent_Fragement();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.Replace, fragment);
            ft.commit();
        }
    }
}
