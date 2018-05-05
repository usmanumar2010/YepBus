package com.example.usman.yepbus;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.id;

public class Payment_details extends AppCompatActivity {

    String item;
    Fragment fragment;
    TextView textView;
    Button bt;
    EditText CardNo;
    EditText cvvNo;
    boolean flag;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        //intialization
        bt=(Button) findViewById(R.id.cont);
      //  CardNo=(EditText) findViewById(R.id.card);
        textView = (TextView) findViewById(R.id.pd);
        Typeface typeFace = Typeface.createFromAsset(getAssets(),"Fonts/Firme Black.otf");
        textView.setTypeface(typeFace);

        //------------------------------------------------------------------------------------------------------------------//
        //Spinners
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> langAdapter = ArrayAdapter.createFromResource(this, R.array.Payment_details, R.layout.spinner_text);//this layout is working with the text showing in default position and also i have addded image here to make it responseive too ,rahter then adding a image tag at main layout with spinner
        langAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown);//this layout working with the dropdown styling
        spinner.setAdapter(langAdapter);

//        Drawable drawable = getApplicationContext().getResources().getDrawable(id);
//        drawable.setBounds(0, 0, 30, 30);
//        spinner.setCompoundDrawables(drawable, null, null, null);

        //----------------------------------------------------------------------------------------------------------------------//
        //onItemClickListner for spinner on
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                Object item = adapterView.getSelectedItem();//this will give us a selected item
                String convertStrinig=(String) item;


                if (convertStrinig.equalsIgnoreCase("Skrill Details")) {

                    fragment = new SkrillFragment();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.addHere, fragment);
                    ft.commit();
                }

                if(convertStrinig.equalsIgnoreCase("Credit card"))
                {
                    fragment=new CreditCardFragment();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.addHere,fragment);
                    ft.commit();


                }


                if(convertStrinig.equalsIgnoreCase("PayPal card"))
                {
                    fragment=new PayPalFragment();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.addHere,fragment);
                    ft.commit();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub
            }
        });
    }



 public void GoToNext(View view){


     if(fragment instanceof CreditCardFragment) {
         flag = ((CreditCardFragment) fragment).checkCreditLayut();

         if(  flag==false)
         {
             Toast.makeText(getApplicationContext(), "Fill the Field ", Toast.LENGTH_SHORT).show();
         }
         else
         {
             Intent menuIntent = new Intent(this, BankDetalis.class);
             startActivity(menuIntent);
         }
     }
     else if(fragment instanceof SkrillFragment)
     {
         flag = ((SkrillFragment) fragment).checkSkrillLayut();
         if(  flag==false)
         {
             Toast.makeText(getApplicationContext(), "Fill the Field ", Toast.LENGTH_SHORT).show();
         }
         else
         {
             Intent menuIntent = new Intent(this, BankDetalis.class);
             startActivity(menuIntent);
         }
     }
     else if(fragment instanceof  PayPalFragment)
     {
         flag = ((PayPalFragment) fragment).checkPaypallLayut();
         if(  flag==false)
         {
             Toast.makeText(getApplicationContext(), "Fill the Field ", Toast.LENGTH_SHORT).show();
         }
         else
         {
             Intent menuIntent = new Intent(this, BankDetalis.class);
             startActivity(menuIntent);
         }
     }



 }





}
