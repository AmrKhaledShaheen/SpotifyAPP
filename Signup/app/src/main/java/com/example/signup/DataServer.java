package com.example.signup;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataServer {

    @GET("posts")
    Call<List<Post>> getPosts();


}
