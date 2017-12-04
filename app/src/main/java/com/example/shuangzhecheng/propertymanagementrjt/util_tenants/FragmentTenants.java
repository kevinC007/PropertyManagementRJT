package com.example.shuangzhecheng.propertymanagementrjt.util_tenants;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.shuangzhecheng.propertymanagementrjt.R;

/**
 * Created by joel on 12/2/2017.
 */

public class FragmentTenants extends Fragment {

    Button btnaddnew,btncontact;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tenants, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    btnaddnew = (Button)view.findViewById(R.id.buttonAddNew);
    btncontact = (Button) view.findViewById(R.id.buttonContactTenants);
    btnaddnew.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            addNewTenant();
        }
    });
    btncontact.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            contactTenant();
        }
    });
    }

//---------------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------All Methods------------------------------------------------------------------
    public void addNewTenant(){
        FragmentAddNewTenant fragmentAddNewTenant = new FragmentAddNewTenant();
        final android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_adder, fragmentAddNewTenant, "NewTenantFragmentTag");
        ft.addToBackStack("FragmentTenants");
        ft.commit();
    }


    private void contactTenant() {
        FragmentContactTenants fragmentContactTenants = new FragmentContactTenants();
        final android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_adder, fragmentContactTenants, "ContactTenantFragmentTag");
        ft.addToBackStack("FragmentTenants");
        ft.commit();
    }

}
