package com.example.usman.yepbus;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import it.sephiroth.android.library.bottomnavigation.BottomBehavior;
import it.sephiroth.android.library.bottomnavigation.BottomNavigation;

public class Navigation_Drawer_activity_vehicle extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    Fragment fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation__drawer_vehicle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        android.support.v7.widget.SearchView sw = (android.support.v7.widget.SearchView) toolbar.findViewById(R.id.serchViewhere);
        sw.setVisibility(View.GONE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dashboard");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        // AdpterForDrawerList adpterForDrawerList=new AdpterForDrawerList(this);
        // ListView lv=(ListView) findViewById(R.id.custom_list_drawer) ;
        //  lv.setAdapter(adpterForDrawerList);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//

        //  View hd=navigationView.getHeaderView(0);
        //  Button bt=(Button) hd.findViewById(R.id.logout);

        android.support.design.widget.NavigationView vr = (android.support.design.widget.NavigationView) findViewById(R.id.nav_view);
        TextView logoutt = (TextView) vr.findViewById(R.id.logout);
        logoutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Logout is clicked", Toast.LENGTH_SHORT).show();
            }
        });
        //-----------------------------------------------------------------------------------------------------------------------//
        //events fragment

        fragment = new fragmentForVehicleForevents();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.Replace, fragment);
        ft.commit();

        //------------------------------------------------------------------------------------------------------------------------------------------//
        //bottom navigation
        it.sephiroth.android.library.bottomnavigation.BottomNavigation bottomNavigationView = (it.sephiroth.android.library.bottomnavigation.BottomNavigation) findViewById(R.id.BottomNavigation);

        class BottomNavigationCustomBehavior extends BottomBehavior {

            public BottomNavigationCustomBehavior(final Context context, AttributeSet attributeSet) {
                super(context, attributeSet);
            }
        }

        //-----------------------------------------------------------------------------------------------------------------------------//
        //bottom menu on Click handling
        bottomNavigationView.setOnMenuItemClickListener(new BottomNavigation.OnMenuItemSelectionListener() {
            @Override
            public void onMenuItemSelect(@IdRes int i, int i1, boolean b) {

                if (i == R.id.bbn_item1) {

                    //Events by default
                    fragment = new fragmentForVehicleForevents();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.Replace, fragment);
                    ft.commit();

                } else if (i == R.id.bbn_item2) {
                    //fragments vehicles list
                    fragment = new Fragment_my_vehicles_driver();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.Replace, fragment);
                    ft.commit();
                } else if (i == R.id.bbn_item3) {
                    //Serching placed here
                    fragment = new SearchViewActivityBottomNav();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.Replace, fragment);
                    ft.commit();

                } else if (i == R.id.bbn_item4) {
                    //change password option is here
                    fragment = new FragementOptions();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.Replace, fragment);
                    ft.commit();
                }
            }

            @Override
            public void onMenuItemReselect(@IdRes int i, int i1, boolean b) {

            }
        });


    }


    //------------------------------------------------------------------------------------------------------------------------------//
    //navigation drawers menu clicks
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.


        int id = item.getItemId();


        if (id == R.id.myProfile) {
            // My Profile is here
            fragment = new My_Profile_driver();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.Replace, fragment);
            ft.commit();

        } else if (id == R.id.myRequest) {

            //Request layout is here
            fragment = new Fragment_MyRequests();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.Replace, fragment);
            ft.commit();

//            Intent menuIntent = new Intent(this, Fragment_MyRequests.class);
//            startActivity(menuIntent);


        } else if (id == R.id.accountSettings) {
            Toast.makeText(getApplicationContext(), "settings is clicked", Toast.LENGTH_SHORT).show();


        } else if (id == R.id.payementDetails) {

            //payment layout here
            FragmentManager fm = getFragmentManager();
            fragment = new Fragment_payment_details_nav();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.Replace, fragment);
            ft.commit();


        } else if (id == R.id.hist) {
            Toast.makeText(getApplicationContext(), "history is clicked ", Toast.LENGTH_SHORT).show();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation__drawer_activity_vehicle, menu);
        return true;
    }


}
