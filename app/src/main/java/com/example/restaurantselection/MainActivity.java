package com.example.restaurantselection;


import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.restaurantselection.DataAccess.ConnectivityFunctions;
import com.example.restaurantselection.DataAccess.RequestQueueSingleton;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Response.Listener<String>, Response.ErrorListener{
    private EditText username;
    private EditText Password;
    private TextView Noaccount;
    private TextView NotMatch;
    private Button Login;
    private Button Register;
    private Button HistoryOrder;
    private Button RecordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RequestQueueSingleton.getInstance(this);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
        Noaccount = (TextView) findViewById(R.id.textView);
        NotMatch = (TextView) findViewById(R.id.tvLoadingMessage);
        Login = (Button) findViewById(R.id.btnLogin);
        Register = (Button) findViewById(R.id.btnRegister);
        HistoryOrder = (Button) findViewById(R.id.btnhistory);
        RecordButton = (Button) findViewById(R.id.btngorecord);
        RecordButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, createOrder.class));
            }
        });
        HistoryOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this, checkHistory.class));
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButtonAction(username.getText().toString(), Password.getText().toString());
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegisterPage();
            }
        });
    }

    private void loginButtonAction(String username, String password){
        NotMatch.setTextColor(Color.BLACK);
        NotMatch.setText("loading");
        ConnectivityFunctions.login(username, password, this, this); //TODO: (nothing need to be done just a marker) isMatched() is called

    }

    private void goToRegisterPage(){
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);

    }


    @Override
    public void onResponse(String response) {
        if(response.equals("successful")){ //TODO: (nothing need to be done just a marker) isMatched() is called
            Intent intent = new Intent(MainActivity.this, SuccessfuloginActivity.class);
            startActivity(intent);
        }else{
            NotMatch.setTextColor(Color.RED);
            NotMatch.setText("Incorrect Password or username");
        }
    }

    @Override
    public void onErrorResponse(VolleyError error){
        error.getCause().printStackTrace();
    }

}