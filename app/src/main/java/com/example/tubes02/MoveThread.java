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
    protected int tileWidth;
    private Handler handler;

    public MoveThread(UIThreadHandler uiThreadHandler, int[] initPos, int maxY, int tileWidth){
        this.uiThreadHandler = uiThreadHandler;
        this.thread = new Thread(this);
        this.handler =  new Handler(getMainLooper());

        this.curPosX = initPos[0];
        this.curPosY = initPos[1];

        this.heightLimit = maxY;
        this.tileWidth = tileWidth;
    }

    public void moveObject(){
        this.thread.start();
    }

    @Override
    public void run() {
        Random rand = new Random();
        boolean check = true;

        while(true){

            int incrY = 40;

            int multp = rand.nextInt(3);

            int arrPos[] = {this.curPosX+this.tileWidth*multp, this.curPosY};

            while(true){
                if(!this.uiThreadHandler.getFlag()){break;}

                if(arrPos[1]<this.heightLimit+20){//tile-pass-no-touch check
                    try{
                        thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                    this.uiThreadHandler.move(arrPos);
                    arrPos[1] = arrPos[1]+incrY;
                }else{
                    if(this.uiThreadHandler.isPassAllowed()){
                        check = true;
                    }else{
                        check = false;

                    }
                    break;
                }
            }
            if(!check){
                break;
            }
            this.uiThreadHandler.resetCheck();
        }
    }

    public void onStop(){

        thread.interrupt();
    }




}
