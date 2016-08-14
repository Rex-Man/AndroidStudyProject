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
 * Use the {@link FragmentToFragmentTo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentToFragmentTo extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String FRAGMENTTOFRAGMENT="fragmentToFragment";

    // TODO: Rename and change types of parameters
    private String fragmentToFragment="";



    public FragmentToFragmentTo() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            fragmentToFragment = getArguments().getString(FRAGMENTTOFRAGMENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragment_to_fragment_to, container, false);
        TextView textView= (TextView) view.findViewById(R.id.fragment_to_fragment_tovalue01);
        textView.setText(fragmentToFragment);
        return view;
    }


}
