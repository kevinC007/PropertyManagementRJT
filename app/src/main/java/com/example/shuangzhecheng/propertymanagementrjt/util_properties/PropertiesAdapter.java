package com.example.shuangzhecheng.propertymanagementrjt.util_properties;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shuangzhecheng.propertymanagementrjt.R;
import com.example.shuangzhecheng.propertymanagementrjt.model.properties.PropertyItem;
import com.example.shuangzhecheng.propertymanagementrjt.util_user_functions.MapDisplay;

import java.util.ArrayList;

/**
 * Created by joel on 12/3/2017.
 */

class PropertiesAdapter extends RecyclerView.Adapter<PropertiesAdapter.ViewHolder> implements View.OnClickListener {

Context context;
   private final ArrayList<PropertyItem> propertyItemsArrayList;
    private final LayoutInflater layoutInflater;
    private FragmentManager fragmentManager;

    public PropertiesAdapter(Context context, ArrayList<PropertyItem> propertyItemsArrayList) {
        layoutInflater = LayoutInflater.from(context);
        this.context=context;
        this.propertyItemsArrayList = propertyItemsArrayList;
    }

    public interface OnRecyclerViewItemClickListener
    {
        void onItemClick(View view, String data);

    }

    private PropertiesAdapter.OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(PropertiesAdapter.OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view,String.valueOf(view.getTag()));
        }
        else{
            Log.e("CLICK", "ERROR");
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        final TextView City;
        final TextView Address;
        //final TextView State;
       // final TextView Country;
        final ImageView image;
        final RelativeLayout linearLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            this.City =  itemView.findViewById(R.id.cityEt);
            this.Address = itemView.findViewById(R.id.addressEt);
         //   this.State =  itemView.findViewById(R.id.stateEt);
            this.image =itemView.findViewById(R.id.defaultimageView);
           // this.Country =itemView.findViewById(R.id.countryEt);
            this.linearLayout = (RelativeLayout) itemView.findViewById(R.id.linearlayoutProperties);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.properties_layout,null);
        view.setOnClickListener(this);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.City.setText(propertyItemsArrayList.get(position).propertycity + "\n" + propertyItemsArrayList.get(position).propertystate + ", " + propertyItemsArrayList.get(position).propertycountry);
        holder.Address.setText(propertyItemsArrayList.get(position).propertyaddress);

     holder.linearLayout.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String a = propertyItemsArrayList.get(position).propertyaddress;
             String c = propertyItemsArrayList.get(position).propertycity;;
             String s = propertyItemsArrayList.get(position).propertystate;
             String n = propertyItemsArrayList.get(position).propertycountry;
             Bundle bundle = new Bundle();
             bundle.putString("Address", a);
             bundle.putString("City", c);
             bundle.putString("State", s);
             bundle.putString("Country",n);

             AppCompatActivity activity = (AppCompatActivity) view.getContext();
             MapDisplay mapDisplay = new MapDisplay();
             mapDisplay.setArguments(bundle);
             final FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
             ft.replace(R.id.fragment_adder, mapDisplay, "ContactTenantFragmentTag");
             ft.addToBackStack("FragmentTenants");
             ft.commit();
         }
     });


    }

    @Override
    public int getItemCount() {
        return propertyItemsArrayList.size();
    }
}