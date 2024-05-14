package com.example.luno;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterActivity extends AppCompatActivity {
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button Submit = findViewById(R.id.SubmitBtn);
        EditText Email = findViewById(R.id.Email);
        EditText PlayerName = findViewById(R.id.Player_Name);
        EditText userName = findViewById(R.id.UserNameSubmit);
        EditText userPassword = findViewById(R.id.Password);
        EditText userPasswordSubmit = findViewById(R.id.Password_submit);


        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new VeritabaniEkleTask().execute();



            }
            private class VeritabaniEkleTask extends AsyncTask<Void, Void, Void> {

                @Override
                protected Void doInBackground(Void... voids) {
                    try {
                        Class.forName(JDBC_DRIVER);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        // Veritabanı bağlantısı oluşturulur
                        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.104:1521/XEPDB1", "YASINS", "ys");

                        // Kullanıcıdan alınan veri
                        String username = userName.getText().toString();
                        String userp=userPassword.getText().toString();

                        // Veri doğrulama yapılabilir

                        // Veritabanına veri eklemek için SQL sorgusu hazırlanır
                        String sql = "INSERT INTO \"USER\" (NAME,PASSWORD) VALUES (?,?)";

                        // SQL sorgusu hazırlanır
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, username);
                        preparedStatement.setString(userp);


                        // Sorgu çalıştırılır
                        int affectedRows = preparedStatement.executeUpdate();

                        // Bağlantı kapatılır
                        preparedStatement.close();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    return null;
                }


                @Override
                protected void onPostExecute(Void aVoid) {
                    // İşlem tamamlandıktan sonra yapılacak işlemler buraya yazılır
                    VeritabaniEkleTask vb=new VeritabaniEkleTask();

                }
            }


            // Kullanıcıdan alınan veri


// Veri doğrulama yapılabilir

            // Veritabanına veri eklemek için SQL sorgusu hazırlanır

// SQL sorgusu hazırlanır



        });

    }







}

  /*  private void insertData(Connection connection ,String uname, String upassword ) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    // Veritabanına veri eklemek için PreparedStatement oluşturun
                    String sql = "INSERT INTO USER (USERNAME, PASSWORD) VALUES (?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, uname);
                    preparedStatement.setString(2, upassword);
                    // SQL sorgusunu çalıştırın
                    preparedStatement.executeUpdate();

                    // PreparedStatement ve bağlantıyı kapatın
                    preparedStatement.close();
                    connection.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }.execute();

    }

}
/* OracleDatabaseHelper db;
        try {
            Class.forName(JDBC_DRIVER);
             db = new OracleDatabaseHelper.ConnectionListener() {
                @Override
                public void onConnectionSuccess(Connection connection) {
                    Submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String usern = userName.getText().toString();
                            String userp = userPassword.getText().toString();
                            db.insertData(usern,userp);
                        }
                    });
                }

                @Override
                public void onConnectionError(SQLException e) {
                    System.out.println("bağlanamadı"+e.getMessage());
                }
            }; db.execute();


        } catch (Exception e) {

        }*/