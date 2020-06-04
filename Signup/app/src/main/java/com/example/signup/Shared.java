package com.example.signup;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class Shared {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    int mode=0;
    String Filename="sdfile";
    String Data="b";


    public Shared(Context context)
    {
        this.context = context;
        sharedPreferences=context.getSharedPreferences(Filename,mode);
        editor=sharedPreferences.edit();
    }
    public void SecondTime()
    {
        editor.putBoolean(Data,true);
        editor.commit();
    }
    public void Logout()
    {
        editor.putBoolean(Data,false);
        editor.commit();
    }
    public void FirstTime(){
            if(!this.login())
            {
                Intent intent=new Intent(context,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
            }
            else
                {
                    Intent intent=new Intent(context,HomePage.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    context.startActivity(intent);
                }

    }
    private boolean login()
    {
        return sharedPreferences.getBoolean(Data,false);
    }
}
