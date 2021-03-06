package com.example.signup;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * This an activity used to search between songs names
 * @version 1.0
 * Retrofit server https://www.youtube.com/playlist?list=PLrnPJCHvNZuCbuD3xpfKzQWOj3AXybSaM
 */

public class Search {
    @SerializedName("song_name")
    @Expose
    private String song_name;

    public Search(String song_name) {
        this.song_name = song_name;
    }

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }
}
