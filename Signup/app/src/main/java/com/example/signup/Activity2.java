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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Activity2 extends AppCompatActivity {
    String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.+[a-z]+";
    EditText editTextEmail;
    Button buttonNext;
    TextView text1;
    TextView text2;
    boolean x=false;
    String y="0";

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
            DataServer dataServer = retrofit.create(DataServer.class);
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
            ///Open new window
            Intent intent = new Intent(this, CreatePass.class);
            startActivity(intent);
            /////
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