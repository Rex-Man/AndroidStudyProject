package com.oocl.manlimeng.androidstudyproject.fragmentTranslateValue.fragmenttofragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentToFragmentFROM.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class FragmentToFragmentFROM extends Fragment {

    private OnFragmentInteractionListener mListener;

    EditText editText;

    public FragmentToFragmentFROM() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragment_to_fragment_from, container, false);
        editText= (EditText) view.findViewById(R.id.fragment_to_fragment_fromET);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                //2
                FragmentToFragmentTo2 fragmentToFragmentTo2= (FragmentToFragmentTo2) getFragmentManager().findFragmentById(R.id.fragment_to_fragment_containerto2);
                fragmentToFragmentTo2.putValues(editText.getText().toString());
                //3
                TextView textView= (TextView) getActivity().findViewById(R.id.fragment_to_fragment_tovalue03);
                textView.setText(editText.getText().toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

                //1
                mListener.sentEditMessageToOtherFragment(editText.getText().toString());

            }
        });
        return view;
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void sentEditMessageToOtherFragment(String value);
    }

}
