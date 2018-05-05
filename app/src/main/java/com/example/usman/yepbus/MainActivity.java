package com.example.usman.yepbus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {


    private TextView newUser;
    Button sRider;
    Button login;
    EditText ed;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        newUser=(TextView) findViewById(R.id.newuserid);
        login=(Button) findViewById(R.id.button1);
        ed=(EditText) findViewById(R.id.editText);
        pass=(EditText) findViewById(R.id.editText2);

        //authentication for login
        //username and password authentication
        login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

               String a=ed.getText().toString();
                String b=pass.getText().toString();
                if(a.matches("") && b.matches(""))
                {
                    Toast.makeText(getApplicationContext(), "username and password is empty", Toast.LENGTH_SHORT).show();

                }
                else if(a.matches(""))
                {
                    Toast.makeText(getApplicationContext(), "username is empty", Toast.LENGTH_SHORT).show();

                }
                else if(b.matches(""))
                {
                    Toast.makeText(getApplicationContext(), "Password is empty", Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getApplicationContext(), "you are logged in ", Toast.LENGTH_SHORT).show();

                }
            }
        }
        );



    }

    //Next Activity(SignUpAs) on Click
    public void onClickNewUser(View view)
    {
                Intent menuIntent = new Intent(this, SignUpAs.class);
                startActivity(menuIntent);

    }



}
