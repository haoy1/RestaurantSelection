package com.example.restaurantselection;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.example.restaurantselection.Adapters.RestaurantListAdapter;
import com.example.restaurantselection.DataAccess.ConnectivityFunctions;
import com.example.restaurantselection.Models.Restaurant;

import java.util.ArrayList;

public class RestaurantListView extends AppCompatActivity implements RestaurantListAdapter.ItemClickedListener, Response.Listener {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    ArrayList<Restaurant> restaurants = new ArrayList<>();

    TextView loadingMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_list_layout);
        loadingMessage = findViewById(R.id.tvRestaurantLoadingMessage);
       // setUpRecyclerView();

        loadingMessage.setText("Loading");
        ConnectivityFunctions.getRestaurants(this);

    }

    @Override
    public void onItemClicked(int index) {

    }

    @Override
    public void onResponse(Object response) {

    }
}
