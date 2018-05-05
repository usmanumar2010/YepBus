package com.example.usman.yepbus;

import android.app.Activity;
import android.app.Dialog;
import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by Usman on 3/2/2017.
 */
public class CustomDialogClass extends Dialog implements
        android.view.View.OnClickListener {

    public Activity c;
    public Dialog d;


    RelativeLayout relativeLayout1,relativeLayout2;

    public CustomDialogClass(Activity a) {
        super(a);

        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_custom_dialog_class);

    //    relativeLayout1=(RelativeLayout) findViewById(R.id.accessCamera) ;
    //    relativeLayout2=(RelativeLayout) findViewById(R.id.accessGallery) ;

        relativeLayout1.setOnClickListener(this);
        relativeLayout2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.accessCamera:
                c.finish();
                break;
            case R.id.accessGallery:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();
    }
}
