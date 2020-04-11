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
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @version 1.0
 * This activity opens when user forgets his password and wants to get it back using his email
 */
public class ForgotPasswordActivity extends AppCompatActivity {
    /**
     * Call is for fake server it has list of objects (post) which has many variables as username / email / password
     */
    /**
     * a pattern to check if the email is written in the right way
     */
    String emailPattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.+[a-z]+";
    private Call<List<Post>> call;
    /**
     * Button for the user to click on
     */
    /**
     * DataServer is for accessing fake server and to load the file with data in it
     */
    private DataServer dataServer;
    private Button getlink;
    /**
     * EditText for the user to type username in it
     */
    private EditText username;
    /**
     *
     */
    private TextView textView2;
    private String emailForPasswordBackUp;
    /**
     * TextWatcher to check condition of email/username gets called automatically when activity is opened
     */
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

    /**
     * gets called by textwatcher always when user is entering username or email to check if its the correct way
     */
    void checkFieldsForEmptyValues() {


        username=(EditText) findViewById(R.id.email_usernameEditText2);
        String s1 = username.getText().toString();
        if (s1.equals("") || !(username.getText().toString().matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.+com+"))) {

            getlink.setEnabled(false);
            getlink.setBackgroundResource(R.drawable.rounded_button_login);
            getlink.setTextColor(getResources().getColor(R.color.grey));
        }
        else if(username.getText().toString().matches("[a-zA-Z0-9._-]+@[a-zA-Z0-9]+\\.+com+"))
        {


            getlink.setEnabled(true);
            getlink.setBackgroundResource(R.drawable.rounded_button_login2);
            getlink.setTextColor(getResources().getColor(R.color.black));
        }
    }

    /**
     * checks if email is valid and is correct and has an account
     * @param view
     */
    public void getLinkFunction(View view)
    {
        call=dataServer.getPosts();

        getlink=(Button) findViewById(R.id.getLink_button);
        username=(EditText) findViewById(R.id.email_usernameEditText2);
        final String email=username.getText().toString();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(ForgotPasswordActivity.this,"Code: " + response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Post> posts=response.body();

                for(Post post:posts) {

                    if(email.equals(post.getEmail()))
                    {
                        emailForPasswordBackUp=email;
                        textView2.setText("Correct Email");
                        return;
                    }


                }
                textView2.setText("Wrong Email");
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

            }
        });
        Toast.makeText(ForgotPasswordActivity.this,email,Toast.LENGTH_LONG).show();

    }



    /**
     * It adds TextChangedListener
     * It creates a retrofit way to access fake server and gets data from it
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        username=(EditText) findViewById(R.id.email_usernameEditText2);
        getlink = (Button) findViewById(R.id.getLink_button);
        username.addTextChangedListener(mTextWatcher);
        textView2=(TextView) findViewById(R.id.textView2);
        checkFieldsForEmptyValues();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/AmrKhaledShaheen/SpotifyAPP/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        dataServer=retrofit.create(DataServer.class);
    }

}