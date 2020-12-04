package com.example.tubes02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements FragmentListener{
    private FragmentManager fragmentManager;
    private MainPresenter presenter;
    private HomeFragment homeFragment;
    private GameFragment gameFragment;
    private MediaPlayers mediaPlayer;
    private UIThreadHandler uiThreadHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.presenter = new MainPresenter(this);
        this.fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction ft = this.fragmentManager.beginTransaction();

        this.uiThreadHandler = new UIThreadHandler(this);

        this.homeFragment = new HomeFragment();
        this.gameFragment = new GameFragment();
        this.gameFragment.setUIThreadHandler(this.uiThreadHandler);

        this.mediaPlayer = new MediaPlayers();

        ft.add(R.id.fragment_container, this.homeFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void changePage(int page) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if(page==2){
            this.PlayMusic();
            if(this.gameFragment.isAdded()){
                ft.show(this.gameFragment);


            }else{
                ft.add(R.id.fragment_container, this.gameFragment)
                        .addToBackStack(null);
            }
            if(this.homeFragment.isAdded()){
                ft.hide(this.homeFragment);
            }
        }
        ft.commit();
    }

    public void PlayMusic() {
        Log.d("debugg", "laguintent");
        Intent intent = new Intent(this, MediaPlayers.class);
        startService(intent);

    }

    @Override
    public void closeApplication(){
        this.moveTaskToBack(true);
        this.finish();
    }

    public void move(int x, int y){
        this.gameFragment.move(x,y);
    }
}