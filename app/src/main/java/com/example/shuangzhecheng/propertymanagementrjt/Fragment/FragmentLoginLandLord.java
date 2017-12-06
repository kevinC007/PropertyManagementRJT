package com.example.shuangzhecheng.propertymanagementrjt.Fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shuangzhecheng.propertymanagementrjt.Dashboard;
import com.example.shuangzhecheng.propertymanagementrjt.Model.User;
import com.example.shuangzhecheng.propertymanagementrjt.R;
import com.example.shuangzhecheng.propertymanagementrjt.network.ApiClient;
import com.example.shuangzhecheng.propertymanagementrjt.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.Context.MODE_PRIVATE;

public class FragmentLoginLandLord extends Fragment {
    EditText email,password;
    Button signin;
    ApiInterface apiInterface;
    User user;
    SharedPreferences sharedpreferences;
    public FragmentLoginLandLord() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment_login_land_lord, container, false);
        email = view.findViewById(R.id.landlordem);
        password = view.findViewById(R.id.landlordpw);
        signin = view.findViewById(R.id.buttonlandlordlogin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em = email.getText().toString();
                String pw = password.getText().toString();
                login(em, pw);
            }
        });
        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!isValidEmail(email.getText())){
                    email.setError("Invalid Email");
                }
            }
        });
        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(password.getText().length() < 4){
                    password.setError("Password Is Shorter than 4 digits");
                }
            }
        });
        return view;
    }
    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
    public void login(final String email, final String password) {
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<User> loginCall = apiInterface.login(email, password);
        loginCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    user = response.body();
                    Log.d("kevin", user.getAppapikey() + " " + user.getUseremail());
                    if (user.getMsg().equals("success") && user.getUsertype().equals("landlord")) {
                        Toast.makeText(getActivity(), "Welcome !" + user.getUsertype(), Toast.LENGTH_SHORT).show();
                        sharedpreferences = getActivity().getSharedPreferences("USER",MODE_PRIVATE);
                        SharedPreferences.Editor edt = sharedpreferences.edit();
                        edt.putString("email",user.getUseremail());
                        edt.putString("type",user.getUsertype());
                        edt.putString("apikey",user.getAppapikey());
                        edt.commit();
                        Intent intent = new Intent(getActivity(), Dashboard.class);
                        startActivity(intent);
                    }
                }
                else {
                    Toast.makeText(getActivity(), "MSG" + user.getMsg(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("failure", "failed");
            }
        });
    }


}
