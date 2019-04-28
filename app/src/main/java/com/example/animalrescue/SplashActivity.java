package com.example.animalrescue;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class SplashActivity extends AppCompatActivity {
TextView welcomeText;         //making all the views global so that they can be accessed by all the functions.
ImageView welcomeImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        welcomeText=findViewById(R.id.welcometext);    //getting reference and making it a java object.
        welcomeImage=findViewById(R.id.welcomelogo);

        Animation animation= AnimationUtils.loadAnimation(this,R.anim.transition_for_splash);//got the animation object
                                                                                                    //from anim directory
        welcomeText.startAnimation(animation);
        welcomeImage.startAnimation(animation);  //starting animation


        new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent=new Intent(SplashActivity.this,SomeActivity.class);
                startActivity(intent);//Explicit Intent to start the new activity
                finish();//when you press back button this activity wont be called again because we have removed it from stack
            }
        }.start();

    }
}
