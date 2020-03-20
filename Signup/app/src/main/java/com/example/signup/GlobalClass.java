package com.example.signup;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalClass extends Application {

    private List<String> username_list=new ArrayList<String>();
    private List<String> password_list=new ArrayList<String>();
    private Map<String,String> login=new HashMap<String,String>();

    public GlobalClass()
    {

    }

    public GlobalClass(HashMap<String,String> hi)
    {
        login=hi;
    }

    public void addto_login(String username,String password)
    {
        login.put(username,password);
    }
    public String check_login(String username,String password)
    {

        for(Map.Entry<String,String> entry : login.entrySet())
        {
            if(entry.getKey().equals(username))
            {
                if(entry.getValue().equals(password))
                    return "both are right";
                else
                    return "wrong password";
            }
        }
        return "both are wrong";
    }
    public void print()
    {
        for(Map.Entry<String,String> entry : login.entrySet())
        {
            Log.i("HABD",entry.getKey());
        }
    }

    /*public void addto_usernameList(String username)
    {
        username_list.add(username);
    }
    public void addto_passwordList(String username)
    {
        username_list.add(username);
    }
    public boolean usernameIsFound(String username)
    {
        for(String name:username_list)
        {
            if(name==username)
                return true;
        }
        return false;
    }

    public boolean passwordIsFound(String username)
    {
        for(String name:username_list)
        {
            if(name==username)
                return true;
        }
        return false;
    }*/


}
