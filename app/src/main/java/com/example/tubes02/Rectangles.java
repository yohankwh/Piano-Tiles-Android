package com.example.tubes02;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Rectangles {
    int x;
    int y = 0;
    int width;
    int height;
    int rectCounter = 1;
    Bitmap rect1, rect2, rect3;

    Rectangles(Resources res){
        this.rect1 = BitmapFactory.decodeResource(res, R.drawable.tile1);
        this.rect2 = BitmapFactory.decodeResource(res, R.drawable.tile1);
        this.rect3 = BitmapFactory.decodeResource(res, R.drawable.tile1);

        this.width = rect1.getWidth();
        this.height = rect1.getHeight();

        this.width /= 3;
        this.height /= 3;

        this.y = -height;
    }
    Bitmap getRect(){
        if(this.rectCounter == 1){
            this.rectCounter++;
            return this.rect1;
        }
        if(this.rectCounter == 2){
            this.rectCounter++;
            return this.rect2;
        }
        this.rectCounter = 1;

        return this.rect3;
    }
}
