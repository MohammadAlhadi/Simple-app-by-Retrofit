package com.mohammad39411.apibyretrofit.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.mohammad39411.apibyretrofit.R;
import com.mohammad39411.apibyretrofit.adapters.PostsAdapter;
import com.mohammad39411.apibyretrofit.pojo.PostModel;
import com.mohammad39411.apibyretrofit.ui.PostViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class MainActivity extends AppCompatActivity {


    PostViewModel viewModel;
    private RecyclerView recyclerView;

    private PostsAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        viewModel.getPosts();

        recyclerView = findViewById(R.id.rec);
        recyclerView.setHasFixedSize(true);

        adapter = new PostsAdapter();
        recyclerView.setAdapter(adapter);

        viewModel.liveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
            }
        });

    }








}
