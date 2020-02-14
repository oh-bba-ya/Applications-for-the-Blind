package com.example.blind_project_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.MotionEvent;
import android.widget.TextView;

import java.util.Locale;

public class U1 extends AppCompatActivity {

    //TTS
    private TextToSpeech tts;

    TextView U1_textView;

    private GestureDetectorCompat gestureDetectorCompat = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u1);

        //TTS
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                String speech = "음성인식 페이지 입니다. 음성 인식을 사용하기 위해 두번 터치해주세요";    //문자 작성.
                tts.setLanguage(Locale.KOREAN);
                tts.speak(speech, TextToSpeech.QUEUE_FLUSH,null);

            }
        });


        U1_textView = findViewById(R.id.U1_textView);

        DetectSwipeGestureListenerU1 gestureListenerU1 = new DetectSwipeGestureListenerU1();
        gestureListenerU1.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(U1.this, gestureListenerU1);

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
