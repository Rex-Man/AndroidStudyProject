package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.oocl.manlimeng.androidstudyproject.R;

public class ImageViewActivity extends Activity {

    int[] images=new int[]{
            R.drawable.lijiang,
            R.drawable.qiao,
            R.drawable.shuangta,
            R.drawable.shui,
            R.drawable.xiangbi
    };
    int currentImg=2;
    private int alpha=255;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        final Button plus = (Button) findViewById(R.id.imageView_Button1);
        final Button minus= (Button) findViewById(R.id.imageView_Button2);
        final Button next= (Button) findViewById(R.id.imageView_Button3);
        final ImageView image1=(ImageView) findViewById(R.id.imageView_1);
        final ImageView image2=(ImageView) findViewById(R.id.imageView_2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image1.setImageResource(images[++currentImg%images.length]);
            }
        });
        Button.OnClickListener listener=new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(v==plus)
                {
                    alpha+=20;
                }
                if(v==minus)
                {
                    alpha-=20;
                }
                if(alpha>=255)
                {
                    alpha=255;
                }
                if(alpha<=0)
                {
                    alpha=0;
                }
                image1.setImageAlpha(alpha);

            }
        };

        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        image1.setOnTouchListener(new View.OnTouchListener() {
                                      @Override
                                      public boolean onTouch(View v, MotionEvent event) {

                                          BitmapDrawable bitmapDrawable= (BitmapDrawable) image1.getDrawable();

                                          Bitmap bitmap=bitmapDrawable.getBitmap();
                                          double scale=1.0*bitmap.getHeight()/image1.getHeight();
                                          int x=(int) (event.getX() * scale);
                                          int y=(int) (event.getY() * scale);
                                          if(x+120 >bitmap.getWidth())
                                          {
                                              x=bitmap.getWidth()-120;
                                          }
                                          if(y+120>bitmap.getHeight())
                                          {
                                              y=bitmap.getHeight()-120;
                                          }
                                          image2.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,120,120));
                                          image2.setImageAlpha(alpha);
                                          return false;
                                      }
                                  }

        );




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_image_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
