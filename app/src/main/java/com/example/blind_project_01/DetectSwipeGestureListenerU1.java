package com.example.blind_project_01;

import android.view.GestureDetector;
import android.view.MotionEvent;

public class DetectSwipeGestureListenerU1 extends GestureDetector.SimpleOnGestureListener {

    private static int MIN_SWIPE_DISTANCE_X = 100;
    private static  int MIN_SWIPE_DISTANCE_Y = 100;

    private static  int MAX_SWIPE_DISTANCE_X = 1000;
    private static  int MAX_SWIPE_DISTANCE_Y = 1000;

    private U1 activity = null;

    public U1 getActivity() { return activity;}

    public  void setActivity(U1 activity) {this.activity = activity;}

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        // Get swipe delta value in x axis.
        float deltaX = e1.getX() - e2.getX();

        // Get swipe delta value in y axis.
        float deltaY = e1.getY() - e2.getY();

        // Get absolute value.
        float deltaXAbs = Math.abs(deltaX);
        float deltaYAbs = Math.abs(deltaY);


        //Detect Left and Right swipes.
        if(deltaXAbs >= MIN_SWIPE_DISTANCE_X && deltaXAbs <= MAX_SWIPE_DISTANCE_X ){
            if(deltaX > 0){
                //this.activity.displayMessage("Swipe To Left");.
                this.activity.activityTurning("Swipe To Left");     //오른쪽에서 왼쪽.



            } else{
                //this.activity.displayMessage("Swipe to Right");.
                this.activity.activityTurning("Swipe To Right");        //왼쪽에서 오른쪽.

            }
        }

        // Only when swipe distance between minimal and maximal distance value then we treat it as effective swipe
        if((deltaYAbs >= MIN_SWIPE_DISTANCE_Y) && (deltaYAbs <= MAX_SWIPE_DISTANCE_Y))
        {
            if(deltaY > 0)
            {

                //this.activity.displayMessage("Swipe to up");
                this.activity.activityTurning("Swipe To Up");

            }else
            {
                //this.activity.displayMessage("Swipe to down");.
                this.activity.activityTurning("Swipe To Down");
            }
        }

        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        this.activity.displayMessage("Single Tap");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        //this.activity.displayMessage("Double Tap");
        this.activity.speak();          //private로 하면 오버라이드가 안되기 때문에 public으로 U1.java에 함수 정의함.
        return true;
    }
}
