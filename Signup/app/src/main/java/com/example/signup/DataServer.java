package com.example.signup;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * This is the fake server we used to check signup and signin process
 * @verison 1.0
 */
public interface DataServer {
    @GET("posts")
    Call<List<Post>> getPosts();
    @GET("songs")
    Call<List<Search>> getSearchs();
    @POST("posts")
    Call<Post>createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post>createPosts(
            @Field("email") String email,
            @Field("username") String username,
            @Field("password")  String password,
            @Field("birthdate") String birthdate,
            @Field("gender") String gender
    );

    Call<Post> createPost(String email, String username, String password, String birthdate, String gender);
}
