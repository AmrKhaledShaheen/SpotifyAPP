package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Creditcard extends AppCompatActivity {
public boolean premium=false;
    public Button Start_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditcard);

        Start_button = (Button) findViewById(R.id.Start_button);
        Start_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(premium==true){
                    Toast.makeText(getApplicationContext(), "Your already premium.\n Enjoy it :)", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    sendMail();
                }
            }
        });
    }
        private void sendMail()
        {
            ///
            SharedPreferences result_email= getSharedPreferences("email", Context.MODE_PRIVATE);
//            SharedPreferences result_password= getSharedPreferences("password", Context.MODE_PRIVATE);
            String email =result_email.getString("email","Data not found");
//            String password =result_password.getString("password","Data not found");
//            Toast.makeText(this, email+"\n"+password, Toast.LENGTH_SHORT).show();
            ///
            String mEmail=email;
            String mSubject=" Spotify Premium";
            String message="Your account is premium now \n Enjoy it.";
            String mail=mEmail.trim();
            String subject=mSubject.trim();
            JavaMailAPI javaMailAPI=new JavaMailAPI(this,mail,subject,message);
            javaMailAPI.execute();
            premium=true;
        }

}
