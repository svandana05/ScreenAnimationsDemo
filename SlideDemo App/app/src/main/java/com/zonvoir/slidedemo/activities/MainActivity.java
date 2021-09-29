package com.zonvoir.slidedemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zonvoir.slidedemo.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnA = findViewById(R.id.btnA);
        Button btnB = findViewById(R.id.btnB);
        Button btnC = findViewById(R.id.btnC);
        Button btnD = findViewById(R.id.btnD);

        clickListener(btnA, btnB, btnC, btnD);
    }


    private void clickListener(View... views){
        for (View v:
             views) {
            v.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.btnA:
                intent = new Intent(MainActivity.this, ActivityA.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,
                        R.anim.slide_out_left);

                break;
            case R.id.btnB:
                intent = new Intent(MainActivity.this, ActivityB.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
                break;
            case R.id.btnC:
                intent = new Intent(MainActivity.this, ActivityC.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_in_pop);
                break;
            case R.id.btnD:
                intent = new Intent(MainActivity.this, ActivityD.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
        }
    }
}