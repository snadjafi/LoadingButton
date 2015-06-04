package com.snad.sample;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.snad.loadingbutton.LoadingButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.first).setOnClickListener(this);
        findViewById(R.id.second).setOnClickListener(this);

        LoadingButton button = new LoadingButton(this);
        LoadingButton.ViewSwitcherFactory factory = new LoadingButton.ViewSwitcherFactory(this,
                getResources().getColor(android.R.color.white),
                44F,
                Typeface.DEFAULT);
        button.setTextFactory(factory);

        button.setText("Press");
        button.setLoadingText("wait...");
        button.setBackgroundColor(Color.RED);
        button.setOnClickListener(this);
        button.setAnimationInDirection(LoadingButton.IN_FROM_LEFT);

        ((ViewGroup) findViewById(R.id.root)).addView(button);
    }

    @Override public void onClick(final View v) {
        ((LoadingButton) v).showLoading();

        v.postDelayed(new Runnable() {
            @Override public void run() {
                ((LoadingButton) v).showButtonText();
            }
        }, 2000);
    }
}
