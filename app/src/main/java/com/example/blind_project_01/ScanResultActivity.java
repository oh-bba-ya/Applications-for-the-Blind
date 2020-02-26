package com.example.blind_project_01;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.util.Locale;

public class ScanResultActivity extends AppCompatActivity {

    TextView TextView_barcode;
    private TextToSpeech tts;
    private String[] scoreList;
    private int i;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_result);

        TextView_barcode=findViewById(R.id.TextView_barcode);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String bar_number=bundle.getString("bar_number");

        //TextView_barcode.setText(bar_number);



        InputStream inputStream = getResources().openRawResource(R.raw.barcode_data);
        CSVFile csvFile = new CSVFile(inputStream);
        scoreList = csvFile.read();

        int cnt=0;
        for(i=1; i<scoreList.length; i+=2){
            cnt++;
            if(scoreList[i].replace("\'", "").equals(bar_number)){
                TextView_barcode.setText(scoreList[i-1]);
                tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        String speech = scoreList[i-1];           //작성된 문자.
                        tts.setLanguage(Locale.KOREAN);
                        tts.speak(speech,TextToSpeech.QUEUE_FLUSH, null);
                    }
                });
                break;
            }
           // if (cnt==scoreList.length/2)
         //       TextView_barcode.setText("검색되지 않았습니다.");
        }
        //TTS





    }


}

