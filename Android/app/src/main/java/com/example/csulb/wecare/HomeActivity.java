package com.example.csulb.wecare;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.fitness.Fitness;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    private GoogleApiClient client;
    public ImageButton mVoice;
    public TextView mName,mDate,mTime;
    public LinearLayout mRunningTab, mExerciseTab, mSleepTab, mMealsTab, mMedicineTab,
            mEmergengyTab, mHeartRateTab, mAlertsTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mName = (TextView) findViewById(R.id.homeNameTextView);

        // Display a date in day, month, year format
        mDate = (TextView) findViewById(R.id.homeDateTextView);
        mDate.setText(""+DateFormat.getDateInstance(DateFormat.LONG, Locale.US).format(new Date()));


        mVoice = (ImageButton)findViewById(R.id.homeVoiceImageButton);
        mVoice.setOnClickListener(this);

        mRunningTab = (LinearLayout)findViewById(R.id.homeRunningTab);
        mRunningTab.setOnClickListener(this);

        mExerciseTab = (LinearLayout)findViewById(R.id.homeExerciseTab);
        mExerciseTab.setOnClickListener(this);

        mSleepTab = (LinearLayout)findViewById(R.id.homeSleepTab);
        mSleepTab.setOnClickListener(this);

        mMealsTab = (LinearLayout)findViewById(R.id.homeMealsTab);
        mMealsTab.setOnClickListener(this);

        mMedicineTab = (LinearLayout)findViewById(R.id.homeMedicineTab);
        mMedicineTab.setOnClickListener(this);

        mEmergengyTab = (LinearLayout)findViewById(R.id.homeEmergencyTab);
        mEmergengyTab.setOnClickListener(this);

        mHeartRateTab = (LinearLayout)findViewById(R.id.homeHeartRateTab);
        mHeartRateTab.setOnClickListener(this);

        mAlertsTab = (LinearLayout)findViewById(R.id.homeAlertsTab);
        mAlertsTab.setOnClickListener(this);

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Check Permissions Now
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    101);
        }
        else if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            // Check Permissions Now
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    102);
        }
    }

    @Override
    public void onClick(View v) {
        if(v == mVoice){
            //Temporary logout button
            SharedPrefManager.getmInstance(getApplicationContext()).logout();
        }
        else if(v==mRunningTab){
            startActivity(new Intent(HomeActivity.this, RunningActivity.class));
        }
        else if(v == mExerciseTab){

        }
        else if(v == mHeartRateTab){

        }
        else if(v == mMedicineTab){

        }
        else if(v == mSleepTab){

        }
        else if(v == mMealsTab){

        }
        else if(v == mEmergengyTab){
            startActivity(new Intent(HomeActivity.this,EmergencyActivity.class));

        }
        else if(v == mAlertsTab){

        }
    }

}
