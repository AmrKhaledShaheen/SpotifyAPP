package com.example.signup;

import android.media.MediaPlayer;
/**
 * This activity responsible for allowing only one mediaplayer to play
 * https://stackoverflow.com/questions/3129418/android-mediaplayer-only-one-instance-at-any-given-time this link helped in allowing only one mediaplayer to play
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
