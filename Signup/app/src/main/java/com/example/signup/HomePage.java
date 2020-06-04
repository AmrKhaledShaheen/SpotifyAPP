package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
    String test;
    public void yrb(View view,List namesofliked)
    {
        Log.i("mesg", String.valueOf(namesofliked.size()));
        for(int i=0;i<3;i++)
      {
        if (namesofliked.get(i).equals("Amr Diab")) {
            ImageView firstlike = (ImageView) findViewById(R.id.FirstImageLiked);
            firstlike.setImageResource(R.drawable.amr_diab_liked);
            test="amr";
        }
        if (namesofliked.get(i).equals("Mohamed Hamaki")) {
            ImageView secondlike = (ImageView) findViewById(R.id.SecondImageLiked);
            secondlike.setImageResource(R.drawable.mohamed_hamaki_liked);
        }
          if (namesofliked.get(i).equals("Tamer hosny")) {
              ImageView thirdlike = (ImageView) findViewById(R.id.ThirdImageLiked);
              thirdlike.setImageResource(R.drawable.tamer_hosny_liked);
          }
          if (namesofliked.get(i).equals("Nancy ajram")) {
              ImageView firstlike_2 = (ImageView) findViewById(R.id.FirstImageLiked);
              firstlike_2.setImageResource(R.drawable.nancy_ajram_liked);
              test="nancy";
          }
      }
    }
    public void goHome(View view)
    {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    public void goPremium(View view)
    {
        Intent intent = new Intent(this, Premiumm.class);
        startActivity(intent);
    }
    public void goLibrary(View view)
    {
        Intent intent = new Intent(this, Library.class);
        startActivity(intent);
    }
    //////Images button
    //First
    public void first_image_clicked(View view)
    {
        Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
        intent.putExtra("EXTRA_SESSION_ID", test);
        startActivity(intent);
    }
    //Second
    public void SecondImageLiked(View view)
    {
        Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
        intent.putExtra("EXTRA_SESSION_ID", test);
        startActivity(intent);
    }
    //Third
    public void ThirdImageLiked(View view)
    {
        Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
        intent.putExtra("EXTRA_SESSION_ID", test);
        startActivity(intent);
    }
/////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        SharedPreferences result_email= getSharedPreferences("email", Context.MODE_PRIVATE);
        SharedPreferences result_password= getSharedPreferences("password", Context.MODE_PRIVATE);
        SharedPreferences result_username= getSharedPreferences("username", Context.MODE_PRIVATE);
        ////artists
        boolean Amr_Diab = true;
        boolean Mohamed_Hamaki= false;
        boolean Tamer_Hosny = true;
        boolean Nancy_Ajram= false;
        //get data
        String email =result_email.getString("email","Data not found"); //email
        String password =result_password.getString("password","Data not found"); // password
        String username =result_username.getString("username","Data not found"); // username
        Toast.makeText(this, email+"\n"+password+"\n"+username+"\n"+"hhhh", Toast.LENGTH_SHORT).show();
        //////////////names ly h5odha mn l backend/////////////////////////////////////////////
        List namesoflikedB = new ArrayList<String>();
        if (Amr_Diab) {
            namesoflikedB.add("Amr Diab");
        }
        if(Mohamed_Hamaki) {
            namesoflikedB.add("Mohamed Hamaki");
        }
        if(Tamer_Hosny) {
            namesoflikedB.add("Tamer hosny");
        }
        if(Nancy_Ajram) {
            namesoflikedB.add("Nancy ajram");
        }
        //////////////////////////////////////////////////////////////////
///////////////////////b5do fl array bt3y/////////////////////////
        List namesofliked = new ArrayList<String>();
        namesofliked=namesoflikedB;
        ////////////////////////////////////////////////////////////////////////////////////////
        ImageView x = null;
        yrb(x,namesofliked);
    }
}
