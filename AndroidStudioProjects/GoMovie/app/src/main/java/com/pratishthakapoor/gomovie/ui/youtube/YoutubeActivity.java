package com.pratishthakapoor.gomovie.ui.youtube;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.pratishthakapoor.gomovie.R;
import com.pratishthakapoor.gomovie.util.AppConstants;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    String videoId;
    @BindView(R.id.youtube_view)
    YouTubePlayerView ytView;
    private static String ARG_VIDEO_ID = "arg_video_id";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        ButterKnife.bind(this);
        Intent i = getIntent();

        if(i != null){
            videoId = i.getStringExtra(ARG_VIDEO_ID);
        }

        if(videoId != null){
            ytView.initialize(AppConstants.YT_DEVELOPER_KEY, this);
        }
    }

    public static Intent getStartIntent(Context context, String video_id){
        Intent i = new Intent(context, YoutubeActivity.class);
        i.putExtra(ARG_VIDEO_ID, video_id);
        return  i;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {
            // loadVideo() will auto play video
            // Use cueVideo() method, if you don't want to play it automatically
            player.loadVideo(videoId);
            player.setFullscreen(true);

        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
