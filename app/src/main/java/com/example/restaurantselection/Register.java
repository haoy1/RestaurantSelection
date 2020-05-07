package com.example.restaurantselection;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurantselection.R;

import android.os.Bundle;

public class Register extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button RegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = (EditText) findViewById(R.id.register_username);
        password = (EditText) findViewById(R.id.register_password);
        RegisterButton = (Button) findViewById(R.id.button2);

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityFunctions.createAccount(username.getText().toString(), password.getText().toString());//TODO: (nothing need to be done just a marker) createAccount() is called
            }
        });
    }
}
