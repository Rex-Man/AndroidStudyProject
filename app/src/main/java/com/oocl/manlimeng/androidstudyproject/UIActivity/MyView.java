package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.oocl.manlimeng.androidstudyproject.R;

/**
 * Created by manre on 8/22/16.
 */
public class MyView extends View {
    private Paint mPaint;
    private Context mContext;
    private static String mString;
    private String test;

    public MyView(Context context) {
        super(context);
        mPaint=new Paint();
    }

    public MyView(Context context,AttributeSet attrs)
    {
        super(context,attrs);
        mPaint=new Paint();
        /*这里取得declare-styleable集合*/
        TypedArray typeArray = context.obtainStyledAttributes(attrs,R.styleable.MyView1);
                 /*这里从集合里取出相对应的属性值,第二参数是如果使用者没用配置该属性时所用的默认值*/
        int textColor = typeArray.getColor(R.styleable.MyView1_textColor,0XFFFFFFFF);
        float textSize = typeArray.getDimension(R.styleable.MyView1_textSize, 36);
        mString = typeArray.getString(R.styleable.MyView1_text);
             /*设置自己的类成员变量*/
        mPaint.setTextSize(textSize);
        mPaint.setColor(textColor);
            /*关闭资源*/
        typeArray.recycle();

    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);

        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(new Rect(10, 10, 90, 90), mPaint);
        mPaint.setColor(Color.BLUE);
        canvas.drawText(mString, 10, 110, mPaint);
    }
}

