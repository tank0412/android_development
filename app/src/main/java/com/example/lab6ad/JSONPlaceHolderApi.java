package com.example.lab6ad;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {
    @GET("/posts/{id}")
    public Call<Post> getPostWithID(@Path("id") int id);
    @GET("/youtube/v3/playlistItems?part=snippet&maxResults=50")
    public Call<Post> getPlaylistWithIDAndKey(@Query("playlistId") String playlist, @Query("key") String key );
}
