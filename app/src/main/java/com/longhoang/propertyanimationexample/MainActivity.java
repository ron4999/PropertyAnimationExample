package com.longhoang.propertyanimationexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.IntProperty;
import android.util.Log;
import android.util.Property;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imgAnimation;
    private ConstraintLayout cslMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgAnimation = findViewById(R.id.iv_image);
        cslMain = findViewById(R.id.csl_main);

        Button btnZoom = findViewById(R.id.btn_zoom);
        btnZoom.setOnClickListener(view -> {
            zoomAnimation();
        });

        Button btnBlink = findViewById(R.id.btn_blink);
        btnBlink.setOnClickListener(view -> {
            blinkAnimation();
        });

        Button btnClockWise = findViewById(R.id.btn_clockwise);
        btnClockWise.setOnClickListener(view -> {
            clockWiseAnimation();
        });

        Button btnMove = findViewById(R.id.btn_move);
        btnMove.setOnClickListener(view -> {
            moveAnimation();
        });

        Button btnFade = findViewById(R.id.btn_fade);
        btnFade.setOnClickListener(view -> {
            fadeAnimation();
        });

        Button btnSlide = findViewById(R.id.btn_slide);
        btnSlide.setOnClickListener(view -> {
            slideAnimation();
        });

        Button btnMix = findViewById(R.id.btn_clockwise_translate);
        btnMix.setOnClickListener(view -> {
            mixAnimation();
        });

        imgAnimation.setOnClickListener(view -> {
            Toast.makeText(this, "This is image", Toast.LENGTH_SHORT).show();
        });
    }

    private void blinkAnimation() {
        // ValueAnimator
        ValueAnimator valueAnimator = ValueAnimator.ofInt(1, 100);
        valueAnimator.addUpdateListener(animation -> {
            int value = (int) animation.getAnimatedValue();
            Log.e("checkValue", "blinkAnimation: value = " + value);
            imgAnimation.setAlpha(value / 100f);
            imgAnimation.invalidate();
        });
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setDuration(2000);
//        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
//        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.start();

        // ObjectAnimator
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imgAnimation, "alpha", 0f, 1f);
//        objectAnimator.setInterpolator(new AccelerateInterpolator());
//        objectAnimator.setDuration(600);
//        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
//        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
//        objectAnimator.start();
    }

    private void mixAnimation() {
        // ValueAnimator
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
//        valueAnimator.addUpdateListener(animation -> {
//            float value = (float) animation.getAnimatedValue();
//            imgAnimation.setRotation(360 * value);
//            imgAnimation.setTranslationX(imgAnimation.getWidth() * 100 / 100f * value);
//            imgAnimation.invalidate();
//        });
//        valueAnimator.setDuration(2000);
//        valueAnimator.start();

        // ObjectAnimator
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imgAnimation, "rotation", 0f, 360f);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imgAnimation, "translationX", 0f, imgAnimation.getWidth() * 1f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(objectAnimator).with(objectAnimator1);
//        animatorSet.playTogether(objectAnimator, objectAnimator1);
        animatorSet.setDuration(2000);
        animatorSet.start();
    }

    private void clockWiseAnimation() {
        // ValueAnimator
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
//        valueAnimator.addUpdateListener(animation -> {
//            float value = (float) animation.getAnimatedValue();
//            imgAnimation.setRotation(360 * value);
//            imgAnimation.invalidate();
//        });
//        valueAnimator.setDuration(5000);
//        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
//        valueAnimator.setRepeatCount(1);
//
//        valueAnimator.start();

//         ObjectAnimator
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imgAnimation, "rotation", 0f, 360f);
        objectAnimator.setDuration(5000);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.setRepeatCount(1);
        objectAnimator.start();
    }

    private void moveAnimation() {
        // ValueAnimator
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.addUpdateListener(animation -> {
            float value = (float) animation.getAnimatedValue();
            imgAnimation.setTranslationX(imgAnimation.getWidth() * value);
            imgAnimation.invalidate();
        });
        valueAnimator.setDuration(800);

        valueAnimator.start();

        // ObjectAnimator
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imgAnimation, "translationX", 0, imgAnimation.getWidth());
//        objectAnimator.setDuration(800);
//        objectAnimator.start();
    }

    private void fadeAnimation() {
        // ValueAnimator
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
//        valueAnimator.addUpdateListener(animation -> {
//            float value = (float) animation.getAnimatedValue();
//            imgAnimation.setAlpha(value);
//            imgAnimation.invalidate();
//        });
//        valueAnimator.setDuration(2000);
//        valueAnimator.start();
//
//        ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(0, 1);
//        valueAnimator1.addUpdateListener(animation -> {
//            float value = (float) animation.getAnimatedValue();
//            imgAnimation.setAlpha(1 - value);
//            imgAnimation.invalidate();
//        });
//        valueAnimator1.setStartDelay(2000);
//        valueAnimator1.setDuration(2000);
//        valueAnimator1.start();

        // ValueAnimator2
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
//        valueAnimator.addUpdateListener(animation -> {
//            float value = (float) animation.getAnimatedValue();
//            imgAnimation.setAlpha(value);
//            imgAnimation.invalidate();
//        });
//        valueAnimator.setDuration(2000);
//        valueAnimator.setRepeatCount(1);
//        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
//        valueAnimator.start();

        // ObjectAnimator
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imgAnimation, "alpha", 0f, 1f);
//        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imgAnimation, "alpha", 1f, 0f);
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.play(objectAnimator1).after(objectAnimator);
//        animatorSet.play(objectAnimator);
//        animatorSet.setDuration(2000);
//        animatorSet.start();

        // ObjectAnimator2
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imgAnimation, "alpha", 0f, 1f);
        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatCount(1);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.start();
    }

    private void slideAnimation() {
//        Animation animationSlide = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
//        imgAnimation.startAnimation(animationSlide);
        imgAnimation.setPivotX(imgAnimation.getWidth() / 2f);
        imgAnimation.setPivotY(0);
        // ValueAnimator

//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
//        valueAnimator.addUpdateListener(animation -> {
//            float value = (float) animation.getAnimatedValue();
//            imgAnimation.setScaleY(1 - value);
//            imgAnimation.setScaleX(1);
//            imgAnimation.invalidate();
//        });
//        valueAnimator.setInterpolator(new LinearInterpolator());
//        valueAnimator.setDuration(500);
//
//        valueAnimator.start();

        // ObjectAnimator
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imgAnimation, "scaleY", 1f, 0f);
        objectAnimator.setInterpolator(new LinearInterpolator());
        objectAnimator.setDuration(500);

        objectAnimator.start();
    }

    private void zoomAnimation() {
        // ValueAnimator
//        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.5f, 1f);
//        valueAnimator.addUpdateListener(animation -> {
//            float value = (float) animation.getAnimatedValue();
//            imgAnimation.setScaleY(value);
//            imgAnimation.setScaleX(value);
//            imgAnimation.invalidate();
//        });
//        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
//        valueAnimator.setRepeatCount(1);
//        valueAnimator.setDuration(2000);
//
//        valueAnimator.start();

        // ObjectAnimator
//        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(imgAnimation, "scaleX", 0.5f, 1f);
//        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(imgAnimation, "scaleY", 0.5f, 1f);
//        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(imgAnimation, "scaleX", 1f, 0.5f);
//        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(imgAnimation, "scaleY", 1f, 0.5f);
//        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.playTogether(objectAnimator, objectAnimator1);
//        AnimatorSet animatorSet1 = new AnimatorSet();
//        animatorSet1.play(objectAnimator2).with(objectAnimator3).after(animatorSet);
//
//        animatorSet.setDuration(2000);
//        animatorSet.start();
//        animatorSet1.setDuration(2000);
//        animatorSet1.start();

        Property property = new IntProperty("testIntProperty") {
            @Override
            public void setValue(Object o, int i) {

            }

            @Override
            public Object get(Object o) {
                return null;
            }
        };

        ObjectAnimator objectAnimator = new ObjectAnimator(); // RED TO BLUE
        objectAnimator.setProperty(property);
        objectAnimator.setPropertyName("testIntProperty");
        objectAnimator.setEvaluator(new ArgbEvaluator());
        objectAnimator.setDuration(3000);
        objectAnimator.start();



        // ObjectAnimator.ofInt(this, "backgroundColor", /*Red*/0xFFFF8080, /*Blue*/0xFF8080FF);
    }
}