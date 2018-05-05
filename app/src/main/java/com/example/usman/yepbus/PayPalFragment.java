package com.example.usman.yepbus;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PayPalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PayPalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PayPalFragment extends Fragment {

    EditText email2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View LayoutPayPall=inflater.inflate(R.layout.fragment_pay_pal, container, false);

        email2=(EditText) LayoutPayPall.findViewById(R.id.editTextPaypal);
        return LayoutPayPall;
    }

    public boolean checkPaypallLayut()
    {



        if(isValidEmail(email2.getText())==false )
        {
            return false;
        }


        return true;
    }

    //email authentications for Paypal

    public final static boolean isValidEmail(CharSequence target) {

        char  a = '.';
        char b=0;
        if(!TextUtils.isEmpty(target)) {

             b = target.charAt(0);
        }

        if (TextUtils.isEmpty(target))
        {
            return false;
        }
        else if(b==a)
        {
            return false;
        }else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }

    }


}
