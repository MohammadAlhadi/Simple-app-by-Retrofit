package com.mohammad39411.apibyretrofit.data;

import com.mohammad39411.apibyretrofit.pojo.PostModel;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface PostInterface {
    @GET("posts/")
    public Call<List<PostModel>> getPost();


}
