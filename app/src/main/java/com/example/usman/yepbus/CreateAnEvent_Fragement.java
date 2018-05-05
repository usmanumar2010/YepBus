package com.example.usman.yepbus;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.daasuu.bl.ArrowDirection;
import com.daasuu.bl.BubbleLayout;
import com.daasuu.bl.BubblePopupHelper;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.app.Activity.RESULT_OK;
import static com.example.usman.yepbus.Vehicles_details.gallery_fourth;

public class CreateAnEvent_Fragement extends Fragment implements View.OnClickListener {

    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Double amountCounter=5.2;
    boolean isClickedPopup4=true;
    View fragmentView;
    public static final int popup_camera = 26;
    public static final int gallery = 33;
    int imageCountForPopup=0;
    boolean isClickedPopup1=true;
    ImageView time;
    ImageView date;
    ImageButton plus;
    ImageButton minus;
    Button cancel;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.activity_create_an_event__fragement, container, false);
        CircleImageView circleImageView=(CircleImageView) rootView.findViewById(R.id.EventProfilePic);
        date=(ImageView) rootView.findViewById(R.id.date) ;
        time=(ImageView) rootView.findViewById(R.id.time) ;
        plus=(ImageButton) rootView.findViewById(R.id.plus);
        minus=(ImageButton) rootView.findViewById(R.id.minus);
        cancel=(Button) rootView.findViewById(R.id.cancel_event);

        List<String> ar=new ArrayList<String>();
        ar.add("Vehicle");
        ar.add("Audi");
        ar.add("BMW");
        ar.add("Toyota");
        ar.add("Ranger Rover");
        ar.add("Jaguar");


        List<String> list2=new ArrayList<String>();
        list2.add("Date");
        list2.add("April,20 2017");
        list2.add("April,21 2017");
        list2.add("April,22 2017");
        list2.add("April,23 2017");
        list2.add("April,24 2017");

        List<String> list3=new ArrayList<String>();
        list3.add("Time");
        list3.add("1,o Clock");
        list3.add("2 ,o,clock");
        list3.add("3 ,o,clock");
        list3.add("4 ,o,clock");
        list3.add("5 ,o,clock");

        Eventspinners(rootView,ar,list2,list3);

        circleImageView.setOnClickListener(this);
        date.setOnClickListener(this);
        time.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        cancel.setOnClickListener(this);


        this.fragmentView=rootView;
        return rootView;

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.EventProfilePic)
        {
            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View inflatedLayout = inflater.inflate(R.layout.activity_custom_dialog_class, null);

            final BubbleLayout bubbleLayout = (BubbleLayout) inflatedLayout;
            final PopupWindow popupWindow = BubblePopupHelper.create(getActivity(), bubbleLayout);
            final Random random = new Random();


            if (isClickedPopup1) {
                isClickedPopup1 = false;
                int[] location = new int[2];
                v.getLocationInWindow(location);
                if (random.nextBoolean()) {
                    bubbleLayout.setArrowDirection(ArrowDirection.TOP);

                }

                popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0], v.getHeight() + location[1]);
                popup(inflatedLayout);
            }else
            {
                isClickedPopup1=true;
            }

        }
        else if(v.getId()==R.id.time)
        {
            spinner2.performClick();
        }
        else if(v.getId()==R.id.date){
            spinner3.performClick();
        }
        else if(v.getId()==R.id.plus)
        {
            TextView tv=(TextView) fragmentView.findViewById(R.id.ammountForEvent);
            int sum=0;
            amountCounter=amountCounter+0.1;

            tv.setText(amountCounter.toString());
        }
        else if(v.getId()==R.id.minus)
        {
            TextView tv=(TextView) fragmentView.findViewById(R.id.ammountForEvent);
            if(amountCounter > 0.0) {
                amountCounter=amountCounter-0.1;
                tv.setText(amountCounter.toString());
            }

        }else if(v.getId()==R.id.cancel_event)
        {
            Fragment fragment = new fragmentForVehicleForevents();
            FragmentManager fm = getActivity().getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.Replace, fragment);
            ft.commit();
        }
    }

    public void Eventspinners(View rootView,List<String> list1,List<String> list2,List<String> list3){
        spinner1 = (Spinner) rootView.findViewById(R.id.spinner1);

        ArrayAdapter<String> langgAdapter =new ArrayAdapter<String>(getActivity(),R.layout.spinner_text,list1);
        langgAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        spinner1.setAdapter(langgAdapter);


        spinner2 = (Spinner) rootView.findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(getActivity(),R.layout.spinner_text_small,list3);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        spinner2.setAdapter(adapter);

        spinner3 = (Spinner) rootView.findViewById(R.id.spinner3);
        ArrayAdapter<String> adapter2 =new ArrayAdapter<String>(getActivity(),R.layout.spinner_text_small,list2);
        adapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        spinner3.setAdapter(adapter2);
    }


    public void popup(View inflatedLayout) {
//        View inflatedLayout= getLayoutInflater().inflate(R.layout.activity_custom_dialog_class, null);
        LinearLayout linearLayout1 = (LinearLayout) inflatedLayout.findViewById(R.id.accessCamera);
        LinearLayout linearLayout2 = (LinearLayout) inflatedLayout.findViewById(R.id.accessGallery);


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Camera is Clicked", Toast.LENGTH_SHORT).show();
                try {
                    if (ContextCompat.checkSelfPermission(getActivity(),
                            android.Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {


                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{android.Manifest.permission.CAMERA, android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                0);

                    } else {
                        //yeah !we got the permission
                        Intent callCameraAppicationintent = new Intent();
                        callCameraAppicationintent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(callCameraAppicationintent, popup_camera);//now we are saying calling camera app,to actually yake a photo
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), "Exception", Toast.LENGTH_SHORT).show();

                }

            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // System.out.println("Hiii");
                Toast.makeText(getActivity(), "Gallery is clicked", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, gallery_fourth);


            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == popup_camera && resultCode == RESULT_OK && data != null) {

            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            de.hdodenhof.circleimageview.CircleImageView imageView = (de.hdodenhof.circleimageview.CircleImageView) fragmentView.findViewById(R.id.EventProfilePic);

//                    editText.setText("Usman");

            imageView.setImageBitmap(photo);
//     ceo can call now for details of content writer               imageView.se
            if (imageCountForPopup == 0) {
                imageCountForPopup++;
            }

        }
        else if (resultCode == RESULT_OK && requestCode == gallery && data != null) {

            Uri selectedImageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImageUri);
                de.hdodenhof.circleimageview.CircleImageView imageView = (de.hdodenhof.circleimageview.CircleImageView) fragmentView.findViewById(R.id.EventProfilePic);
                imageView.setImageBitmap(bitmap);
                if (imageCountForPopup == 0) {
                    imageCountForPopup++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }


        }



    }


}
