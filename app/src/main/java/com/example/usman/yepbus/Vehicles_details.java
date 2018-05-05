package com.example.usman.yepbus;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.daasuu.bl.ArrowDirection;
import com.daasuu.bl.BubbleLayout;
import com.daasuu.bl.BubblePopupHelper;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import static android.R.attr.breadCrumbShortTitle;
import static android.R.attr.data;
import static android.R.attr.resizeable;
import static java.security.AccessController.getContext;

public class Vehicles_details extends AppCompatActivity {

    String imageFileLocation = "";
    File fileContainsPhoto;

    boolean isClickedPopup1=true;
    boolean isClickedPopup2=true;
    boolean isClickedPopup3=true;
    boolean isClickedPopup4=true;
    boolean isClickedPopup5=true;
    public static final int ACTIVITY_START_CAMERA_APP = 0;
    public static final int popup_two_camera_requestCode = 23;
    public static final int popup_three_camera_requestCode = 24;
    public static final int popup_four_camera_requestCode = 25;
    public static final int popup_fifth_camera_requestCode = 26;

    public static final int gallery_one = 30;
    public static final int gallery_two = 31;
    public static final int gallery_three = 32;
    public static final int gallery_fourth = 33;
    public static final int gallery_fifth = 34;
    int count = 0;

    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    int imageCountForPopupone=0;
    int imageCountForPopuptwo=0;
    int imageCountForPopupthree=0;
    int imageCountForPopupfour=0;
    int imageCountForPopupFive=0;

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        return super.onCreateView(parent, name, context, attrs);
    }



    //handling which pop up is being clicked
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case ACTIVITY_START_CAMERA_APP:
                if (requestCode == ACTIVITY_START_CAMERA_APP && resultCode == RESULT_OK && data != null) {

                    Bundle extras = data.getExtras();
                    Bitmap photo = (Bitmap) extras.get("data");
                    ImageView imageView = (ImageView) findViewById(R.id.image1);
                    imageView.setImageBitmap(photo);
                    if(imageCountForPopupone==0)
                    {
                        imageCountForPopupone++;
                    }

                }
                break;
            case popup_two_camera_requestCode:
                if (requestCode == popup_two_camera_requestCode && resultCode == RESULT_OK && data != null) {

                    Bundle extras = data.getExtras();
                    Bitmap photo = (Bitmap) extras.get("data");
                    ImageView imageView = (ImageView) findViewById(R.id.image2);
                    imageView.setImageBitmap(photo);
                    if(imageCountForPopuptwo==0)
                    {
                        imageCountForPopuptwo++;
                    }
                }
                break;
            case popup_three_camera_requestCode:
                if (requestCode == popup_three_camera_requestCode && resultCode == RESULT_OK && data != null) {

                    Bundle extras = data.getExtras();
                    Bitmap photo = (Bitmap) extras.get("data");
                    ImageView imageView = (ImageView) findViewById(R.id.image3);
                    imageView.setImageBitmap(photo);
                    if(imageCountForPopupthree==0)
                    {
                        imageCountForPopupthree++;
                    }
                }
                break;
            case popup_four_camera_requestCode:
                if (requestCode == popup_two_camera_requestCode && resultCode == RESULT_OK && data != null) {

                    Bundle extras = data.getExtras();
                    Bitmap photo = (Bitmap) extras.get("data");
                    ImageView imageView = (ImageView) findViewById(R.id.image4);
                    imageView.setImageBitmap(photo);
                    if(imageCountForPopupfour==0)
                    {
                        imageCountForPopupfour++;
                    }

                }
                break;
            case popup_fifth_camera_requestCode:
                if (requestCode == popup_fifth_camera_requestCode && resultCode == RESULT_OK && data != null) {

                    Bundle extras = data.getExtras();
                    Bitmap photo = (Bitmap) extras.get("data");
                    ImageView imageView = (ImageView) findViewById(R.id.image5);
                    imageView.setImageBitmap(photo);
                    if(imageCountForPopupFive==0)
                    {
                        imageCountForPopupFive++;
                    }
                }
                break;

            case gallery_one:
                if (resultCode == RESULT_OK && requestCode == gallery_one && data != null) {

                    Uri selectedImageUri = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                        ImageView imageView = (ImageView) findViewById(R.id.image1);
                        imageView.setImageBitmap(bitmap);

                        if(imageCountForPopupone==0)
                        {
                            imageCountForPopupone++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
                break;
            case gallery_two:
                if (resultCode == RESULT_OK && requestCode == gallery_two && data != null) {

                    Uri selectedImageUri = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                        ImageView imageView = (ImageView) findViewById(R.id.image2);
                        imageView.setImageBitmap(bitmap);
                        if(imageCountForPopuptwo==0)
                        {
                            imageCountForPopuptwo++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
                break;
            case gallery_three:
                if (resultCode == RESULT_OK && requestCode == gallery_three && data != null) {

                    Uri selectedImageUri = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                        ImageView imageView = (ImageView) findViewById(R.id.image3);
                        imageView.setImageBitmap(bitmap);
                        if(imageCountForPopupthree==0)
                        {
                            imageCountForPopupthree++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
                break;
            case gallery_fourth:
                if (resultCode == RESULT_OK && requestCode == gallery_fourth && data != null) {

                    Uri selectedImageUri = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                        ImageView imageView = (ImageView) findViewById(R.id.image4);
                        imageView.setImageBitmap(bitmap);
                        if(imageCountForPopupfour==0)
                        {
                            imageCountForPopupfour++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
                break;
            case gallery_fifth:
                if (resultCode == RESULT_OK && requestCode == gallery_fifth && data != null) {

                    Uri selectedImageUri = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                        ImageView imageView = (ImageView) findViewById(R.id.image5);
                        imageView.setImageBitmap(bitmap);
                        if(imageCountForPopupFive==0)
                        {
                            imageCountForPopupFive++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
                break;
            default:
                break;
        }
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vehicles_details);
        //applying custom fonts
        AppyText();
        //spinner inside this function
        spinnerFunction();


//        CustomDialogClass cdd=new CustomDialogClass(Vehicles_details.this);
//        cdd.show();


        ImageView imageView = (ImageView) findViewById(R.id.image1);

  //---------------------------------------------------------------------------------------------------------------------------//
        //pop up one
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View inflatedLayout = inflater.inflate(R.layout.activity_custom_dialog_class, null);

                final BubbleLayout bubbleLayout = (BubbleLayout) inflatedLayout;
                final PopupWindow popupWindow = BubblePopupHelper.create(Vehicles_details.this, bubbleLayout);
                final Random random = new Random();

                if (isClickedPopup1) {
                    isClickedPopup1 = false;
                    int[] location = new int[2];
                    v.getLocationInWindow(location);
                    if (random.nextBoolean()) {
                        bubbleLayout.setArrowDirection(ArrowDirection.TOP);

                    }

                    popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0], v.getHeight() + location[1]);
                    popup_one(inflatedLayout);
                }else
                {
                    isClickedPopup1=true;
                }

            }
        });

        //---------------------------------------------------------------------------------------------------------------------------//
        //pop up two
        ImageView imageView2 = (ImageView) findViewById(R.id.image2);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View inflatedLayout = inflater.inflate(R.layout.activity_custom_dialog_class, null);

                final BubbleLayout bubbleLayout = (BubbleLayout) inflatedLayout;
                final PopupWindow popupWindow = BubblePopupHelper.create(Vehicles_details.this, bubbleLayout);
                final Random random = new Random();

                if (isClickedPopup2) {
                    isClickedPopup2 = false;
                    int[] location = new int[2];
                    v.getLocationInWindow(location);
                    if (random.nextBoolean()) {
                        bubbleLayout.setArrowDirection(ArrowDirection.TOP);


                    }

                    popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0], v.getHeight() + location[1]);
                    popup_two(inflatedLayout);
                }else {
                    isClickedPopup2 = true;

                }
            }
        });

        //---------------------------------------------------------------------------------------------------------------------------//
        //pop up three
        ImageView imageView3 = (ImageView) findViewById(R.id.image3);

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View inflatedLayout = inflater.inflate(R.layout.activity_custom_dialog_class, null);

                final BubbleLayout bubbleLayout = (BubbleLayout) inflatedLayout;
                final PopupWindow popupWindow = BubblePopupHelper.create(Vehicles_details.this, bubbleLayout);
                final Random random = new Random();

                if (isClickedPopup3) {
                    isClickedPopup3 = false;
                    int[] location = new int[2];
                    v.getLocationInWindow(location);
                    if (random.nextBoolean()) {
                        bubbleLayout.setArrowDirection(ArrowDirection.TOP);
                    }

                    popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0], v.getHeight() + location[1]);
                    popup_three(inflatedLayout);
                }
                else{
                        isClickedPopup3 = true;
                    }
            }
        });

        //---------------------------------------------------------------------------------------------------------------------------//
        //pop up four
        ImageView imageView4 = (ImageView) findViewById(R.id.image4);

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View inflatedLayout = inflater.inflate(R.layout.activity_custom_dialog_class, null);

                final BubbleLayout bubbleLayout = (BubbleLayout) inflatedLayout;
                bubbleLayout.setArrowPosition(250);
                final PopupWindow popupWindow = BubblePopupHelper.create(Vehicles_details.this, bubbleLayout);
                final Random random = new Random();

                if (isClickedPopup4) {
                    isClickedPopup4 = false;

                    int[] location = new int[2];
                    v.getLocationInWindow(location);
                    if (random.nextBoolean()) {
                        bubbleLayout.setArrowDirection(ArrowDirection.TOP);

                    }

                    popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0], v.getHeight() + location[1]);
                    popup_four(inflatedLayout);
                }else{
                    isClickedPopup4 = true;
                }
            }
        });

        //---------------------------------------------------------------------------------------------------------------------------//
        //pop up five

        ImageView imageView5 = (ImageView) findViewById(R.id.image5);

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View inflatedLayout = inflater.inflate(R.layout.activity_custom_dialog_class, null);

                final BubbleLayout bubbleLayout = (BubbleLayout) inflatedLayout;
                bubbleLayout.setArrowPosition(500);
                final PopupWindow popupWindow = BubblePopupHelper.create(Vehicles_details.this, bubbleLayout);
                final Random random = new Random();

                if (isClickedPopup5) {
                    isClickedPopup5 = false;
                    int[] location = new int[2];
                    v.getLocationInWindow(location);
                    if (random.nextBoolean()) {
                        bubbleLayout.setArrowDirection(ArrowDirection.TOP);

                    }

                    popupWindow.showAtLocation(v, Gravity.NO_GRAVITY, location[0], v.getHeight() + location[1]);
                    popup_fifth(inflatedLayout);
                }
                else{
                    isClickedPopup5=true;
                }
            }
        });





        //Button Continue and validation is here
        Button btn_int=(Button) findViewById(R.id.button1) ;
        btn_int.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( spinner1.getSelectedItem().toString().equalsIgnoreCase("Vehicle Type")  && spinner2.getSelectedItem().toString().equalsIgnoreCase("Manufacturer") && spinner3.getSelectedItem().toString().equalsIgnoreCase("Model") && spinner4.getSelectedItem().toString().equalsIgnoreCase("Number of Passenger Seats")) {

                    Toast.makeText(getApplicationContext(), "Fill the fields ", Toast.LENGTH_SHORT).show();

                } else if (spinner1.getSelectedItem().toString().equalsIgnoreCase("Vehicle Type")) {
                    Toast.makeText(getApplicationContext(), "Select the item ", Toast.LENGTH_SHORT).show();

                } else if (spinner2.getSelectedItem().toString().equalsIgnoreCase("Manufacturer")) {
                    Toast.makeText(getApplicationContext(), "Select the item ", Toast.LENGTH_SHORT).show();

                } else if (spinner3.getSelectedItem().toString().equalsIgnoreCase("Model")) {
                    Toast.makeText(getApplicationContext(), "Select the item", Toast.LENGTH_SHORT).show();

                } else if (spinner4.getSelectedItem().toString().equalsIgnoreCase("Number of Passenger Seats")) {
                    Toast.makeText(getApplicationContext(), "Select the item ", Toast.LENGTH_SHORT).show();

                }else if((imageCountForPopupone+imageCountForPopuptwo+imageCountForPopupthree+imageCountForPopupfour+imageCountForPopupFive)<3)
                {
                    Toast.makeText(getApplicationContext(), "At Least three images", Toast.LENGTH_SHORT).show();

                }
                else{
                    Intent menuIntent = new Intent(getApplicationContext(), Vehicle_detail_documents.class);
                    startActivity(menuIntent);
                }



            }
        });

    }

    public void popup_one(View inflatedLayout) {
//        View inflatedLayout= getLayoutInflater().inflate(R.layout.activity_custom_dialog_class, null);
        LinearLayout linearLayout1 = (LinearLayout) inflatedLayout.findViewById(R.id.accessCamera);
        LinearLayout linearLayout2 = (LinearLayout) inflatedLayout.findViewById(R.id.accessGallery);


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Camera is Clicked", Toast.LENGTH_SHORT).show();
                try {
                    if (ContextCompat.checkSelfPermission(Vehicles_details.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {


                        ActivityCompat.requestPermissions(Vehicles_details.this,
                                new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                0);

                    } else {
                        //yeah !we got the permission
                        Intent callCameraAppicationintent = new Intent();
                        callCameraAppicationintent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(callCameraAppicationintent, ACTIVITY_START_CAMERA_APP);//now we are saying calling camera app,to actually yake a photo
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Exception", Toast.LENGTH_SHORT).show();

                }

            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Hiii");
                Toast.makeText(getApplicationContext(), "Gallery is clicked", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, gallery_one);


            }
        });

    }

    public void popup_two(View inflatedLayout) {
//        View inflatedLayout= getLayoutInflater().inflate(R.layout.activity_custom_dialog_class, null);
        LinearLayout linearLayout1 = (LinearLayout) inflatedLayout.findViewById(R.id.accessCamera);
        LinearLayout linearLayout2 = (LinearLayout) inflatedLayout.findViewById(R.id.accessGallery);


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Camera is Clicked", Toast.LENGTH_SHORT).show();
                try {
                    if (ContextCompat.checkSelfPermission(Vehicles_details.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {


                        ActivityCompat.requestPermissions(Vehicles_details.this,
                                new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                0);

                    } else {
                        //yeah !we got the permission
                        Intent callCameraAppicationintent = new Intent();
                        callCameraAppicationintent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(callCameraAppicationintent, popup_two_camera_requestCode);//now we are saying calling camera app,to actually yake a photo
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Exception", Toast.LENGTH_SHORT).show();

                }

            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // System.out.println("Hiii");
                Toast.makeText(getApplicationContext(), "Gallery is clicked", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, gallery_two);


            }
        });


    }

    public void popup_three(View inflatedLayout) {
//        View inflatedLayout= getLayoutInflater().inflate(R.layout.activity_custom_dialog_class, null);
        LinearLayout linearLayout1 = (LinearLayout) inflatedLayout.findViewById(R.id.accessCamera);
        LinearLayout linearLayout2 = (LinearLayout) inflatedLayout.findViewById(R.id.accessGallery);


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Camera is Clicked", Toast.LENGTH_SHORT).show();
                try {
                    if (ContextCompat.checkSelfPermission(Vehicles_details.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {


                        ActivityCompat.requestPermissions(Vehicles_details.this,
                                new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                0);

                    } else {
                        //yeah !we got the permission
                        Intent callCameraAppicationintent = new Intent();
                        callCameraAppicationintent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(callCameraAppicationintent, popup_three_camera_requestCode);//now we are saying calling camera app,to actually yake a photo
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Exception", Toast.LENGTH_SHORT).show();

                }

            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Hiii");
                Toast.makeText(getApplicationContext(), "Gallery is clicked", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, gallery_three);


            }
        });




    }

    public void popup_four(View inflatedLayout) {
//        View inflatedLayout= getLayoutInflater().inflate(R.layout.activity_custom_dialog_class, null);
        LinearLayout linearLayout1 = (LinearLayout) inflatedLayout.findViewById(R.id.accessCamera);
        LinearLayout linearLayout2 = (LinearLayout) inflatedLayout.findViewById(R.id.accessGallery);


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Camera is Clicked", Toast.LENGTH_SHORT).show();
                try {
                    if (ContextCompat.checkSelfPermission(Vehicles_details.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {


                        ActivityCompat.requestPermissions(Vehicles_details.this,
                                new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                0);

                    } else {
                        //yeah !we got the permission
                        Intent callCameraAppicationintent = new Intent();
                        callCameraAppicationintent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(callCameraAppicationintent, popup_four_camera_requestCode);//now we are saying calling camera app,to actually yake a photo
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Exception", Toast.LENGTH_SHORT).show();

                }

            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // System.out.println("Hiii");
                Toast.makeText(getApplicationContext(), "Gallery is clicked", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, gallery_fourth);


            }
        });


    }

    public void popup_fifth(View inflatedLayout) {
//        View inflatedLayout= getLayoutInflater().inflate(R.layout.activity_custom_dialog_class, null);
        LinearLayout linearLayout1 = (LinearLayout) inflatedLayout.findViewById(R.id.accessCamera);
        LinearLayout linearLayout2 = (LinearLayout) inflatedLayout.findViewById(R.id.accessGallery);


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Camera is Clicked", Toast.LENGTH_SHORT).show();
                try {
                    if (ContextCompat.checkSelfPermission(Vehicles_details.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {


                        ActivityCompat.requestPermissions(Vehicles_details.this,
                                new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                0);

                    } else {
                        //yeah !we got the permission
                        Intent callCameraAppicationintent = new Intent();
                        callCameraAppicationintent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(callCameraAppicationintent, popup_fifth_camera_requestCode);//now we are saying calling camera app,to actually yake a photo
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Exception", Toast.LENGTH_SHORT).show();

                }

            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Hiii");
                Toast.makeText(getApplicationContext(), "Gallery is clicked", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, gallery_fifth);


            }
        });


    }

    public void AppyText() {
        TextView vehicleDetails = (TextView) findViewById(R.id.header);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "Fonts/Firme Black.otf");
        vehicleDetails.setTypeface(typeFace);

        TextView vehiclePicturesText = (TextView) findViewById(R.id.vehiclePicture);
        Typeface typeFace2 = Typeface.createFromAsset(getAssets(), "Fonts/Firme Light.otf");
        vehiclePicturesText.setTypeface(typeFace2);

    }
    //function to apply text
    public void ApplyText()
    {
        TextView Yep=(TextView) findViewById(R.id.header);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"Fonts/Firme Book Italic.otf");
        Yep.setTypeface(typeFace);



    }

    //function for spinner

    public void spinnerFunction() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> langAdapter1 = ArrayAdapter.createFromResource(this, R.array.Type, R.layout.spinner_text);
        langAdapter1.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        spinner1.setAdapter(langAdapter1);

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> langAdapter2 = ArrayAdapter.createFromResource(this, R.array.Manufacturer, R.layout.spinner_text);
        langAdapter2.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        spinner2.setAdapter(langAdapter2);


        spinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> langAdapter3 = ArrayAdapter.createFromResource(this, R.array.Model, R.layout.spinner_text);
        langAdapter3.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        spinner3.setAdapter(langAdapter3);

        spinner4 = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> langAdapter4 = ArrayAdapter.createFromResource(this, R.array.Passenger, R.layout.spinner_text);
        langAdapter4.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        spinner4.setAdapter(langAdapter4);

    }

}


