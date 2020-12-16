package com.mohammad39411.apibyretrofit.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.mohammad39411.apibyretrofit.R;
import com.mohammad39411.apibyretrofit.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostsViewHolder> {

    private List<PostModel> mData = new ArrayList<>();

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostsViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder holder, int position) {

        //Hold views here
        holder.tvTitle.setText(mData.get(position).getTitle());
        holder.tvBody.setText(mData.get(position).getBody());
        holder.tvUserId.setText(mData.get(position).getUserId() + "");
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setList(List<PostModel> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    public class PostsViewHolder extends RecyclerView.ViewHolder {
        //ini Views

        TextView tvUserId , tvTitle , tvBody;
        public PostsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvUserId = itemView.findViewById(R.id.tv_userId);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvBody = itemView.findViewById(R.id.tv_body);

        }
    }
}
