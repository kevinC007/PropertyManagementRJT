package com.example.shuangzhecheng.propertymanagementrjt.util_properties;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shuangzhecheng.propertymanagementrjt.R;
import com.example.shuangzhecheng.propertymanagementrjt.model.properties.PropertyItem;

import java.util.ArrayList;

/**
 * Created by joel on 12/3/2017.
 */

class PropertiesAdapter extends RecyclerView.Adapter<PropertiesAdapter.ViewHolder> implements View.OnClickListener {

    private final ArrayList<PropertyItem> propertyItemArrayList;
    private final Context context;
    private final LayoutInflater layoutInflater;

    public PropertiesAdapter(Context context, ArrayList<PropertyItem> propertyItemArrayList){
        layoutInflater = LayoutInflater.from(context);
        this.context=context;
        this.propertyItemArrayList = propertyItemArrayList;
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

        public ViewHolder(View itemView) {
            super(itemView);
            this.City =  itemView.findViewById(R.id.cityEt);
            this.Address = itemView.findViewById(R.id.addressEt);
         //   this.State =  itemView.findViewById(R.id.stateEt);
            this.image =itemView.findViewById(R.id.defaultimageView);
           // this.Country =itemView.findViewById(R.id.countryEt);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.properties_layout,null);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.City.setText(propertyItemArrayList.get(position).propertycity + "     " + propertyItemArrayList.get(position).propertystate + "     "  + propertyItemArrayList.get(position).propertycountry);
        holder.Address.setText(propertyItemArrayList.get(position).propertyaddress);
  //      holder.State.setText(propertyItemArrayList.get(position).propertystate);
    ///    holder.Country.setText(propertyItemArrayList.get(position).propertycountry);
        //holder.price.setText(productsArrayList.get(position).Price);
    }

    @Override
    public int getItemCount() {
        return propertyItemArrayList.size();
    }
}