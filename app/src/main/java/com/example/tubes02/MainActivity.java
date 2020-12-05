package com.example.tubes02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

//import com.example.tubes02.TempRepo.AppConstants;
//import com.example.tubes02.TempRepo.GameActivity;

public class MainActivity extends AppCompatActivity implements FragmentListener, View.OnClickListener{
    private FragmentManager fragmentManager;
    private MainPresenter presenter;
    private HomeFragment homeFragment;
    private GameFragment gameFragment;
    private MediaPlayers mediaPlayer;
    private UIThreadHandler uiThreadHandler;
    private boolean back;
//    private MoveThread moveThread;
//    private int[] test = new int[100];



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.back=true;

//        AppConstants.initialization(this.getApplicationContext());
//        this.test[0]  =40;
//        this.test[1] = 40;
        this.presenter = new MainPresenter(this);
        this.fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction ft = this.fragmentManager.beginTransaction();

        this.uiThreadHandler = new UIThreadHandler(this);


        this.homeFragment = new HomeFragment();
        this.gameFragment = new GameFragment();
        this.gameFragment.setUIThreadHandler(this.uiThreadHandler);
//        this.moveThread = new MoveThread(uiThreadHandler,test ,300);
        this.mediaPlayer = new MediaPlayers();



        ft.add(R.id.fragment_container, this.homeFragment)
                .addToBackStack(null)
                .commit();


    }

    @Override
    public void changePage(int page) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if(page==2){
            this.playMusic(!back);
//            bgPianoTile();
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

    public void playMusic(boolean check) {
        Log.d("debugg", "laguintent");
        Intent intent = new Intent(this, MediaPlayers.class);
        if(check == true){
            stopService(intent);
        }else {
            startService(intent);
        }

    }

    @Override
    public void closeApplication(){
        this.moveTaskToBack(true);
        this.finish();
    }

    public void move(int x, int y){
        this.gameFragment.move(x,y);
    }



    @Override
    public void onBackPressed() {
//        this.moveThread.thread.interrupt();
        this.back = true;
        this.playMusic(this.back);
//        finish();
        super.onBackPressed();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Log.d(this.getClass().getName(), "back button pressed");
        }
        return super.onKeyDown(keyCode, event);
    }

    public boolean getBack(){
        return this.back;
    }


    @Override
    public void onClick(View v) {
        this.back=false;

    }

    @Override
    protected void onDestroy() {
        this.back = true;
        this.playMusic(this.back);
        super.onDestroy();
    }

//    public void bgPianoTile(){
//        Intent intent = new Intent(this, GameActivity.class);
//        startActivity(intent);
//        finish();
//    }
}