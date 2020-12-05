package com.example.tubes02;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;

import androidx.core.content.res.ResourcesCompat;

import java.util.Random;

public class UIThreadHandler extends Handler {
    protected final static int MSG_MOVE_OBJECT_OUTPUT=123;
    protected MainActivity mainActivity;
    protected boolean flag;

    public UIThreadHandler(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        this.flag=true;
    }

    @Override
    public void handleMessage(Message msg){
        if(msg.what == UIThreadHandler.MSG_MOVE_OBJECT_OUTPUT){
            int[] param = (int[])msg.obj;
            this.mainActivity.move(param[0],param[1]);
        }
    }

    public void move(int[] arrPos){
        Message msg = new Message();
        msg.what = MSG_MOVE_OBJECT_OUTPUT;
        msg.obj = arrPos;
        this.sendMessage(msg);
    }

    public boolean isPassAllowed(){
        return this.mainActivity.isPassAllowed();
    }

    public void resetCheck(){
        this.mainActivity.resetGameCheck();
    }

    public boolean getFlag(){
        return this.flag;
    }

    public void setFlagFalse(){
        this.flag = false;
    }

    public void setFlagTrue(){
        this.flag = true;
    }
}
