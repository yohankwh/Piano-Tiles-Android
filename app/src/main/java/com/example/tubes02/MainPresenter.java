package com.example.tubes02;

import android.content.res.Resources;
import android.util.Log;
import android.view.SurfaceView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

public class MainPresenter {
    private FragmentListener fl;
    private Rectangles[] rects;
    private IMainActivity ui;

    public MainPresenter(IMainActivity activity, FragmentListener fl) {
        this.ui = activity;
        this.fl = fl;

        rects = new Rectangles[3];
    }

}
