package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {





public void viewLogInPage(View view)
{
        //Button Signup_button=(Button)findViewById(R.id.Login_button);
        Intent intent= new Intent(this,LoginActivity.class);
        startActivity(intent);
        //Animation animation = AnimationUtils.loadAnimation(this,R.anim.animationscalebutton);
        //Signup_button.startAnimation(animation);
}


public void OpenSecondSignup(View view)
{
    Button Signup_button=(Button)findViewById(R.id.Signup_button);
    Intent intent= new Intent(this,Activity2.class);
    startActivity(intent);
    Animation animation = AnimationUtils.loadAnimation(this,R.anim.animationscalebutton);
    Signup_button.startAnimation(animation);
}

public void FbClick(View view)
{
    Button Fb_button=(Button)findViewById(R.id.Facebook_button);
    Animation animation = AnimationUtils.loadAnimation(this,R.anim.animationscalebutton);
    Fb_button.startAnimation(animation);
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
