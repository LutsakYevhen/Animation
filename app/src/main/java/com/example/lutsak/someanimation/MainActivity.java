package com.example.lutsak.someanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    TextView title;
    Button alphaButton;
    Button rotateButton;
    Button scaleButton;
    Button translateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, ">> onCreate");

        getElements();

        Log.d(TAG, "<< onCreate");
    }

    private void getElements() {
        title = findViewById(R.id.animator_text);
        alphaButton = findViewById(R.id.animation_alpha);
        rotateButton = findViewById(R.id.animation_rotate);
        scaleButton = findViewById(R.id.animation_scale);
        translateButton = findViewById(R.id.animation_translate);

        alphaButton.setOnClickListener(this);
        rotateButton.setOnClickListener(this);
        scaleButton.setOnClickListener(this);
        translateButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}
