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

            case R.id.radioButtonViewPropertyAnimator:

                switch (v.getId()){

                    case R.id.animation_alpha:
                        Runnable reversAlpha = new Runnable() {
                            public void run() {
                                title.animate().alpha(1).setDuration(3000);
                            }
                        };
                        title.animate().alpha(0).setDuration(3000).withEndAction(reversAlpha);
                        break;
                    case R.id.animation_rotate:
                        title.animate().rotation(360).setDuration(3000);
                        break;
                    case R.id.animation_scale:
                        Runnable reversScale = new Runnable() {
                            @Override
                            public void run() {
                                title.animate().scaleX(1).scaleY(1).setDuration(3000);
                            }
                        };
                        title.animate()
                                .scaleX(0.5f)
                                .scaleY(0.5f)
                                .setDuration(3000)
                                .withEndAction(reversScale);
                        break;

                    case R.id.animation_translate:
                        Runnable reverseTranslate = new Runnable() {
                            @Override
                            public void run() {
                                title.animate().translationX(0).translationY(0).setDuration(3000);
                            }
                        };
                        title.animate()
                                .translationX(-100)
                                .translationY(-100)
                                .setDuration(3000)
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
