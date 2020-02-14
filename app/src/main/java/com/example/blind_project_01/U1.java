package com.example.blind_project_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class U1 extends AppCompatActivity {

    TextView U1_textView;

    private GestureDetectorCompat gestureDetectorCompat = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u1);

        U1_textView = findViewById(R.id.U1_textView);

        DetectSwipeGestureListenerU1 gestureListenerU1 = new DetectSwipeGestureListenerU1();
        gestureListenerU1.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(U1.this, gestureListenerU1);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }

    public void displayMessage(String message){
        U1_textView.setText(message);
    }

    public void activityTurning(String message) {
        if (U1_textView != null) {


            if(message == "Swipe To Up"){
                Intent intent = new Intent(U1.this, MainActivity.class);
                startActivity(intent);
            }
        }
    }

}
