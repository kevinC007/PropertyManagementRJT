package com.example.shuangzhecheng.propertymanagementrjt.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shuangzhecheng.propertymanagementrjt.LoginActivity;
import com.example.shuangzhecheng.propertymanagementrjt.R;
import com.example.shuangzhecheng.propertymanagementrjt.network.ApiClient;
import com.example.shuangzhecheng.propertymanagementrjt.network.ApiInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by joel on 12/3/2017.
 */

public class FragmentRegisterTenant extends Fragment {
    ApiInterface apiInterface;
    EditText emailLandlord,email,password,passwordc;
    Button signup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registertenant, container, false);
        signup = view.findViewById(R.id.buttonSignUptenant);
        email = view.findViewById(R.id.emfortenantregister);
        emailLandlord = view.findViewById(R.id.landlordemfortenantregister);
        password = view.findViewById(R.id.pwfortenantregister);
        passwordc = view.findViewById(R.id.pwfortenantregisterconfirm);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "clicked", Toast.LENGTH_SHORT).show();
                String eml = emailLandlord.getText().toString();
                String em = email.getText().toString();
                String pw = password.getText().toString();
                String accountType = "tenant";
                doRegister(em,eml,pw,accountType);
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
    private void doRegister(String email, String emailforlandlord, String password, String accountType) {
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<String> call = apiInterface.registertenant(email,emailforlandlord, password, accountType);
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
