package com.example.restaurantselection;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurantselection.R;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText Password;
    private TextView Noaccount;
    private TextView NotMatch;
    private Button Login;
    private Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.etUsername);
        Password = (EditText) findViewById(R.id.etPassword);
        Noaccount = (TextView) findViewById(R.id.textView);
        NotMatch = (TextView) findViewById(R.id.tvLoadingMessage);
        Login = (Button) findViewById(R.id.btnLogin);
        Register = (Button) findViewById(R.id.btnRegister);

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
        if(ConnectivityFunctions.isMatched(username, password)){ //TODO: (nothing need to be done just a marker) isMatched() is called
            Intent intent = new Intent(MainActivity.this, SuccessfuloginActivity.class);
            startActivity(intent);
        }else{
            NotMatch.setText("Incorrect Password");
        }
    }

    private void goToRegisterPage(){
        Intent intent = new Intent(MainActivity.this, SuccessfuloginActivity.class);
        startActivity(intent);

    }


}