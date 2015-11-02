package com.example.samarium.finalyearproject;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

    String TAG = "com.ebookfrenzy.videoplayer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final VideoView videoView = (VideoView)findViewById(R.id.myVideo);
        Button btnNick = (Button)findViewById(R.id.btnNick);
        Button btnOwen = (Button)findViewById(R.id.btnOwen);
        Button btnWilliam = (Button)findViewById(R.id.btnWilliam);

        videoView.setVideoPath("https://ia700401.us.archive.org/19/items/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_512kb.mp4");

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i(TAG, "Duration =" + videoView.getDuration());
            }
        });

        btnNick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.setVideoPath("http://techslides.com/demos/sample-videos/small.mp4");

                videoView.start();
            }
        });

        videoView.start();
    }
}