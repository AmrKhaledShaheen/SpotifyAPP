package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The second activity in signup process
 * @version 1.0
 */
public class CreatePass extends AppCompatActivity {

    /**
     * opens next activity
     * @see birthdate
     * @param view
     */

    public void OpenFourthSignup(View view)
    {

        Button buttonNext=(Button)findViewById(R.id.button);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animationscalebutton);
        buttonNext.startAnimation(animation);
        ///Open new window
        Intent intent= new Intent(this,birthdate.class);
        startActivity(intent);

    }

    /**
     * creates addTextChangedListener --> checks on password length if greater than 8 makes both textviews invisible and make button enabled and if less makes button disabled
     * creates setOnKeyListener checks on password length
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pass);
        EditText editext3=(EditText)findViewById(R.id.editText3);
        Button button=(Button)findViewById(R.id.button);

        editext3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                EditText editext3=(EditText)findViewById(R.id.editText3);
                Button button=(Button)findViewById(R.id.button);
                TextView textView=(TextView)findViewById(R.id.textView);
                TextView textview3=(TextView)findViewById(R.id.textView3);
                if(editext3.getText().length()>=8)
                {
                    button.setEnabled(true);
                    textView.setVisibility(View.INVISIBLE);
                    textview3.setVisibility(View.INVISIBLE);
                    editext3.setPressed(false);
                    editext3.setTextColor(Color.WHITE);

                }
                if(editext3.getText().length()<8)
                {
                     button.setEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editext3.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                EditText editext3=(EditText)findViewById(R.id.editText3);
                Button button=(Button)findViewById(R.id.button);
                TextView textView=(TextView)findViewById(R.id.textView);
                TextView textview3=(TextView)findViewById(R.id.textView3);
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    // this is for backspace
                    if(editext3.getText().length()<9)
                    {
                        button.setEnabled(false);
                        editext3.setTextColor(Color.RED);
                       // editext3.setFocusable(false);
                        editext3.setPressed(true);
                        textView.setVisibility(View.INVISIBLE);
                        textview3.setVisibility(View.VISIBLE);
                    }
                    if(editext3.getText().length()>9)
                    {
                        button.setEnabled(true);
                        editext3.setTextColor(Color.WHITE);
                    //    editext3.setFocusable(true);
                        editext3.setPressed(false);
                        textView.setVisibility(View.INVISIBLE);
                        textview3.setVisibility(View.INVISIBLE);

                    }

                }

                return false;
            }
        });
    }
}
