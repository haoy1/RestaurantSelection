package com.example.restaurantselection.DataAccess;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.restaurantselection.Adapters.RestaurantListAdapter;
import com.example.restaurantselection.DataAccess.RequestQueueSingleton;
import com.example.restaurantselection.Models.Restaurant;
import com.example.restaurantselection.RestaurantListView;
import com.google.gson.JsonArray;

import org.json.JSONArray;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class ConnectivityFunctions {

    //rose server
    //private static final String url = "http://137.112.104.115:8080";

    //local server
    private static final String url = "http://10.0.2.2:8080";

    private static String savedUsername;
    private static String savedPassword;

    public static void createAccount(final String username, final String password, Response.Listener<String> listener, Response.ErrorListener errorListener){ //Called in Register.java [line28]
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url+"/register", listener, errorListener){
            @Override
            public Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };
        RequestQueueSingleton.getInstance().addToRequestQueue(stringRequest);
    }

    public static void login(final String username, final String password, Response.Listener<String> listener, Response.ErrorListener errorListener){ //Called in MainActivity.java [line52]
        savedUsername = username;
        savedPassword = password;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url+"/login", listener, errorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };
        RequestQueueSingleton.getInstance().addToRequestQueue(stringRequest);
    }

    public static void getRestaurants(Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        JsonArrayRequest arrayRequest = new JsonArrayRequest(url+"/restaurants", listener, errorListener ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("username", savedUsername);
                params.put("password", savedPassword);
                return params;
            }
        };
        RequestQueueSingleton.getInstance().addToRequestQueue(arrayRequest);
    }
}
