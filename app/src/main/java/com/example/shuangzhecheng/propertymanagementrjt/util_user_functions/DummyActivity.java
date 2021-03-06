package com.example.shuangzhecheng.propertymanagementrjt.util_user_functions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.shuangzhecheng.propertymanagementrjt.R;
import com.example.shuangzhecheng.propertymanagementrjt.util_collect_rent.FragmentCollectRent;
import com.example.shuangzhecheng.propertymanagementrjt.util_properties.FragmentProperties;
import com.example.shuangzhecheng.propertymanagementrjt.util_tenants.FragmentTenants;
import com.example.shuangzhecheng.propertymanagementrjt.util_todo.FragmentToDo;
import com.example.shuangzhecheng.propertymanagementrjt.util_transactions.FragmentTransaction;

public class DummyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);

        Intent intent = getIntent();
        int id = intent.getIntExtra("a",0);
        Log.i("String","Value :" +id);

        FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(id==1){
            FragmentProperties fragmentProperties = new FragmentProperties();
            fragmentTransaction.add(R.id.fragment_adder, fragmentProperties,"FragmentProperties");
            fragmentTransaction.commit();

        }
        else if(id==2){
            FragmentTenants fragmentTenants = new FragmentTenants();
            fragmentTransaction.add(R.id.fragment_adder, fragmentTenants,"FragmentTenants");
            fragmentTransaction.commit();
        }
        else if(id ==3){
            FragmentTransaction fragmentTransactions = new FragmentTransaction();
            fragmentTransaction.add(R.id.fragment_adder, fragmentTransactions);
            fragmentTransaction.commit();
        }
        else if(id==4){
            FragmentCollectRent fragmentCollectRent = new FragmentCollectRent();
            fragmentTransaction.add(R.id.fragment_adder, fragmentCollectRent);
            fragmentTransaction.commit();
        }
        else if(id==5){
            FragmentToDo fragmentToDo = new FragmentToDo();
            fragmentTransaction.add(R.id.fragment_adder, fragmentToDo);
            fragmentTransaction.commit();
        }
        else{
            Toast.makeText(DummyActivity.this, "Coming Soon",Toast.LENGTH_SHORT).show();
        }
    }
}
