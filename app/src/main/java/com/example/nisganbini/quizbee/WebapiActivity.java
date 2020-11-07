package com.example.nisganbini.quizbee;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class WebapiActivity extends YouTubeBaseActivity {


    Button button5;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webapi);
        youTubePlayerView=findViewById(R.id.youtube_view);
        onInitializedListener=new YouTubePlayer.OnInitializedListener(){
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("QXeEoD0pB3E");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        button5=findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                youTubePlayerView.initialize("AIzaSyDYWNin1mwGNX45s3ydgZ5i2L34P9pfCGI",onInitializedListener);
            }
        });

    }
}