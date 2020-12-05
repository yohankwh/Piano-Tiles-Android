//package com.example.tubes02.TempRepo;
//
//import android.content.Context;
//import android.util.DisplayMetrics;
//import android.view.Display;
//import android.view.WindowManager;
//
//import com.example.tubes02.TempRepo.BitmapAsset;
//
//public class AppConstants {
//
//    private static BitmapAsset bitmapAsset;
//    private static GameEngine gameEngine;
//    private static int SCREEN_WIDTH, SCREEN_HEIGHT;
//
//    public static void initialization(Context context){
//        setScreenSize(context);
//        bitmapAsset = new BitmapAsset(context.getResources());
//        gameEngine = new GameEngine();
//
//    }
//
//    public static BitmapAsset getBitmapAsset(){
//        return bitmapAsset;
//    }
//
//    public static GameEngine getGameEngine(){
//        return gameEngine;
//    }
//
//    private static void setScreenSize(Context context){
//        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        Display display = wm.getDefaultDisplay();
//        DisplayMetrics metrics = new DisplayMetrics();
//        display.getRealMetrics(metrics);
//
//        int width = metrics.widthPixels;
//        int height = metrics.heightPixels;
//        AppConstants.SCREEN_WIDTH = width;
//        AppConstants.SCREEN_HEIGHT = height;
//    }
//}
