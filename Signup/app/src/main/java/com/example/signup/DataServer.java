package com.example.signup;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @verison 1.0
 * This is the fake server we used to check signup and signin process
 */
public interface DataServer {
    @GET("posts")
    Call<List<Post>> getPosts();


}
