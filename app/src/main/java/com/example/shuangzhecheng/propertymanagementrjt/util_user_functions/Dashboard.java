package com.example.shuangzhecheng.propertymanagementrjt.util_user_functions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.shuangzhecheng.propertymanagementrjt.R;

public class Dashboard extends AppCompatActivity {

    ImageButton alerts,properties,tenants,transactions,collect_rent,to_do,trips,documents,vendors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        alerts =(ImageButton)findViewById(R.id.notificationsButton);
        properties = (ImageButton)findViewById(R.id.propertiesButton);
        tenants = (ImageButton)findViewById(R.id.tenantsButton);
        transactions = (ImageButton)findViewById(R.id.transactionsButton);
        collect_rent = (ImageButton)findViewById(R.id.collectrentButton);
        to_do = (ImageButton)findViewById(R.id.todoButton);
        trips = (ImageButton)findViewById(R.id.tripsButton);
        documents = (ImageButton)findViewById(R.id.documentsButton);
        vendors = (ImageButton)findViewById(R.id.vendorsButton);

//------------------------------Setting up Listeners for the image Buttons and Inflating the fragments-------------------------------
    properties.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Dashboard.this,DummyActivity.class);
            intent.putExtra("a",1);
            startActivity(intent);
        }
    });
//------------------------------------------------------------------------------------------------------------------------------------
    tenants.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Dashboard.this,DummyActivity.class);
            intent.putExtra("a",2);
            startActivity(intent);
        }
    });
//--------------------------------------------------------------------------------------------------------------------------------------
    transactions.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Dashboard.this,DummyActivity.class);
            intent.putExtra("a",3);
            startActivity(intent);
        }
    });
//--------------------------------------------------------------------------------------------------------------------------------------
    collect_rent.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Dashboard.this,DummyActivity.class);
            intent.putExtra("a",4);
            startActivity(intent);
        }
    });
//-------------------------------------------------------------------------------------------------------------------------------------
    to_do.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Dashboard.this,DummyActivity.class);
            intent.putExtra("a",5);
            startActivity(intent);
        }
    });
//------------------------------------------------------------------------------------------------------------------------------------
  }
}
