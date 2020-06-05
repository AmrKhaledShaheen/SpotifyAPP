package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Creditcard extends AppCompatActivity {
    SharedPreferences sharedPreferences;
public boolean premium=false;
    public Button Start_button;
    public void yrb(View view)
    {
        wee(this);

    }
    public void wee(Context context)
    {
        SharedPreferences settings2 = context.getSharedPreferences("spotify", Context.MODE_PRIVATE);
        settings2.edit().clear().commit();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditcard);

        final EditText credit_number=(EditText)findViewById(R.id.CreditNumber_edittext);
        final TextView warning=(TextView)findViewById(R.id.warning_text);
        warning.setVisibility(View.INVISIBLE);
        credit_number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String x = credit_number.getText().toString();

//                if(!x.matches("[0-9]+"))
//                {
//                    System.out.println("wew");
//                }
                if(!(credit_number.getText().length()==14) || !(x.matches("[0-9]+")) )
                {
                    System.out.println(x.length());
                    warning.setVisibility(View.VISIBLE);
                }
                else{
                    warning.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




        //////////////////////
        Start_button = (Button) findViewById(R.id.Start_button);
        Start_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SharedPreferences result_premium = getSharedPreferences("spotify", 0);
                premium = result_premium.getBoolean("premium", false);
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
            sharedPreferences=getSharedPreferences("spotify", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor= sharedPreferences.edit();
            editor.putBoolean("premium",premium);
            editor.commit();
        }

}
