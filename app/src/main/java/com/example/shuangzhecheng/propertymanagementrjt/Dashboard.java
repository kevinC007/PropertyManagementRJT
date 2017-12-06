package com.example.shuangzhecheng.propertymanagementrjt;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shuangzhecheng.propertymanagementrjt.Model.Geocode;
import com.example.shuangzhecheng.propertymanagementrjt.network.ApiInterface;
import com.example.shuangzhecheng.propertymanagementrjt.network.GoogleClient;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Dashboard extends AppCompatActivity {

    ProgressBar progressBar;
    TextView progresspercent;
    ApiInterface apiInterface;
    PieChart pieChart;
    ImageButton alerts,properties,tenants,transactions,collect_rent,to_do,trips,documents,vendors;
    private int[] yData = {30000,25000,28000,60000,85000};
    private String[] xData = {"Property1","Property2","Property3","Property4","Property5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        progressBar = findViewById(R.id.progressBar);
        progresspercent = findViewById(R.id.progressPercent);
        alerts =(ImageButton)findViewById(R.id.notificationsButton);
        properties = (ImageButton)findViewById(R.id.propertiesButton);
        tenants = (ImageButton)findViewById(R.id.tenantsButton);
        transactions = (ImageButton)findViewById(R.id.transactionsButton);
        collect_rent = (ImageButton)findViewById(R.id.collectrentButton);
        to_do = (ImageButton)findViewById(R.id.todoButton);
        trips = (ImageButton)findViewById(R.id.tripsButton);
        documents = (ImageButton)findViewById(R.id.documentsButton);
        vendors = (ImageButton)findViewById(R.id.vendorsButton);
        progressBar.setProgress(Integer.parseInt(progresspercent.getText().toString()));
        progresspercent.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                progressBar.setProgress(Integer.parseInt(progresspercent.getText().toString()));
            }
        });
        trips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = "2801 S King Dr";
                String apiKey = "AIzaSyB5bdMqMEq7cA3peWU1eUqn9INb4oYeNOI";
                getcordinates(address,apiKey);
            }
        });
        Description dis = new Description();
        dis.setText("Expenses");
        pieChart = findViewById(R.id.piechart);
        pieChart.setHoleRadius(30);
        pieChart.setDescription(dis);
        pieChart.setEntryLabelTextSize(15);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.getDescription().setTextSize(22);
        addDataSet();


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

    private void getcordinates(final String address, final String apiKey) {
        apiInterface = GoogleClient.getRetrofit().create(ApiInterface.class);
        Call<Geocode> call = apiInterface.getlanlang(address,apiKey);
        call.enqueue(new Callback<Geocode>() {
            @Override
            public void onResponse(Call<Geocode> call, Response<Geocode> response) {
                Geocode geocode = response.body();
                double lat = geocode.getResults().get(0).getGeometry().getLocation().getLat();
                double lng = geocode.getResults().get(0).getGeometry().getLocation().getLng();
                Toast.makeText(Dashboard.this, Double.toString(lat) +","+ Double.toString(lng), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Geocode> call, Throwable t) {

            }
        });
    }

    private void addDataSet() {
        ArrayList<PieEntry> yEntry = new ArrayList<>();
        ArrayList<String> xEntry = new ArrayList<>();

        for (int i = 0; i < yData.length; i++) {
            yEntry.add(new PieEntry(yData[i], xData[i]));
        }
        for (int i = 0; i < xData.length; i++) {
            xEntry.add(xData[i]);
        }


        PieDataSet pieDataSet = new PieDataSet(yEntry, "Property values");
        pieDataSet.setSliceSpace(1);
        pieDataSet.setFormSize(10);
        pieDataSet.setValueTextSize(15);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);

        pieDataSet.setColors(colors);
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);
        legend.setTextSize(13);

        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

    }

}
