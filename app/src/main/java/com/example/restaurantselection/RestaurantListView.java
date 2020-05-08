package com.example.restaurantselection;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.restaurantselection.Adapters.RestaurantListAdapter;
import com.example.restaurantselection.DataAccess.ConnectivityFunctions;
import com.example.restaurantselection.Models.Restaurant;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class RestaurantListView extends AppCompatActivity implements RestaurantListAdapter.ItemClickedListener, Response.Listener<JSONArray>, Response.ErrorListener {

    RecyclerView recyclerView;
    RestaurantListAdapter adapter;

    ArrayList<Restaurant> restaurants = new ArrayList<>();

    TextView loadingMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_list_layout);
        loadingMessage = findViewById(R.id.tvRestaurantLoadingMessage);
       // setUpRecyclerView();

        loadingMessage.setText("Loading");
        ConnectivityFunctions.getRestaurants(this, this);

    }

    @Override
    public void onItemClicked(int index) {
        //todo what happens when a restaurant is selected
    }

    @Override
    public void onResponse(JSONArray response) {
        Type listType = new TypeToken<ArrayList<Restaurant>>() {}.getType();
        String json = response.toString();
        ArrayList<Restaurant> restaurants = new Gson().fromJson(json, listType);
        this.restaurants = restaurants;
        adapter.setList(restaurants);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
