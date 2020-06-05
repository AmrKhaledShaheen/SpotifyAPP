package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Library extends AppCompatActivity {

    private Button playlistsButton,artistsButton,albums,homeButton,searchButton,libraryButton,premiumButton,createplaylistButton,addplaylistButton;
    private int k=1;
    private EditText newplaylistEditText;
    LinearLayout createplaylistLinearLayout,allplaylistsLinearLayout;
    Drawable spotify1,spotify2,library1,library2,home1,home2,search1,search2;
    Drawable[] drawableArray={spotify1,spotify2,search1,search2,home1,home2,library1,library2};
    Button [] buttonsArray={homeButton,libraryButton,searchButton,premiumButton};
    private DataServer dataServer;

    /// SharedPrefs /////
    public static final String SHARED_PREFS="sharedPrefs";
    public static final String playlists_Number="playlists_Number";
    private int playlists_count;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        ///////// Create playlist linear layout and its children
        createplaylistLinearLayout=(LinearLayout) findViewById(R.id.createplaylistLinearLayout);
        addplaylistButton=(Button) findViewById(R.id.addplaylistButton);
        newplaylistEditText=(EditText) findViewById(R.id.newplaylistEditText);

        //////// all created playlists linear layout and its children
        allplaylistsLinearLayout=(LinearLayout) findViewById(R.id.allplaylistsLayout);
        createplaylistButton=(Button) findViewById(R.id.createplaylistButton);



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
        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/AmrKhaledShaheen/SpotifyAPP/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        dataServer=retrofit.create(DataServer.class);
        createPost();*/
        loadData();
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
   /* public void artistsCall(View view)
    {
        setContent(R.layout.activity_artists_view);
        artistsButton.setTextColor(Color.WHITE);


    }*/
    public void albumsCall(View view)
    {
        Intent intent=new Intent(this, AlbumsView.class);
        startActivity(intent);
    }
    public void goHome(View view)
    {
        Intent intent=new Intent(this, HomePage.class);
        startActivity(intent);
    }

    public void goSearch(View view)
    {
        /*resetAll();
        searchButton.setTextColor(Color.WHITE);
        searchButton.setCompoundDrawables(null,search2,null,null);*/
    }
    /*public void goLibrary(View view)
    {
        setContent(R.layout.activity_library);
        resetAll();
        libraryButton.setTextColor(Color.WHITE);

        libraryButton.setCompoundDrawables(null,library2,null,null);
    }*/
    public void goPremium(View view)
    {
        /*resetAll();
        premiumButton.setTextColor(Color.WHITE);


        premiumButton.setCompoundDrawables(null,spotify2,null,null);*/
        Intent intent=new Intent(this, Premiumm.class);
        startActivity(intent);
    }
    public void showCreate(View view)
    {

        createplaylistLinearLayout.setVisibility(View.VISIBLE);
    }
    public void resetAll()
    {
        /*homeButton.setTextColor(getResources().getColor(R.color.greyHome));
        libraryButton.setTextColor(getResources().getColor(R.color.greyHome));
        searchButton.setTextColor(getResources().getColor(R.color.greyHome));
        premiumButton.setTextColor(getResources().getColor(R.color.greyHome));
        homeButton.setCompoundDrawables(null,home1,null,null);
        premiumButton.setCompoundDrawables(null,spotify1,null,null);
        searchButton.setCompoundDrawables(null,search1,null,null);
        libraryButton.setCompoundDrawables(null,library1,null,null);*/
    }
    public void hidePlaylist(View view)
    {

        createplaylistLinearLayout.setVisibility(View.INVISIBLE);
    }
    public void createPlaylist(View view)
    {
        String koko;
        createplaylistLinearLayout.setVisibility(View.INVISIBLE);
        Button button=new Button(this);

        button.setTextSize(22);
        button.setAllCaps(false);
        button.setText("  " + newplaylistEditText.getText().toString());
        koko=newplaylistEditText.getText().toString();
        newplaylistEditText.setText("");
        //button.setWidth(playlist.getWidth());
        //button.setPadding(10,0,0,0);
        button.setBackgroundColor(Color.BLACK);
        Drawable img=getResources().getDrawable(R.drawable.ic_music);
        img.setBounds(0,0,182,182);
        LinearLayout.LayoutParams k=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        button.setCompoundDrawables(img,null,null,null);
        button.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
        allplaylistsLinearLayout.addView(button,k);
        playlists_count++;
        saveData(koko);
    }
    public void openArtistsView(View view)
    {
        Intent intent=new Intent(this, ArtistsView.class);
        startActivity(intent);
    }

    public void saveData(String koko)
    {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(playlists_Number,playlists_count);
        editor.putString("playlist"+playlists_count,koko);
        editor.apply();
    }

    public void loadData() {

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        playlists_count = sharedPreferences.getInt(playlists_Number, 0);

        System.out.println(playlists_count);
        for (int i = 1; i <= playlists_count; i++)
        {
            String playlistName=sharedPreferences.getString("playlist"+i,"koko");
            Button button=new Button(this);

            button.setTextSize(22);
            button.setAllCaps(false);
            button.setText("  " + playlistName);

            //button.setWidth(playlist.getWidth());
            //button.setPadding(10,0,0,0);
            button.setBackgroundColor(Color.BLACK);
            Drawable img=getResources().getDrawable(R.drawable.ic_music);
            img.setBounds(0,0,182,182);
            LinearLayout.LayoutParams k=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            button.setCompoundDrawables(img,null,null,null);
            button.setGravity(Gravity.LEFT|Gravity.CENTER_VERTICAL);
            allplaylistsLinearLayout.addView(button,k);
        }
    }



    /*public void chooseArtist(View view)
    {
        Button b=(Button) findViewById(R.id.chooseartistButton);
        Intent intent=new Intent(this, Artist.class);
        startActivity(intent);
    }*/
   /* private void createPost(){
        Post post =new Post("asfg","fasdads","dsadsaddas","dsadsasda","dssdsdsd");
        Call<Post> call=dataServer.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    //
                    return;
                }
                Post postResponse=response.body();
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });

    }*/
}
