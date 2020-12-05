//package com.example.tubes02.TempRepo;
//
//import android.content.Context;
//import android.view.SurfaceHolder;
//import android.view.SurfaceView;
//
//import androidx.annotation.NonNull;
//
//public class GameView extends SurfaceView implements SurfaceHolder.Callback {
//
////    private MoveThread moveThread;
//
//    private PianoThread pianoThread;
//
//    public GameView(Context context) {
//        super(context);
//
//    }
//
//    @Override
//    public void surfaceCreated(@NonNull SurfaceHolder holder) {
//        if(!this.pianoThread.isRunning()){
//            this.pianoThread = new PianoThread(holder);
//            this.pianoThread.start();
//        }else{
//            this.pianoThread.start();
//        }
//    }
//
//    @Override
//    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
//
//    }
//
//    @Override
//    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
//        if(this.pianoThread.isRunning()){
//            this.pianoThread.setIsRunning(false);
//            boolean retry = true;
//            while(retry){
//                try {
//                    this.pianoThread.join();
//                    retry = false;
//                }catch (InterruptedException e){
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//
//    public void initView(){
//        SurfaceHolder holder = getHolder();
//        holder.addCallback(this);
//
//        setFocusable(true);
//
//        this.pianoThread = new PianoThread(holder);
//    }
//}
