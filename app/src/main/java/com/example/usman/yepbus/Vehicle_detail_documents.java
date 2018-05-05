package com.example.usman.yepbus;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.daasuu.bl.ArrowDirection;
import com.daasuu.bl.BubbleLayout;
import com.daasuu.bl.BubblePopupHelper;

import java.io.IOException;
import java.util.Random;

import static com.example.usman.yepbus.R.layout.three_custom_popups;
import static com.example.usman.yepbus.Vehicles_details.popup_two_camera_requestCode;

public class Vehicle_detail_documents extends AppCompatActivity {

    Button next;

    public final int popup_one_gallery_requestCode = 10;
    public final int popup_one_camera_requestCode = 11;
    public final int popup_one_cloud_requestCode = 12;

    public final int popup_two_gallery_requestCode = 40;
    public final int popup_two_camera_requestCode = 41;
    public final int popup_two_cloud_requestCode = 42;

    public final int popup_three_gallery_requestCode = 50;
    public final int popup_three_camera_requestCode = 51;
    public final int popup_three_cloud_requestCode = 52;

    int countForImagesofpopup1=0;
    int countForImagesofpopup2=0;
    int countForImagesofpopup3=0;

    boolean isClickedimage1=true;
    boolean isClickedimage2=true;
    boolean isClickedimage3=true;

    //handling requests for pop ups gallerty and imagae
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case popup_one_gallery_requestCode:
                if (requestCode == popup_one_gallery_requestCode && resultCode == RESULT_OK && data != null) {
                    Uri selectedImageUri = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                        ImageView imageView = (ImageView) findViewById(R.id.doc1);
                        imageView.setImageBitmap(bitmap);
                        if(countForImagesofpopup1==0)
                        {
                            countForImagesofpopup1++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
                break;
            case popup_one_camera_requestCode :
                if ( requestCode == popup_one_camera_requestCode  &&resultCode == RESULT_OK && data != null) {


                    Bundle extras = data.getExtras();
                    Bitmap photo = (Bitmap) extras.get("data");
                    ImageView imageView = (ImageView) findViewById(R.id.doc1);
                    imageView.setImageBitmap(photo);
                    if(countForImagesofpopup1==0)
                    {
                        countForImagesofpopup1++;
                    }

                }
                break;
            case popup_two_gallery_requestCode:
                if (requestCode == popup_two_gallery_requestCode && resultCode == RESULT_OK && data != null) {



                    Uri selectedImageUri = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                        ImageView imageView = (ImageView) findViewById(R.id.doc2);
                        imageView.setImageBitmap(bitmap);
                        if(countForImagesofpopup2==0)
                        {
                            countForImagesofpopup2++;
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case popup_two_camera_requestCode:
                if (requestCode == popup_two_camera_requestCode && resultCode == RESULT_OK && data != null) {



                    Bundle extras = data.getExtras();
                    Bitmap photo = (Bitmap) extras.get("data");
                    ImageView imageView = (ImageView) findViewById(R.id.doc2);
                    imageView.setImageBitmap(photo);
                    if(countForImagesofpopup2==0)
                    {
                        countForImagesofpopup2++;
                    }


                }
                break;
            case popup_three_gallery_requestCode:
                if (requestCode == popup_three_gallery_requestCode && resultCode == RESULT_OK && data != null) {



                    Uri selectedImageUri = data.getData();
                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageUri);
                        ImageView imageView = (ImageView) findViewById(R.id.doc3);
                        imageView.setImageBitmap(bitmap);
                        if(countForImagesofpopup3==0)
                        {
                            countForImagesofpopup3++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }




                }
                break;
            case popup_three_camera_requestCode:
                if (requestCode == popup_three_camera_requestCode && resultCode == RESULT_OK && data != null) {



                    Bundle extras = data.getExtras();
                    Bitmap photo = (Bitmap) extras.get("data");
                   ImageView imageView = (ImageView) findViewById(R.id.doc3);
                    imageView.setImageBitmap(photo);

                    if(countForImagesofpopup3==0)
                    {
                        countForImagesofpopup3++;
                    }

                }
                break;
            default:
                Toast.makeText(getApplicationContext(), "error occured", Toast.LENGTH_SHORT).show();

        }

    }

    //bubble layout is here
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_detail_documents);
        AppyText();



        //document one pop up

        ImageView imageView = (ImageView) findViewById(R.id.doc1);



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View inflatedLayout = inflater.inflate(R.layout.three_custom_popups, null);

                final BubbleLayout bubbleLayout1 = (BubbleLayout) inflatedLayout;
                final PopupWindow popupWindow1 = BubblePopupHelper.create(Vehicle_detail_documents.this, bubbleLayout1);
                final Random random = new Random();

                if (isClickedimage1) {
                    isClickedimage1 = false;
                    int[] location = new int[2];
                    v.getLocationInWindow(location);
                    if (random.nextBoolean()) {
                        bubbleLayout1.setArrowDirection(ArrowDirection.TOP);
                    }
                    popupWindow1.showAtLocation(v, Gravity.NO_GRAVITY, location[0], v.getHeight() + location[1]);

                    popup_one(inflatedLayout);
                }
                else{
                   isClickedimage1=true;
                }
            }
        });


        //document two pop up
        ImageView imageView2 = (ImageView) findViewById(R.id.doc2);



        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View inflatedLayout = inflater.inflate(R.layout.three_custom_popups, null);
                final BubbleLayout bubbleLayout2 = (BubbleLayout) inflatedLayout;
                bubbleLayout2.setArrowPosition(300);
                final PopupWindow popupWindow2 = BubblePopupHelper.create(Vehicle_detail_documents.this, bubbleLayout2);
                final Random random2 = new Random();


                if (isClickedimage2) {
                    isClickedimage2 = false;
                    int[] location = new int[2];
                    v.getLocationInWindow(location);
                    if (random2.nextBoolean()) {
                        bubbleLayout2.setArrowDirection(ArrowDirection.TOP);
                    }
                    popupWindow2.showAtLocation(v, Gravity.NO_GRAVITY, location[0], v.getHeight() + location[1]);

                    popup_two(inflatedLayout);
                }else {
                    isClickedimage2=true;
                }
            }
        });



        //document three pop up
        ImageView imageView3 = (ImageView) findViewById(R.id.doc3);



        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View inflatedLayout = inflater.inflate(R.layout.three_custom_popups, null);

                final BubbleLayout bubbleLayout3 = (BubbleLayout) inflatedLayout;
                bubbleLayout3.setArrowPosition(600);
                final PopupWindow popupWindow3 = BubblePopupHelper.create(Vehicle_detail_documents.this, bubbleLayout3);
                final Random random3 = new Random();


                if (isClickedimage3) {
                    isClickedimage3 = false;
                    int[] location = new int[2];
                    v.getLocationInWindow(location);
                    if (random3.nextBoolean()) {
                        bubbleLayout3.setArrowDirection(ArrowDirection.TOP);
                    }
                    popupWindow3.showAtLocation(v, Gravity.NO_GRAVITY, location[0], v.getHeight() + location[1]);

                    popup_three(inflatedLayout);
                } else {
                    isClickedimage3 = true;
                }
            }
        });



    }


    public void popup_one(View inflatedLayout) {

        LinearLayout linearLayout1 = (LinearLayout) inflatedLayout.findViewById(R.id.accessGallery2);
        LinearLayout linearLayout2 = (LinearLayout) inflatedLayout.findViewById(R.id.accessDropbox);


        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Camera is Clicked", Toast.LENGTH_SHORT).show();
                try {
                    if (ContextCompat.checkSelfPermission(Vehicle_detail_documents.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {


                        ActivityCompat.requestPermissions(Vehicle_detail_documents.this,
                                new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                0);

                    } else {
                        //yeah !we got the permission
                        Intent callCameraAppicationintent = new Intent();
                        callCameraAppicationintent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(callCameraAppicationintent, popup_one_camera_requestCode);//now we are saying calling camera app,to actually yake a photo
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Exception", Toast.LENGTH_SHORT).show();

                }

            }
        });

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Hiii");
                Toast.makeText(getApplicationContext(), "Gallery is clicked", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, popup_one_gallery_requestCode);


            }
        });



    }

    public void popup_two(View inflatedLayout) {
        LinearLayout linearLayout1 = (LinearLayout) inflatedLayout.findViewById(R.id.accessGallery2);
        LinearLayout linearLayout2 = (LinearLayout) inflatedLayout.findViewById(R.id.accessDropbox);


        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Camera is Clicked", Toast.LENGTH_SHORT).show();
                try {
                    if (ContextCompat.checkSelfPermission(Vehicle_detail_documents.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {


                        ActivityCompat.requestPermissions(Vehicle_detail_documents.this,
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

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Hiii");
                Toast.makeText(getApplicationContext(), "Gallery is clicked", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, popup_two_gallery_requestCode);


            }
        });



        //continue button or Intent to next activity and validation too
        next=(Button) findViewById(R.id.goTonext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((countForImagesofpopup1+countForImagesofpopup2+countForImagesofpopup3)<3)
                {
                    Toast.makeText(getApplicationContext(), "Add all documents please", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Intent menuIntent = new Intent(getApplicationContext(),Navigation_Drawer_activity_vehicle.class);
                    startActivity(menuIntent);

                }
            }
        });

    }


    public void popup_three(View inflatedLayout) {
        LinearLayout linearLayout1 = (LinearLayout) inflatedLayout.findViewById(R.id.accessGallery2);
        LinearLayout linearLayout2 = (LinearLayout) inflatedLayout.findViewById(R.id.accessDropbox);


        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Camera is Clicked", Toast.LENGTH_SHORT).show();
                try {
                    if (ContextCompat.checkSelfPermission(Vehicle_detail_documents.this,
                            Manifest.permission.CAMERA)
                            != PackageManager.PERMISSION_GRANTED) {


                        ActivityCompat.requestPermissions(Vehicle_detail_documents.this,
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

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Hiii");
                Toast.makeText(getApplicationContext(), "Gallery is clicked", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, popup_three_gallery_requestCode);


            }
        });


    }

    //Applying text
    public void AppyText()
    {
        TextView vehicleDetails = (TextView) findViewById(R.id.middle);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "Fonts/Firme Book Italic.otf");
        vehicleDetails.setTypeface(typeFace);

        TextView veh=(TextView) findViewById(R.id.vehicle);
        Typeface typeFace2=Typeface.createFromAsset(getAssets(),"Fonts/Firme Black.otf");
        veh.setTypeface(typeFace2);

        TextView det=(TextView) findViewById(R.id.details);
        Typeface typeFace3=Typeface.createFromAsset(getAssets(),"Fonts/Firme Black.otf");
        det.setTypeface(typeFace3);

        TextView document=(TextView) findViewById(R.id.documents);
        Typeface typeFace4=Typeface.createFromAsset(getAssets(),"Fonts/Firme Black.otf");
        document.setTypeface(typeFace4);
    }




}

