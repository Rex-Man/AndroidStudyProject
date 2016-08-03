package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ViewFlipper;

import com.oocl.manlimeng.androidstudyproject.R;

public class ViewFlipperActivity extends Activity {

    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper_viewflipper01);

    }
    public void viewFlipper_next(View view)
    {
        viewFlipper.setInAnimation(this,R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this,R.anim.slide_out_left);
        viewFlipper.showNext();
        viewFlipper.stopFlipping();
    }
    public void viewFlipper_auto(View view)
    {
        viewFlipper.setInAnimation(this,R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this,R.anim.slide_out_left);
        viewFlipper.startFlipping();
    }
    public void viewFlipper_prev(View view)
    {
        viewFlipper.setInAnimation(this,R.anim.slide_in_right);
        viewFlipper.setOutAnimation(this,R.anim.slide_out_left);
        viewFlipper.showPrevious();
        viewFlipper.stopFlipping();
    }
}
