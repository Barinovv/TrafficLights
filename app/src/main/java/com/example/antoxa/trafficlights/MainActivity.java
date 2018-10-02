package com.example.antoxa.trafficlights;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {


    Button redButton;
    Button yellowButton;
    Button greenButton;
    ConstraintLayout constraintLayout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redButton = findViewById(R.id.buttonRed);
        yellowButton = findViewById(R.id.buttonYellow);
        greenButton = findViewById(R.id.buttonGreen);
        constraintLayout = findViewById(R.id.background);

    }


    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.buttonRed):
                constraintLayout.setBackgroundColor(Color.RED);
                break;
            case (R.id.buttonYellow):
                constraintLayout.setBackgroundColor(Color.YELLOW);
                break;
            case (R.id.buttonGreen):
                constraintLayout.setBackgroundColor(Color.GREEN);
                break;
        }
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        View view = findViewById(R.id.background);
        int color = Color.TRANSPARENT;
        Drawable background = view.getBackground();
        if (background instanceof ColorDrawable)
            color = ((ColorDrawable) background).getColor();
        outState.putInt("background", color);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        View view = findViewById(R.id.background);

        if (savedInstanceState != null && savedInstanceState.containsKey("background")) {
            view.setBackgroundColor(savedInstanceState.getInt("background"));
        }
    }
}


