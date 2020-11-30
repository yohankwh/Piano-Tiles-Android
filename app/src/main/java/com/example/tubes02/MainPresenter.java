package com.example.tubes02;

public class MainPresenter {
    private FragmentListener fl;
    private Rectangles[] rects;

    public MainPresenter(FragmentListener fl){
        this.fl = fl;


        rects = new Rectangles[3];
    }


}
