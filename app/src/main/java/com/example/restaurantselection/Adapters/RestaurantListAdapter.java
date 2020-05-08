package com.example.restaurantselection.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.restaurantselection.Models.Restaurant;
import com.example.restaurantselection.R;

import java.util.ArrayList;
import java.util.List;

public class RestaurantListAdapter  extends RecyclerView.Adapter<RestaurantListAdapter.ViewHolder>{

    private ArrayList<Restaurant> restaurants;

    ItemClickedListener activity;

    @NonNull
    @Override
    public RestaurantListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list_layout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position){
        holder.itemView.setTag(restaurants.get(position));

        // todo configure information to display about each restaurant
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

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //todo connect to ui
        }
    }

}
