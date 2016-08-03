package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.media.Rating;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;


import com.oocl.manlimeng.androidstudyproject.R;

public class SeekBarActivity extends Activity {

    ImageView imageView;
    SeekBar seekBar;
    RatingBar ratingBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(R.layout.activity_seek_bar);
        Button button1 = (Button) findViewById(R.id.seekBar_show);
        Button button2 = (Button) findViewById(R.id.seekBar_hide);
        imageView = (ImageView) findViewById(R.id.seekBar_imageView);
        seekBar= (SeekBar) findViewById(R.id.seekBar_seekBar);
        ratingBar= (RatingBar) findViewById(R.id.SeekBar_ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                imageView.setImageAlpha((int)(rating*255/5));
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                imageView.setImageAlpha(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBarIndeterminateVisibility(true);
                setProgressBarVisibility(true);
                setProgress(4500);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setProgressBarIndeterminateVisibility(false);
                setProgressBarVisibility(false);
            }
        });


    }


}
