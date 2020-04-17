package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.List;

public class Library extends AppCompatActivity {

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
    Drawable[] drawableArray={spotify1,spotify2,search1,search2,home1,home2,library1,library2};
    Button [] buttonsArray={homeButton,libraryButton,searchButton,premiumButton};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContent(R.layout.activity_home);
        homeButton.setCompoundDrawables(null,home2,null,null);
        homeButton.setTextColor(Color.WHITE);



    }
    public void setContent(int id)
    {
        setContentView(id);
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
    }
    /*public void setImgBounds()
    {
        Log.i("dss","ERROR");
        for(int i=0;i<drawableArray.length;i++)
        {
            Log.i("ERORRSARASRASR","sdadasdas");
            drawableArray[i].setBounds(0,0,130,130);
        }

    }*/
    public void de7k(View view){
        System.out.println("SASDASD");
    }
    public void playlistsCall(View view)
    {
        setContent(R.layout.activity_library);
        playlistsButton.setTextColor(Color.WHITE);
    }
    public void artistsCall(View view)
    {
        setContent(R.layout.activity_artist1);
        artistsButton.setTextColor(Color.WHITE);


    }
    public void albumsCall(View view)
    {
        return;
        //setContent(R.layout.activity_library);
        //albums.setTextColor(Color.WHITE);
    }
    public void goHome(View view)
    {
        setContent(R.layout.activity_home);
        resetAll();
        homeButton.setTextColor(Color.WHITE);
        Log.i("HOHOOOO","FASSDA");
        homeButton.setCompoundDrawables(null, home2, null, null);


    }
    public void goSearch(View view)
    {
        resetAll();
        searchButton.setTextColor(Color.WHITE);
        searchButton.setCompoundDrawables(null,search2,null,null);
    }
    public void goLibrary(View view)
    {
        setContent(R.layout.activity_library);
        resetAll();
        libraryButton.setTextColor(Color.WHITE);

        libraryButton.setCompoundDrawables(null,library2,null,null);
    }
    public void goPremium(View view)
    {
        resetAll();
        premiumButton.setTextColor(Color.WHITE);


        premiumButton.setCompoundDrawables(null,spotify2,null,null);
    }
    public void showCreate(View view)
    {
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.playlistLayout);
        linearLayout.setVisibility(View.VISIBLE);
    }
    public void resetAll()
    {
        homeButton.setTextColor(getResources().getColor(R.color.greyHome));
        libraryButton.setTextColor(getResources().getColor(R.color.greyHome));
        searchButton.setTextColor(getResources().getColor(R.color.greyHome));
        premiumButton.setTextColor(getResources().getColor(R.color.greyHome));
        homeButton.setCompoundDrawables(null,home1,null,null);
        premiumButton.setCompoundDrawables(null,spotify1,null,null);
        searchButton.setCompoundDrawables(null,search1,null,null);
        libraryButton.setCompoundDrawables(null,library1,null,null);
    }
    public void hidePlaylist(View view)
    {
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.playlistLayout);
        linearLayout.setVisibility(View.INVISIBLE);
    }
    public void createPlaylist(View view)
    {
        LinearLayout linearLayout=(LinearLayout) findViewById(R.id.playlistLayout);
        linearLayout.setVisibility(View.INVISIBLE);
        Button button=new Button(this);
        EditText editText=(EditText) findViewById(R.id.playlistName);
        Button playlist=(Button) findViewById(R.id.createplaylistButton);
        button.setTextSize(22);
        button.setAllCaps(false);
        button.setText("  " + editText.getText().toString());
        editText.setText("");
        //button.setWidth(playlist.getWidth());
        //button.setPadding(10,0,0,0);
        button.setBackgroundColor(Color.BLACK);
        Drawable img=getResources().getDrawable(R.drawable.ic_music);
        img.setBounds(0,0,182,182);
        LinearLayout l=(LinearLayout) findViewById(R.id.allplaylistLayout);
        LinearLayout.LayoutParams k=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        button.setCompoundDrawables(img,null,null,null);
        button.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
        l.addView(button,k);
    }

    public void chooseArtist(View view)
    {
        Button b=(Button) findViewById(R.id.chooseartistButton);
        Intent intent=new Intent(this, Artist.class);
        startActivity(intent);
    }

}
