package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * This is the begining activity in sign in process
 * https://www.youtube.com/watch?v=GP5OyYDu_mU used to understand post and get methods
 * @version 1.0
 */
public class LoginActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    /**
     * EditText for user to write username and password in each one for login request
     */
    private EditText username,password;

    /**
     * Button to send request to backend to check if username/password are correct
     */
    private Button login;
    /**
     * Call is for fake server it has list of objects (post) which has many variables as username / email / password
     */
    private Call<List<Post>> call;
    /**
     * DataServer is for accessing fake server and to load the file with data in it
     */
    private DataServer dataServer;

    /**
     * TextWatcher is to check by every adding letter to check if this can be an email or username and to allow user to click on login button
     */

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


        }
    };

    /*void showpass(View view) {
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }*/

    /**
     * checks if username and password EditText are not empty to make login button enabled to be clicked
     */
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

    /**
     * opens the next activity
     * @see ForgotPasswordActivity
     * @param view
     */
    public void forgotpassword(View view)
    {
        Intent intent=new Intent(this, ForgotPasswordActivity.class);
        startActivity(intent);

    }
    /*public void email_usernameHighlight(View view)
    {
        return;
    }*/

    /**
     * gets called when clicked on button
     * checks if username and password are correct and goes to the next activity
     * @see
     * @param view
     */
    public void checkRequest(View view)
    {

        //String USERNAME="omar";
        //String PASSWORD="omar";

        username=(EditText) findViewById(R.id.email_usernameEditText);
        password=(EditText) findViewById(R.id.passwordEditText);
        final String Username=username.getText().toString();
        final String Password=password.getText().toString();
        call=dataServer.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(LoginActivity.this,"Code: " + response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Post> posts=response.body();

                for(Post post:posts)
                {
                    Log.i("login",Username);
                    Log.i("login",Password);
                    Log.i("check",post.getUsername());
                    Log.i("check",post.getPassword());
                    if((Username.equals(post.getUsername()) || Username.equals(post.getEmail())))
                    {
                        if(Password.equals(post.getPassword()))
                        {
                            Toast.makeText(LoginActivity.this,"Welcome!",Toast.LENGTH_SHORT).show();
                            TextView show=(TextView) findViewById(R.id.textView3);
                            System.out.println(Username);
                            editor.putString("currentEmail",Username).apply();
                            openHome();
                            return;
                        }
                        else
                        {
                            TextView show=(TextView) findViewById(R.id.textView3);
                            show.setText("Incorrect Password");
                            return;
                        }
                    }
                }
                TextView show=(TextView) findViewById(R.id.textView3);
                show.setText("This email and password combination is incorrect.");

            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(LoginActivity.this,t.getMessage().toString(),Toast.LENGTH_SHORT).show();
            }
        });

        //Toast.makeText(LoginActivity.this,"Welcome Omar!",Toast.LENGTH_SHORT).show();
        //Log.i("login","done");
        /*GlobalClass globalClass=new GlobalClass();
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
        }*/
    }

    /**
     * It adds TextChangedListener
     * It creates a retrofit way to access fake server and gets data from it
    // * @param savedInstanceState
     */

    protected  void openHome()
    {

        editor.putBoolean("firsttime",true);
        editor.apply();
        Intent intent=new Intent(this, HomePage.class);
        startActivity(intent);
        /*finish();
        Shared shared=new Shared(getApplicationContext());
        shared.SecondTime();*/
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences=getSharedPreferences("spotify", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        //SharedPreferences preferences=getSharedPreferences("sharedPrefs",MODE_PRIVATE);
        //preferences.edit().clear().commit();
        setContentView(R.layout.activity_login);
        username=(EditText) findViewById(R.id.email_usernameEditText);
        password=(EditText) findViewById(R.id.passwordEditText);
        // spannableString=new SpannableString("");
        username.addTextChangedListener(mTextWatcher);
        password.addTextChangedListener(mTextWatcher);
        checkFieldsForEmptyValues();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/AmrKhaledShaheen/SpotifyAPP/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        dataServer=retrofit.create(DataServer.class);


        //Toolbar toolbar=findViewById(R.id.toolbar)
    }
}