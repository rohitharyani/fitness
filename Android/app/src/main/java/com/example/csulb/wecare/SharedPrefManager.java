package com.example.csulb.wecare;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Rohit on 03/06/2018.
 */

public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private static Context mCtx;
    private static final String SHARED_PREF_NAME = "mySharedPrefMAnager";
    private static final String KEY_LOGIN = "userLoginButton";
    private static final String KEY_GOOGLE = "userGoogleLogin";
    private static final String KEY_FACEBOOK = "userFacebookLogin";

    private SharedPrefManager(Context context){
        mCtx = context;
    }

    public static synchronized  SharedPrefManager getmInstance (Context context){
        if (mInstance == null){
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean userLoginButton(String login){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_LOGIN,login);
        editor.apply();
        return true;
    }

    public boolean userLoginGoogle(String login){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_GOOGLE,login);
        editor.apply();
        return true;
    }
    public boolean userLoginFacebook(String login){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_FACEBOOK,login);
        editor.apply();
        return true;
    }

    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_LOGIN, null) !=null){
            return true;
        }
        else if (sharedPreferences.getString(KEY_GOOGLE, null) !=null){
            return true;
        }
        else if (sharedPreferences.getString(KEY_FACEBOOK, null) !=null) {
            return true;
        }
        return false;
    }

    public boolean logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.clear();
        editor.apply();

        return true;
    }
}
