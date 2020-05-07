package com.example.restaurantselection;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurantselection.DataAccess.DataAccess;
import com.example.restaurantselection.R;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText Password;
    private TextView Noaccount;
    private TextView result;
    private Button Login;
    private Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
        Noaccount = (TextView) findViewById(R.id.textView);
        result = (TextView) findViewById(R.id.tvLoadingMessage);
        Login = (Button) findViewById(R.id.btnLogin);
        Register = (Button) findViewById(R.id.btnRegister);
    }

    private void loginSucceed(){
        if(DataAccess.login(username.getText().toString(), Password.getText().toString(), result)){

        }
    }

}