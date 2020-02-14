package com.example.blind_project_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class R2 extends AppCompatActivity {

    TextView R2_textView;

    private GestureDetectorCompat gestureDetectorCompat =null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r2);

        R2_textView = findViewById(R.id.R2_textView);

        DetectSwipeGestureListenerR2 gestureListenerR2 = new DetectSwipeGestureListenerR2();
        gestureListenerR2.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(R2.this, gestureListenerR2);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }

    public void displayMessage(String message){
        R2_textView.setText(message);
    }

    public void activityTurning(String message) {
        if (R2_textView != null) {

            if (message == "Swipe To Left") {     //오른쪽에서 왼쪽.
                Intent intent = new Intent(R2.this, R3.class);
                startActivity(intent);
            } else if (message == "Swipe To Right") {  //왼쪽에서 오른쪽.
                Intent intent = new Intent(R2.this, R1.class);
                startActivity(intent);
            } else if (message == "Swipe To Down") {          //위에서 아래로.
                Intent intent = new Intent(R2.this, U1.class);
                startActivity(intent);
            }
        }
    }
}
