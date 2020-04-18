package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ArtistsView extends AppCompatActivity {
    private Button playlistsButton;
    private Button artistsButton;
    private Button albums;
    private Button homeButton;
    private Button searchButton;
    private Button libraryButton;
    private Button premiumButton;
    private int k=1;
    Drawable spotify1;
    Drawable spotify2;
    Drawable library1;
    Drawable library2;
    Drawable home1;
    Drawable home2;
    Drawable search1;
    Drawable search2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artists_view);
        playlistsButton=(Button) findViewById(R.id.playlistButton);
        artistsButton=(Button) findViewById(R.id.artistsButton);
        albums=(Button) findViewById(R.id.albumsButton);
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
        //setImgBounds();
        home1.setBounds(0,0,130,130);
        home2.setBounds(0,0,130,130);
        spotify1.setBounds(0,0,130,130);
        spotify2.setBounds(0,0,130,130);
        library1.setBounds(0,0,130,130);
        library2.setBounds(0,0,130,130);
        search2.setBounds(0,0,130,130);
        search1.setBounds(0,0,130,130);
        libraryButton.setTextColor(Color.WHITE);
        libraryButton.setCompoundDrawables(null,library2,null,null);
    }
    public void openChooseArtist(View view)
    {
        Intent intent=new Intent(this, ChooseArtist.class);
        startActivity(intent);
    }

    public void playlistsCall(View view)
    {
        Intent intent=new Intent(this, Library.class);
        startActivity(intent);
    }
    public void albumsCall(View view)
    {
        Intent intent=new Intent(this, AlbumsView.class);
        startActivity(intent);
    }
    public void goHome(View view)
    {
        return;
    }

    public void goPremium(View view)
    {
        return;
    }

    public void goSearch(View view)
    {
        return;
    }
    public void goLibrary(View view)
    {
        Intent intent=new Intent(this, Library.class);
        startActivity(intent);
    }
    /*public void resetAll()
    {
        homeButton.setTextColor(getResources().getColor(R.color.greyHome));
        libraryButton.setTextColor(getResources().getColor(R.color.greyHome));
        searchButton.setTextColor(getResources().getColor(R.color.greyHome));
        premiumButton.setTextColor(getResources().getColor(R.color.greyHome));
        homeButton.setCompoundDrawables(null,home1,null,null);
        premiumButton.setCompoundDrawables(null,spotify1,null,null);
        searchButton.setCompoundDrawables(null,search1,null,null);
        libraryButton.setCompoundDrawables(null,library1,null,null);
    }*/
}
