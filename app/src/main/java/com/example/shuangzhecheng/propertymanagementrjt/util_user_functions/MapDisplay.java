package com.example.shuangzhecheng.propertymanagementrjt.util_user_functions;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shuangzhecheng.propertymanagementrjt.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapDisplay extends Fragment implements OnMapReadyCallback {

    String Property_Address,Property_City,Property_State,Property_Country;
    TextView addr,city,state,country;
    GoogleMap map;
    LatLng Current = null;
    Context context;

    Double lat = 0.0;
    Double lon = 0.0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_maps, container, false);
        addr = (TextView) view.findViewById(R.id.addressMap);
        city = (TextView) view.findViewById(R.id.CityMap);
        state = (TextView) view.findViewById(R.id.stateMap);
        country = (TextView) view.findViewById(R.id.countryMap);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
            Property_Address = bundle.getString("Address");
            Property_City = bundle.getString("City");
            Property_State = bundle.getString("State");
            Property_Country = bundle.getString("Country");
        addr.setText(Property_Address);
        city.setText(Property_City);
        state.setText(Property_State);
        country.setText(Property_Country);



            lat = 41.904172;
            lon = -88.335830;

        Current = new LatLng(lat, lon);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        map.addMarker(new MarkerOptions().position(Current).title("Location:  " +Property_Address));
        map.moveCamera(CameraUpdateFactory.newLatLng(Current));

    }

}