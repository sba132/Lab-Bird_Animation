package com.csemadlab.birdanimation;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    AnimationDrawable birdAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imageView = findViewById(R.id.imageView);
        imageView.setBackgroundResource(R.drawable.bird_images);
        birdAnimation = (AnimationDrawable) imageView.getBackground();
    }

    @Override
    protected void onStart() {
        super.onStart();
        birdAnimation.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(birdAnimation.isRunning()){
            birdAnimation.stop();
        }
    }
}