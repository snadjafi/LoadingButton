package com.snad.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.snad.loadingbutton.LoadingButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.first).setOnClickListener(this);
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
