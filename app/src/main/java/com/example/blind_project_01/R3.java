package com.example.blind_project_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class R3 extends AppCompatActivity {

    TextView R3_textView;

    private GestureDetectorCompat gestureDetectorCompat = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r3);

        R3_textView = findViewById(R.id.R3_textView);

        DetectSwipeGestureListenerR3 gestureListenerR1 = new DetectSwipeGestureListenerR3();
        gestureListenerR1.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(R3.this, gestureListenerR1);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }

    public void displayMessage(String message){
        R3_textView.setText(message);
    }

    public void activityTurning(String message) {
        if (R3_textView != null) {

            if (message == "Swipe To Left") {     //오른쪽에서 왼쪽.
                Intent intent = new Intent(R3.this, MainActivity.class);
                startActivity(intent);
            } else if (message == "Swipe To Right") {  //왼쪽에서 오른쪽.
                Intent intent = new Intent(R3.this, R2.class);
                startActivity(intent);
            } else if (message == "Swipe To Down") {          //위에서 아래로.
                Intent intent = new Intent(R3.this, U1.class);
                startActivity(intent);
            }
        }
    }

}
