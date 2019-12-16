package com.example.lab6ad.ui.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.lab6ad.NetworkService;
import com.example.lab6ad.Post;
import com.example.lab6ad.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoFragment extends Fragment {

    private VideoViewModel videoViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        NetworkService networkService = new NetworkService();
        networkService = networkService.getInstance();

        final NetworkService networkService2 = networkService;
        videoViewModel =
                ViewModelProviders.of(this).get(VideoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_video, container, false);
        final TextView textView = root.findViewById(R.id.text_video);
        videoViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText( "12");
            }
        });

        final TextView textView2 = root.findViewById(R.id.text_video);
        networkService.getJSONApi()
                .getPostWithID(1)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {
                        Post post = response.body();

                        textView2.append(post.getId() + "\n");
                        textView2.append(post.getUserId() + "\n");
                        textView2.append(post.getTitle() + "\n");
                        textView2.append(post.getBody() + "\n");
                    }

                    @Override
                    public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {

                        textView2.append("Error occurred while getting request!");
                        t.printStackTrace();
                    }
                });
        //networkService2.textView.getText()
        return root;
    }
}