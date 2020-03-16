package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity {
    String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.+[a-z]+";
    EditText editTextEmail;
    Button buttonNext;
    TextView text1;
    TextView text2;
    boolean x=false;

    public void OpenThirdSignup(View view)
    {   editTextEmail=findViewById(R.id.emailtext);
        buttonNext=findViewById(R.id.Next_first);
        text1=findViewById(R.id.confirm_text);
        text2=findViewById(R.id.confirm_text2);

        if (editTextEmail.getText().toString().matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.+com+"))
        {
        ///Open new window
        Intent intent = new Intent(this, CreatePass.class);
        startActivity(intent);
        /////
        }
        else
        {
            text1.setVisibility(View.INVISIBLE);
            text2.setVisibility(View.VISIBLE);
            editTextEmail.setFocusable(false);
            editTextEmail.setPressed(true);
            editTextEmail.setTextColor(Color.RED);
            buttonNext.setEnabled(false);
            x=true;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        editTextEmail=findViewById(R.id.emailtext);
        buttonNext=findViewById(R.id.Next_first);

        editTextEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String emailInput= editTextEmail.getText().toString().trim();
                //////////////////////////////////////
                if(emailInput.matches(emailPattern) && s.length() > 0 && !x )
                {
                        buttonNext.setEnabled(true);

                }
                else if(emailInput.matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.+com+"))
                {
                    buttonNext.setEnabled(true);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
