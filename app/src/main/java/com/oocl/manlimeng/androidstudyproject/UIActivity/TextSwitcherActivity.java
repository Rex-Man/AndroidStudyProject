package com.oocl.manlimeng.androidstudyproject.UIActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.oocl.manlimeng.androidstudyproject.R;

public class TextSwitcherActivity extends Activity {

    TextSwitcher textSwitcher;
    String[] strs=new String[]{
      "Java","Android","Ajax","Spring"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_switcher);
        textSwitcher= (TextSwitcher) findViewById(R.id.textSwitcher_textSwitcher01);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView tv= new TextView(TextSwitcherActivity.this);
                tv.setTextSize(40);
                tv.setTextColor(Color.MAGENTA);
                return tv;
            }
        });
    }
    int i;
    public void TextSwitcher_Next(View view)
    {

        textSwitcher.setText(strs[i++%strs.length]);
    }

}
