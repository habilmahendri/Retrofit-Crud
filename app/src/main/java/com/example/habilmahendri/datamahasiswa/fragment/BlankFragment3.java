package com.example.habilmahendri.datamahasiswa.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.habilmahendri.datamahasiswa.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment3 extends Fragment {


    public static BlankFragment3 newInstance() {
        BlankFragment3 fragment = new BlankFragment3();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_fragment3, container, false);
    }

}
