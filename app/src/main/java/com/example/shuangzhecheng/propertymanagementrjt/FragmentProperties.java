package com.example.shuangzhecheng.propertymanagementrjt;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by joel on 12/2/2017.
 */

public class FragmentProperties extends Fragment {

    Button addproperty;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_properties, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addproperty = (Button)view.findViewById(R.id.buttonAddNew);

        addproperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentAddProperty fragmentAddProperty = new FragmentAddProperty();
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_adder, fragmentAddProperty, "NewFragmentTag");
                ft.commit();
            }
        });
    }

}
