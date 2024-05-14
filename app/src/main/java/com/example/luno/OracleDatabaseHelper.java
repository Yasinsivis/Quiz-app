package com.example.luno;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.EditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class OracleDatabaseHelper {
     //AsyncTask kullanarak ana iş parçacığını bloke etmeden veri tabanına ulaşıyoruz ve LUNO_USER tablosuna kullanıcıdan aldığımnız verileri ekliyoruz.
    public static void VeriADD(final Context context, final String username, final String password) {
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    // Veritabanı işlemleri
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.104:1521/XEPDB1", "YASINS", "ys");
                    String sql = "INSERT INTO LUNO_USER (NAME,PASSWORD) VALUES (?,?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, username);
                    preparedStatement.setString(2, password);
                    int affectedRows = preparedStatement.executeUpdate();
                    preparedStatement.close();
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                // İşlem tamamlandıktan sonra yapılacak işlemler buraya yazılır
            }
        };
        task.execute();
    }
}










