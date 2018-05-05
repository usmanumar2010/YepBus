package com.example.usman.yepbus;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.app.SearchManager;
import android.widget.SearchView.OnQueryTextListener;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchViewActivityBottomNav extends Fragment {

    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    android.support.v7.widget.SearchView sw;
    ListView lv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Toast.makeText(getActivity(), "helloo i m in fragemnt", Toast.LENGTH_SHORT).show();

        View rootView = inflater.inflate(R.layout.activity_search_view_bottom_nav, container, false);

        final Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        lv = (ListView) rootView.findViewById(R.id.recyclerSearch);

        arrayList = new ArrayList<String>();
        arrayList.add("John");
        arrayList.add("Charlie");
        arrayList.add("ward");


        //   adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arrayList);
//        lv.setAdapter(adapter);


        try {
            sw = (android.support.v7.widget.SearchView) toolbar.findViewById(R.id.serchViewhere);
            sw.setVisibility(View.VISIBLE);
            sw.setFocusable(true);
            sw.setIconified(false);

            sw.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {

//                    initList();


                    ArrayList<String> tempList = new ArrayList<String>();
                    if (!newText.equals("")) {
                        for (String s : arrayList) {
                            if (s.toLowerCase().contains(newText.toString())) {
                                tempList.add(s);
                            }
                        }
                    }

                    if (tempList != null) {
                        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, tempList);
                        lv.setAdapter(adapter);
                    }


//                    if(newText.equals("")) {
//                    }
//                    else {
//                        adapter.getFilter().filter(newText);
//                    }
                    return false;
                }
            });

        } catch (Exception e) {
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();
            System.out.println("Hello" + e.toString());
        }


//        SearchView sw=(SearchView) rootView.findViewById(R.id.sw);


        // sw.performClick();

        return rootView;
    }

//    public void initList(){
//
//
////        listItems=new ArrayList<>(Arrays.asList(items));
//        arrayList=new ArrayList<String>();
//        arrayList.add("John");
//        arrayList.add("Charlie");
//        arrayList.add("ward");
//        adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arrayList);
//      //  lv.setAdapter(adapter);
//
//    }

//    private void searchItem(String textToSearch) {
//        for (String item:){
//            if (!item.contains(textToSearch)) {
//                lv.remove(item);
//            }
//        }
//
//        adapter.notifyDataSetChanged();
//    }

}