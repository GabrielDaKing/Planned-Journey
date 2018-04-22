package com.example.gncis.test1;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.Gravity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.transition.Explode;

import com.example.gncis.test1.data.BusDBHelper;
import com.example.gncis.test1.data.FlightDBHelper;
import com.example.gncis.test1.data.HotelDBHelper;
import com.example.gncis.test1.data.TrainDBHelper;
import com.example.gncis.test1.data.UserDBHelper;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import android.view.animation.AnticipateOvershootInterpolator;
import java.util.Arrays;


public class Main2Activity extends AppCompatActivity {


    Button btn1;
    Button btn2;
    Button btn3;
    public static final String ANONYMOUS = "anonymous";

    private FirebaseAuth mFirebaseAuth;

    private static final int RC_SIGN_IN = 123;

    private FirebaseAuth.AuthStateListener mAuthstatelistener;

    private String mUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setupWindowAnimations();

        btn1 =findViewById(R.id.button_send1);
        btn2 =findViewById(R.id.button_send2);
        btn3 =findViewById(R.id.button_send3);

        mFirebaseAuth = FirebaseAuth.getInstance(); 

        mAuthstatelistener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user!=null){
                    //Toast.makeText(MainActivity.this, "Youre logged in", Toast.LENGTH_SHORT).show();
                    mUsername = user.getDisplayName();
                }
                else{
                    mUsername = ANONYMOUS;
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.EmailBuilder().build(),
                                            new AuthUI.IdpConfig.GoogleBuilder().build(),
                                            new AuthUI.IdpConfig.PhoneBuilder().build()))
                                    .setTheme(R.style.AppTheme)
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
        // Choose authentication providers
        onButtonListener();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupWindowAnimations() {
        // Re-enter transition is executed when returning back to this activity
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT); // Use START if using right - to - left locale
        slideTransition.setDuration(1000);

        getWindow().setReenterTransition(slideTransition);  // When MainActivity Re-enter the Screen
        getWindow().setExitTransition(slideTransition);     // When MainActivity Exits the Screen

        // For overlap of Re Entering Activity - MainActivity.java and Exiting TransitionActivity.java
        getWindow().setAllowReturnTransitionOverlap(false);
    }



    public void onButtonListener(){

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              // Toast.makeText(Main2Activity.this, "View Current trip", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Main2Activity.this , ViewCurrent.class));

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(Main2Activity.this, "Create a new trip", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Main2Activity.this , CreateNew.class));
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(Main2Activity.this, "View Old Trips", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Main2Activity.this , ViewOld.class));
            }
        });

    }


    @Override
    protected void onPause(){
        super.onPause();
        if(mAuthstatelistener!=null)
            mFirebaseAuth.removeAuthStateListener(mAuthstatelistener);
    }

    @Override
    protected void onResume(){
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthstatelistener);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sign_out_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sign_out:
                AuthUI.getInstance().signOut(this);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN) {
            if (resultCode == RESULT_OK) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null)
                    if (user.getDisplayName() != null)
                        Toast.makeText(this, "Welcome to Tripese, " + user.getDisplayName() + "!", Toast.LENGTH_SHORT).show();
            }
            else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Sign In Cancelled!", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
}