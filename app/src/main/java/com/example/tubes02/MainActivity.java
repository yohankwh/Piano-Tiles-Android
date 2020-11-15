package com.example.tubes02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentListener{
    private FragmentManager fragmentManager;
    private MainPresenter presenter;
    private HomeFragment homeFragment;
    private GameFragment gameFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.presenter = new MainPresenter(this);
        this.fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction ft = this.fragmentManager.beginTransaction();

        this.homeFragment = new HomeFragment();
        this.gameFragment = new GameFragment();

        ft.add(R.id.fragment_container, this.homeFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void changePage(int page) {
        FragmentTransaction ft = this.fragmentManager.beginTransaction();
        if(page==2){
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
}