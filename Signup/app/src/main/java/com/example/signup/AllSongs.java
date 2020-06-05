package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AllSongs extends AppCompatActivity {
    private LinearLayout linearLayout;
    private TextView textView;
    private String [] songsName={"sugar","maps","zaymanty","bahebu","Wanta maaya","Helw elmakan","EL OMR","LYA","Ya Sattar","We A3mal Eih"};

    public AllSongs() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_songs);
        textView=(TextView)findViewById(R.id.textView_songs);
        linearLayout=(LinearLayout) findViewById(R.id.allsongsLinearLayout);
        loadSongs();

    }
    public void loadSongs()
    {
        LinearLayout.LayoutParams k=
                new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        k.setMargins(0,30,0,0);
        Drawable img=getResources().getDrawable(R.drawable.kafoury);
        for(int i=0;i<songsName.length;i++)
        {

            String name=songsName[i];
            Button button=new Button(this);
            switch (name)
            {
                case "sugar":
                    img=getResources().getDrawable(R.drawable.sugar);
                    break;
                case "maps":
                    img=getResources().getDrawable(R.drawable.maps);
                    break;
                case "zaymanty":
                    img=getResources().getDrawable(R.drawable.zaymanty);
                    break;
                case "bahebu":
                    img=getResources().getDrawable(R.drawable.bahebu);
                case "Wanta maaya":
                    img=getResources().getDrawable(R.drawable.wantamaaya);
                    break;
                case "Helw elmakan":
                    img=getResources().getDrawable(R.drawable.helwelmakan);
                case "El OMR":
                    img=getResources().getDrawable(R.drawable.elomr);
                    break;
                case "LYA":
                    img=getResources().getDrawable(R.drawable.lya);
                case "Ya Sattar":
                    img=getResources().getDrawable(R.drawable.yasattar);
                    break;
                case "We A3mal Eih":
                    img=getResources().getDrawable(R.drawable.wantamaaya);
                    break;
            }
            img.setBounds(0,0,160,160);
            button.setTextSize(22);
            button.setPadding(40,0,0,0);
            button.setAllCaps(false);
            button.setText("  "+name);
            button.setBackgroundColor(Color.BLACK);
            button.setCompoundDrawables(img,null,null,null);
            button.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
            linearLayout.addView(button,k);
        }

    }

}
