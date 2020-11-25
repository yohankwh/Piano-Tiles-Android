package com.example.tubes02;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Toast;

public class MediaPlayers {
    private MediaPlayer mediaPlayer;

    public void play(View v){
        if(this.mediaPlayer == null){
            this.mediaPlayer = MediaPlayer.create(this, R.raw.Dramaturgy);
            this.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer;
                }
            });
        }
        mediaPlayer.start();
    }

    public void pause(View v){
        if(mediaPlayer != null){
            mediaPlayer.pause();
        }
    }

    public void stop(View v){
        stopPlayer();
    }

    private void stopPlayer(){
        if(this.mediaPlayer != null){
            this.mediaPlayer.release();
            this.mediaPlayer = null;
            Toast.makeText(this, "MediaPlayer release", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        stopPlayer();
    }
}
