package com.example.restaurantselection.DataAccess;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.example.restaurantselection.DataAccess.RequestQueueSingleton;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@RequiresApi(api = Build.VERSION_CODES.O)
public class ConnectivityFunctions {

    //rose server
    private static final String url = "http://137.112.104.115:8080";

    //local server
    //private static final String url = "http://10.0.2.2:8080";

    private static final Base64.Encoder enc = Base64.getEncoder();

    public static void createAccount(final String username, final String password, Response.Listener<String> listener, Response.ErrorListener errorListener){ //Called in Register.java [line28]
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url+"/register", listener, errorListener){
            @Override
            public Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("username", enc.encodeToString(username.getBytes()));
                params.put("password", enc.encodeToString(password.getBytes()));
                return params;
            }
        };
    }

    public static void login(final String username, final String password, Response.Listener<String> listener, Response.ErrorListener errorListener){ //Called in MainActivity.java [line52]
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url+"/login", listener, errorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("username", enc.encodeToString(username.getBytes()));
                params.put("password", enc.encodeToString(password.getBytes()));
                return params;
            }
        };
        RequestQueueSingleton.getInstance().addToRequestQueue(stringRequest);
    }

}
