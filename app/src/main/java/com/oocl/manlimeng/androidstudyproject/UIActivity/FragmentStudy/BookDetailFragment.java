package com.oocl.manlimeng.androidstudyproject.UIActivity.FragmentStudy;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oocl.manlimeng.androidstudyproject.R;
import com.oocl.manlimeng.androidstudyproject.entity.Book;
import com.oocl.manlimeng.androidstudyproject.entity.BookContent;

public class BookDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public static final String ITEM_ID="item_id";
    Book book;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;



    public BookDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookDetailFragment newInstance(String param1, String param2) {
        BookDetailFragment fragment = new BookDetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        if(getArguments().containsKey(ITEM_ID))
        {
            book=BookContent.ITEM_MAP.get(getArguments().getInt(ITEM_ID));
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_book_detail, container, false);

        if(book!=null)
        {
            ((TextView)rootView.findViewById(R.id.book_title)).setText(book.getTitle());
            ((TextView)rootView.findViewById(R.id.book_desc)).setText(book.getDesc());
        }


        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onDetach() {
        super.onDetach();

    }
}
