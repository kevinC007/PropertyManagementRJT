package com.example.shuangzhecheng.propertymanagementrjt.util_properties;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.shuangzhecheng.propertymanagementrjt.R;
import com.example.shuangzhecheng.propertymanagementrjt.database.database_properties.SQLp;
import com.example.shuangzhecheng.propertymanagementrjt.model.Graphsandchart.RentDetails;
import com.example.shuangzhecheng.propertymanagementrjt.model.properties.PropertyItem;
import com.example.shuangzhecheng.propertymanagementrjt.net.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by joel on 12/2/2017.
 */

public class FragmentProperties extends Fragment {

    private static final String url = "http://rjtmobile.com/aamir/property-mgmt/property.php?";

    Button addproperty;
    private SQLp SqlHelper;
    private SQLiteDatabase db;
    private RecyclerView propertiesRecyclerView;
    private PropertiesAdapter propertiesAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<PropertyItem> propertyItemsArrayList;
    private ArrayList<RentDetails> rentDetailsArrayList;
    private RentDetails rentDetails;
    private PropertyItem propertyItem;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_properties, container, false);

        propertiesRecyclerView = (RecyclerView) view.findViewById(R.id.propertiesRecyclerView);
        propertiesRecyclerView.setHasFixedSize(true);
        SqlHelper = new SQLp(getContext());
        db = SqlHelper.getWritableDatabase();


        layoutManager = new LinearLayoutManager(getActivity());
        propertiesRecyclerView.setLayoutManager(layoutManager);
        propertyItemsArrayList = new ArrayList<>();

        requestProperties();
        return view;
    }
//----------------------------------------------------------------------------------------------------------------------------------------------------
    private void requestProperties() {
        StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            Log.i("MYTEST", response);
            try {
                JSONObject jsonObject = new JSONObject(response);
                JSONArray property = jsonObject.getJSONArray("Property");
                for (int i = 0; i < property.length(); i++) {
                    JSONObject item = property.getJSONObject(i);

                    final String id = item.getString("id");
                    final String propertyaddress = item.getString("propertyaddress");
                    final String propertycity  = item.getString("propertycity");
                    final String propertystate = item.getString("propertystate");
                    final String propertycountry = item.getString("propertycountry");
                    final String propertypurchaseprice = item.getString("propertypurchaseprice");
                    final String propertymortageinfo = item.getString("propertymortageinfo");

                    propertyItem = new PropertyItem(id, propertyaddress,propertycity,propertystate,propertycountry,propertypurchaseprice,propertymortageinfo);
                    propertyItemsArrayList.add(propertyItem);
                    propertiesAdapter = new PropertiesAdapter(getActivity(), propertyItemsArrayList);
                    propertiesRecyclerView.setAdapter(propertiesAdapter);
                }

                propertiesAdapter.setOnItemClickListener(new PropertiesAdapter.OnRecyclerViewItemClickListener() {
                        @Override
                        public void onItemClick(View view, String data) {
                            Log.i("VALUES","you clicked me?");
                            Bundle bundle = new Bundle();
                            for (PropertyItem p : propertyItemsArrayList) {
                                if (p.id.equals(data)) {
                                    bundle.putString("Address", p.propertyaddress);
                                    bundle.putString("City", p.propertycity);
                                    bundle.putString("State", p.propertystate);
                                    bundle.putString("Country", p.propertycountry);
                                    Log.i("VALUES","V" + p.propertyaddress);
                                }
                            }
                        }
                });
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        AppController.getInstance().addToRequestQueue(sr);

    }
//---------------------------------------------------------------------------------------------------------------------------------------
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addproperty = (Button) view.findViewById(R.id.buttonAddNew);

        addproperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentAddProperty fragmentAddProperty = new FragmentAddProperty();
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_adder, fragmentAddProperty, "NewFragmentTag");
                ft.addToBackStack("FragmentProperties");
                ft.commit();
            }
        });
    }
}