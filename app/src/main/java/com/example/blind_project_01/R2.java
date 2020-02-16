package com.example.blind_project_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.MotionEvent;
import android.widget.TextView;

import java.util.Locale;

public class R2 extends AppCompatActivity {

    //TTS
    private TextToSpeech tts;


    TextView R2_textView;

    private GestureDetectorCompat gestureDetectorCompat =null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r2);

        //TTS 실행.
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                String speech = "바코드 인식 기능 페이지입니다. 기능을 사용하기 위해 두번 터치해주세요";    //문자 작성.
                tts.setLanguage(Locale.KOREAN);
                tts.speak(speech, TextToSpeech.QUEUE_FLUSH,null);
            }
        });


        R2_textView = findViewById(R.id.R2_textView);

        DetectSwipeGestureListenerR2 gestureListenerR2 = new DetectSwipeGestureListenerR2();
        gestureListenerR2.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(R2.this, gestureListenerR2);

    }

    //어플리케이션 종료시 TTS 중단.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // TTS 객체가 남아있다면 실행을 중지하고 메모리에서 제거한다.
        if(tts != null){
            tts.stop();
            tts.shutdown();
            tts = null;
        }
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
                tts.stop();
                tts.shutdown();
                tts = null;
                finish();
            } else if (message == "Swipe To Right") {  //왼쪽에서 오른쪽.
                Intent intent = new Intent(R2.this, R1.class);
                startActivity(intent);
                tts.stop();
                tts.shutdown();
                tts = null;
                finish();
            } else if (message == "Swipe To Down") {          //위에서 아래로.
                Intent intent = new Intent(R2.this, U1.class);
                startActivity(intent);
                tts.stop();
                tts.shutdown();
                tts = null;
                finish();
            }
            else if (message == "Swipe To Up"){         //아래에서 위로.
                Intent intent = new Intent(R2.this, MainActivity.class);
                startActivity(intent);
                tts.stop();
                tts.shutdown();
                tts = null;
                finish();
            }
        }
    }
}
