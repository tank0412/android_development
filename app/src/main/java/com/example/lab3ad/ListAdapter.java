package com.example.lab3ad;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter {
    /*
    private List<String> imagesList;

    public ListAdapter(Context context, List<String> imagesList) {
        this.imagesList = imagesList;
    }
     */

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener, View.OnClickListener {

        public ViewHolder(View view) {
            super(view);
            view.setOnCreateContextMenuListener(this);
        }

        @Override
        public void onClick(View v) {

        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        ViewHolder vh = new ViewHolder(view);

        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        View v = holder.itemView;
        ImageView image = v.findViewById(R.id.photo);
        Picasso.get().load("https://i.imgur.com/2KxoIsa.jpg").into(image);
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
