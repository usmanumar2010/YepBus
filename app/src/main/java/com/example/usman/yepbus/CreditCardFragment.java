package com.example.usman.yepbus;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CreditCardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CreditCardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreditCardFragment extends Fragment {

     Spinner   spinneOfCC;
    Spinner spinnerOfCCforYear;
    EditText CardNo;
    EditText cvvNo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_credit_card, container, false);


        CardNo=(EditText) rootView.findViewById(R.id.card);
        cvvNo=(EditText) rootView.findViewById(R.id.cvv);
        TextView pd = (TextView) rootView.findViewById(R.id.expiry_date);


        //Font Styles
        Typeface typeFace = Typeface.createFromAsset(getActivity().getApplicationContext().getAssets(),"Fonts/Firme Book Italic.otf");
        pd.setTypeface(typeFace);


        //spinner consist of Month
        ArrayAdapter<CharSequence> langAdapter1 = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.Month_array, R.layout.spinner_text);
        spinneOfCC = (Spinner) rootView.findViewById(R.id.spinner1);
        langAdapter1.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        spinneOfCC.setAdapter(langAdapter1);

        //Spinner consist of Year
        ArrayAdapter<CharSequence> langAdapter2 = ArrayAdapter.createFromResource(getActivity().getApplicationContext(), R.array.Year_array, R.layout.spinner_text);
         spinnerOfCCforYear = (Spinner) rootView.findViewById(R.id.spinner3);
        langAdapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        spinnerOfCCforYear.setAdapter(langAdapter2);



        return rootView;
    }

    //authentications
    public boolean checkCreditLayut()
    {
         String a=CardNo.getText().toString();
        String b=cvvNo.getText().toString();

        if(a.matches("") && b.matches("") && spinneOfCC.getSelectedItem().toString().equalsIgnoreCase("Month") &&  spinnerOfCCforYear.getSelectedItem().toString().equalsIgnoreCase("Year"))
        {
            return false;
        }
        else if(a.matches(""))
        {
            return false;
        }
        else if(b.matches(""))
        {
            return  false;
        }
        else if( spinneOfCC.getSelectedItem().toString().equalsIgnoreCase("Month"))
        {
            return  false;
        }
        else if( spinnerOfCCforYear.getSelectedItem().toString().equalsIgnoreCase("Year"))
        {
            return false;
        }


        return true;
    }


}
