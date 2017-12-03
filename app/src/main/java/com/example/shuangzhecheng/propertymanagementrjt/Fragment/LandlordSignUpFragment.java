package com.example.shuangzhecheng.propertymanagementrjt.Fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shuangzhecheng.propertymanagementrjt.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandlordSignUpFragment extends Fragment {


    public LandlordSignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_landlord_signup, container, false);
    }

}
