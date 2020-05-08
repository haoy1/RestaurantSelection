package com.example.restaurantselection.Requests;

import androidx.annotation.Nullable;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.example.restaurantselection.Models.Restaurant;

import java.util.ArrayList;

public class RestaurantListRequest extends Request<ArrayList<Restaurant>> {
    public RestaurantListRequest(int method, String url, @Nullable Response.ErrorListener listener) {
        super(method, url, listener);
    }

    @Override
    protected Response<ArrayList<Restaurant>> parseNetworkResponse(NetworkResponse response) {
        ArrayList<Restaurant> output = new ArrayList<>();
        //Gson gson = new Gson();
        //response.data
        return null;
    }

    @Override
    protected void deliverResponse(ArrayList<Restaurant> response) {

    }
}
