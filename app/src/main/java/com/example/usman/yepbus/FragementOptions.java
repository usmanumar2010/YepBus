package com.example.usman.yepbus;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragementOptions extends Fragment  implements  View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        final View rootView = inflater.inflate(R.layout.activity_fragement_options, container, false);
        //Search visiblility should be Gone here on ToolBar
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        android.support.v7.widget.SearchView sw=(android.support.v7.widget.SearchView) toolbar.findViewById(R.id.serchViewhere);
        sw.setVisibility(View.GONE);

        TextView tv=(TextView) rootView.findViewById(R.id.changePassword);

        //click listner
        tv.setOnClickListener(this);

        return rootView;

    }

    //handling click
    @Override
    public void onClick(View v) {

        //layout where you can chage password it will come onCick
        if(v.getId()==R.id.changePassword)
        {
            Fragment fragment = new Fragement_change_Password();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.Replace, fragment);
            ft.commit();
        }

    }
}
