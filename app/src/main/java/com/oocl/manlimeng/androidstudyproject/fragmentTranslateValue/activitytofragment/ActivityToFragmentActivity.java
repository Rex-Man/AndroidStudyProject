package com.oocl.manlimeng.androidstudyproject.fragmentTranslateValue.activitytofragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.oocl.manlimeng.androidstudyproject.R;

public class ActivityToFragmentActivity extends Activity {

    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_to_fragment);
        editText= (EditText) findViewById(R.id.activity_to_frag_edittext);
        ActivityToFragmentFragment fragment=new ActivityToFragmentFragment();
        Bundle bundle=new Bundle();
        bundle.putString("activitytofragmentvalue","defaultvalue");
        fragment.setArguments(bundle);
        FragmentManager fragmentManager=getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.activity_to_frag_container,fragment).commit();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ActivityToFragmentFragment fragment=new ActivityToFragmentFragment();
                Bundle bundle=new Bundle();
                bundle.putString("activitytofragmentvalue",editText.getText().toString());
                fragment.setArguments(bundle);
                FragmentManager fragmentManager=getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.activity_to_frag_container,fragment).commit();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

}
