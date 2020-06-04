package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class Singers_Songs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String sessionId = getIntent().getStringExtra("EXTRA_SESSION_ID");
        Toast.makeText(this, sessionId, Toast.LENGTH_SHORT).show();
        String nancy="nancy";
        String amr="amr";
        String tamer="tamer";
        String hamaki="hamaki";
        if (sessionId.matches(nancy))
        {
            setContentView(R.layout.nancy_ajram);
        }
        if(sessionId.matches(amr))
        {
            setContentView(R.layout.amr_diab);
        }
        if(sessionId.matches(tamer))
        {
            setContentView(R.layout.tamer_hosny);
        }
        if(sessionId.matches(hamaki))
        {
            setContentView(R.layout.mohamed_hamaki);
        }
    }
}
