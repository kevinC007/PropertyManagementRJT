package com.example.shuangzhecheng.propertymanagementrjt.util_properties;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.shuangzhecheng.propertymanagementrjt.R;
import com.example.shuangzhecheng.propertymanagementrjt.net.AppController;

/**
 * Created by joel on 12/3/2017.
 */

public class FragmentAddProperty extends Fragment {

    Context context;
    EditText etAddress,etCity,etState,etZip,etCountry,etPurchasePrice;
    String address, city, state, country, purchase_price, mortage_info;
    String pro_status1 = "landlord";
    Button btnAddProperty;

    private RecyclerView propertiesRecyclerView;
    private PropertiesAdapter productsAdapter;
    private RecyclerView.LayoutManager layoutManager;
    RadioGroup rg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_addproperty, container, false);
        etAddress       = (EditText)view.findViewById(R.id.addressEt);
        etCity          = (EditText)view.findViewById(R.id.cityEt);
        etState         = (EditText)view.findViewById(R.id.stateEt);
        etZip           = (EditText)view.findViewById(R.id.zipEt);
        etCountry       = (EditText)view.findViewById(R.id.countryEt);
        etPurchasePrice = (EditText)view.findViewById(R.id.purchasePriceEt);
        btnAddProperty  = (Button)view.findViewById(R.id.addPropertyBtn);
        rg              = (RadioGroup)view.findViewById(R.id.rg);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButtonYes) {
                    mortage_info = "yes";
                } else if (i == R.id.radioButtonNo) {
                    mortage_info = "no";
                }
            }
        });

        btnAddProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                address = etAddress.getText().toString();
                city = etCity.getText().toString();
                state = etState.getText().toString();
                country = etCountry.getText().toString();
                purchase_price = etPurchasePrice.getText().toString();
                Log.i("Add Property", "Mortgage Info: " + mortage_info);
                Log.i("Add Property", "Details: " + address);
                if (!(address.isEmpty()) && !(city.isEmpty()) && !(state.isEmpty()) && !(country.isEmpty()) && !(purchase_price.isEmpty())) {
                    if (!(address == "") && !(city == "") && !(state == "") && !(country == "") && !(purchase_price == "")) {
                        Toast.makeText(getActivity(), "Processing Your Request", Toast.LENGTH_SHORT).show();
                        String url = "http://rjtmobile.com/aamir/property-mgmt/pro_mgt_add_pro.php?" +
                                "address=" + address + "&city=" + city + "&state=" + state + "&country=" +country + "&pro_status=" + pro_status1 +
                                "&purchase_price=" + purchase_price + "&mortage_info=" + mortage_info;
                        webserviceaddproperty(url);
                    } else
                        Toast.makeText(getActivity(), " Fill Details Correctly", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getActivity(), "Some Fields are Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
private void webserviceaddproperty(String url) {
    String tag_string_req = "string_req";
    StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
         Log.i("Add Property:", response);



                   FragmentProperties fragmentProperties = new FragmentProperties();
                    final FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragment_adder, fragmentProperties, "PropertiesFragmentTag");
//                    ft.addToBackStack("FragmentProperties");
                    ft.commit();

         }
    }, new Response.ErrorListener() {

        @Override
        public void onErrorResponse(VolleyError error) {

        }
    });
            // Adding request to request queue
            AppController.getInstance().addToRequestQueue(stringRequest, tag_string_req);
    }
}
