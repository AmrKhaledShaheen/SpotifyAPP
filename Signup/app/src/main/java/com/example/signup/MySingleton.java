package com.example.signup;

import android.media.MediaPlayer;
/**
 * This activity responsible for allowing only one mediaplayer to play
 * @version 1.0
 */
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
