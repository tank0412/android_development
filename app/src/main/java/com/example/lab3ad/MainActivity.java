package com.example.lab3ad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListAdapter.OnItemClicked {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.show_Photos); // для прокручиваемого списка
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // similar to listView
        recyclerView.setLayoutManager(layoutManager);

        ListAdapter listAdapter = new ListAdapter(prepareData());
        recyclerView.setAdapter(listAdapter);

        listAdapter.setOnClick(MainActivity.this); // Bind the listener

    }
    private List<String> prepareData() {
        List<String> imagesUrlList = new ArrayList<>();
        imagesUrlList.add("https://i.imgur.com/2KxoIsa.jpg");
        imagesUrlList.add("https://i.imgur.com/EZHXbA0.jpg");
        imagesUrlList.add("https://i.imgur.com/qb7Ev7A.jpg");
        imagesUrlList.add("https://i.imgur.com/ZtXXAwX.jpg");
        imagesUrlList.add("https://i.imgur.com/lrE9vha.jpg");
        imagesUrlList.add("https://i.imgur.com/S66rx9n.jpg");
        imagesUrlList.add("https://i.imgur.com/KaSkWef.jpg");
        imagesUrlList.add("https://i.imgur.com/jp5z1s0.jpg");
        imagesUrlList.add("https://i.imgur.com/iLNrl9Z.jpg");
        imagesUrlList.add("https://i.imgur.com/uXbb81d.jpg");
        imagesUrlList.add("https://i.imgur.com/92mT0BB.jpg");
        return  imagesUrlList;
    }

    @Override
    public void onItemClick(int position) {
        // The onClick implementation of the RecyclerView item click
        //ur intent code here
        MediaPlayer mPlayer = MediaPlayer.create(MainActivity.this, R.raw.sound);
        mPlayer.start();
    }
}
