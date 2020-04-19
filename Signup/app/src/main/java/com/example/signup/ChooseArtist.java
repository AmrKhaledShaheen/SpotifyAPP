package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;

import static android.view.View.VISIBLE;

public class ChooseArtist extends AppCompatActivity {

    private ImageView artist1true,artist2true,artist3true,artist4true,artist5true,artist6true;
    private TextView artist1TextView,artist2TextView,artist3TextView,artist4TextView,artist5TextView,artist6TextView;
    private ImageView artist1ImageView,artist2ImageView,artist3ImageView,artist4ImageView,artist5ImageView,artist6ImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_artist);
        artist1true=(ImageView) findViewById(R.id.artist1true);
        artist2true=(ImageView) findViewById(R.id.artist2true);
        artist3true=(ImageView) findViewById(R.id.artist3true);
        artist4true=(ImageView) findViewById(R.id.artist4true);
        artist5true=(ImageView) findViewById(R.id.artist5true);
        artist6true=(ImageView) findViewById(R.id.artist6true);
        artist1TextView=(TextView) findViewById(R.id.artist1textView);
        artist2TextView=(TextView) findViewById(R.id.artist2textView);
        artist3TextView=(TextView) findViewById(R.id.artist3textView);
        artist4TextView=(TextView) findViewById(R.id.artist4textView);
        artist5TextView=(TextView) findViewById(R.id.artist5textView);
        artist6TextView=(TextView) findViewById(R.id.artist6textView);
        artist1ImageView=(ImageView) findViewById(R.id.artist1imageView);
        artist2ImageView=(ImageView) findViewById(R.id.artist2imageView);
        artist3ImageView=(ImageView) findViewById(R.id.artist3imageView);
        artist4ImageView=(ImageView) findViewById(R.id.artist4imageView);
        artist5ImageView=(ImageView) findViewById(R.id.artist5imageView);
        artist6ImageView=(ImageView) findViewById(R.id.artist6imageView);
    }

    public void chooseMe(View view)
    {
        ImageView imageView=(ImageView) findViewById(view.getId());
        String string=imageView.getTag().toString();
        switch (string)
        {
            case "artist1":
                System.out.println("artist1");
                if(artist1true.getVisibility()== VISIBLE)
                    artist1true.setVisibility(View.INVISIBLE);
                else
                    artist1true.setVisibility(VISIBLE);
                break;
            case "artist2":
                System.out.println("artist2");
                if(artist2true.getVisibility()== VISIBLE)
                    artist2true.setVisibility(View.INVISIBLE);
                else
                    artist2true.setVisibility(VISIBLE);
                break;
            case "artist3":
                System.out.println("artist3");
                if(artist3true.getVisibility()== VISIBLE)
                    artist3true.setVisibility(View.INVISIBLE);
                else
                    artist3true.setVisibility(VISIBLE);
                break;
            case "artist4":
                System.out.println("artist4");
                if(artist4true.getVisibility()== VISIBLE)
                    artist4true.setVisibility(View.INVISIBLE);
                else
                    artist4true.setVisibility(VISIBLE);
                break;
            case "artist5":
                System.out.println("artist5");
                if(artist5true.getVisibility()== VISIBLE)
                    artist5true.setVisibility(View.INVISIBLE);
                else
                    artist5true.setVisibility(VISIBLE);
                break;
            case "artist6":
                System.out.println("artist6");
                if(artist6true.getVisibility()== VISIBLE)
                    artist6true.setVisibility(View.INVISIBLE);
                else
                    artist6true.setVisibility(VISIBLE);
                break;
        }
    }

    public void goSearch(View view)
    {
        Intent intent=new Intent(this, Searchartist.class);
        startActivity(intent);
    }

    @SuppressLint("SetTextI18n")
    public void savelikedArtists(View view)
    {
        int i=0;
        Intent intent=new Intent(this,ArtistsView.class);
        if(artist1true.getVisibility()==VISIBLE)
        {
            i++;
            String text=("  "+artist1TextView.getText().toString());

            intent.putExtra("button"+i+"text",text);
        }
        if(artist2true.getVisibility()==VISIBLE)
        {
            i++;
            String text=("  "+artist2TextView.getText().toString());

            intent.putExtra("button"+i+"text",text);
        }

        if(artist3true.getVisibility()==VISIBLE)
        {
            i++;
            String text=("  "+artist3TextView.getText().toString());

            intent.putExtra("button"+i+"text",text);
        }
        if(artist4true.getVisibility()==VISIBLE)
        {
            i++;
            String text=("  "+artist4TextView.getText().toString());

            intent.putExtra("button"+i+"text",text);
        }
        if(artist5true.getVisibility()==VISIBLE)
        {
            i++;
            String text=("  "+artist5TextView.getText().toString());

            intent.putExtra("button"+i+"text",text);
        }
        intent.putExtra("artistsnumber",i);
        startActivity(intent);
    }

}
