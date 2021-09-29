package com.zonvoir.slidedemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zonvoir.slidedemo.R;

public class ActivityC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.zoom_out_pop, R.anim.zoom_out);

    }
}