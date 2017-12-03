package com.example.shuangzhecheng.propertymanagementrjt;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shuangzhecheng.propertymanagementrjt.Fragment.LandlordSignUpFragment;
import com.example.shuangzhecheng.propertymanagementrjt.Fragment.TenantSignUpFragment;
import com.example.shuangzhecheng.propertymanagementrjt.Model.User;
import com.example.shuangzhecheng.propertymanagementrjt.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    User user;
    ApiInterface apiInterface;
    TextView landlordSignupswitch;
    TextView tenantSignupswitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        tenantSignupswitch = findViewById(R.id.textViewTenantSignup);
        landlordSignupswitch = findViewById(R.id.textViewLandLordSignup);
        getSupportActionBar().hide();
        tenantSignupswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TenantSignUpFragment FragT = new TenantSignUpFragment();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment_signup, FragT);
                ft.commit();
            }
        });
        landlordSignupswitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LandlordSignUpFragment FragL = new LandlordSignUpFragment();
                android.app.FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.fragment_signup, FragL);
                ft.commit();
            }
        });

    }

}
