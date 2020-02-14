package com.example.blind_project_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    private GestureDetectorCompat gestureDetectorCompat =null;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();
        gestureListener.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }

    public void displayMessage(String message){
        textView.setText(message);
    }

    public void activityTurning(String message){
        if(textView != null){

            if(message == "Swipe To Left"){     //오른쪽에서 왼쪽.
                Intent intent = new  Intent(MainActivity.this, R1.class);
                startActivity(intent);
            }

            else if(message == "Swipe To Right"){       //왼쪽에서 오른쪽.
                Intent intent = new Intent(MainActivity.this, R3.class);
                startActivity(intent);
            }

            else if(message == "Swipe To Down"){      //위에서 아래로.
                Intent intent = new Intent(MainActivity.this, U1.class);
                startActivity(intent);
            }
        }

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
