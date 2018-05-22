package com.example.franck.myapplication;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Typeface;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private TextView textViewRashod;
    private TextView textViewPotreb;
    private ValueAnimator valueAnimator;
    private CountDownTimer timer;
    private Button sell;
    private Button buy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Typeface tf = Typeface.createFromAsset(getAssets(),
                "fonts/1374.ttf");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewRashod = findViewById(R.id.rashod_text);
        textViewPotreb = findViewById(R.id.potreb_text);
        sell = findViewById(R.id.sell);
        buy = findViewById(R.id.buy);
        textViewRashod.setTypeface(tf);
        textViewPotreb.setTypeface(tf);
        animateTextView(0, 1000, textViewPotreb);


        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer dif = (new Integer(textViewRashod.getText().toString()) - new Integer(textViewPotreb.getText().toString())) / 2;
                animateTextView(new Integer(textViewPotreb.getText().toString()), new Integer(textViewPotreb.getText().toString()) + dif,textViewPotreb);
                animateTextView(new Integer(textViewRashod.getText().toString()), new Integer(textViewRashod.getText().toString()) - dif,textViewRashod);
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer dif = Math.abs((new Integer(textViewRashod.getText().toString()) - new Integer(textViewPotreb.getText().toString())) / 2);
                animateTextView(new Integer(textViewPotreb.getText().toString()), new Integer(textViewPotreb.getText().toString()) - dif,textViewPotreb);
                animateTextView(new Integer(textViewRashod.getText().toString()), new Integer(textViewRashod.getText().toString()) + dif,textViewRashod);
            }
        });
    }

    public void animateTextView(int initialValue, int finalValue, final TextView  textview) {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(initialValue, finalValue);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                textview.setText(valueAnimator.getAnimatedValue().toString());
            }
        });
        valueAnimator.addListener(new ValueAnimator.AnimatorListener() {

            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                changeColor();
                changeButton();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        valueAnimator.start();


    }



    public void changeColor() {
        if (new Integer(textViewPotreb.getText().toString()) - 1 == new Integer(textViewRashod.getText().toString()) || new Integer(textViewPotreb.getText().toString()) + 1 == new Integer(textViewRashod.getText().toString())) {
            textViewPotreb.setTextColor(getResources().getColor(R.color.colorPrimary));
            textViewRashod.setTextColor(getResources().getColor(R.color.colorPrimary));
            return;
        }
        if (new Integer(textViewPotreb.getText().toString()) > new Integer(textViewRashod.getText().toString())) {
            textViewPotreb.setTextColor(getResources().getColor(R.color.green));
            textViewRashod.setTextColor(getResources().getColor(R.color.red));
        }
        if ((new Integer(textViewPotreb.getText().toString()) < new Integer(textViewRashod.getText().toString()))){
            textViewPotreb.setTextColor(getResources().getColor(R.color.red));
            textViewRashod.setTextColor(getResources().getColor(R.color.green));
        }
    }

    public void changeButton() {
        if (new Integer(textViewPotreb.getText().toString()) - 1 == new Integer(textViewRashod.getText().toString()) || new Integer(textViewPotreb.getText().toString()) + 1 == new Integer(textViewRashod.getText().toString())){
            sell.setEnabled(true);
            buy.setEnabled(true);
            return;
        }
        if (new Integer(textViewPotreb.getText().toString()) > new Integer(textViewRashod.getText().toString())) {
           sell.setEnabled(false);
           buy.setEnabled(true);
        }
        if (new Integer(textViewPotreb.getText().toString()) < new Integer(textViewRashod.getText().toString())){
            sell.setEnabled(true);
            buy.setEnabled(false);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
