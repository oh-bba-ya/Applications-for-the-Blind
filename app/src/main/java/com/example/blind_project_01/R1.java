package com.example.blind_project_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.MotionEvent;
import android.widget.TextView;

import java.util.Locale;

public class R1 extends AppCompatActivity {

    //tts
    private TextToSpeech tts;

    TextView R1_textView;

    private GestureDetectorCompat gestureDetectorCompat =null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r1);

        //tts 실행.
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                String speech = "이미지인식 페이지 입니다. 기능을 사용하기 위해 두번 터치해주세요";    //문자 작성.
                tts.setLanguage(Locale.KOREAN);
                tts.speak(speech, TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        R1_textView = findViewById(R.id.R1_textView);

        DetectSwipeGestureListenerR1 gestureListenerR1 = new DetectSwipeGestureListenerR1();
        gestureListenerR1.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(R1.this, gestureListenerR1);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetectorCompat.onTouchEvent(event);
        return true;
    }

    public void displayMessage(String message){
        R1_textView.setText(message);
    }

    public void activityTurning(String message) {
        if (R1_textView != null) {

            if (message == "Swipe To Left") {     //오른쪽에서 왼쪽.
                Intent intent = new Intent(R1.this, R2.class);
                startActivity(intent);
                tts.stop();
                tts.shutdown();
                tts = null;
            } else if (message == "Swipe To Right") {  //왼쪽에서 오른쪽.
                Intent intent = new Intent(R1.this, MainActivity.class);
                startActivity(intent);
                tts.stop();
                tts.shutdown();
                tts = null;
                finish();
            } else if (message == "Swipe To Down") {          //위에서 아래로.
                Intent intent = new Intent(R1.this, U1.class);
                startActivity(intent);
                tts.stop();
                tts.shutdown();
                tts = null;
                finish();
            }
        }
    }
}
