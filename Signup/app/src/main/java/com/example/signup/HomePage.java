package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AppCompatActivity {
String img3_singer,img4_singer,img5_singer,img6_singer="";
Drawable spotify1,spotify2,library1,library2,home1,home2,search1,search2;
private Button homeButton,searchButton,libraryButton,premiumButton;
private SharedPreferences sharedPreferences;
private SharedPreferences.Editor editor;
private int numberofartists;
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
//    public void yrb(View view,List namesofliked)
//    {
//        for(int i=0;i<namesofliked.size();i++)
//      {
//        if (namesofliked.get(i).equals("Amr Diab")) {
//            ImageView firstlike = (ImageView) findViewById(R.id.FirstImageLiked);
//            firstlike.setImageResource(R.drawable.amr_diab_liked);
//            test="amr";
//        }
//        if (namesofliked.get(i).equals("Mohamed Hamaki")) {
//            ImageView secondlike = (ImageView) findViewById(R.id.SecondImageLiked);
//            secondlike.setImageResource(R.drawable.mohamed_hamaki_liked);
//        }
//          if (namesofliked.get(i).equals("Tamer hosny")) {
//              ImageView thirdlike = (ImageView) findViewById(R.id.ThirdImageLiked);
//              thirdlike.setImageResource(R.drawable.tamer_hosny_liked);
//          }
//          if (namesofliked.get(i).equals("Nancy ajram")) {
//              ImageView firstlike_2 = (ImageView) findViewById(R.id.FirstImageLiked);
//              firstlike_2.setImageResource(R.drawable.nancy_ajram_liked);
//              test="nancy";
//          }
//      }
//    }
    public void goHome(View view)
    {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }
    public void goPremium(View view)
    {
        Intent intent = new Intent(this, Premiumm.class);
        startActivity(intent);
    }
    public void goLibrary(View view)
    {
        Intent intent = new Intent(this, Library.class);
        startActivity(intent);
    }
    public void goLogout(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Logout.class);
        startActivity(intent);

    }
//    //////Images button
//    //First
//    public void first_image_clicked(View view)
//    {
//        Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
//        intent.putExtra("EXTRA_SESSION_ID", test);
//        startActivity(intent);
//    }
//    //Second
//    public void SecondImageLiked(View view)
//    {
//        Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
//        intent.putExtra("EXTRA_SESSION_ID", test);
//        startActivity(intent);
//    }
//    //Third
//    public void ThirdImageLiked(View view)
//    {
//        Intent intent = new Intent(getBaseContext(), Singers_Songs.class);
//        intent.putExtra("EXTRA_SESSION_ID", test);
//        startActivity(intent);
//    }
    public void yrab(View view,List list) {
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        sharedPreferences=getSharedPreferences("sharedPrefs",MODE_PRIVATE);
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
                    break;
                case "Adam Levine":
                    break;
                case "Nancy Ajram":
                    break;
                case "Wael Kfoury":
                    break;
                case "Tamer Hosny":
                    break;
                case "Hamaki":
                    break;

            }
            namesoflikedB.add("Amr_Diab");
            namesoflikedB.add("Mohamed_Hamaki");
            namesoflikedB.add("Tamer_hosny");
            namesoflikedB.add("Nancy_ajram");
        }

        ImageView x = null;
        yrab(x,namesoflikedB);
        SharedPreferences result_email= getSharedPreferences("spotify", Context.MODE_PRIVATE);
        SharedPreferences result_password= getSharedPreferences("spotify", Context.MODE_PRIVATE);
        SharedPreferences result_username= getSharedPreferences("spotify", Context.MODE_PRIVATE);
//        ////artists
//        boolean Amr_Diab = false;
//        boolean Mohamed_Hamaki= true;
//        boolean Tamer_Hosny = false;
//        boolean Nancy_Ajram= true;
//        //get data
        String email =result_email.getString("email","Data not found"); //email
        String password =result_password.getString("password","Data not found"); // password
        String username =result_username.getString("username","Data not found"); // username
        Toast.makeText(this, email+"\n"+password+"\n"+username, Toast.LENGTH_SHORT).show();
//        //////////////names ly h5odha mn l backend/////////////////////////////////////////////
//        List namesoflikedB = new ArrayList<String>();
//        if (Amr_Diab) {
//            namesoflikedB.add("Amr Diab");
//        }
//        if(Mohamed_Hamaki) {
//            namesoflikedB.add("Mohamed Hamaki");
//        }
//        if(Tamer_Hosny) {
//            namesoflikedB.add("Tamer hosny");
//        }
//        if(Nancy_Ajram) {
//            namesoflikedB.add("Nancy ajram");
//        }
//        //////////////////////////////////////////////////////////////////
/////////////////////////b5do fl array bt3y/////////////////////////
//        List namesofliked = new ArrayList<String>();
//        namesofliked=namesoflikedB;
        ////////////////////////////////////////////////////////////////////////////////////////
//        System.out.println(namesofliked.get(1));
//        System.out.println(namesofliked.get(0));
//        System.out.println("sssssss");
//        System.out.println(namesofliked.size());
//        ImageView x = null;
//        if(namesofliked.size()!=0) {
//            yrb(x, namesofliked);
//        }
    }
}
