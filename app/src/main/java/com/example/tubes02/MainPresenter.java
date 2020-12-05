package com.example.tubes02;

import android.content.res.Resources;
import android.view.SurfaceView;

public class MainPresenter {
    private FragmentListener fl;
    private Rectangles[] rects;

    public MainPresenter(FragmentListener fl) {
        this.fl = fl;


        rects = new Rectangles[3];
    }
}
