package com.example.usman.yepbus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.daasuu.bl.ArrowDirection;
import com.daasuu.bl.BubbleLayout;
import com.daasuu.bl.BubblePopupHelper;


import java.util.Random;

public class SignUpAs extends Activity {
    Button sRider;
    Button questionMark;
    Point p;
    int[] location;
    boolean isClicked = true;
    PopupWindow popUpWindow;
    ViewGroup.LayoutParams layoutParams;
    LinearLayout mainLayout;
    LinearLayout containerLayout;
    TextView signup;
    TextView tvMsg;
    ScrollView sc;
    TextView btn_driver;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_as);
        //      initComponent();


        //Intializations
        signup = (TextView) findViewById(R.id.signuptext);
        //Chnage Font
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "Fonts/Firme ExtraBold.otf");
        signup.setTypeface(typeFace);

        questionMark = (Button) findViewById(R.id.btn_qustionMark);
        btn_driver=(Button) findViewById(R.id.yepDriver);

        //-----------------------------------------------------------------------------------------------------------------------//

        final BubbleLayout bubbleLayout = (BubbleLayout) LayoutInflater.from(this).inflate(R.layout.layout_sample_popup, null);
        final PopupWindow popupWindow = BubblePopupHelper.create(this, bubbleLayout);
        final Random random = new Random();


        //-----------------------------------------------------------------------------------------------------------------------------------//
        //BUBBLE LAYOUT
        //popup menu
        questionMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    isClicked = false;
                    int[] location = new int[2];
                    v.getLocationInWindow(location);
                    if (random.nextBoolean()) {
                        bubbleLayout.setArrowDirection(ArrowDirection.TOP);
                    }
                    popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0], v.getHeight() + location[1]);
                } else {
                    isClicked = true;
                   // popUpWindow.dismiss();
                }
            }
            });



        //------------------------------------------------------------------------------------------------------------------//
            //Click for YepDriver buuton

            btn_driver.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){

                SharedPreferences sharedPreferences = getSharedPreferences("RiderDriverFile", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();// SharedPreferences.Editor object will allow us to edit a above file
                editor.putString("iClicked", "Driver");
                editor.commit();

                Intent menuIntent = new Intent(getApplicationContext(), SignUpRider.class);
                startActivity(menuIntent);
            }
            }

            );

        }

        //---------------------------------------------------------------------------------------------------------------------//

    //OnClick for YepRider
    public void signUpRider(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("RiderDriverFile", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();// SharedPreferences.Editor object will allow us to edit a above file
        editor.putString("iClicked", "Rider");
         editor.commit();
        Intent menuIntent = new Intent(this, SignUpRider.class);
        startActivity(menuIntent);

    }


//    public void popUpforSignup(View view){
//        if (isClicked) {
//            isClicked = false;
//            popUpWindow.showAtLocation(mainLayout, Gravity.BOTTOM, 100, 400);
//            questionMark.getLocationOnScreen(location);
//
//            p.set(location[0],location[1]);
//            popUpWindow.update(p.x, p.y+100, 320, 400);
//
//        } else {
//            isClicked = true;
//            popUpWindow.dismiss();
//        }
//    }

//    private void initComponent()
//    {
    //     }


}
