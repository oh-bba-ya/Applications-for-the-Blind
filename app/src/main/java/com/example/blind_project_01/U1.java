package com.example.blind_project_01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class U1 extends AppCompatActivity {

    //STT
    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;

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


        //Swipe
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


    //Swipe
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
                tts.stop();
                tts.shutdown();
                tts = null;
                finish();
            }
        }
    }

    //STT
    public void speak() {
        //intent to show speech to text dialog
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.KOREAN);        //언어 설정인가?
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi speak somthing");

        //start intent
        try {
            //in there was no error
            //show dialog
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
            tts.stop();
            tts.shutdown();
            tts = null;
        } catch (Exception e) {
            //if there was some error
            //get message of error and show
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

    //receive voice input and handle it

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        switch (requestCode) {
            case REQUEST_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    //get text array from voice intent
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    //set to text view

                    //mTextTv.setText(result.get(0));  결과값을 나타낼 필요가 없어 주석처리.

                    String message = result.get(0);

                    if (message.contains("바코드")) {
                        Intent intent = new Intent(U1.this, R2.class);
                        startActivity(intent);
                        finish();       //화면전환시 현재 Activity 삭제.
                    }

                    else if(message.contains("이미지")){
                        Intent intent = new Intent(U1.this, R1.class);
                        startActivity(intent);
                        finish();       //화면전환시 현재 Activity 삭제.
                    }

                    else if(message.contains("텍스트") || message.contains("글자")){
                        Intent intent = new Intent(U1.this, R3.class);
                        startActivity(intent);
                        finish();       //화면전환시 현재 Activity 삭제.
                    }

                    break;
                }
            }

        }
    }


}
