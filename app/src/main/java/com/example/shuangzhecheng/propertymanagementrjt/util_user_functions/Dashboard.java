package com.example.shuangzhecheng.propertymanagementrjt.util_user_functions;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.shuangzhecheng.propertymanagementrjt.R;
import com.example.shuangzhecheng.propertymanagementrjt.database.database_properties.SQLp;
import com.example.shuangzhecheng.propertymanagementrjt.model.Graphsandchart.RentDetails;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    ImageButton alerts, properties, tenants, transactions, collect_rent, to_do, trips, documents, vendors;
    BarChart chart;
    ArrayList<BarEntry> BARENTRY;
    ArrayList<String> BarEntryLabels;
    BarDataSet Bardataset;
    BarData BARDATA;
    PieChart pieChart;
    ArrayList<Entry> entries;
    ArrayList<String> PieEntryLabels;
    PieDataSet pieDataSet;
    PieData pieData;
    private SQLp SqlHelper;
    private SQLiteDatabase db;
    public  ArrayList<RentDetails> rentDetailsArrayList;


    float a = 10000;
    float b = 15000;
    float c = 30000;
    float d = 20000;
    float e = 25000;
    float f = 30000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        SqlHelper = new SQLp(this);
        db = SqlHelper.getReadableDatabase();
        alerts = (ImageButton) findViewById(R.id.notificationsButton);
        properties = (ImageButton) findViewById(R.id.propertiesButton);
        tenants = (ImageButton) findViewById(R.id.tenantsButton);
        transactions = (ImageButton) findViewById(R.id.transactionsButton);
        collect_rent = (ImageButton) findViewById(R.id.collectrentButton);
        to_do = (ImageButton) findViewById(R.id.todoButton);
        trips = (ImageButton) findViewById(R.id.tripsButton);
        documents = (ImageButton) findViewById(R.id.documentsButton);
        vendors = (ImageButton) findViewById(R.id.vendorsButton);


        chart = (BarChart) findViewById(R.id.graph);
        pieChart = (PieChart) findViewById(R.id.pie);


        BARENTRY = new ArrayList<>();
        entries = new ArrayList<>();


        BarEntryLabels = new ArrayList<String>();
        PieEntryLabels = new ArrayList<String>();

        AddValuesToBARENTRY();
        AddValuesToPIEENTRY();

        AddValuesToBarEntryLabels();
        AddValuesToPieEntryLabels();

        Bardataset = new BarDataSet(BARENTRY, "Projects");
        pieDataSet = new PieDataSet(entries, "");

        BARDATA = new BarData(BarEntryLabels, Bardataset);
        pieData = new PieData(PieEntryLabels, pieDataSet);

        Bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        chart.setData(BARDATA);
        pieChart.setData(pieData);

/*        Cursor cursor = db.rawQuery
                ("select * from " + TABLE10, null);
        cursor.moveToFirst();
        do {
            RentDetails rd = new RentDetails(
                    cursor.getString(cursor.getColumnIndex(KEY_ID)),
                    cursor.getString(cursor.getColumnIndex(ADDRESS)),
                    cursor.getString(cursor.getColumnIndex(CITY)),
                    cursor.getString(cursor.getColumnIndex(STATE)),
                    cursor.getString(cursor.getColumnIndex(PRICE)),
                    cursor.getString(cursor.getColumnIndex(COUNTRY)),
                    cursor.getString(cursor.getColumnIndex(MORTAGE)));
            // cursor.getString(cursor.getColumnIndex(IMAGE)));
            rentDetailsArrayList.add(rd);
        }
        while (cursor.moveToNext());
        Log.i("CARTDETAILS","CHECK" +rentDetailsArrayList);*/

//------------------------------Setting up Listeners for the image Buttons and Inflating the fragments-------------------------------
            properties.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Dashboard.this, DummyActivity.class);
                    intent.putExtra("a", 1);
                    startActivity(intent);
                }
            });
//------------------------------------------------------------------------------------------------------------------------------------
            tenants.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Dashboard.this, DummyActivity.class);
                    intent.putExtra("a", 2);
                    startActivity(intent);
                }
            });
//--------------------------------------------------------------------------------------------------------------------------------------
            transactions.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Dashboard.this, DummyActivity.class);
                    intent.putExtra("a", 3);
                    startActivity(intent);
                }
            });
//--------------------------------------------------------------------------------------------------------------------------------------
            collect_rent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Dashboard.this, DummyActivity.class);
                    intent.putExtra("a", 4);
                    startActivity(intent);
                }
            });
//-------------------------------------------------------------------------------------------------------------------------------------
            to_do.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Dashboard.this, DummyActivity.class);
                    intent.putExtra("a", 5);
                    startActivity(intent);
                }
            });
//------------------------------------------------------------------------------------------------------------------------------------
            chart.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    chart.saveToGallery("chart", 50);
                    return true;
                }
            });
        }
//-------------------------------------------------------------------------------------------------------------------------------------
    public void AddValuesToBARENTRY() {
        BARENTRY.add(new BarEntry(a, 0));
        BARENTRY.add(new BarEntry(b, 1));
        BARENTRY.add(new BarEntry(c, 2));
        BARENTRY.add(new BarEntry(d, 3));
        BARENTRY.add(new BarEntry(e, 4));
        BARENTRY.add(new BarEntry(f, 5));
    }

    public void AddValuesToBarEntryLabels() {
        BarEntryLabels.add("1");
        BarEntryLabels.add("2");
        BarEntryLabels.add("3");
        BarEntryLabels.add("4");
        BarEntryLabels.add("5");
        BarEntryLabels.add("6");
    }

    public void AddValuesToPIEENTRY() {
        entries.add(new BarEntry(a, 0));
        entries.add(new BarEntry(b, 1));
        entries.add(new BarEntry(c, 2));
        entries.add(new BarEntry(d, 3));
        entries.add(new BarEntry(e, 4));
        entries.add(new BarEntry(f, 5));

    }

    public void AddValuesToPieEntryLabels() {
        PieEntryLabels.add("1");
        PieEntryLabels.add("2");
        PieEntryLabels.add("3");
        PieEntryLabels.add("4");
        PieEntryLabels.add("5");
        PieEntryLabels.add("6");
    }
}