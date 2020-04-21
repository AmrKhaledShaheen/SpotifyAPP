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
    }
    public void Try_button(View view)
    {
        Intent intent = new Intent(this, Creditcard.class);
        startActivity(intent);
    }

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
