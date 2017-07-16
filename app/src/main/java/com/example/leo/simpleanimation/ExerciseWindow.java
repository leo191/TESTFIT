package com.example.leo.simpleanimation;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class ExerciseWindow extends AppCompatActivity {

    Toolbar toolbar;
    ImageView excercise_image;
    String[] mProc;
    String mExame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_window);
        setUI();
        Intent out = getIntent();
        mExame = out.getStringExtra("ename");
        ((TextView)toolbar.getChildAt(0)).setText(mExame.toUpperCase());






    }



    public void setUI()
    {
        toolbar = (android.support.v7.widget.Toolbar)findViewById(R.id.toolbar_bench);
        setSupportActionBar(toolbar);
        Drawable upArrow = getResources().getDrawable(R.drawable.abc_ic_ab_back_material);
        upArrow.setColorFilter(getResources().getColor(android.R.color.darker_gray), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        excercise_image = (ImageView) findViewById(R.id.specific_exercise_tv);

    }


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }


}
