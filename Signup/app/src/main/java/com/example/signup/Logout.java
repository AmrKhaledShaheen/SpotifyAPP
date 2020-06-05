package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class Logout extends AppCompatActivity {

    public void logoutclicked(View view)
    {
    clear(this);
    }
    public void clear(Context context)
    {
        SharedPreferences settings2 = context.getSharedPreferences("spotify", Context.MODE_PRIVATE);
        settings2.edit().clear().commit();
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
    }
}
