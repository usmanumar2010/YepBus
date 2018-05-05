package com.example.usman.yepbus;

import android.app.Fragment;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.daasuu.bl.ArrowDirection;
import com.daasuu.bl.BubbleLayout;
import com.daasuu.bl.BubblePopupHelper;

import java.util.Random;

public class Fragment_Show_More_One extends Fragment  implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {



        final View rootView = inflater.inflate(R.layout.activity_fragment__show__more__one, container, false);
        //Search visiblility should be Gone here on ToolBar
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        android.support.v7.widget.SearchView sw=(android.support.v7.widget.SearchView) toolbar.findViewById(R.id.serchViewhere);
        sw.setVisibility(View.GONE);

        //comments of driver here
        RecyclerView recyclerAdapter2 = (RecyclerView) rootView.findViewById(R.id.recyclerForShowMore1);
        recyclerAdapter2.setHasFixedSize(true);
        recyclerAdapter2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerAdapter2.setAdapter(new Recycler_adapter_for_show_more_One(getActivity().getApplicationContext(), getActivity()));

        return rootView;

    }

    @Override
    public void onClick(View v) {

    }
}
