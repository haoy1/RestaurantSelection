package com.example.restaurantselection;

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
    private TextView result;
    private Button Login;
    private Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewByID(R.id.editText3);
        Password = (EditText) findViewByID(R.id.editText2);
        Noaccount = (TextView) findViewByID(R.id.textView);
        result = (TextView) findViewByID(R.id.textView2);
        Login = (Button) findViewById(R.id.loginButton);
        Register = (Button) findViewById(R.id.button2);
    }

    private void loginSucceed(){
        if(isMatched(username, Password, result)){

        }
    }
    private static boolean isMatched(EditText username, EditText password, TextView result){
        return true;
    }
}