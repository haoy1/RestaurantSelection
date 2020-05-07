package com.example.restaurantselection;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurantselection.R;

import android.os.Bundle;

public class Register extends AppCompatActivity {

    private EditText username;
    private EditText Password;
    private Button RegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    username = (EditText) findViewById(R.id.register_username);
    Password = (EditText) findViewById(R.id.register_password);
    RegisterButton = (Button) findViewById(R.id.button2);

    Register.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            createAccount(username.getText().toString(), password.getText().toString());
        }
    });

    private static boolean createAccount(String username, String password)
}
