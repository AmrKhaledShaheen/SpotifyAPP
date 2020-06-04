package com.example.signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The fifth activity in signup process
 * @version 1.0
 */
public class Createfinal extends AppCompatActivity {
SharedPreferences sharedPreferences;



    /**
     * creates textChangedListener
     * checks length if its correct
     * enable button and change colors
     * and if it's incorrect it disable button
     * sets text style
     * determines words to open terms and conditions and privacy
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createfinal);
        EditText Nameedittext=(EditText)findViewById(R.id.Nameedittext);
        Nameedittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText Nameedittext=(EditText)findViewById(R.id.Nameedittext);
                Button CreateButton = (Button)findViewById(R.id.Createbutton);

                if(Nameedittext.getText().toString().length()+1>0)
                {
                    Nameedittext.setPressed(true);
                    //Nameedittext.setEnabled(false);
                    CreateButton.setEnabled(true);
                    CreateButton.setTextColor(Color.BLACK);
                }
                if(Nameedittext.getText().toString().length()==0)
                {
                     Nameedittext.setPressed(false);
                    //Nameedittext.setEnabled(true);
                    CreateButton.setEnabled(false);
                    CreateButton.setTextColor(R.color.Create);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        TextView terms= findViewById(R.id.TermsText);
        String text1="By creating an account, you agree to Spotify's Terms of        \n                                             Service.";
        SpannableString ss1= new SpannableString(text1);
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {

                Toast.makeText(Createfinal.this, "should be Terms Page!", Toast.LENGTH_SHORT).show();
            }
        };
        ClickableSpan clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {

                Toast.makeText(Createfinal.this, "should be Terms Page!", Toast.LENGTH_SHORT).show();
            }
        };
        ForegroundColorSpan t1 =new ForegroundColorSpan(Color.WHITE);
        ForegroundColorSpan t2 =new ForegroundColorSpan(Color.WHITE);
        BackgroundColorSpan t11 = new BackgroundColorSpan(Color.BLACK);
        BackgroundColorSpan t22 = new BackgroundColorSpan(Color.BLACK);
        ss1.setSpan(clickableSpan1,47,55, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        ss1.setSpan(clickableSpan2,109,117, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE );
        ss1.setSpan(t2,109,117,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss1.setSpan(t1,47,55,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss1.setSpan(t22,109,117,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss1.setSpan(t11,47,55,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        terms.setText(ss1);
        terms.setMovementMethod(LinkMovementMethod.getInstance());
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        TextView Privacy= findViewById(R.id.PrivacyText);
        String text2="To learn more about how Spotify collects,  uses,  shares  \n  and protects your personal data please read Spotify's \n                                       Privacy policy";
        SpannableString ss2= new SpannableString(text2);
        ClickableSpan clickableSpan3= new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {

                Toast.makeText(Createfinal.this, "Should be Privacy Page!", Toast.LENGTH_SHORT).show();
            }
        };
        ForegroundColorSpan t3 =new ForegroundColorSpan(Color.WHITE);
        BackgroundColorSpan t33 = new BackgroundColorSpan(Color.BLACK);
        ss2.setSpan(clickableSpan3,155,169,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss2.setSpan(t3,155,169,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss2.setSpan(t33,155,169,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        Privacy.setText(ss2);
        Privacy.setMovementMethod(LinkMovementMethod.getInstance());
    }
    public void Createbutton (View view)
    {
        Button CreateButton=(Button)findViewById(R.id.Createbutton);
        EditText Nameedittext=(EditText)findViewById(R.id.Nameedittext);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animationscalebutton);
        CreateButton.startAnimation(animation);
        //send username
        sharedPreferences=getSharedPreferences("username", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("username",Nameedittext.getText().toString());
        editor.apply();
        ///Open new window
        Intent intent = new Intent(getApplicationContext(), HomePage.class);
        startActivity(intent);
    }
}
