package com.example.startbuddy;

import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

public class Mountain extends AppCompatActivity {
    ImageView imageView;
    MediaPlayer mm;
    ImageButton btn1;
    TextView output;
    final int REQ_CODE_SPEECH_INPUT=100;
    TextToSpeech t1;
    Button btn2;
    private StringBuilder text = new StringBuilder();
    RelativeLayout r1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        btn1 =  findViewById(R.id.button2);

        imageView = findViewById(R.id.image1);
        imageView.setImageResource(R.drawable.a4);
        btn2=findViewById(R.id.afterlistening);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getApplicationContext());
                dialog.setContentView(R.layout.whatifeel);
                Button hide = dialog.findViewById(R.id.hide_btn);
                dialog.show();
                hide.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
            }
        });
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setSpeechRate(0.9f);
                    t1.setLanguage(Locale.ENGLISH);
                    //  t1.setLanguage(new Locale("en", "IN"));


                }
            }
        });
        mm= MediaPlayer.create(getApplicationContext(),R.raw.backgroundmusic);
        mm.start();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("Mountain Meditation.txt")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                text.append(mLine);
                text.append('\n');
            }
        }
        catch (IOException e)

        {
            Toast.makeText(getApplicationContext(),"Error reading file!", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        finally
        {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }

            output= findViewById(R.id.textView);
            output.setMovementMethod(new ScrollingMovementMethod());
            output.setText(text);

        }



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btn1.setVisibility(View.GONE);
                String toSpeak = output.getText().toString();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);


            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if(requestCode==REQ_CODE_SPEECH_INPUT)
        {
            if(resultCode==RESULT_OK && null != data)
            {
                ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                output.setText(result.get(0));

            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onPause() {
        super.onPause();
        t1.shutdown();
        //  Intent intent = new Intent(getApplicationContext(),Whatufeel.class);
        // startActivity(intent);
    }


    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        t1.shutdown();
        //Intent intent = new Intent(getApplicationContext(),Whatufeel.class);
        //startActivity(intent);
        mm.stop();
        finish();
    }
}

