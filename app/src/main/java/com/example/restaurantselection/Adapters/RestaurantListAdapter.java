package com.example.restaurantselection.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantselection.Models.Restaurant;
import com.example.restaurantselection.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RestaurantListAdapter  extends RecyclerView.Adapter<RestaurantListAdapter.ViewHolder>{

    private ArrayList<Restaurant> restaurants;

    ItemClickedListener activity;

    @NonNull
    @Override
    public RestaurantListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restuarant_format, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        holder.itemView.setTag(restaurants.get(position));

        Restaurant current = restaurants.get(position);

        holder.phoneNumber.setText(Long.toString(current.getContactNumber()));
        holder.address.setText(current.getAddress());
        holder.closeTime.append(" " + current.getClosingTime());
        holder.openTime.append(" " + current.getOpeningTime());
        holder.category.setText(current.getCategory());
        holder.name.setText(current.getName());
    }

    @Override
    public int getItemCount(){
        return restaurants.size();
    }

    public interface ItemClickedListener{
        void onItemClicked(int index);
    }

    public RestaurantListAdapter(Context context, ArrayList<Restaurant> list){
        restaurants = list;
        activity = (ItemClickedListener) context;
    }

    public ArrayList<Restaurant> getList(){
        return restaurants;
    }

    public void setList(ArrayList<Restaurant> restaurants){
        this.restaurants = restaurants;
        this.notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView category;
        TextView openTime;
        TextView closeTime;
        TextView address;
        TextView phoneNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvRestaurantName);
            category = itemView.findViewById(R.id.tvCategory);
            openTime = itemView.findViewById(R.id.tvOpenTime);
            closeTime = itemView.findViewById(R.id.tvCloseTime);
            address = itemView.findViewById(R.id.tvAddress);
            phoneNumber = itemView.findViewById(R.id.tvPhoneNumber);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(restaurants.indexOf(v.getTag()));
                }
            });
        }
    }

}
