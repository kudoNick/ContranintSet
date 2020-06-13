package com.example.animationlayout;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1;
    ConstraintSet constraintSet1;
    ConstraintSet constraintSet2;
    ConstraintLayout root;
    private boolean set = true;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1 = findViewById(R.id.imageView);
        button = findViewById(R.id.btnButtom);
        root = findViewById(R.id.root);
        addAnimationIcon();
    }

    private void addAnimationIcon() {
        constraintSet1 = new ConstraintSet();
        constraintSet1.clone(this, R.layout.activity_main);
        constraintSet2 = new ConstraintSet();
        constraintSet2.clone(this, R.layout.acivity_main2);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionManager.beginDelayedTransition(root);
                    // set đang bằng true | nếu đang là fale thì mở màn hình 1 và cho set bằng true, ko thì sẽ mở màn hình 2 mà cho set bằng fale
                    if (!set) {
//                        constraintSet1.applyTo(root);
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                        Toast.makeText(MainActivity.this, "True", Toast.LENGTH_SHORT).show();
                       set = true;
                    } else {
                        constraintSet2.applyTo(root);
                        Toast.makeText(MainActivity.this, "False", Toast.LENGTH_SHORT).show();
                        set = false;
                    }
                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                constraintSet1 = new ConstraintSet();
                constraintSet1.clone(MainActivity.this, R.layout.activity_main);
                TransitionManager.beginDelayedTransition(root);
                constraintSet1.applyTo(root);
                set = true;
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onResume() {
        super.onResume();
        constraintSet1 = new ConstraintSet();
        constraintSet1.clone(this, R.layout.activity_main);
        TransitionManager.beginDelayedTransition(root);
        constraintSet1.applyTo(root);
    }
    //    @Override
//    protected void onPause() {
//        super.onPause();
//        constraintSet1 = new ConstraintSet();
//        constraintSet1.clone(this, R.layout.activity_main);
//        TransitionManager.beginDelayedTransition(root);
//        constraintSet1.applyTo(root);
//    }
}