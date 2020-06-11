package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * This an activity which shows albums
 * @version 1.0
 */

public class AlbumsView extends AppCompatActivity {
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
        setContentView(R.layout.activity_albums_view);
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

    /**
     * opens library activity
     * @see Library
     * @param view
     */

    public void playlistsCall(View view)
    {
        Intent intent=new Intent(this, Library.class);
        startActivity(intent);
    }

    /**
     * opens premium activity
     * @see Premiumm
     * @param view
     */
    public void goPremium(View view)
    {
        Intent intent=new Intent(this, Premiumm.class);
        startActivity(intent);
    }

    /**
     * opens home activity
     * @see HomePage
     * @param view
     */
    public void goHome(View view)
    {
        Intent intent=new Intent(this, HomePage.class);
        startActivity(intent);
    }
    /**
     * opens searchartist activity
     * @see Searchartist
     * @param view
     */
    public void goSearch(View view)
    {
        Intent intent=new Intent(this, Searchartist.class);
        startActivity(intent);
    }
    /**
     * opens artist activity
     * @see ArtistsView
     * @param view
     */
    public void openArtistsView(View view)
    {
        Intent intent=new Intent(this, ArtistsView.class);
        startActivity(intent);
    }
}
