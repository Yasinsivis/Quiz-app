package com.example.luno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MainActivity extends AppCompatActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login();

    }
    protected  void Login(){
        EditText userName = findViewById(R.id.UserName);
        EditText userPassword = findViewById(R.id.UserPassword);
        Button login = findViewById(R.id.Enter);

        String Username = userName.getText().toString();
        String Userpassword = userPassword.getText().toString();


        login.setOnClickListener(v -> {
            try {
                OracleDatabaseHelper.checkLoginCredentials(Username , Userpassword);
                Log.e("Başarılı","Kullanıcı girişi çalışıyor.");
                Intent HomeUp= new Intent(MainActivity.this , HomeActivity.class);
                startActivity(HomeUp);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

    }


    public void Register_Start(View view) {
        Intent RegisterUp = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(RegisterUp);

    }
}










