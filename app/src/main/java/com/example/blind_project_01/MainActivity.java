package com.example.blind_project_01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //TTS
    private TextToSpeech tts;

    //페이지 넘김. 설정.
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

        //TTS
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                String speech = "시각장애인 활동 보조 어플리케이션입니다. 화면을 위에서 아래로 밀어주시면 음성인식이 시작됩니다." +
                        "오른쪽에서 왼쪽으로 화면을 밀어주시면 기능들을 바로 사용 할 수 있습니다.";    //문자 작성.
                tts.setLanguage(Locale.KOREAN);
                tts.speak(speech, TextToSpeech.QUEUE_FLUSH,null);

            }
        });


        textView = findViewById(R.id.textView);

        DetectSwipeGestureListener gestureListener = new DetectSwipeGestureListener();
        gestureListener.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(this, gestureListener);

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
        textView.setText(message);
    }

    public void activityTurning(String message){
        if(textView != null){

            if(message == "Swipe To Left"){     //오른쪽에서 왼쪽.
                Intent intent = new  Intent(MainActivity.this, R1.class);
                startActivity(intent);
                tts.stop();
                tts.shutdown();
                tts = null;
                finish();
            }

            else if(message == "Swipe To Right"){       //왼쪽에서 오른쪽.
                Intent intent = new Intent(MainActivity.this, R3.class);
                startActivity(intent);
                tts.stop();
                tts.shutdown();
                tts = null;
                finish();
            }

            else if(message == "Swipe To Down"){      //위에서 아래로.
                Intent intent = new Intent(MainActivity.this, U1.class);
                startActivity(intent);
                tts.stop();
                tts.shutdown();
                tts = null;
                finish();
            }
        }

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
