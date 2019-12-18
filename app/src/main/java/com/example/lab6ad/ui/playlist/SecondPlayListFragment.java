package com.example.lab6ad.ui.playlist;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab6ad.Items;
import com.example.lab6ad.NetworkService;
import com.example.lab6ad.PlaylistRecicleViewAdapter;
import com.example.lab6ad.Post;
import com.example.lab6ad.R;
import com.example.lab6ad.ui.Config;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SecondPlayListFragment extends Fragment implements PlaylistRecicleViewAdapter.ItemClickListener {

    private PlayListViewModel playListViewModel;

    PlaylistRecicleViewAdapter adapter;

    ArrayList<String> videoIDs = new ArrayList<>();

    String PLAYLIST_ID = "PLWz5rJ2EKKc_i9rV2WE-GhWLm4JmsraRM";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NetworkService networkService = new NetworkService();
        networkService = networkService.getInstance();
        playListViewModel =
                ViewModelProviders.of(this).get(PlayListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_playlist, container, false);
        final View root2 = root;
        networkService.getJSONApi()
                .getPlaylistWithIDAndKey(PLAYLIST_ID, Config.YOUTUBE_API_KEY)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {

                        Post post = response.body();

                        ArrayList<Items> items = post.getItems();
                        ArrayList<String> IDs = new ArrayList<>();

                        int countIds = 0;

                        for(Items item : items) {
                            Log.v("onResponse1", item.getId());
                            if(item.snippet.getId() != null)
                                Log.v("onResponse2", item.snippet.getId());
                            if(item.snippet.resourceId.getId() != null) {
                                Log.v("onResponse3", item.snippet.resourceId.getId());
                                videoIDs.add(item.snippet.resourceId.getId());
                                countIds++;
                            }
                        }

                        RecyclerView recyclerView = root2.findViewById(R.id.rvAnimals);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        adapter = new PlaylistRecicleViewAdapter(getContext(), videoIDs, getLifecycle(), getContext(), countIds);
                        //adapter.setClickListener(this);
                        recyclerView.setAdapter(adapter);

                    }

                    @Override
                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {

                        //textView2.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });


        return root;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getContext(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        return;
    }
}