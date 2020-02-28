package com.example.blind_project_01;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextDetector;

import java.util.List;
import java.util.Locale;

public class R3 extends AppCompatActivity {

    //tts
    private TextToSpeech tts;

    TextView R3_textView;

    private GestureDetectorCompat gestureDetectorCompat = null;

    //text인식.
    private Button captureImageBtn, detectTextBtn;
    private ImageView imageView;
    private TextView textView;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private Bitmap imageBitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r3);

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                String speech = "글자인식 페이지 입니다. 기능을 사용하기 위해 두번 터치해주세요";    //문자 작성.
                tts.setLanguage(Locale.KOREAN);
                tts.speak(speech, TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        R3_textView = findViewById(R.id.R3_textView);

        DetectSwipeGestureListenerR3 gestureListenerR1 = new DetectSwipeGestureListenerR3();
        gestureListenerR1.setActivity(this);
        gestureDetectorCompat = new GestureDetectorCompat(R3.this, gestureListenerR1);


        //text인식
        captureImageBtn = findViewById(R.id.capture_image_btn);
        detectTextBtn = findViewById(R.id.detect_text_image_btn);
        imageView = findViewById(R.id.image_view);
        textView = findViewById(R.id.text_display);

        captureImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
                textView.setText("");
            }
        });

        detectTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                detectTextFromImage();
                
            }
        });



    }




    //Text 인식
    private void dispatchTakePictureIntent()
    {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null)
        {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK)
        {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }


    private void detectTextFromImage()
    {
        FirebaseVisionImage firebaseVisionImage = FirebaseVisionImage.fromBitmap(imageBitmap);
        FirebaseVisionTextDetector firebaseVisionTextDetector = FirebaseVision.getInstance().getVisionTextDetector();
        firebaseVisionTextDetector.detectInImage(firebaseVisionImage).addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
            @Override
            public void onSuccess(FirebaseVisionText firebaseVisionText) {
                displayTextFromImage(firebaseVisionText);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(R3.this, "Error: " + e.getMessage(),Toast.LENGTH_SHORT);

                Log.d("Error: ",e.getMessage());
            }
        });


    }

    private void displayTextFromImage(FirebaseVisionText firebaseVisionText) {
        List<FirebaseVisionText.Block> blockList = firebaseVisionText.getBlocks();
        if(blockList.size() == 0){
            Toast.makeText(this, "No TextFound in image.", Toast.LENGTH_SHORT);
        }
        else{
            for(FirebaseVisionText.Block block : firebaseVisionText.getBlocks()){
                String text = block.getText();
                textView.setText(text);
            }
        }
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
        R3_textView.setText(message);
    }

    public void activityTurning(String message) {
        if (R3_textView != null) {

            if (message == "Swipe To Left") {     //오른쪽에서 왼쪽.
                Intent intent = new Intent(R3.this, MainActivity.class);
                startActivity(intent);
                tts.stop();
                tts.shutdown();
                tts = null;
                finish();
            } else if (message == "Swipe To Right") {  //왼쪽에서 오른쪽.
                Intent intent = new Intent(R3.this, R2.class);
                startActivity(intent);
                tts.stop();
                tts.shutdown();
                tts = null;
                finish();
            } else if (message == "Swipe To Down") {          //위에서 아래로.
                Intent intent = new Intent(R3.this, U1.class);
                startActivity(intent);
                tts.stop();
                tts.shutdown();
                tts = null;
                finish();
            }
        }
    }

}
