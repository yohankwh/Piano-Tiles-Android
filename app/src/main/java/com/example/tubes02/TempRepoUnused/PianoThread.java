//package com.example.tubes02.TempRepo;
//
//import android.graphics.Canvas;
//import android.os.SystemClock;
//import android.view.SurfaceHolder;
//
//import com.example.tubes02.TempRepo.AppConstants;
//
//public class PianoThread extends Thread{
//    private SurfaceHolder surfaceHolder;
//    private boolean isRunning;
//    private long startTime, loopTime;
//    private long delay;
//
//    public PianoThread(SurfaceHolder surfaceHolder){
//        this.surfaceHolder = surfaceHolder;
//        this.delay = 33;
//        this.isRunning = true;
//    }
//
//    @Override
//    public void run() {
//
//        while (isRunning){
//            this.startTime = SystemClock.uptimeMillis();
//
//            Canvas canvas = surfaceHolder.lockCanvas(null);
//
//            if(canvas != null){
//                synchronized (this.surfaceHolder){
//                    AppConstants.getGameEngine().updateAndDrawBackgroundImage(canvas);
//                    surfaceHolder.unlockCanvasAndPost(canvas);
//                }
//            }
//
//            loopTime = SystemClock.uptimeMillis() - this.startTime;
//
//
//            if(this.loopTime < this.delay){
//                try{
//                    Thread.sleep(this.delay-this.loopTime);
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public boolean isRunning(){
//        return this.isRunning;
//    }
//
//    public void setIsRunning(boolean state){
//        this.isRunning = state;
//    }
//
//}
