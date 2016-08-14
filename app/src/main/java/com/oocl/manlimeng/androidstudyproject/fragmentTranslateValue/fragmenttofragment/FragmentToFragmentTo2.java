package com.oocl.manlimeng.androidstudyproject.fragmentTranslateValue.fragmenttofragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentToFragmentTo2 extends Fragment {

    TextView textView;
    public FragmentToFragmentTo2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_fragment_to_fragment_to2, container, false);
       textView= (TextView) view.findViewById(R.id.fragment_to_fragment_tovalue02);
        return  view;
    }
    public void putValues(String strValues)
    {
        textView.setText(strValues);
    }

}
