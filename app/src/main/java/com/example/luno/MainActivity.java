package com.example.luno;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Login();
        findViewById(R.id.main).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });

    }

    protected void Login() {
        EditText userName = findViewById(R.id.UserName);
        EditText userPassword = findViewById(R.id.UserPassword);
        Button login = findViewById(R.id.Enter);


        login.setOnClickListener(v -> {
            String Username = userName.getText().toString();
            String Userpassword = userPassword.getText().toString();


            CustomDialog dialog = new CustomDialog(MainActivity.this);
            if (8 > userPassword.length()) { //eğer şifre 8 karakter kısalığından kısaysa hata mesajı verdirip geri döndürüyoruz
                dialog.setMessageTitleAndShow(" Şifre en az 8 karakter olmalıdır", "Hata");
                return;
            }
            if(userName.getText().toString().isEmpty() || userPassword.getText().toString().isEmpty()){
                dialog.setMessageTitleAndShow("Kullanıcı Adı veya Şifre Alanları Boş Girilemez.!","Hata");
            }
            ProcessResult result = APP.Database.Login(Username, Userpassword);
            if (!result.getResult()) {
                dialog.setMessageTitleAndShow("Girdiğiniz Bilgiler Yanlış  Lütfen Tekrar Giriniz.", "Uyarı");
            } else {
                dialog.setMessageTitleAndShow("Giriş Başarılı", "Başarılı");
                Intent HomeUp = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(HomeUp);
            }


        });

    }


    public void Register_Start(View view) {
        Intent RegisterUp = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(RegisterUp);

    }
}










