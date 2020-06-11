package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Activity which allows user to promote his account to be premium
 * @version 1.0
 * To make horizontal imageview sllider
 *  https://www.youtube.com/watch?v=94rCjYxvzEE&t=989s
 *  https://www.youtube.com/watch?v=UsXv6VRqZKs
 */

public class Premiumm extends AppCompatActivity {
    Drawable spotify1,spotify2,library1,library2,home1,home2,search1,search2;
    private Button homeButton,searchButton,libraryButton,premiumButton;
    /**
     * send user to credit card activity to enter 14 number of credit card

     * @param view
     */
    public void GetPremium_button(View view)
    {
        Intent intent = new Intent(this, Creditcard.class);
        startActivity(intent);
        finish();
        Shared shared=new Shared(getApplicationContext());
        shared.Logout();
    }
    /**
     * send user to credit card activity to enter 14 number of credit card

     * @param view
     */
    public void Try_button(View view)
    {
        Intent intent = new Intent(this, Creditcard.class);
        startActivity(intent);
    }
    /**
     * opens home page

     * @param view
     */
    ///////////////////////////////////////////Toolbar
    public void goHome(View view)
    {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    /**
     * opens home premium
     *

     * @param view
     */
    public void goPremium(View view)
    {
        Intent intent = new Intent(this, Premiumm.class);
        startActivity(intent);
    }
    /**
     * opens library page

     * @param view
     */
    public void goLibrary(View view)
    {
        Intent intent = new Intent(this, Library.class);
        startActivity(intent);
    }
    public void goLogout(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Logout.class);
        startActivity(intent);

    }
///////////////////////////////////////////////////
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premiumm);


        /////////////////////////////////////// Premiumm betnawar////////////////////////////////

        homeButton=(Button) findViewById(R.id.homeButton);
        searchButton=(Button) findViewById(R.id.searchButton);
        libraryButton=(Button) findViewById(R.id.libraryButton);
        premiumButton=(Button) findViewById(R.id.premiumButton);
        spotify1=getResources().getDrawable(R.drawable.ic_spotify);
        spotify2=getResources().getDrawable(R.drawable.ic_spotify2);
        library1=getResources().getDrawable(R.drawable.ic_library);
        library2=getResources().getDrawable(R.drawable.ic_library2);
        search1=getResources().getDrawable(R.drawable.ic_search);
        search2=getResources().getDrawable(R.drawable.ic_search2);
        home1=getResources().getDrawable(R.drawable.ic_homee);
        home2=getResources().getDrawable(R.drawable.ic_homee2);
        home1.setBounds(0,0,130,130);
        home2.setBounds(0,0,130,130);
        spotify1.setBounds(0,0,130,130);
        spotify2.setBounds(0,0,130,130);
        library1.setBounds(0,0,130,130);
        library2.setBounds(0,0,130,130);
        search2.setBounds(0,0,130,130);
        search1.setBounds(0,0,130,130);
        premiumButton.setTextColor(Color.WHITE);
        premiumButton.setCompoundDrawables(null,spotify2,null,null);



        models=new ArrayList<>();
        models.add(new Model(R.drawable.s1));
        models.add(new Model(R.drawable.s2));
        models.add(new Model(R.drawable.s3));
        models.add(new Model(R.drawable.s4));
        models.add(new Model(R.drawable.s5));
        adapter=new Adapter(models,this);
        viewPager =findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,130,0);


    }
}
