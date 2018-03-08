package com.example.csulb.wecare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    public ImageButton mVoice;
    public TextView mName,mDate,mTime;
    public LinearLayout mRunningTab, mExerciseTab, mSleepTab, mMealsTab, mMedicineTab,
            mEmergengyTab, mHeartRateTab, mAlertsTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mName = (TextView) findViewById(R.id.homeNameTextView);
        mDate = (TextView) findViewById(R.id.homeDateTextView);
        mTime = (TextView) findViewById(R.id.homeTimeTextView);

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
    }

    @Override
    public void onClick(View v) {
        if(v == mVoice){
            SharedPrefManager.getmInstance(getApplicationContext()).logout();
        }
        else if(v==mRunningTab){

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

        }
        else if(v == mAlertsTab){

        }
    }
}
