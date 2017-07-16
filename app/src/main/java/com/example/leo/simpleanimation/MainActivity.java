package com.example.leo.simpleanimation;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    private TextView start_now_tvt, loginSc_tvt,becom_tv,login_tvt;
    private TextView btn_fb_register,terms;
    ImageView front;
    ViewFlipper vf;
    static int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setUI();






    }



    public void setUI()
    {
        btn_fb_register = (TextView)findViewById(R.id.register_with_fb_bt);
        terms = (TextView)findViewById(R.id.terms);
        vf = (ViewFlipper) findViewById( R.id.flipper);
        start_now_tvt = (TextView)findViewById(R.id.start_now_bt);
        loginSc_tvt = (TextView)findViewById(R.id.loginSc);
        login_tvt = (TextView)findViewById(R.id.login_main);
        becom_tv = (TextView)findViewById(R.id.becom_text);
        front =(ImageView)findViewById(R.id.front_image);
        Typeface proto = Typeface.createFromAsset(getAssets(),  "fonts/proto.ttf");
        Typeface toxi = Typeface.createFromAsset(getAssets(),  "fonts/toxigenesis.ttf");

        setTextStyle();





        becom_tv.setTypeface(toxi);
        loginSc_tvt.setTypeface(proto);
        start_now_tvt.setTypeface(proto);



        login_tvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,DashTabsActivity.class));
            }
        });


        start_now_tvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=1;
                vf.setInAnimation(AnimationUtils.loadAnimation( getApplicationContext(), R.anim.slide_in_up ));
                vf.setOutAnimation(AnimationUtils.loadAnimation( getApplicationContext(), R.anim.slide_out_up ));
                vf.showNext();
            }
        });


        loginSc_tvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i=2;
                vf.setInAnimation(null);
                vf.setOutAnimation(null);
                vf.setDisplayedChild(2);
            }
        });



    }





    public void setTextStyle()
    {


        String text = "<big>Register With Facebook<big> <font color=\"#879fd0\"><br><small>Nothing Shared without your permission</small></font>";
        btn_fb_register.setText(Html.fromHtml(text));


        text = "By creating an account, I agree to This app <font color=\"#949898\"><u>Terrms of Use</u> </font>and <font color=\"#949898\"><u>Privacy Policy</u></font>";
        terms.setText(Html.fromHtml(text));
    }


//    public void Trans()
//    {
//
//        Transition slide = new Slide(Gravity.TOP);
//        slide.excludeTarget(android.R.id.statusBarBackground, true);
//        slide.excludeTarget(android.R.id.navigationBarBackground, true);
//        slide.setDuration(500);
//        getWindow().setExitTransition(slide);
//        getWindow().setEnterTransition(slide);
//    }


    @Override
    public void onBackPressed() {
        if(i==1)
        {
            i=0;
            vf.setInAnimation(AnimationUtils.loadAnimation( getApplicationContext(), R.anim.slide_in_down ));
            vf.setOutAnimation(AnimationUtils.loadAnimation( getApplicationContext(), R.anim.slide_out_down ));

            vf.showPrevious();
        }
        else if(i==2)
        {
                vf.setDisplayedChild(0);
                i=0;
        }
        else
            super.onBackPressed();

    }
}
