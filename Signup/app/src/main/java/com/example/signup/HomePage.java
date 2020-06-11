package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * This is the home page when users log in or sign up
 * @version 1.0
 */

public class HomePage extends AppCompatActivity {
///////////////////////////////////////////////////////////////////////////////
DataServer dataServer;
private Call<List<Search>> call;

///////////////////////////////////////////////////////////////////////////////
    /**
     * String variables which take name of singers
     */
String img3_singer,img4_singer,img5_singer,img6_singer="";
    /**
     * Drawable files for toolbar below of (HOME,LIBRARY,SEARCH,PREMIUM)
     */
Drawable spotify1,spotify2,library1,library2,home1,home2,search1,search2;
    /**
     * Buttons which open activities (HOME,LIBRARY,SEARCH,PREMIUM)
     */
private Button homeButton,searchButton,libraryButton,premiumButton;
private SharedPreferences sharedPreferences;
private SharedPreferences.Editor editor;
//////////////////

SearchView mysearch;//////////
ListView mylist;//////////////
ArrayList<String> list;////////
ArrayAdapter<String> adapter;//
/////////////////////////////
    /**
     * Integer indicates number of liked artists
     */
private int numberofartists;

    /**
     * checks which singer i chooose then go to his/her activity

     * @param view
     */
public void img3_clicked(View view)
{
    if(img3_singer=="amr")
    {
        Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
        intent.putExtra("EXTRA_SESSION_ID", "amr");
        startActivity(intent);
    }
    else if(img3_singer=="tamer")
    {
        Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
        intent.putExtra("EXTRA_SESSION_ID", "tamer");
        startActivity(intent);
    }
    else if(img3_singer=="nancy")
    {
        Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
        intent.putExtra("EXTRA_SESSION_ID", "nancy");
        startActivity(intent);
    }
    else if(img3_singer=="hamaki")
    {
        Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
        intent.putExtra("EXTRA_SESSION_ID", "hamaki");
        startActivity(intent);
    }

}
    /**
     * checks which singer i chooose then go to his/her activity

     * @param view
     */
    public void img4_clicked(View view)
    {
        if(img4_singer=="amr")
        {
            Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
            intent.putExtra("EXTRA_SESSION_ID", "amr");
            startActivity(intent);
        }
        else if(img4_singer=="tamer")
        {
            Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
            intent.putExtra("EXTRA_SESSION_ID", "tamer");
            startActivity(intent);
        }
        else if(img4_singer=="nancy")
        {
            Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
            intent.putExtra("EXTRA_SESSION_ID", "nancy");
            startActivity(intent);
        }
        else if(img4_singer=="hamaki")
        {
            Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
            intent.putExtra("EXTRA_SESSION_ID", "hamaki");
            startActivity(intent);
        }

    }
    /**
     *  set the search visible

     * @param view
     */
    public void goSearch(View view)
    {
        mysearch.setVisibility(View.VISIBLE);
    }
    /**
     * checks which singer i chooose then go to his/her activity

     * @param view
     */
    public void img5_clicked(View view)
    {
        if(img5_singer=="amr")
        {
            Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
            intent.putExtra("EXTRA_SESSION_ID", "amr");
            startActivity(intent);
        }
        else if(img5_singer=="tamer")
        {
            Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
            intent.putExtra("EXTRA_SESSION_ID", "tamer");
            startActivity(intent);
        }
        else if(img5_singer=="nancy")
        {
            Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
            intent.putExtra("EXTRA_SESSION_ID", "nancy");
            startActivity(intent);
        }
        else if(img5_singer=="hamaki")
        {
            Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
            intent.putExtra("EXTRA_SESSION_ID", "hamaki");
            startActivity(intent);
        }

    }
    /**
     * checks which singer i chooose then go to his/her activity

     * @param view
     */
    public void img6_clicked(View view)
    {
        if(img6_singer=="amr")
        {
            Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
            intent.putExtra("EXTRA_SESSION_ID", "amr");
            startActivity(intent);
        }
        else if(img6_singer=="tamer")
        {
            Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
            intent.putExtra("EXTRA_SESSION_ID", "tamer");
            startActivity(intent);
        }
        else if(img6_singer=="nancy")
        {
            Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
            intent.putExtra("EXTRA_SESSION_ID", "nancy");
            startActivity(intent);
        }
        else if(img6_singer=="hamaki")
        {
            Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
            intent.putExtra("EXTRA_SESSION_ID", "hamaki");
            startActivity(intent);
        }

    }
    /////////////////////////////////////////////////////////////TOOLBAR
    /**
     * opens home page

     * @param view
     */
    public void goHome(View view)
    {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    /**
     * opens premium page

     * @param view
     */
    public void goPremium(View view)
    {
        Intent intent = new Intent(this, Premiumm.class);
        startActivity(intent);
    }
    /**
     * opens Library page

     * @param view
     */
    public void goLibrary(View view)
    {
        Intent intent = new Intent(this, Library.class);
        startActivity(intent);
    }
    /**
     * signs out user

     * @param view
     */
    public void goLogout(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Logout.class);
        startActivity(intent);

    }
    ////////////////////////////////////////////////////////////////////////////
    /**
     * takes from database singers whom are liked and set it to homepage
     * changes visibilty of textviews
     * @param view
     * @param list
     */
    public void setimg(View view,List list) {
        //////////////////////////////////////////////////////////////////images
        ImageView img3 = (ImageView) findViewById(R.id.ThirdImageLiked);
        ImageView img4 = (ImageView) findViewById(R.id.FourthImageLiked);
        ImageView img5 = (ImageView) findViewById(R.id.FifthImageLiked);
        ImageView img6 = (ImageView) findViewById(R.id.SixthImageLiked);
        ///////////////////////////////////////////////////////////////// texts
        TextView txt1=(TextView)findViewById(R.id.text1);
        TextView txt2=(TextView)findViewById(R.id.text2);
        TextView txt3=(TextView)findViewById(R.id.text3);
        TextView txt4=(TextView)findViewById(R.id.text4);
        /////////////////////////////////////////////////////////////// images ( taken or not )
        int img3_value = 0;
        int img4_value = 0;
        int img5_value = 0;
        int img6_value = 0;
        if (list.size() != 0)
        {
            TextView txt_like = (TextView) findViewById(R.id.text_like);
            txt_like.setVisibility(View.GONE);
        }
        for (int i = 0; i < list.size(); i++)
        {
            String x = list.get(i).toString();
            System.out.println(x);
            if (img3_value == 0) {
                img3.setVisibility(View.VISIBLE);
                txt4.setVisibility(View.VISIBLE);
                if (x == "Amr_Diab") {
                    img3.setImageResource(R.drawable.amr_diab_liked);
                    img3_value = 1;
                    img3_singer="amr";
                } else if (x == "Mohamed_Hamaki") {
                    img3.setImageResource(R.drawable.mohamed_hamaki_liked);
                    img3_value = 1;
                    img3_singer="hamaki";
                } else if (x == "Tamer_hosny") {
                    img3.setImageResource(R.drawable.tamer_hosny_liked);
                    img3_value = 1;
                    img3_singer="tamer";
                } else if (x == "Nancy_ajram") {
                    img3.setImageResource(R.drawable.nancy_ajram_liked);
                    img3_value = 1;
                    img3_singer="nancy";
                }
            }
            else if (img4_value == 0)
            {
                img4.setVisibility(View.VISIBLE);
                txt3.setVisibility(View.VISIBLE);
                if (x == "Amr_Diab") {
                    img4.setImageResource(R.drawable.amr_diab_liked);
                    img4_value = 1;
                    img4_singer="amr";
                } else if (x == "Mohamed_Hamaki") {
                    img4.setImageResource(R.drawable.mohamed_hamaki_liked);
                    img4_value = 1;
                    img4_singer="hamaki";
                } else if (x == "Tamer_hosny") {
                    img4.setImageResource(R.drawable.tamer_hosny_liked);
                    img4_value = 1;
                    img4_singer="tamer";
                } else if (x == "Nancy_ajram") {
                    img4.setImageResource(R.drawable.nancy_ajram_liked);
                    img4_value = 1;
                    img4_singer="nancy";
                }
            }
            else if (img5_value == 0)
            {
                img5.setVisibility(View.VISIBLE);
                txt2.setVisibility(View.VISIBLE);
                if (x == "Amr_Diab") {
                    img5.setImageResource(R.drawable.amr_diab_liked);
                    img5_value = 1;
                    img5_singer="amr";
                } else if (x == "Mohamed_Hamaki") {
                    img5.setImageResource(R.drawable.mohamed_hamaki_liked);
                    img5_value = 1;
                    img5_singer="hamaki";
                } else if (x == "Tamer_hosny") {
                    img5.setImageResource(R.drawable.tamer_hosny_liked);
                    img5_value = 1;
                    img5_singer="tamer";
                } else if (x == "Nancy_ajram") {
                    img5.setImageResource(R.drawable.nancy_ajram_liked);
                    img5_value = 1;
                    img5_singer="nancy";
                }
            }
            else if (img6_value == 0)
            {
                img6.setVisibility(View.VISIBLE);
                txt1.setVisibility(View.VISIBLE);
                if (x == "Amr_Diab") {
                    img6.setImageResource(R.drawable.amr_diab_liked);
                    img6_value = 1;
                    img6_singer="amr";
                } else if (x == "Mohamed_Hamaki") {
                    img6.setImageResource(R.drawable.mohamed_hamaki_liked);
                    img6_value = 1;
                    img6_singer="hamaki";
                } else if (x == "Tamer_hosny") {
                    img6.setImageResource(R.drawable.tamer_hosny_liked);
                    img6_value = 1;
                    img6_singer="tamer";
                } else if (x == "Nancy_ajram") {
                    img6.setImageResource(R.drawable.nancy_ajram_liked);
                    img6_value = 1;
                    img6_singer="nancy";
                }
            }
        }
    }
///////////////////////
    /**
     * takes from server all songs and set it in listview
     * search on what user write
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        String preference_name=getSharedPreferences("spotify",MODE_PRIVATE).getString("currentEmail","not found");
        sharedPreferences=getSharedPreferences(preference_name,MODE_PRIVATE);
        editor=sharedPreferences.edit();
        numberofartists=sharedPreferences.getInt("numberofartists",0);
        System.out.println(numberofartists);
        /////////////////////////////////////// Home betnawar////////////////////////////////

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


        home1.setBounds(0,0,130,130);
        home2.setBounds(0,0,130,130);
        spotify1.setBounds(0,0,130,130);
        spotify2.setBounds(0,0,130,130);
        library1.setBounds(0,0,130,130);
        library2.setBounds(0,0,130,130);
        search2.setBounds(0,0,130,130);
        search1.setBounds(0,0,130,130);
        homeButton.setTextColor(Color.WHITE);
        homeButton.setCompoundDrawables(null,home2,null,null);
        ///////////////////////////////////////////////////////////////Four images
        ImageView img3=(ImageView)findViewById(R.id.ThirdImageLiked);
        ImageView img4=(ImageView)findViewById(R.id.FourthImageLiked);
        ImageView img5=(ImageView)findViewById(R.id.FifthImageLiked);
        ImageView img6=(ImageView)findViewById(R.id.SixthImageLiked);
        ////////////////////////////////////////////////////////////////Four text
        TextView txt1=(TextView)findViewById(R.id.text1);
        TextView txt2=(TextView)findViewById(R.id.text2);
        TextView txt3=(TextView)findViewById(R.id.text3);
        TextView txt4=(TextView)findViewById(R.id.text4);
        ////////////////////////////////////////////////////////////Gone four images and text
        txt1.setVisibility(View.GONE);
        txt2.setVisibility(View.GONE);
        txt3.setVisibility(View.GONE);
        txt4.setVisibility(View.GONE);
        img3.setVisibility(View.GONE);
        img4.setVisibility(View.GONE);
        img5.setVisibility(View.GONE);
        img6.setVisibility(View.GONE);
        /////////////////////////////////////////////////////////////////
        List namesoflikedB = new ArrayList<String>();
        for(int i=0;i<numberofartists;i++)
        {
            int count=i+1;
            String name=sharedPreferences.getString("artist"+count,"not found");
            System.out.println(name);
            switch(name)
            {
                case "Amr Diab":
                    namesoflikedB.add("Amr_Diab");
                    break;
//                case "Adam Levine":
//                    break;
                case "Nancy Ajram":
                    namesoflikedB.add("Nancy_ajram");
                    break;
//                case "Wael Kfoury":
//                    break;
                case "Tamer Hosny":
                    namesoflikedB.add("Tamer_hosny");
                    break;
                case "Hamaki":
                    namesoflikedB.add("Mohamed_Hamaki");
                    break;

            }
        }
        ImageView x = null;
        setimg(x,namesoflikedB);
        SharedPreferences result_email= getSharedPreferences("spotify", Context.MODE_PRIVATE);
        SharedPreferences result_password= getSharedPreferences("spotify", Context.MODE_PRIVATE);
        SharedPreferences result_username= getSharedPreferences("spotify", Context.MODE_PRIVATE);

        String email =result_email.getString("email","Data not found"); //email
        String password =result_password.getString("password","Data not found"); // password
        String username =result_username.getString("username","Data not found"); // username
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        mysearch=(SearchView)findViewById(R.id.search);
        mylist=(ListView)findViewById(R.id.list);
        list=new ArrayList<String>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://my-json-server.typicode.com/AmrKhaledShaheen/SpotifyAPP/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        dataServer=retrofit.create(DataServer.class);
        call=dataServer.getSearchs();
        call.enqueue(new Callback<List<Search>>() {
            @Override
            public void onResponse(Call<List<Search>> call, Response<List<Search>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(HomePage.this,"Code: " + response.code(),Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Search> searchs=response.body();

                for(Search search:searchs)
                {
                    list.add( search.getSong_name());
                }

            }

            @Override
            public void onFailure(Call<List<Search>> call, Throwable t) {
                Toast.makeText(HomePage.this,t.getMessage().toString(),Toast.LENGTH_SHORT).show();
            }
        });
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,list);
        mylist.setAdapter(adapter);
        mysearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        if(adapter.getItem(position).matches("EL OMR"))
                        {
                            Toast.makeText(HomePage.this, "weee", Toast.LENGTH_SHORT).show();
                            String preference_name=getSharedPreferences("spotify",MODE_PRIVATE).getString("currentEmail","not found");
                            sharedPreferences=getSharedPreferences(preference_name,MODE_PRIVATE);
                            SharedPreferences.Editor editor= sharedPreferences.edit();
                            editor.putString("songName","  EL OMR");
                            editor.apply();
                            Intent intent = new Intent(getApplicationContext(), SongDetails.class);
                            startActivity(intent);
                        }
                        if(adapter.getItem(position).matches("LYA"))
                        {
                            String preference_name=getSharedPreferences("spotify",MODE_PRIVATE).getString("currentEmail","not found");
                            sharedPreferences=getSharedPreferences(preference_name,MODE_PRIVATE);
                            SharedPreferences.Editor editor= sharedPreferences.edit();
                            editor.putString("songName","  LYA");
                            editor.apply();
                            Intent intent = new Intent(getApplicationContext(), SongDetails.class);
                            startActivity(intent);
                        }
                        if(adapter.getItem(position).matches("Zaymanty"))
                        {
                            String preference_name=getSharedPreferences("spotify",MODE_PRIVATE).getString("currentEmail","not found");
                            sharedPreferences=getSharedPreferences(preference_name,MODE_PRIVATE);
                            SharedPreferences.Editor editor= sharedPreferences.edit();
                            editor.putString("songName","  Zaymanty");
                            editor.apply();
                            Intent intent = new Intent(getApplicationContext(), SongDetails.class);
                            startActivity(intent);
                        }
                        if(adapter.getItem(position).matches("Bahebu"))
                        {
                            String preference_name=getSharedPreferences("spotify",MODE_PRIVATE).getString("currentEmail","not found");
                            sharedPreferences=getSharedPreferences(preference_name,MODE_PRIVATE);
                            SharedPreferences.Editor editor= sharedPreferences.edit();
                            editor.putString("songName","  Bahebu");
                            editor.apply();
                            Intent intent = new Intent(getApplicationContext(), SongDetails.class);
                            startActivity(intent);
                        }
                        if(adapter.getItem(position).matches("Helw elmakan"))
                        {
                            String preference_name=getSharedPreferences("spotify",MODE_PRIVATE).getString("currentEmail","not found");
                            sharedPreferences=getSharedPreferences(preference_name,MODE_PRIVATE);
                            SharedPreferences.Editor editor= sharedPreferences.edit();
                            editor.putString("songName","  Helw elmakan");
                            editor.apply();
                            Intent intent = new Intent(getApplicationContext(), SongDetails.class);
                            startActivity(intent);
                        }
                        if(adapter.getItem(position).matches("Wanta maaya"))
                        {
                            String preference_name=getSharedPreferences("spotify",MODE_PRIVATE).getString("currentEmail","not found");
                            sharedPreferences=getSharedPreferences(preference_name,MODE_PRIVATE);
                            SharedPreferences.Editor editor= sharedPreferences.edit();
                            editor.putString("songName","  Wanta maaya");
                            editor.apply();
                            Intent intent = new Intent(getApplicationContext(), SongDetails.class);
                            startActivity(intent);
                        }
                        if(adapter.getItem(position).matches("Ya Sattar"))
                        {
                            String preference_name=getSharedPreferences("spotify",MODE_PRIVATE).getString("currentEmail","not found");
                            sharedPreferences=getSharedPreferences(preference_name,MODE_PRIVATE);
                            SharedPreferences.Editor editor= sharedPreferences.edit();
                            editor.putString("songName","  Ya Sattar");
                            editor.apply();
                            Intent intent = new Intent(getApplicationContext(), SongDetails.class);
                            startActivity(intent);
                        }
                        if(adapter.getItem(position).matches("We A3mal Eih"))
                        {
                            String preference_name=getSharedPreferences("spotify",MODE_PRIVATE).getString("currentEmail","not found");
                            sharedPreferences=getSharedPreferences(preference_name,MODE_PRIVATE);
                            SharedPreferences.Editor editor= sharedPreferences.edit();
                            editor.putString("songName","  We A3mal Eih");
                            editor.apply();
                            Intent intent = new Intent(getApplicationContext(), SongDetails.class);
                            startActivity(intent);
                        }
                    }
                });
                if(newText!="" ) {
                    mylist.setVisibility(View.VISIBLE);
                }
                if(newText.isEmpty() )
                {
                    mylist.setVisibility(View.GONE);
                }
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        mysearch.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                mysearch.setVisibility(View.INVISIBLE);
                return false;
            }
        });
    }
}
