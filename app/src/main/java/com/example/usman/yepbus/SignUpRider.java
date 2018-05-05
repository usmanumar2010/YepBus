
package com.example.usman.yepbus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.daasuu.bl.ArrowDirection;
import com.daasuu.bl.BubbleLayout;
import com.daasuu.bl.BubblePopupHelper;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static android.provider.UserDictionary.Words.APP_ID;

public class SignUpRider extends AppCompatActivity {

    private static final int RC_SIGN_IN = 99;
    GoogleApiClient mGoogleApiClient;


    TextView sign;
    Button btn;
    ListView lv;
    Activity context;
    ArrayList a;
    int count = 0;
    ImageView imageView;
    RelativeLayout rl;
    public static TextView tv;
    EditText us;
    EditText em;
    EditText pass;
    EditText add;
    EditText mobiLe;
    EditText confirm_password;
    Spinner spinner;
    Spinner spinner1;
    Spinner spinner3;

    LinearLayout holaDriver;
    LinearLayout holaRider;
    ImageView tickImageDriver;
    ImageView tickImageRider;
    ImageView fb;

    private SignInButton mGoogleBtn;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    CallbackManager mCallbackManager;
    private static final String TAG = "SIGNUP_RIDER";
    public final int fbRequestCode = 111;
    String app_iddd = "1340863286007217";
    private boolean isClicked = true;
    String signup_url = "http://yepbus.com/dev/yepbus/api/signUpApi";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //       FacebookSdk.setApplicationId(app_iddd);
        FacebookSdk.sdkInitialize(this.getApplicationContext());
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        setContentView(R.layout.activity_sign_up_rider);


        //intialization
        btn = (Button) findViewById(R.id.button1);
        rl = (RelativeLayout) findViewById(R.id.clickHere);
        tv = (TextView) findViewById(R.id.RIDER);
        us = (EditText) findViewById(R.id.username);
        em = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        add = (EditText) findViewById(R.id.address);
        ImageView gmail_btn = (ImageView) findViewById(R.id.btn_google);
        mGoogleBtn = (SignInButton) findViewById(R.id.gmailHere);
        mAuth = FirebaseAuth.getInstance();
        mobiLe = (EditText) findViewById(R.id.mobile);
        confirm_password = (EditText) findViewById(R.id.password2);



        //upon Click on YepRider and YepDriver changing the Font
        SharedPreferences sharedPreferences = getSharedPreferences("RiderDriverFile", MODE_PRIVATE);
        String value = sharedPreferences.getString("iClicked", "");
        //    sharedPreferences.edit().clear().commit();

        switch (value) {
            case "Driver":
                tv.setText("Driver");
                break;
            case "Rider":
                tv.setText("Rider");
                break;
        }

        //function to show custom textStyle
        setFont();
        //sppiners are here
        spinnerHere();


        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();


        mGoogleApiClient = new GoogleApiClient.Builder(getApplicationContext()).enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
            @Override
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

            }
        })
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();


        gmail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                signIn();
            }
        });

        //---------------------------------------------------------------------------------------------------------------------//
        //facebook
        // Initialize Facebook Login button
        mCallbackManager = CallbackManager.Factory.create();
        fb = (ImageView) findViewById(R.id.btn_facebook);
        final LoginButton loginButton = (LoginButton) findViewById(R.id.facebookLogin);


        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginButton.performClick();
            }
        });



        loginButton.setReadPermissions("email", "public_profile");

        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(TAG, "facebook:onSuccess:" + loginResult);
                // Toast.makeText(getApplicationContext(), "On Success", Toast.LENGTH_SHORT).show();


                AccessToken accessToken = loginResult.getAccessToken();
//                GraphRequest request = GraphRequest.newMeRequest( AccessToken.getCurrentAccessToken(),
//                        new GraphRequest.GraphJSONObjectCallback() {
//                            @Override
//                            public void onCompleted(JSONObject object, GraphResponse response) {
//                                try {
//
//
//                                    String name=object.getString("name");
//                                    us.setText(name);
//                                    Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
//
//                                    String  email=object.optString("email");
//                                    em.setText(email);
//                                    Toast.makeText(getApplicationContext(), email, Toast.LENGTH_SHORT).show();
//
//
//
//
//                                    Log.d(TAG + "user name ", name);
//                                } catch (JSONException e) {
//                                    // TODO Auto-generated catch block
//                                    e.printStackTrace();
//                                }
//
//                            }
//
//                        });
//                Bundle parameters = new Bundle();
//                parameters.putString("fields","name,email,gender");
//                request.setParameters(parameters);
//                request.executeAsync();


                handleFacebookAccessToken(loginResult.getAccessToken());

            }

            @Override
            public void onCancel() {
                Log.d(TAG, "facebook:onCancel");
                // ...
            }

            @Override
            public void onError(FacebookException error) {
                Log.d(TAG, "facebook:onError", error);
                // ...
            }
        });


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {


                //    Toast.makeText(getApplicationContext(), "hello auth listener", Toast.LENGTH_SHORT).show();
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    em.setText(user.getEmail());
                    us.setText(user.getDisplayName());


                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...

            }
        };



    }//on Create end




    //getting firebase token for authentication
    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG, "handleFacebookAccessToken:" + token);

        final AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        // signed in user can be handled in the listener.
                        Toast.makeText(SignUpRider.this, "Authentication Successful." + task.isSuccessful(),
                                Toast.LENGTH_SHORT).show();


                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithCredential", task.getException());
                            // Toast.makeText(SignUpRider.this, "Authentication failed in hadleFacebook().",  Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    //checking the response depending upon the  request code wheter user hit gmail else facebook
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);


            }
        } else {
            mCallbackManager.onActivityResult(requestCode, resultCode, data);

        }
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    //Authentication of google through firebase using token
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());
                        Toast.makeText(getApplicationContext(), "you  are signed in  ", Toast.LENGTH_SHORT).show();
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {

                            Log.w(TAG, "signInWithCredential", task.getException());
                            Toast.makeText(SignUpRider.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // ...
                    }
                });
    }


    //Google Intent
    private void signIn() {

        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    //-----------------------------------------------------------------------------------------------------------------------------------//

    //intent for next Activity and authentication are  here
    public void Listner(View view) throws JSONException {


        String a = us.getText().toString();
        String b = em.getText().toString();
        String c = pass.getText().toString();
        String d = add.getText().toString();
        String e = confirm_password.getText().toString();
        String f = mobiLe.getText().toString();


        //validation
        if (a.matches("") && b.matches("") && c.matches("") && c.matches("") && d.matches("") && spinner.getSelectedItem().toString().equalsIgnoreCase("Day") && spinner1.getSelectedItem().toString().equalsIgnoreCase("Month") && spinner3.getSelectedItem().toString().equalsIgnoreCase("Year")) {

            Toast.makeText(getApplicationContext(), "Fill the fields ", Toast.LENGTH_SHORT).show();

        } else if (a.matches("")) {
            Toast.makeText(getApplicationContext(), "username is empty ", Toast.LENGTH_SHORT).show();

        } else if (isValidEmail(em.getText()) == false) {
            Toast.makeText(getApplicationContext(), " invalid email", Toast.LENGTH_SHORT).show();

        } else if (c.matches("")) {
            Toast.makeText(getApplicationContext(), "password is empty ", Toast.LENGTH_SHORT).show();

        } else if (e.matches("")) {
            Toast.makeText(getApplicationContext(), "Confirm password is empty ", Toast.LENGTH_SHORT).show();
        } else if (f.matches("")) {
            Toast.makeText(getApplicationContext(), "Mobile number is empty ", Toast.LENGTH_SHORT).show();

        } else if (d.matches("")) {
            Toast.makeText(getApplicationContext(), "address is empty ", Toast.LENGTH_SHORT).show();

        } else if (spinner.getSelectedItem().toString().equalsIgnoreCase("Day")) {
            Toast.makeText(getApplicationContext(), "Select the day ", Toast.LENGTH_SHORT).show();

        } else if (spinner1.getSelectedItem().toString().equalsIgnoreCase("Month")) {
            Toast.makeText(getApplicationContext(), "Select the month", Toast.LENGTH_SHORT).show();
        } else if (spinner3.getSelectedItem().toString().equalsIgnoreCase("Year")) {
            Toast.makeText(getApplicationContext(), "Select the year", Toast.LENGTH_SHORT).show();

        } else {
            if (!c.equals(e)) {
                Toast.makeText(getApplicationContext(), "Password mismatch,Enter again", Toast.LENGTH_SHORT).show();
                pass.setText("");
                confirm_password.setText("");
            } else {

//              //  volley and json
//                StringRequest stringRequest = new StringRequest(Request.Method.POST, signup_url, new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        Toast.makeText(context, "Response:" + response, Toast.LENGTH_SHORT).show();
//
//                        try {
//
//
//                            JSONArray jsonArray = new JSONArray(response);
//
//
//                            JSONObject jsonObject = jsonArray.getJSONObject(0);
//
//                            String status = jsonObject.getString("status");
////                            String message = jsonObject.getString("message");//here message is a key
////                 Toast.makeText(getApplicationContext(), "Server response=" + message, Toast.LENGTH_SHORT).show();
//
//                            if(status.equals("failure")) {
//                                Toast.makeText(getApplicationContext(), jsonObject.getString("data"), Toast.LENGTH_SHORT).show();
//
//                            }else if(status.equals("success"))
//                            {
//                                finish();
//                            }
//
//                        } catch (JSONException e1) {
//                            System.out.println("hello");
//                            System.out.println("hello");
//                            System.out.println("hello");
//                            System.out.println("hello");
//                            System.out.println("usman" + e1.toString());
//                            Toast.makeText(getApplicationContext(), "error in Json=" + e1.toString(), Toast.LENGTH_SHORT).show();
//
//                            // Log.d("usman",e1.toString());
//                        }
//
//                    }
//
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getApplicationContext(), "error in volley respose=" + error.toString(), Toast.LENGTH_SHORT).show();
//
//                    }
//                }) {
//                    @Override
//                    protected Map<String, String> getParams() throws AuthFailureError {
//                        Map<String, String> params = new HashMap<String, String>();
//                     //   params.put("signup_array", jsonArray.toString());
//
//                        params.put("member_username", us.getText().toString());
//                        params.put("member_type", "1");
//                        params.put("member_email", em.getText().toString());
//                        params.put("member_password", pass.getText().toString());
//                        params.put("member_phone", mobiLe.getText().toString());
//                        params.put("member_address", add.getText().toString());
//                        params.put("member_dob", "Jun, 27,2016");
//                        return params;
//
//                    }
//                };
//
//
//
//                MySingleton.getmInstance(SignUpRider.this).addToRequestquue(stringRequest);


                //next activty
                Intent menuIntent = new Intent(this, Payment_details.class);
                startActivity(menuIntent);
            }



        }
    }

    //--------------------------------------------------------------------------------------------------------------------------------//
    //email checking
    public final static boolean isValidEmail(CharSequence target) {

        char a = '.';
        char b = 0;
        if (!TextUtils.isEmpty(target)) {

            b = target.charAt(0);
        }

        if (TextUtils.isEmpty(target)) {
            return false;
        } else if (b == a) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }

    }
    //----------------------------------------------------------------------------------------------------------------------------//

    // custom menu i.e it contains popUp
    public void ControlMenu(View view) {


        if (isClicked) {
            isClicked = false;
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View menuLayout = inflater.inflate(R.layout.custom_menu_with_bubblelyout, null);

            final BubbleLayout bubbleLayout = (BubbleLayout) menuLayout;
            final PopupWindow popupWindow = BubblePopupHelper.create(this, bubbleLayout);
            final Random random = new Random();

            //BUBBLE LAYOUT
            int[] location = new int[2];
            view.getLocationInWindow(location);
            if (random.nextBoolean()) {
                bubbleLayout.setArrowDirection(ArrowDirection.TOP);
            }
            popupWindow.showAtLocation(view, Gravity.NO_GRAVITY, location[0], view.getHeight() + location[1]);


            holaDriver = (LinearLayout) menuLayout.findViewById(R.id.helloDriver);
            holaRider = (LinearLayout) menuLayout.findViewById(R.id.helloRider);
            tickImageDriver = (ImageView) menuLayout.findViewById(R.id.tick1);
            tickImageRider = (ImageView) menuLayout.findViewById(R.id.tick2);

            holaDriver.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (tickImageRider.getVisibility() == View.VISIBLE) {
                        tickImageRider.setVisibility(View.INVISIBLE);
                        tickImageDriver.setVisibility(View.VISIBLE);
                        tv.setText("Driver");


                    } else {
                        tickImageDriver.setVisibility(View.VISIBLE);
                        tv.setText("Driver");
                    }
                }
            });

            holaRider.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (tickImageDriver.getVisibility() == View.VISIBLE) {
                        tickImageDriver.setVisibility(View.INVISIBLE);
                        tickImageRider.setVisibility(View.VISIBLE);
                        tv.setText("Rider");

                    } else {

                        tickImageRider.setVisibility(View.VISIBLE);
                        tv.setText("Rider");
                    }
                }
            });
        } else {

            isClicked=true;

        }


        //this is a custom spinner which  has tick property in it
//
//        final Spinner spinner0 = (Spinner) findViewById(R.id.spinnerPop);
//        spinner0.performClick();
//        ArrayAdapter<String> daTaAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, this.getResources().getStringArray(R.array.rider_array));
//        daTaAdapter.setDropDownViewResource(spinner_layout);//spinner_layout
//        spinner0.setAdapter(daTaAdapter);
//
//
//        spinner0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view,
//                                       int position, long id) {
//                Object item = adapterView.getSelectedItem();//this will give us a selected item
//                String convertStrinig = (String) item;
//
//                if (convertStrinig.equalsIgnoreCase("YepDriver")) {
//
//
//                    tv = (TextView) findViewById(R.id.RIDER);
//                    tv.setText("DRIVER");
//
//
//                }
//
//                if (convertStrinig.equalsIgnoreCase("YepRider")) {
//
//                    tv = (TextView) findViewById(R.id.RIDER);
//                    tv.setText("RIDER");
//
//
//                }
//
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//
//        });

    }

    //-----------------------------------------------------------------------------------------------------------------------------//

    //font style functoin
    public void setFont() {
        sign = (TextView) findViewById(R.id.signas);
        Typeface typeFace = Typeface.createFromAsset(getAssets(), "Fonts/Firme Black.otf");
        sign.setTypeface(typeFace);

        TextView Yep = (TextView) findViewById(R.id.YEP);
        typeFace = Typeface.createFromAsset(getAssets(), "Fonts/Firme Light.otf");
        Yep.setTypeface(typeFace);

        TextView Rider = (TextView) findViewById(R.id.RIDER);
        typeFace = Typeface.createFromAsset(getAssets(), "Fonts/Firme Black.otf");
        Rider.setTypeface(typeFace);

        TextView Date = (TextView) findViewById(R.id.BirthDate);
        typeFace = Typeface.createFromAsset(getAssets(), "Fonts/Firme Book Italic.otf");
        Date.setTypeface(typeFace);


    }

    //----------------------------------------------------------------------------------------------------------------------------//

    //spinners funtion
    public void spinnerHere() {


        spinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> langgAdapter = ArrayAdapter.createFromResource(this, R.array.Day_array, R.layout.spinner_text);
        spinner.setPrompt("Country");
        langgAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        spinner.setAdapter(langgAdapter);


//        ArrayAdapter<String> langAdapter = new ArrayAdapter<String>(this,
//               android.R.layout.simple_spinner_dropdown_item,this.getResources().getStringArray(R.array.Payment_details));
//        langAdapter.setDropDownViewResource(R.layout.spinner_layout);
//       spinner.setAdapter(langAdapter);

        spinner1 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> langAdapter1 = ArrayAdapter.createFromResource(this, R.array.Month_array, R.layout.spinner_text);
        langAdapter1.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        spinner1.setAdapter(langAdapter1);


        spinner3 = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> langAdapter3 = ArrayAdapter.createFromResource(this, R.array.Year_array, R.layout.spinner_text);
        langAdapter3.setDropDownViewResource(R.layout.simple_spinner_dropdown);
        spinner3.setAdapter(langAdapter3);


    }


}




