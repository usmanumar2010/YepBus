package com.example.usman.yepbus;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class BankDetalis extends Activity {

    EditText num;
    EditText title;
    EditText code;
    Spinner sp;
    Spinner sp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_detalis);

        //intialization
        num=(EditText) findViewById(R.id.editText1) ;
        title=(EditText) findViewById(R.id.editText2);
        code=(EditText) findViewById(R.id.editText);
        TextView bankText = (TextView) findViewById(R.id.Bank_details);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "Fonts/Firme Black.otf");
        bankText.setTypeface(typeFace);

        TextView skipText = (TextView) findViewById(R.id.skip);
        Typeface typeFace2 = Typeface.createFromAsset(getAssets(), "Fonts/Firme Book.otf");
        skipText.setTypeface(typeFace2);

        //spinner for Banks
        sp=(Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> langAdapter1 = ArrayAdapter.createFromResource(this, R.array.Bank, R.layout.spinner_text);
        langAdapter1.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        sp.setAdapter(langAdapter1);

        //spinner for Branch of Bank
         sp3=(Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> langAdapter2 = ArrayAdapter.createFromResource(this, R.array.Branch, R.layout.spinner_text);
        langAdapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        sp3.setAdapter(langAdapter2);



        //if you want to skip this activity then press click
       TextView skipActivity=(TextView) findViewById(R.id.skip) ;
        skipActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menuIntent = new Intent(getApplicationContext(),Vehicles_details.class);
                startActivity(menuIntent);

            }
        });
    }

    public void goToVehicleActivty(View view) {


        String a = num.getText().toString();
        String b = title.getText().toString();
        String c = code.getText().toString();


        if (a.matches("") && b.matches("") && c.matches("") && c.matches("")  && sp.getSelectedItem().toString().equalsIgnoreCase("Bank")  && sp3.getSelectedItem().toString().equalsIgnoreCase("Branch") ) {

            Toast.makeText(getApplicationContext(), "Fill the fields ", Toast.LENGTH_SHORT).show();

        } else if (a.matches("")) {
            Toast.makeText(getApplicationContext(), "username is Account number ", Toast.LENGTH_SHORT).show();

        } else if (b.matches("")) {
            Toast.makeText(getApplicationContext(), "Account Title is empty ", Toast.LENGTH_SHORT).show();

        } else if (c.matches("")) {
            Toast.makeText(getApplicationContext(), "enter the swift code ", Toast.LENGTH_SHORT).show();

        } else if (sp.getSelectedItem().toString().equalsIgnoreCase("Bank")) {
            Toast.makeText(getApplicationContext(), "Select the Bank ", Toast.LENGTH_SHORT).show();

        } else if (sp3.getSelectedItem().toString().equalsIgnoreCase("Branch")) {
            Toast.makeText(getApplicationContext(), "Select the Branch", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent menuIntent = new Intent(this, Vehicles_details.class);
            startActivity(menuIntent);
        }

    }
}
