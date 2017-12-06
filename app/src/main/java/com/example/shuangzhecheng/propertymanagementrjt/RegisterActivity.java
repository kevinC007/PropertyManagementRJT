package com.example.shuangzhecheng.propertymanagementrjt;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.shuangzhecheng.propertymanagementrjt.Fragment.FragmenRegisterLandLord;
import com.example.shuangzhecheng.propertymanagementrjt.Fragment.FragmentRegisterTenant;

public class RegisterActivity extends AppCompatActivity {

    Button landlord,propertymanager,tenant,vendor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        landlord = (Button) findViewById(R.id.buttonLandLord);
        propertymanager = (Button) findViewById(R.id.buttonPM);
        tenant = (Button) findViewById(R.id.buttonTenant);
        vendor = (Button) findViewById(R.id.buttonVendor);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmenRegisterLandLord fragmenRegisterLandLord = new FragmenRegisterLandLord();
        fragmentTransaction.add(R.id.registerfragment_adder, fragmenRegisterLandLord);
        fragmentTransaction.commit();


//------------------------------Setting up Listeners for the image Buttons and Inflating the fragments-------------------------------
        landlord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmenRegisterLandLord fragmenRegisterLandLord = new FragmenRegisterLandLord();
                fragmentTransaction.add(R.id.registerfragment_adder, fragmenRegisterLandLord);
                fragmentTransaction.commit();
            }
        });
//------------------------------------------------------------------------------------------------------------------------------------
        tenant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentRegisterTenant fragmentRegisterPM = new FragmentRegisterTenant();
                fragmentTransaction.replace(R.id.registerfragment_adder, fragmentRegisterPM);
                fragmentTransaction.commit();
            }
        });
//-------------------------------------------------------------------------------------------------------------------------------------
    }
}
