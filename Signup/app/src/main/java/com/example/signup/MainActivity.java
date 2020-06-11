package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


/**
 * The main activity for the Application
 * @verison 1.0
 * This is the first screen the user sees
 */

public class MainActivity extends AppCompatActivity {


    /**
     * opens next activity
     * @see LoginActivity
     * @param view
     */
    public void viewLogInPage(View view)
{
        //Button Signup_button=(Button)findViewById(R.id.Login_button);
        Intent intent= new Intent(this,LoginActivity.class);
        startActivity(intent);
        //Animation animation = AnimationUtils.loadAnimation(this,R.anim.animationscalebutton);
        //Signup_button.startAnimation(animation);
}

    /**
     * opens next activity
     * @see Activity2
     * creates animation for button
     * @param view
     */

public void OpenSecondSignup(View view)
{
    Button Signup_button=(Button)findViewById(R.id.Signup_button);
    Intent intent= new Intent(this,Activity2.class);
    startActivity(intent);
    Animation animation = AnimationUtils.loadAnimation(this,R.anim.animationscalebutton);
    Signup_button.startAnimation(animation);
}

    /**
     * creates animation
     * @param view
     */
    public void FbClick(View view)
{
    Button Fb_button=(Button)findViewById(R.id.Facebook_button);
    Animation animation = AnimationUtils.loadAnimation(this,R.anim.animationscalebutton);
    Fb_button.startAnimation(animation);
    Intent intent= new Intent(this,HomePage.class);
    startActivity(intent);
}

    /*public void openLibrary()
    {
        Intent intent= new Intent(this,Library.class);
        startActivity(intent);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Boolean check;
        SharedPreferences test = getSharedPreferences("spotify", 0);
        check = test.getBoolean("firsttimei", false);
        if(check)
        {
            Intent intent= new Intent(this,HomePage.class);
            startActivity(intent);
        }
    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        Shared shared=new Shared(getApplicationContext());
//        shared.FirstTime();
//    }
}
