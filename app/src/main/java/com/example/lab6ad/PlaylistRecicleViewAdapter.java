package com.example.lab6ad;


import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.util.List;

public class PlaylistRecicleViewAdapter extends RecyclerView.Adapter<PlaylistRecicleViewAdapter.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Lifecycle lifecycle;
    private WebView webView;
    private Context context;
    private int countIds;


    // data is passed into the constructor
    public PlaylistRecicleViewAdapter(Context context, List<String> data, Lifecycle lifecycle ,Context mycontext, int countIds) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.lifecycle = lifecycle;
        this.context = mycontext;
        this.countIds = countIds;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.recyclerview_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(countIds <= 0) {
            return;
        }
        String id = mData.get(position);

        Log.v("onBindViewHolder",id );


        WebView wv;
        String html = "<iframe class=\"youtube-player\" " + "style=\"border: 0; width: 100%; height: 96%;"
                + "padding:0px; margin:0px\" " + "id=\"ytplayer\" type=\"text/html\" "
                + "src=\"http://www.youtube.com/embed/" + id
                + "?&theme=dark&autohide=2&modestbranding=1&showinfo=0&autoplay=1\fs=0\" frameborder=\"0\" "
                + "allowfullscreen autobuffer " + "controls onclick=\"this.play()\">\n" + "</iframe>\n";

        countIds--;

        wv = webView;
        wv.setVisibility(View.VISIBLE);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new Browser());
        wv.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        wv.getSettings().setSupportMultipleWindows(true);
        wv.loadDataWithBaseURL("", html , "text/html",  "UTF-8", "");
        wv.setWebChromeClient(new MyWebClient(context, wv));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        WebView frameLayout;

        ViewHolder(View itemView) {
            super(itemView);
            Log.v("ViewHolderCalled","0" );
            frameLayout = itemView.findViewById(R.id.webView);
            webView = itemView.findViewById(R.id.webView);;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}

class MyWebClient extends WebChromeClient
{
    private View mCustomView;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;
    protected FrameLayout mFullscreenContainer;
    private int mOriginalOrientation;
    private int mOriginalSystemUiVisibility;

    private MainActivity mainActivity;
    private WebView wv;

    public MyWebClient(Context context, WebView wv) {
        this.mainActivity = (MainActivity) context;
        this.wv = wv;
    }

    public Bitmap getDefaultVideoPoster()
    {
        if (mainActivity== null) {
            return null;
        }
        return BitmapFactory.decodeResource(mainActivity.getApplicationContext().getResources(), 2130837573);
    }

    public void onHideCustomView()
    {
        ((FrameLayout)mainActivity.getWindow().getDecorView()).removeView(this.mCustomView);
        this.mCustomView = null;
        mainActivity.getWindow().getDecorView().setSystemUiVisibility(this.mOriginalSystemUiVisibility);
        mainActivity.setRequestedOrientation(this.mOriginalOrientation);
        this.mCustomViewCallback.onCustomViewHidden();
        this.mCustomViewCallback = null;
    }

    public void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
        if (this.mCustomView != null)
        {
            onHideCustomView();
            return;
        }
        //mainActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.mCustomView = paramView;
        this.mOriginalSystemUiVisibility = mainActivity.getWindow().getDecorView().getSystemUiVisibility();
        this.mOriginalOrientation = mainActivity.getRequestedOrientation();
        this.mCustomViewCallback = paramCustomViewCallback;
        this.mCustomView.setBackgroundColor(Color.BLACK);
        ((FrameLayout)mainActivity.getWindow().getDecorView()).addView(this.mCustomView, new FrameLayout.LayoutParams(-1, -1));
        mainActivity.getWindow().getDecorView().setSystemUiVisibility(3846);
    }
}

class Browser
        extends WebViewClient
{
    Browser() {}

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
        paramWebView.loadUrl(paramString);
        return true;
    }
}