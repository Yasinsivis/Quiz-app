package com.example.luno;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userRegistration();
    }


    protected void userRegistration() {
        //Tanımlar
        Button Submit = findViewById(R.id.SubmitBtn);
        EditText Email = findViewById(R.id.Email);
        EditText PlayerName = findViewById(R.id.Player_Name);
        EditText userName = findViewById(R.id.UserNameSubmit);
        EditText userPassword = findViewById(R.id.Password);
        EditText userPC = findViewById(R.id.Password_submit);

        //Kayıt ol butonuna tıklandığı an çalışcak işlemler
        Submit.setOnClickListener(v -> {
            String uName = userName.getText().toString();
            String userpass = userPC.getText().toString();
            String uPassword = userPassword.getText().toString();
            String pName = PlayerName.getText().toString();
            String E_mail = Email.getText().toString();
            CustomDialog dialog = new CustomDialog(RegisterActivity.this);

            if (!uPassword.equals(userpass)) {
                dialog.setMessageTitleAndShow("Şifreler Aynı Değil", "Hata");
                return;
            }

            if (8 > uPassword.length()) { //eğer şifre 8 karakter kısalığından kısaysa hata mesajı verdirip geri döndürüyoruz
                dialog.setMessageTitleAndShow(" Şifre en az 8 karakter olmalıdır", "Hata");
                return;
            }

            if (PlayerName.getText().toString().isEmpty()) {
                dialog.setMessageTitleAndShow("Kullanıcı adı boş geçilemez. Lütfen kullanıcı adınızı giriniz.", "Hata");
                return;
            }
            //OracleDatabaseHelper.PlayerNameAdd(RegisterActivity.this, pName);
            ProcessResult result = APP.Database.createUser(uName, uPassword, E_mail, pName);
            if (!result.getResult()) {
                dialog.setMessageTitleAndShow("Hata", result.getMessage());
            } else {
                dialog.setMessageTitleAndShow("Onay", result.getMessage());
            }

        });
    }
}





