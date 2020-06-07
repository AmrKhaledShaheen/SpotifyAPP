package com.example.signup;

import android.media.MediaPlayer;

public final class MySingleton {

    static MediaPlayer instance;

    public static MediaPlayer getInstance() {

        if (instance == null)
        {
            instance = new MediaPlayer();

        }


        return instance;
    }
}
