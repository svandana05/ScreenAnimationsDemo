package com.zonvoir.slidedemo.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;

import com.zonvoir.slidedemo.R;
import com.zonvoir.slidedemo.fragments.FragmentA;
import com.zonvoir.slidedemo.fragments.FragmentB;
import com.zonvoir.slidedemo.fragments.FragmentC;
import com.zonvoir.slidedemo.fragments.FragmentD;

import java.util.ArrayList;

public class ActivityD extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<String> spinnerList;
    int animType = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        AppCompatSpinner spinner = findViewById(R.id.spinner);
        spinnerList = new ArrayList<>();

        spinnerList.add("Slide Left-Right");
        spinnerList.add("Slide Up-Down");
        spinnerList.add("PopUp In-Out");
        spinnerList.add("Fade In-Out");

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, spinnerList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                animType = i;
                Toast.makeText(ActivityD.this, "Anim selected: " + spinnerList.get(i), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

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

    private void loadFragment(Fragment fragment){
        if (fragment != null) {
            int enterAnim = 0, exitAnim=0, popEnter=0, popExit=0;
            if(animType==0){
                enterAnim = R.anim.slide_in_right;
                exitAnim = R.anim.slide_out_left;
                popEnter = R.anim.slide_in_left;
                popExit = R.anim.slide_out_right;
            }else if(animType==1){
                enterAnim = R.anim.slide_up;
                exitAnim = R.anim.slide_down;
                popEnter = R.anim.slide_down_reverse;
                popExit = R.anim.slide_up_reverse;
            }else if(animType==2){
                enterAnim = R.anim.zoom_in;
                exitAnim = R.anim.zoom_in_pop;
                popEnter = R.anim.zoom_out_pop;
                popExit = R.anim.zoom_out;
            }else if(animType==3){
                enterAnim = R.anim.fade_in;
                exitAnim = R.anim.fade_out;
                popEnter = R.anim.fade_in;
                popExit = R.anim.fade_out;
            }
            getSupportFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(
                            enterAnim,
                            exitAnim,
                            popEnter,
                            popExit
                    )
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnA:
                loadFragment(new FragmentA());
                break;
            case R.id.btnB:
                loadFragment(new FragmentB());
                break;
            case R.id.btnC:
                loadFragment(new FragmentC());
                break;
            case R.id.btnD:
                loadFragment(new FragmentD());
                break;
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}