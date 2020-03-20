package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class LoginActivity extends AppCompatActivity {

    private EditText username,password;
    private Button login;
    private SpannableString spannableString;

    private TextWatcher mTextWatcher=new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            //String string=username.getText().toString();
            username.setPaintFlags(username.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
        }

        @Override
        public void afterTextChanged(Editable s) {
            checkFieldsForEmptyValues();
            if(spannableString.length()>0)
                username.setText(spannableString);

        }
    };

    void showpass(View view) {
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    void checkFieldsForEmptyValues() {
        //username.setText(spannableString);
        login=(Button) findViewById(R.id.login_button);
        String s1=username.getText().toString();
        String s2=password.getText().toString();
        if(s1.equals("") || s2.equals(""))
        {
            login.setEnabled(false);
            login.setBackgroundResource(R.drawable.rounded_button_login);
            login.setTextColor(getResources().getColor(R.color.grey));
        }
        else
        {
            login.setEnabled(true);
            login.setBackgroundResource(R.drawable.rounded_button_login2);
            login.setTextColor(getResources().getColor(R.color.black));
        }

    }
    public void forgotpassword(View view)
    {
        Intent intent=new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);
    }
    public void email_usernameHighlight(View view)
    {
        return;
    }

    public void checkRequest(View view)
    {
        //String USERNAME="omar";
        //String PASSWORD="omar";

        username=(EditText) findViewById(R.id.email_usernameEditText);
        password=(EditText) findViewById(R.id.passwordEditText);
        String Username=username.getText().toString();
        String Password=password.getText().toString();

        //Toast.makeText(LoginActivity.this,"Welcome Omar!",Toast.LENGTH_SHORT).show();
        //Log.i("login","done");
        GlobalClass globalClass=new GlobalClass();
        globalClass.addto_login("Omar","lifesucks");
        globalClass.addto_login("Sayed","hibye");
        globalClass.print();
        String msg=globalClass.check_login(Username,Password);
        if(msg=="both are right")
        {
            Toast.makeText(LoginActivity.this,"Welcome!",Toast.LENGTH_SHORT).show();
        }
        else if(msg=="wrong password")
        {
            Toast.makeText(LoginActivity.this,msg,Toast.LENGTH_SHORT).show();
        }
        else
        {
            TextView show=(TextView) findViewById(R.id.textView3);
            show.setText("This email and password combination is incorrect.");
            Toast.makeText(LoginActivity.this,msg,Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText) findViewById(R.id.email_usernameEditText);
        password=(EditText) findViewById(R.id.passwordEditText);
        spannableString=new SpannableString("");
        username.addTextChangedListener(mTextWatcher);
        password.addTextChangedListener(mTextWatcher);
        checkFieldsForEmptyValues();
        //Toolbar toolbar=findViewById(R.id.toolbar)
    }
}