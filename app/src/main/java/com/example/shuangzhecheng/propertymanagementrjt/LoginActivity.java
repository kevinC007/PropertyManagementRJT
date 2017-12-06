package com.example.shuangzhecheng.propertymanagementrjt;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shuangzhecheng.propertymanagementrjt.Fragment.FragmentLoginLandLord;
import com.example.shuangzhecheng.propertymanagementrjt.Fragment.FragmentLoginTenant;
import com.example.shuangzhecheng.propertymanagementrjt.network.ApiClient;
import com.example.shuangzhecheng.propertymanagementrjt.network.ApiInterface;


public class LoginActivity extends AppCompatActivity {
    Button landlord,propertymanager,tenant,vendor;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        landlord = (Button) findViewById(R.id.buttonLandLordlogin);
        propertymanager = (Button) findViewById(R.id.buttonPMlogin);
        tenant = (Button) findViewById(R.id.buttonTenantlogin);
        vendor = (Button) findViewById(R.id.buttonVendorlogin);
        final FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentLoginLandLord f1 = new FragmentLoginLandLord();
        fragmentTransaction.add(R.id.loginfragment_adder, f1);
        fragmentTransaction.commit();
        getSupportActionBar().hide();
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        /*signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em = email.getText().toString();
                String pw = password.getText().toString();
                if(radiotenant.isChecked()) {
                    login(em, pw);
                }
                if(radiolandlord.isChecked()){
                    Toast.makeText(LoginActivity.this, "Landlord login", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
        landlord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentLoginLandLord f1 = new FragmentLoginLandLord();
                fragmentTransaction.add(R.id.loginfragment_adder, f1);
                fragmentTransaction.commit();
            }
        });
//------------------------------------------------------------------------------------------------------------------------------------
        tenant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentLoginTenant f2 = new FragmentLoginTenant();
                fragmentTransaction.replace(R.id.loginfragment_adder, f2);
                fragmentTransaction.commit();
            }
        });

    }
    /*public void login(final String email, final String password) {
        Call<User> loginCall = apiInterface.login(email, password);
        loginCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    user = response.body();
                    Log.d("kevin", user.getAppapikey() + " " + user.getUseremail());
                    if (user.getMsg().equals("success") && user.getUsertype().equals("tenant")) {
                        Toast.makeText(LoginActivity.this, "Welcome !" + user.getUsertype(), Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this, Dashboard.class);
                        startActivity(i);
                    }
                }
                else {
                    Toast.makeText(LoginActivity.this, "MSG" + user.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("failure", "failed");
            }
        });
    }*/
}
