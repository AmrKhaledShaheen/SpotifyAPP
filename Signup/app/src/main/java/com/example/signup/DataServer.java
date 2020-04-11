package com.example.signup;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * This is the fake server we used to check signup and signin process
 * @verison 1.0
 */
public interface DataServer {
    @GET("posts")
    Call<List<Post>> getPosts();


}
