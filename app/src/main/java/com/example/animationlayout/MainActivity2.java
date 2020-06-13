package com.example.animationlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;

public class MainActivity2 extends AppCompatActivity {

    ConstraintSet constraintSet1;
    ConstraintLayout root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        root = findViewById(R.id.root);
    }
}