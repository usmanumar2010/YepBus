package com.example.usman.yepbus;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Fragment_payment_details_nav extends Fragment {
    private ArrayList<String> arrayList;
//    private ArrayList<String> adapterr;

@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_fragment_payment_details_nav, container, false);

        arrayList=new ArrayList<>();
    try {

        ListView listView = (ListView) rootView.findViewById(R.id.paymentDetailsListView);
        String[] account_Number = {"1111-2222-3333-4444", "4444-3333-2222-1111","4525-333-2222-1111"};
        String[] nameofPayment={"Visa","AmericanExpress","Skrill"};
        String[] emails = {"john@gmai.com", "bob@gmail.com","dan@gmail.com"};
        int[] paymentsImages = {R.drawable.visa_image, R.drawable.american_express_logo,R.drawable.skrill_logo};

//    PaymentClass py = new PaymentClass();
//
//    for(String a:account_Number) {
//        py.setAccountNo(a);
//    }



        //list of  Payment method
        ArrayList<PaymentDetailsClassdDriverNav> payDetailss=new ArrayList<>();
        payDetailss.add(new PaymentDetailsClassdDriverNav("1111-2222-3333-4444","Visa","john@gmai.com",R.drawable.visa_image));
        payDetailss.add(new PaymentDetailsClassdDriverNav("1111-3333-3333-4444","AmericanExpress","john@gmai.com",R.drawable.american_express_logo));
        payDetailss.add(new PaymentDetailsClassdDriverNav("1111-4444-3333-4444","Skrill","john@gmai.com",R.drawable.skrill_logo));
//         AdpaterForPayment adapter = new AdpaterForPayment(getActivity(), emails, account_Number, paymentsImages,nameofPayment);
        AdpaterForPayment adapter = new AdpaterForPayment(getActivity(), payDetailss);
        listView.setAdapter(adapter);


    }
    catch (Exception e)
    {
        System.out.println(e.toString());
    }

        return rootView;
    }

}
