package com.example.luno;

import static java.sql.DriverManager.getConnection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.SQLException;

public class RegisterActivity extends AppCompatActivity {


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
        EditText userPC = findViewById(R.id.Password_submit);

        Submit.setOnClickListener(new View.OnClickListener() { //Kayıt ol butonuna tıklandığı an çalışcak işlemler
            @Override
            public void onClick(View v) {

                String uName = userName.getText().toString();
                String userpass = userPC.getText().toString();
                String uPassword = userPassword.getText().toString();
                String pName = PlayerName.getText().toString();

                boolean contorlPassword = uPassword.equals(userpass);
                if (8 > uPassword.length() && contorlPassword == false) { //eğer şifre 8 karakter kısalığından kısaysa hata mesajı verdirip geri döndürüyoruz
                    CustomDialog dialog = new CustomDialog(RegisterActivity.this, "Hata", "Şifreniz en az 8 karakterli olmak zorundadır ve lütfen şifreleriniz aynı olsun.");
                    dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_bg);
                    dialog.show();
                } else {

                    OracleDatabaseHelper.UserAdd(RegisterActivity.this, uName, uPassword);

                    if (PlayerName.getText().toString().matches("")) {
                        CustomDialog dialog = new CustomDialog(RegisterActivity.this, "Hata", "Kullanıcı adı boş geçilemez. Lütfen kullanıcı adınızı giriniz.");
                        dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_bg);
                        dialog.show();


                    } else {
                        OracleDatabaseHelper.checkPlayerLogin(pName, new OracleDatabaseHelper.OnLoginCheckedListener() {
                            @Override
                            public void onLoginChecked(boolean result) {


                                if (result == true) {
                                    CustomDialog dialog = new CustomDialog(RegisterActivity.this, "Hata", "Böyle bir kullanıcı adı zaten var lütfen başka bir kullanıcı adı oluşturunuz...");
                                    dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_bg);
                                    dialog.show();


                                } else {
                                    OracleDatabaseHelper.PlayerNameAdd(RegisterActivity.this, pName);
                                }


                            }

                        });


                    }

                }

            }

        });
    }
}





