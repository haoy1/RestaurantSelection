package com.example.restaurantselection;

import android.app.Application;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.restaurantselection.DataAccess.RequestQueueSingleton;

import java.util.HashMap;
import java.util.Map;

public class ConnectivityFunctions {
    private static final String url = "http://137.112.104.115:8080";

    static void createAccount(final String username, final String password, Response.Listener<String> listener, Response.ErrorListener errorListener){ //Called in Register.java [line28]
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url+"/register", listener, errorListener){
            @Override
            public Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("username", username);
                params.put("password", password);
                return params;
            }
        };
    }

    static void login(final String username, final String password, Response.Listener<String> listener, Response.ErrorListener errorListener){ //Called in MainActivity.java [line52]
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

}
