package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class Gender extends AppCompatActivity {
    /**
     * opens next activity
     * @see Createfinal
     * @param view
     */
    public void Femaleonclick(View view)
    {

        Button MaleButton=(Button)findViewById(R.id.MaleButton);
        Button Femalebutton=(Button)findViewById(R.id.FemaleButton);
        Femalebutton.setTextColor(Color.WHITE);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animationscalebutton);
        Femalebutton.startAnimation(animation);
        MaleButton.setTextColor(Color.GRAY);

        Intent intent= new Intent(Gender.this,Createfinal.class);
        startActivity(intent);

    }
    /**
     * opens next activity
     * @see Createfinal
     * @param view
     */
    public void MaleClick(View view)
    {
        Button MaleButton=(Button)findViewById(R.id.MaleButton);
        Button Femalebutton=(Button)findViewById(R.id.FemaleButton);

        MaleButton.setTextColor(Color.WHITE);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animationscalebutton);
        MaleButton.startAnimation(animation);
        Femalebutton.setTextColor(Color.GRAY);

        Intent intent= new Intent(Gender.this,Createfinal.class);
        startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

    }
}
