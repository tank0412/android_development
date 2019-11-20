package com.example.lab3ad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.show_Photos); // для прокручиваемого списка
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); // similar to listView
        recyclerView.setLayoutManager(layoutManager);

        ListAdapter listAdapter = new ListAdapter();
        recyclerView.setAdapter(listAdapter);

    }
}
