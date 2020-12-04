package com.example.tubes02;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;

public class GameFragment extends Fragment implements View.OnClickListener, View.OnTouchListener {
    protected UIThreadHandler uiThreadHandler;
    private FragmentListener fragmentListener;
    protected Canvas mCanvas;
    protected ImageView ivCanvas;
    protected Bitmap mBitmap;

    private TextView startBtn;
    private int tileWidth;
    private int heightLimit;

    public void setUIThreadHandler(UIThreadHandler ui){
        this.uiThreadHandler = ui;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        this.ivCanvas = view.findViewById(R.id.iv_main);

        this.startBtn = view.findViewById(R.id.tv_game_start);
        this.startBtn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.fragmentListener = (FragmentListener) context;
        } else{
            throw new ClassCastException(context.toString()
                    + "must implement FragmentListener");
        }
    }

    public void initiateCanvas(){
        // 1. Create Bitmap
        this.mBitmap = Bitmap.createBitmap(this.ivCanvas.getWidth(),this.ivCanvas.getHeight(), Bitmap.Config.ARGB_8888);
        // 2. Associate the bitmap to the ImageView.
        this.ivCanvas.setImageBitmap(mBitmap);
        // 3. Create a Canvas with the bitmap.
        this.mCanvas = new Canvas(this.mBitmap);
        //resetCanvas
        this.resetCanvas();
        this.ivCanvas.setOnTouchListener(this);
        this.tileWidth = this.ivCanvas.getWidth()/3;
        this.heightLimit = this.ivCanvas.getHeight();

        int[] initPos = {10, 50};
        int[] initPos2 = {this.tileWidth+10, 0};
        int[] initPos3 = {this.tileWidth*2+10, 80};
//        MoveThread threadObj = new MoveThread(this.uiThreadHandler, initPos, ivCanvas.getHeight());
//        threadObj.moveObject();

        DrawerAsyncTask dat = new DrawerAsyncTask();
        dat.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, initPos[0], initPos[1]);
        DrawerAsyncTask dat2 = new DrawerAsyncTask();
        dat2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, initPos2[0], initPos2[1]);
        DrawerAsyncTask dat3 = new DrawerAsyncTask();
        dat3.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, initPos3[0], initPos3[1]);
    }

    public void resetCanvas(){
        // 4. Draw canvas background
        this.mCanvas.drawColor(ResourcesCompat.getColor(getResources(), R.color.white, null));
        // 5. force draw
        this.ivCanvas.invalidate();
    }

    @Override
    public void onClick(View v) {
        if(v==this.startBtn){
            initiateCanvas();
            this.startBtn.setVisibility(View.GONE);
        }
    }

    public void move(int newPosX, int newPosY){
        this.resetCanvas();
        Paint paint = new Paint();
        int mColorTest = ResourcesCompat.getColor(getResources(),R.color.teal_200, null);
        paint.setColor(mColorTest);

        mCanvas.drawRect(newPosX, newPosY, newPosX+this.tileWidth,newPosY+200, paint);
        this.ivCanvas.invalidate();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int x = (int)motionEvent.getX();
        int y = (int)motionEvent.getY();
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                this.checkAction(x, y);
                Log.d("touch_listener", "down");
                Log.d("POSITION", x+" "+y);
                break;
            case MotionEvent.ACTION_POINTER_DOWN:
                Log.d("touch_listener", "pointer_down");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("touch_listener", "up");
                break;
            case MotionEvent.ACTION_POINTER_UP:
                Log.d("touch_listener", "pointer_up");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("touch_listener", "move");
                break;
        }
        return false;
    }

    public void checkAction(int x, int y){
        //if x, y is in range within the rectangle, add score, else game over?
    }

    public int getHeightCanvas(){
        return this.ivCanvas.getMaxHeight();
    }


    private class DrawerAsyncTask extends AsyncTask<Integer, Integer, String>{

        protected void onPreExecute(){
//            this.countNumber = 0;
        }

        protected void onProgressUpdate(Integer... progress){
            int count = progress[0];
//            counterView.setText(Integer.toString(count));
        }

        protected void onPostExecute(String result){
//            btn.setText("START");
//            counterView.setText("0");
//            countNumber = 0;
//            Toast toast = Toast.makeText(counterView.getContext(),"Counter "+(position+1)+" finished", Toast.LENGTH_SHORT);
//            toast.show();
//            //Challenge 7.
//            renewJob();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            int posX = integers[0];
            int posY = integers[1];

            Log.d("x is: ",posX+"");
            Log.d("y is: ",posY+"");

            int incrY = 20;

            int arrPos[] = {posX, posY};

            while(arrPos[1]<heightLimit){
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                move(arrPos[0],arrPos[1]);

                arrPos[1] = arrPos[1]+incrY;
            }
            return null;
        }
    }
}

