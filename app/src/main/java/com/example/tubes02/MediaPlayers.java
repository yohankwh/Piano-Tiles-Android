package com.example.tubes02;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MediaPlayers extends Service implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener,
        MediaPlayer.OnCompletionListener {
    private MediaPlayer mediaPlayer;

    private ArrayList<Song> songs;

    @Override
    public void onCreate() {
        super.onCreate();
        this.play();
    }

    public void play(){
        if(this.mediaPlayer == null){
            this.mediaPlayer = MediaPlayer.create(this, R.raw.silhouette);
            mediaPlayer.setVolume(1.0f, 1.0f);
            this.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlayer();                }
            });
        }
        mediaPlayer.start();
        Toast.makeText(getApplicationContext(), "Silhoutte is playing",    Toast.LENGTH_SHORT).show();

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
        this.mediaPlayer.stop();
        if(this.mediaPlayer != null){
            this.mediaPlayer.release();
            this.mediaPlayer = null;
            Toast.makeText(this, "MediaPlayer release", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }
//
//    @Override
//    protected void onStop(){
//        super.onStop();
//        stopPlayer();
//    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {

    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {

    }
}
