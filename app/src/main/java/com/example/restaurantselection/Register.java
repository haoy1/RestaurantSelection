package com.example.restaurantselection;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.restaurantselection.DataAccess.ConnectivityFunctions;

import android.os.Bundle;
import android.widget.TextView;

public class Register extends AppCompatActivity implements Response.Listener<String>, Response.ErrorListener {
    private EditText username;
    private EditText password;
    private Button RegisterButton;
    private TextView loadingMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText) findViewById(R.id.register_username);
        password = (EditText) findViewById(R.id.register_password);
        RegisterButton = (Button) findViewById(R.id.createaccountbutton);
        loadingMessage = findViewById(R.id.tvRegisterLoadingMessage);

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingMessage.setTextColor(Color.BLACK);
                loadingMessage.setText("Loading...");
                registerUser(username.getText().toString(), password.getText().toString());
            }
        });
    }

    public void registerUser(String username, String password){
        ConnectivityFunctions.createAccount(username, password, this, this);//TODO: (nothing need to be done just a marker) createAccount() is called
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(String response) {
        if(response.equals("Success")){
            Intent intent = new Intent(Register.this, MainActivity.class);
            startActivity(intent);
        }else{
            loadingMessage.setTextColor(Color.RED);
            loadingMessage.setText("User name is already taken");
        }
    }
}
