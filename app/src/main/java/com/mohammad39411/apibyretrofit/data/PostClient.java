package com.mohammad39411.apibyretrofit.data;

import android.content.Context;

import com.mohammad39411.apibyretrofit.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;

    private static PostClient instance;

    public PostClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostClient getInstance() {

        if (null == instance){
            instance = new PostClient();
        }
        return instance;
    }

    public Call<List<PostModel>> getPosts(){
        return postInterface.getPost();
    }
}
