package com.example.csulb.wecare;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.jgabrielfreitas.core.BlurImageView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{


    private BlurImageView mLoginBackground;
    private Button mloginButton;
    private Button mSignUpButton;
    private TextView mforgotLoginTextView;

    private LoginButton loginFacebookButton;
    private FirebaseAuth mFacebookAuth;
    private CallbackManager mFacebookCallbackManager;
    private static final String TAG2 = "Facebook Sign in";
    private SignInButton googleLoginButton;
    private static final int RC_SIGN_IN = 196;
    private static final String TAG1 = "Google Sign in";
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mGoogleAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mLoginBackground = (BlurImageView)findViewById(R.id.loginBackgroundImageView);
        mLoginBackground.setBlur(1);

        mloginButton = (Button)findViewById(R.id.loginButton);
        mloginButton.setOnClickListener(this);
        mSignUpButton = (Button)findViewById(R.id.loginSignUpButton);
        mSignUpButton.setOnClickListener(this);


        //Facebook Sign in
        FacebookSdk.sdkInitialize(getApplicationContext());
        mFacebookAuth = FirebaseAuth.getInstance();
        mFacebookCallbackManager = CallbackManager.Factory.create();

        loginFacebookButton = (LoginButton) findViewById(R.id.loginFacebookButton);
        loginFacebookButton.setReadPermissions("email", "public_profile");
        loginFacebookButton.registerCallback(mFacebookCallbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Log.d(TAG2, "facebook:onSuccess:" + loginResult);
                        handleFacebookAccessToken(loginResult.getAccessToken());
                    }

                    @Override
                    public void onCancel() {
                        Log.d(TAG2, "facebook:onCancel");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Log.d(TAG2, "facebook:onError", exception);
                    }
                });


        //Facebook sign extends

        //Configure Google Sign in
        mGoogleAuth = FirebaseAuth.getInstance();
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(LoginActivity.this, gso);

        googleLoginButton= (SignInButton) findViewById(R.id.loginGoogleButton);
        googleLoginButton.setOnClickListener(this);
        //Google sign in extended
    }


    //Facebook sign in continues

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mFacebookAuth.getCurrentUser();

    }
    // [END on_start_check_user]

    // [START on_activity_result]
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result back to the Facebook SDK
        mFacebookCallbackManager.onActivityResult(requestCode, resultCode, data);
    }*/
    // [END on_activity_result]

    // [START auth_with_facebook]
    private void handleFacebookAccessToken(AccessToken token) {
        Log.d(TAG2, "handleFacebookAccessToken:" + token);

        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mFacebookAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG2, "signInWithCredential:success");
                            FirebaseUser user = mFacebookAuth.getCurrentUser();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG2, "signInWithCredential:failure", task.getException());
                            Toast.makeText(LoginActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }


                    }
                });
    }
    // [END auth_with_facebook]








    //Google sign in continues
        private void signIn() {
            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
            startActivityForResult(signInIntent, RC_SIGN_IN);
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
            if (requestCode == RC_SIGN_IN) {
                Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
                try {
                    // Google Sign In was successful, authenticate with Firebase
                    GoogleSignInAccount account = task.getResult(ApiException.class);
                    firebaseAuthWithGoogle(account);
                } catch (ApiException e) {
                    // Google Sign In failed, update UI appropriately
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }else{
                mFacebookCallbackManager.onActivityResult(requestCode, resultCode, data);
            }
        }

        private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
            Log.d(TAG1, "firebaseAuthWithGoogle:" + acct.getId());

            AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
            mGoogleAuth.signInWithCredential(credential)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG1, "signInWithCredential:success");
                                FirebaseUser user = mGoogleAuth.getCurrentUser();
                                Toast.makeText(LoginActivity.this, "User signed in successfully", Toast.LENGTH_SHORT).show();

                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG1, "signInWithCredential:failure", task.getException());
                                Toast.makeText(LoginActivity.this, "Authentication Failed.", Toast.LENGTH_SHORT).show();

                            }


                        }
                    });

            //Google Sign in ends here.

        }


    @Override
    public void onClick(View v) {
        if(v == mloginButton){
            login();
        }else if (v == mSignUpButton){
            signUp();
        } else if(v == googleLoginButton){
            signIn();
        } else if (v == mforgotLoginTextView){
            forgotLogin();
        }
    }

    private void forgotLogin() {

    }

    private void signUp() {
        finish();
        Intent intentSignUp = new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(intentSignUp);

    }

    private void login() {
    }


}
