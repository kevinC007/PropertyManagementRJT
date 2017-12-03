package com.example.shuangzhecheng.propertymanagementrjt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.shuangzhecheng.propertymanagementrjt.Model.User;
import com.example.shuangzhecheng.propertymanagementrjt.network.ApiClient;
import com.example.shuangzhecheng.propertymanagementrjt.network.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    User user;
    EditText email;
    EditText password;
    Button signin;
    ApiInterface apiInterface;
    RadioButton radiolandlord;
    RadioButton radiotenant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.email_login);
        password = findViewById(R.id.password_login);
        signin = findViewById(R.id.button_signin);
        radiolandlord = findViewById(R.id.radioButtonlandlord);
        radiotenant = findViewById(R.id.radioButtontenant);
        getSupportActionBar().hide();
        apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        signin.setOnClickListener(new View.OnClickListener() {
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
        });

    }
    public void login(final String email, final String password) {
        Call<User> loginCall = apiInterface.login(email, password);
        loginCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    user = response.body();
                    Log.d("kevin", user.getAppapikey() + " " + user.getUseremail());
                    if (user.getMsg().equals("success") && user.getUsertype().equals("tenant")) {
                        Toast.makeText(LoginActivity.this, "Welcome !" + user.getUsertype(), Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(LoginActivity.this, MainActivity.class);
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
    }
}
