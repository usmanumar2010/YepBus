package com.example.usman.yepbus;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Fragement_change_Password extends Fragment implements  View.OnClickListener {

    EditText tv2;
    EditText tv3;
    EditText tv1;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {


        final View rootView = inflater.inflate(R.layout.activity_fragement_change__password, container, false);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        android.support.v7.widget.SearchView sw=(android.support.v7.widget.SearchView) toolbar.findViewById(R.id.serchViewhere);
        sw.setVisibility(View.GONE);

        tv1=(EditText) rootView.findViewById(R.id.currentPassword);

        tv2=(EditText) rootView.findViewById(R.id.pass2);
       tv3=(EditText) rootView.findViewById(R.id.pass3);
        Button bt=(Button) rootView.findViewById(R.id.SaveChanges);
        Button bt1=(Button) rootView.findViewById(R.id.button2);
        bt.setOnClickListener(this);
        bt1.setOnClickListener(this);


        return rootView;

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.SaveChanges) {

            String a=tv2.getText().toString();
            String b=tv3.getText().toString();
            if(tv1.getText().toString().equals(""))
            {
                Toast.makeText(getActivity(), "new password is empty", Toast.LENGTH_SHORT).show();
            }
            else if(a.equals(""))
            {
                Toast.makeText(getActivity(), "Current password is empty", Toast.LENGTH_SHORT).show();
            }
            else if(b.equals(""))
            {
                Toast.makeText(getActivity(), "Re-Type password field is empty", Toast.LENGTH_SHORT).show();
            }
            if (!a.equals(b)) {
                Toast.makeText(getActivity(), "password mis-match", Toast.LENGTH_SHORT).show();
            }
        }
        else if(v.getId()==R.id.button2)
        {
            tv2.setText("");
            tv3.setText("");
        }

    }
}
