package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ChooseArtist extends AppCompatActivity {

    private ImageView artist1true;
    private ImageView artist2true;
    private ImageView artist3true;
    private ImageView artist4true;
    private ImageView artist5true;
    private ImageView artist6true;
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
    }

    public void chooseMe(View view)
    {
        ImageView imageView=(ImageView) findViewById(view.getId());
        String string=imageView.getTag().toString();
        switch (string)
        {
            case "artist1":
                System.out.println("artist1");
                if(artist1true.getVisibility()==View.VISIBLE)
                    artist1true.setVisibility(View.INVISIBLE);
                else
                    artist1true.setVisibility(View.VISIBLE);
                break;
            case "artist2":
                System.out.println("artist2");
                if(artist2true.getVisibility()==View.VISIBLE)
                    artist2true.setVisibility(View.INVISIBLE);
                else
                    artist2true.setVisibility(View.VISIBLE);
                break;
            case "artist3":
                System.out.println("artist3");
                if(artist3true.getVisibility()==View.VISIBLE)
                    artist3true.setVisibility(View.INVISIBLE);
                else
                    artist3true.setVisibility(View.VISIBLE);
                break;
            case "artist4":
                System.out.println("artist4");
                if(artist4true.getVisibility()==View.VISIBLE)
                    artist4true.setVisibility(View.INVISIBLE);
                else
                    artist4true.setVisibility(View.VISIBLE);
                break;
            case "artist5":
                System.out.println("artist5");
                if(artist5true.getVisibility()==View.VISIBLE)
                    artist5true.setVisibility(View.INVISIBLE);
                else
                    artist5true.setVisibility(View.VISIBLE);
                break;
            case "artist6":
                System.out.println("artist6");
                if(artist6true.getVisibility()==View.VISIBLE)
                    artist6true.setVisibility(View.INVISIBLE);
                else
                    artist6true.setVisibility(View.VISIBLE);
                break;
        }
    }

    public void goSearch(View view)
    {
        Intent intent=new Intent(this, Searchartist.class);
        startActivity(intent);
    }

    public void saveArtists(View view)
    {
        return;
    }

}
