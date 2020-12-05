package com.example.tubes02;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.Random;

import static android.os.Looper.*;

public class MoveThread implements Runnable{
    protected UIThreadHandler uiThreadHandler;
    protected Thread thread;

    protected int curPosX;
    protected int curPosY;
    protected int heightLimit;
    private Handler handler;

    public MoveThread(UIThreadHandler uiThreadHandler, int[] initPos, int maxY){
        this.uiThreadHandler = uiThreadHandler;
        this.thread = new Thread(this);
        this.handler =  new Handler(getMainLooper());

        this.curPosX = initPos[0];
        this.curPosY = initPos[1];

        this.heightLimit = maxY;
    }

    public void moveObject(){
        this.thread.start();
    }

    @Override
    public void run() {
        int incrY = 20;

        int arrPos[] = {this.curPosX, this.curPosY};

        while(arrPos[1]<this.heightLimit){
            try{
                Thread.sleep(100);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
            this.uiThreadHandler.move(arrPos);

            arrPos[1] = arrPos[1]+incrY;
        }
    }

    public void stop(){
        Thread.interrupted();
    }

//    private Runnable MyThread = new Runnable()
//    {
//        @Override
//        public void run() {
//            handler.removeCallbacks(MyThread);
//        }
//    };



}
