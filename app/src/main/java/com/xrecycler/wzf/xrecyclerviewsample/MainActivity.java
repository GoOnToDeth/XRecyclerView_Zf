package com.xrecycler.wzf.xrecyclerviewsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.xrecycler.wzf.xrecyclerviewsample.ui.GridActivity;
import com.xrecycler.wzf.xrecyclerviewsample.ui.LinearActivity;
import com.xrecycler.wzf.xrecyclerviewsample.ui.ViewPagerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void linearStart(View view) {
        startActivity(new Intent(this, LinearActivity.class));
    }

    public void pagerStart(View view) {
        startActivity(new Intent(this, ViewPagerActivity.class));
    }

    public void gridStart(View view) {
        startActivity(new Intent(this, GridActivity.class));
    }
}
