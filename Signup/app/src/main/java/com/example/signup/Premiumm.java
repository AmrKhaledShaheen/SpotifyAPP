package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class Premiumm extends AppCompatActivity {

    public void GetPremium_button(View view)
    {
        Intent intent = new Intent(this, Creditcard.class);
        startActivity(intent);
        finish();
        Shared shared=new Shared(getApplicationContext());
        shared.Logout();
    }
    public void Try_button(View view)
    {
        Intent intent = new Intent(this, Creditcard.class);
        startActivity(intent);
    }
    ///////////////////////////////////////////Toolbar
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
///////////////////////////////////////////////////
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_premiumm);
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
