package com.example.mygallery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mygallery.Modal.Photo;
import com.example.mygallery.R;

import java.util.List;

public class GridAdaptor extends RecyclerView.Adapter<GridAdaptor.MyViewHolder> {

    Context context;
    List<Photo> imageList ;

    public GridAdaptor(Context context, List<Photo> imageList){
        this.context = context;
        this.imageList = imageList;
    }

    @NonNull
    @Override
    public GridAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdaptor.MyViewHolder holder, int position) {

        String image = imageList.get(position).getUrl_s();

        int width = (int) imageList.get(position).getWidth_s();
        int height = (int) imageList.get(position).getHeight_s();

        Glide.with(context).load(image).override(width,height).into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_item);
        }
    }
}
