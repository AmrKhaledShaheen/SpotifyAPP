package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPasswordActivity extends AppCompatActivity {

    private Button getlink;
    private EditText username;
    private TextWatcher mTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            username.setPaintFlags(username.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        }

        @Override
        public void afterTextChanged(Editable s) {
            checkFieldsForEmptyValues();
        }
    };

    void checkFieldsForEmptyValues() {


        username=(EditText) findViewById(R.id.email_usernameEditText2);
        String s1 = username.getText().toString();
        if (s1.equals("")) {

            getlink.setEnabled(false);
            getlink.setBackgroundResource(R.drawable.rounded_button_login);
            getlink.setTextColor(getResources().getColor(R.color.grey));
        } else {


            getlink.setEnabled(true);
            getlink.setBackgroundResource(R.drawable.rounded_button_login2);
            getlink.setTextColor(getResources().getColor(R.color.black));
        }
    }

    public void getLinkFunction(View view)
    {

        getlink=(Button) findViewById(R.id.getLink_button);
        username=(EditText) findViewById(R.id.email_usernameEditText2);
        String email=username.getText().toString();
        Toast.makeText(ForgotPasswordActivity.this,email,Toast.LENGTH_LONG).show();

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        username=(EditText) findViewById(R.id.email_usernameEditText2);
        getlink = (Button) findViewById(R.id.getLink_button);
        username.addTextChangedListener(mTextWatcher);
        checkFieldsForEmptyValues();
    }

}