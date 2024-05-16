package com.example.luno;

import android.content.Context;
import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleDatabaseHelper {
    //AsyncTask kullanarak ana iş parçacığını bloke etmeden veri tabanına ulaşıyoruz ve LUNO_USER tablosuna kullanıcıdan aldığımnız verileri ekliyoruz.

    public static Connection connection;

    public static void DatabaseConnec() throws ClassNotFoundException, SQLException { //Database bağlantımızı bir method haline getirip her yerden erişelbilir elde etmiş oldukç
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                return null;
            }

            @Override
            protected void onPreExecute() {
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    connection = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.106:1521/XEPDB1", "YASINS", "ys");
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                    // İşlem tamamlandıktan sonra yapılacak işlemler buraya yazılır
                }
            }

            protected void onPostExecutes(Void aVoid) {

            }

        }.execute();

    }

    public static void UserAdd(final Context context, final String username, final String password) {
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    // Veritabanı işlemleri
                    DatabaseConnec();
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

    public static void PlayerNameAdd(final Context context, final String playername) {
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    // Veritabanı işlemleri
                    DatabaseConnec();
                    String sql = "INSERT INTO PLAYER (NAME) VALUES (?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setString(1, playername);
                    int affectedRows = preparedStatement.executeUpdate();
                    preparedStatement.close();
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        task.execute();
    }


    // Örnek bir metot
    public static void checkPlayerLogin(final String username,final OnLoginCheckedListener listener ) {
        // AsyncTask'ı başlatmak için yeni bir instance oluştur ve execute() metoduyla çalıştır
        AsyncTask<Void, Void, Boolean> task = new AsyncTask<Void, Void, Boolean>() {



            @Override
            protected Boolean doInBackground(Void... voids) {
               boolean result = false;

                try {
                    DatabaseConnec();
                    String sql = "SELECT COUNT(*) FROM PLAYER WHERE NAME = ? ";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, username);
                    ResultSet resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        // Sonuçları işleyin
                        result = true;
                    }

                }catch (SQLException ex) {
                    throw new RuntimeException(ex);

                } finally {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                    return result;

                }

            }
            @Override
            protected void onPostExecute(Boolean result){
                super.onPostExecute(result);
                listener.onLoginChecked(result);
            }
        };
        task.execute();


    }
    public interface OnLoginCheckedListener {
        void onLoginChecked(boolean result);
    }

}















