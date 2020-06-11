package com.example.signup;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This is the begining activity in sign up process
 * For shared preferences we use help from this https://youtu.be/GD1Z3LrZac8
 * For mock server we use retrofit with help from this small course https://www.youtube.com/playlist?list=PLrnPJCHvNZuCbuD3xpfKzQWOj3AXybSaM
 * @version 1.0
 */


public class Activity2 extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    DataServer dataServer;
    /**
     * emailPattern is to check validation of right way for an email
     */
    String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.+[a-z]+";
    /**
     * editText it's a place where user write his email
     */
    EditText editTextEmail;
    /**
     * Button for user to click on to open next activity
     */
    Button buttonNext;
    /**
     * TextView to show messages to user
     */
    TextView text1;
    TextView text2;
    /**
     * boolean x to allow user to click on button Next for the first time
      */
    boolean x=false;
    /**
     * String y to check if username is already registered or not
     */
    String y="0";

    /**
     * checks if email is written a right way(with .com) to enable button or disable button and also to change visibility text1 and text2
     * Checks if email is in database

     * @param view
     */

    public void OpenThirdSignup(View view)
    {
        editTextEmail=findViewById(R.id.emailtext);
        buttonNext=findViewById(R.id.Next_first);
        text1=findViewById(R.id.confirm_text);
        text2=findViewById(R.id.confirm_text2);

        Button buttonNext=(Button)findViewById(R.id.Next_first);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.animationscalebutton);
        buttonNext.startAnimation(animation);
        if (editTextEmail.getText().toString().matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.+com+"))
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://my-json-server.typicode.com/AmrKhaledShaheen/SpotifyAPP/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
             dataServer = retrofit.create(DataServer.class);
            Call<List<Post>> call= dataServer.getPosts();
            call.enqueue(new Callback<List<Post>>() {
                @Override
                public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                    if(!response.isSuccessful())
                    {
                        Toast.makeText(Activity2.this, "Code:   " + response.code(), Toast.LENGTH_SHORT).show();
                        return;
                    }
                    List<Post>posts=response.body();
                    for(Post post :posts)
                    {
                        // Log.i("mesg0",String.valueOf(y));
                        if(editTextEmail.getText().toString().equals(post.getEmail()))
                        {
                            y="1";

                        }

                    }
                    checkintent(y);
                }

                @Override
                public void onFailure(Call<List<Post>> call, Throwable t) {
                    Toast.makeText(Activity2.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
            Log.i("mesg",String.valueOf(y));
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
        //checkintent(y);
    }

    /**
     * gets called from function OpenThirdSignUp
     * If y=0
     * opens next activity
     * @see CreatePass
     * If y=1
     * opens login activity
     * @see LoginActivity
     * @param y
     */
    public void checkintent(String y)
    {
        if(y=="1")
        {

            ///Open new window
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
        if(y=="0") {
            Toast.makeText(this, editTextEmail.getText().toString() +"\n"+"sent to backend", Toast.LENGTH_SHORT).show();
            //send the email
            sharedPreferences=getSharedPreferences("spotify", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putString("email",editTextEmail.getText().toString());
            editor.apply();
            ///Open new window
            Intent intent = new Intent(getApplicationContext(), CreatePass.class);
            startActivity(intent);
            /////
        }
    }

    /**
     * calls function onText
     * adds textChangeListener(checks length of email to enable button or disable it)
     * also checks if email is written in right way
     * @param savedInstanceState
     */
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
                    text1.setVisibility(View.VISIBLE);
                    text2.setVisibility(View.INVISIBLE);
                    editTextEmail.setFocusable(true);
                    editTextEmail.setPressed(false);
                    editTextEmail.setTextColor(Color.WHITE);
                }
                else if(emailInput.matches(""))
                {
                    text1.setVisibility(View.VISIBLE);
                    text2.setVisibility(View.INVISIBLE);
                    editTextEmail.setFocusable(true);
                    editTextEmail.setPressed(false);
                    editTextEmail.setTextColor(Color.WHITE);
                    buttonNext.setEnabled(false);
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}