package com.example.lab6ad.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab6ad.PlaylistRecicleViewAdapter;
import com.example.lab6ad.R;

import java.util.ArrayList;

public class PlaylistFragment extends Fragment implements PlaylistRecicleViewAdapter.ItemClickListener {

    private PlayListViewModel playListViewModel;

    PlaylistRecicleViewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        playListViewModel =
                ViewModelProviders.of(this).get(PlayListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_playlist, container, false);
        final TextView textView = root.findViewById(R.id.text_tools);
        playListViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        animalNames.add("Horse");
        animalNames.add("Cow");
        animalNames.add("Camel");
        animalNames.add("Sheep");
        animalNames.add("Goat");

        // set up the RecyclerView
        RecyclerView recyclerView = root.findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PlaylistRecicleViewAdapter(getContext(), animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        return root;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        return;
    }
}