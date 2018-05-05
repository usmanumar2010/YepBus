package com.example.usman.yepbus;

import android.*;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.daasuu.bl.ArrowDirection;
import com.daasuu.bl.BubbleLayout;
import com.daasuu.bl.BubblePopupHelper;

import java.io.IOException;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.R.attr.data;
import static android.R.attr.id;
import static android.R.attr.widgetLayout;
import static android.app.Activity.RESULT_OK;
import static com.example.usman.yepbus.Vehicles_details.gallery_fourth;
import static com.facebook.FacebookSdk.getApplicationContext;

public class My_Profile_driver extends Fragment {


    RecyclerView recyclerView;
    boolean isClickedPopup4=true;
    public static final int popup_camera = 26;
    public static final int gallery = 33;
    int imageCountForPopup=0;
    boolean isClickedPopup1=true;
    View fragmentView;

    //camera and gallery request code handle here
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

                if (requestCode == popup_camera && resultCode == RESULT_OK && data != null) {

                    Bundle extras = data.getExtras();
                    Bitmap photo = (Bitmap) extras.get("data");
                    de.hdodenhof.circleimageview.CircleImageView imageView = (de.hdodenhof.circleimageview.CircleImageView) fragmentView.findViewById(R.id.profile_imageUser);
                    TextView editText=(TextView) fragmentView.findViewById(R.id.editProfile);

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
                        de.hdodenhof.circleimageview.CircleImageView imageView = (de.hdodenhof.circleimageview.CircleImageView) fragmentView.findViewById(R.id.profile_imageUser);
                        imageView.setImageBitmap(bitmap);
                        if (imageCountForPopup == 0) {
                            imageCountForPopup++;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Toast.makeText(getActivity(), "helloo i m in fragemnt", Toast.LENGTH_SHORT).show();


        final View rootView = inflater.inflate(R.layout.activity_my__profile_driver, container, false);

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        android.support.v7.widget.SearchView sw=(android.support.v7.widget.SearchView) toolbar.findViewById(R.id.serchViewhere);
        sw.setVisibility(View.GONE);
        final EditText editText = (EditText) rootView.findViewById(R.id.aboutMe);
        final TextView editTextName = (TextView) rootView.findViewById(R.id.name);
        final TextView editTextState = (TextView) rootView.findViewById(R.id.state);


        ImageView imageView = (ImageView) rootView.findViewById(R.id.pencill);
        ImageView imageView1 = (ImageView) rootView.findViewById(R.id.editName);
        ImageView imageView2 = (ImageView) rootView.findViewById(R.id.editState);
        final ImageView editState = (ImageView) rootView.findViewById(R.id.editState);
        RelativeLayout rl=(RelativeLayout) rootView.findViewById(R.id.showMoreOne) ;
        RelativeLayout rl2=(RelativeLayout) rootView.findViewById(R.id.showMoreTwo) ;

        editText.setEnabled(false);
        editTextName.setEnabled(false);
        editTextState.setEnabled(false);




        //set about me to true
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editText.setEnabled(true);
                editText.requestFocus();
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                AlertDialog.Builder mBuilder=new AlertDialog.Builder(getActivity());
//                View mView= getLayoutInflator().inflate(R.layout.dialogue_for_profile_name,null);
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View inflatedLayout = inflater.inflate(R.layout.dialogue_for_profile_name, null);

                final EditText ed1=(EditText) inflatedLayout.findViewById(R.id.myChangedName);
                ed1.setText(editTextName.getText());

                Button imageEditName =(Button) inflatedLayout.findViewById(R.id.okayPressed);


                mBuilder.setView(inflatedLayout);
                final AlertDialog dialogue=mBuilder.create();
                dialogue.show();

                imageEditName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if( ed1.getText().equals("") )
                        {
                            Toast.makeText(getActivity(), "Field is empty", Toast.LENGTH_SHORT).show();
                            dialogue.dismiss();
                        }
                        else{
                            editTextName.setText(ed1.getText());
                            dialogue.dismiss();
                        }
                    }
                });

                Button cancel=(Button) inflatedLayout.findViewById(R.id.CancelPressed);

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogue.dismiss();
                    }
                });


//                editTextName.setEnabled(true);
//                editTextName.setFocusable(true);
//                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//                imm.showSoftInput(editTextName, InputMethodManager.SHOW_IMPLICIT);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                AlertDialog.Builder mBuilder=new AlertDialog.Builder(getActivity());
//                View mView= getLayoutInflator().inflate(R.layout.dialogue_for_profile_name,null);
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View inflatedLayout = inflater.inflate(R.layout.dialogue_for_profile_name, null);

                TextView tv=(TextView) inflatedLayout.findViewById(R.id.stateAdrressed);
                tv.setText("Set Location");

                final EditText ed1=(EditText) inflatedLayout.findViewById(R.id.myChangedName);
                ed1.setText(editTextState.getText());

                Button imageEditName =(Button) inflatedLayout.findViewById(R.id.okayPressed);


                mBuilder.setView(inflatedLayout);
                final AlertDialog dialogue=mBuilder.create();
                dialogue.show();

                imageEditName.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if( ed1.getText().equals("") )
                        {
                            Toast.makeText(getActivity(), "Field is empty", Toast.LENGTH_SHORT).show();
                            dialogue.dismiss();
                        }
                        else{
                            editTextState.setText(ed1.getText());
                            dialogue.dismiss();
                        }
                    }
                });

                Button cancel=(Button) inflatedLayout.findViewById(R.id.CancelPressed);

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogue.dismiss();
                    }
                });
            }
        });

        //recycler view for driver
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerForComments);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerAdapterForComments(getActivity().getApplicationContext(), getActivity()));


        //recycler for riders
        RecyclerView recyclerAdapter2 = (RecyclerView) rootView.findViewById(R.id.recyclerForComments2);
        recyclerAdapter2.setHasFixedSize(true);
        recyclerAdapter2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerAdapter2.setAdapter(new RecyclerAdapter_for_fragment_for_yepRiders_comments(getActivity().getApplicationContext(), getActivity()));

        ImageView imageViewphoto = (ImageView) rootView.findViewById(R.id.takeMyPhoto);

        imageViewphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        });

        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragment = new Fragment_Show_More_One();
                FragmentManager fm = getActivity().getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.Replace, fragment);
                ft.commit();

            }
        });

        rl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Fragement_show_more_Two();
                FragmentManager fm = getActivity().getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.Replace, fragment);
                ft.commit();
            }
        });




            this.fragmentView = rootView;//this line is acting as a layoiut
            return rootView;

    }




    public void popup(View inflatedLayout) {
        LinearLayout linearLayout1 = (LinearLayout) inflatedLayout.findViewById(R.id.accessCamera);
        LinearLayout linearLayout2 = (LinearLayout) inflatedLayout.findViewById(R.id.accessGallery);


        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Camera is Clicked", Toast.LENGTH_SHORT).show();
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

                }

            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // System.out.println("Hiii");
                Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, gallery);


            }
        });


    }

}
