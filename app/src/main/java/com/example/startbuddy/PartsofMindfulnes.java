package com.example.startbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PartsofMindfulnes extends AppCompatActivity implements View.OnClickListener {
    ImageButton b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partsof_mindfulnes);
        b1= findViewById(R.id.knowingbtn);
        b2 = findViewById(R.id.beingbtn);
        b3 = findViewById(R.id.doingbtn);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
    switch (v.getId())
    {
        case R.id.knowingbtn:
            Intent intent = new Intent(getApplicationContext(), Knowing.class);
            startActivity(intent);
            break;
        case R.id.beingbtn:
            Intent intent1 = new Intent(getApplicationContext(),Being.class);
            startActivity(intent1);
            break;
        case R.id.doingbtn:
            Intent intent2 = new Intent(getApplicationContext(),Doing.class);
            startActivity(intent2);
            break;


    }
    }
}
