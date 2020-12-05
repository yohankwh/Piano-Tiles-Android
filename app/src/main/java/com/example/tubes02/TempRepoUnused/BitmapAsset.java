//package com.example.tubes02.TempRepo;
//
//import android.content.res.Resources;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//
//import com.example.tubes02.R;
//
//public class BitmapAsset {
//
//    Bitmap background;
//
//    public BitmapAsset(Resources res) {
//        this.background = BitmapFactory.decodeResource(res, R.drawable.bgminimal);
////        this.background = scaleImage(background);
//    }
//
//    public Bitmap getBackground(){
//        return this.background;
//    }
//
//    public int getBackgroundWidth(){
//        return this.background.getWidth();
//    }
//
//    public int getBackgroundHeight(){
//        return this.background.getHeight();
//    }
//
////    public Bitmap scaleImage(Bitmap bitmap){
////        float widthHeightRatio = this.getBackgroundWidth()/this.getBackgroundHeight();
////
////        int backgroundScaleWidth = (int)widthHeightRatio * AppConstants.SCREEN_HEIGHT;
////        return Bitmap.createScaledBitmap(bitmap, backgroundScaleWidth, AppConstants.SCREEN_HEIGHT,
////                false);
////    }
//}
