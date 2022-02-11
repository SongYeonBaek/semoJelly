package com.example.prography_quest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private ArrayList<ItemObject> mList;

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_image;
        private TextView tv_title, tv_director, tv_story, tv_score;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_title = (TextView) itemView.findViewById(R.id.title);
            tv_director = (TextView) itemView.findViewById(R.id.director);
            tv_story = (TextView) itemView.findViewById(R.id.story);
            tv_score = (TextView) itemView.findViewById(R.id.score);
            iv_image = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    public RecyclerAdapter(ArrayList<ItemObject> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_byscore, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        holder.tv_title.setText(String.valueOf(mList.get(position).getTitle()));
        holder.tv_director.setText(String.valueOf(mList.get(position).getDirector()));
        holder.tv_story.setText(String.valueOf(mList.get(position).getStory()));
        holder.tv_score.setText(String.valueOf(mList.get(position).getScore()));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
