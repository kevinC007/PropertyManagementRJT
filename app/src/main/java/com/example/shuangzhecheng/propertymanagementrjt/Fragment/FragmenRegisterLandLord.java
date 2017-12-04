package com.example.shuangzhecheng.propertymanagementrjt;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

/**
 * Created by joel on 12/3/2017.
 */

public class FragmenRegisterLandLord extends Fragment {

    EditText etEmail,etPassword,etConfirmPassword;
    Button btnSignup;
    private String tmpurl="";
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registerlandlord, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etEmail = (EditText) view.findViewById(R.id.landlordEmailtv);
        etPassword = (EditText) view.findViewById(R.id.landlordPasstv);
        etConfirmPassword = (EditText) view.findViewById(R.id.landlordCPasstv);
        btnSignup = (Button) view.findViewById(R.id.buttonSignUp);

        final String input_email = etEmail.getText().toString();
        final String input_password = etPassword.getText().toString();
        final String input_confirmpassword = etConfirmPassword.getText().toString();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*if (input_email.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+") && !(input_email.equals(""))) {
                    if (input_password.length() >= 6) {
                        if (input_password.equals(input_confirmpassword)) {*/
                            tmpurl = "http://newtojava.000webhostapp.com/landlordregistry.txt";

                            registerLandlord(tmpurl);
                        /*} else {
                            Toast.makeText(context, "Passwords Do Not Match", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(context, "Password should be greater than 6 digits", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(context, "Please Enter Valid Email", Toast.LENGTH_LONG).show();
                }*/
            }
        });
    }

    private void registerLandlord(String tmpurl) {
        String  tag_string_req = "string_req";
        StringRequest stringRequest = new StringRequest(Request.Method.POST,tmpurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("Result Response:",response);

                if(response.contains("successfully registered")){

                    Toast.makeText(context,response+"You can Login Now",Toast.LENGTH_LONG).show();
                    Intent backbuttonpressed = new Intent(context,WelcomeActivity.class);
                    startActivity(backbuttonpressed);
                }
                else{
                    Toast.makeText(context,response+"Error",Toast.LENGTH_LONG).show();
                }
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(stringRequest, tag_string_req);
    }
}
