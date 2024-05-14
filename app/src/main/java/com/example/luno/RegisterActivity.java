package com.example.luno;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //Tanımlar
        Button Submit = findViewById(R.id.SubmitBtn);
        EditText Email = findViewById(R.id.Email);
        EditText PlayerName = findViewById(R.id.Player_Name);
        EditText userName = findViewById(R.id.UserNameSubmit);
        EditText userPassword = findViewById(R.id.Password);
        EditText userPasswordSubmit = findViewById(R.id.Password_submit);
        Submit.setOnClickListener(new View.OnClickListener() { //Kayıt ol butonuna tıklandığı an çalışcak işlemler
            @Override
            public void onClick(View v) {
              String uName=userName.getText().toString();
              String uPassword=userPassword.getText().toString();
              if(8>uPassword.length()){ //eğer şifre 8 karakter kısalığından kısaysa hata mesajı verdirip geri döndürüyoruz
                    CustomDialog dialog = new CustomDialog(RegisterActivity.this,"Hata","Şifreniz en az 8 karakterli olmak zorundadır.");
                    dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_bg);
                    dialog.show();
              }else {
                  OracleDatabaseHelper.VeriADD(RegisterActivity.this,uName,uPassword); //Burada ise database işlemlerimizi yaptırıyoruz...
              }


            }

        });

    }







}

