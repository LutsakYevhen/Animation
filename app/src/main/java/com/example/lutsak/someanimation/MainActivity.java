package com.example.lutsak.someanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int DEFAULT_DURATION = 3000;
    public static final int ALPHA_FROM = 0;
    public static final int ALPHA_TO = 1;
    public static final int ROTATION_TO = 360;
    public static final int ROTATION_BACK = 0;
    public static final float SCALE_XY_TO = 0.5f;
    public static final float SCALE_XY_BACK_TO = 1f;
    public static final float TRANSLATION_XY_TO = -100;
    public static final float TRANSLATION_XY_BACK_TO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getElements();
    }

    @Override
    public void onClick(View v) {

        Animation animation = null;
        Animator animator;
        RadioGroup groupClass = findViewById(R.id.radio_group_class);
        final TextView title = findViewById(R.id.animator_text);

        switch (groupClass.getCheckedRadioButtonId()) {
            // Animate our textView using ANIMATION and load animation from xml file
            case R.id.radioButtonAnimation:

                switch (v.getId()) {

                    case R.id.animation_alpha:
                        animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                        break;
                    case R.id.animation_rotate:
                        animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                        break;
                    case R.id.animation_scale:
                        animation = AnimationUtils.loadAnimation(this, R.anim.scale);
                        break;
                    case R.id.animation_translate:
                        animation = AnimationUtils.loadAnimation(this, R.anim.translate);
                        break;
                }
                title.startAnimation(animation);
            // Animate textView using Animator and load animation from xml using AnimatorInflater
            case R.id.radioButtonAnimator:

                switch (v.getId()) {

                    case R.id.animation_alpha:
                        animator = AnimatorInflater.loadAnimator(this, R.animator.alpha);
                        animator.setTarget(title);
                        animator.start();
                        break;
                    case R.id.animation_rotate:
                        animator = AnimatorInflater.loadAnimator(this, R.animator.rotate);
                        animator.setTarget(title);
                        animator.start();
                        break;
                    case R.id.animation_scale:
                        animator = AnimatorInflater.loadAnimator(this, R.animator.scale);
                        animator.setTarget(title);
                        animator.start();
                        break;
                    case R.id.animation_translate:
                        animator = AnimatorInflater.loadAnimator(this, R.animator.translate);
                        animator.setTarget(title);
                        animator.start();
                        break;
                }
            /* Animate our textView using ViewPropertyAnimator
              (using Runnable we add one more animation that reverse our first)*/
            case R.id.radioButtonViewPropertyAnimator:

                switch (v.getId()){

                    case R.id.animation_alpha:
                        Runnable reversAlpha = new Runnable() {
                            public void run() {
                                title.animate()
                                        .alpha(ALPHA_TO)
                                        .setDuration(DEFAULT_DURATION);
                            }
                        };
                        title.animate()
                                .alpha(ALPHA_FROM)
                                .setDuration(DEFAULT_DURATION)
                                .withEndAction(reversAlpha);
                        break;
                    case R.id.animation_rotate:
                        Runnable reversRotation = new Runnable() {
                            @Override
                            public void run() {
                                title.animate()
                                        .rotation(ROTATION_BACK)
                                        .setDuration(DEFAULT_DURATION);
                            }
                        };
                        title.animate()
                                .rotation(ROTATION_TO)
                                .setDuration(DEFAULT_DURATION)
                                .withEndAction(reversRotation);
                        break;
                    case R.id.animation_scale:
                        Runnable reversScale = new Runnable() {
                            @Override
                            public void run() {
                                title.animate()
                                        .scaleX(SCALE_XY_BACK_TO)
                                        .scaleY(SCALE_XY_BACK_TO)
                                        .setDuration(DEFAULT_DURATION);
                            }
                        };
                        title.animate()
                                .scaleX(SCALE_XY_TO)
                                .scaleY(SCALE_XY_TO)
                                .setDuration(DEFAULT_DURATION)
                                .withEndAction(reversScale);
                        break;
                    case R.id.animation_translate:
                        Runnable reverseTranslate = new Runnable() {
                            @Override
                            public void run() {
                                title.animate()
                                        .translationX(TRANSLATION_XY_BACK_TO)
                                        .translationY(TRANSLATION_XY_BACK_TO)
                                        .setDuration(DEFAULT_DURATION);
                            }
                        };
                        title.animate()
                                .translationX(TRANSLATION_XY_TO)
                                .translationY(TRANSLATION_XY_TO)
                                .setDuration(DEFAULT_DURATION)
                                .withEndAction(reverseTranslate);
                        break;
                }
        }
    }

    private void getElements() {
        Button alphaButton = findViewById(R.id.animation_alpha);
        Button rotateButton = findViewById(R.id.animation_rotate);
        Button scaleButton = findViewById(R.id.animation_scale);
        Button translateButton = findViewById(R.id.animation_translate);

        alphaButton.setOnClickListener(this);
        rotateButton.setOnClickListener(this);
        scaleButton.setOnClickListener(this);
        translateButton.setOnClickListener(this);
    }

}
