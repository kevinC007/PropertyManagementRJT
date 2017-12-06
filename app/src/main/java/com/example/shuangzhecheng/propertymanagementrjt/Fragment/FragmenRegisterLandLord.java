package com.example.shuangzhecheng.propertymanagementrjt.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.shuangzhecheng.propertymanagementrjt.AppController;
import com.example.shuangzhecheng.propertymanagementrjt.Dashboard;
import com.example.shuangzhecheng.propertymanagementrjt.LoginActivity;
import com.example.shuangzhecheng.propertymanagementrjt.R;
import com.example.shuangzhecheng.propertymanagementrjt.WelcomeActivity;
import com.example.shuangzhecheng.propertymanagementrjt.network.ApiClient;
import com.example.shuangzhecheng.propertymanagementrjt.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by joel on 12/3/2017.
 */

public class FragmenRegisterLandLord extends Fragment {

    EditText email, password, passwordc;
    Button signup;
    ApiInterface apiInterface;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registerlandlord, container, false);
        email = view.findViewById(R.id.landlordEmailtv);
        password = view.findViewById(R.id.landlordPasstv);
        passwordc = view.findViewById(R.id.landlordCPasstv);
        signup = view.findViewById(R.id.buttonSignUplandlord);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String em = email.getText().toString();
                String pw = password.getText().toString();
                String account = "landlord";
                doRegister(em,pw,account);

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
        passwordc.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!passwordc.getText().toString().equals(password.getText().toString())){
                    passwordc.setError("Not Match");
                    Toast.makeText(getActivity(), passwordc.getText()+"  " +password.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }
    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
    private void doRegister(String email, String password, String accountType) {
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<String> call = apiInterface.register(email, password, accountType);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                Toast.makeText(getActivity(), "RESPONSE : " + response.body(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getActivity(), "RESPONSE IS FAILED", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
