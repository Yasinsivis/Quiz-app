package com.example.luno;


import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class OracleDatabaseHelper {

    public static Connection connection;


    public OracleDatabaseHelper() {
        createDatabaseConnection();
    }

    public static Connection getConnection() {
        if (isConnectionValid())
            return connection;

        createDatabaseConnection();
        if (isConnectionValid()) {
            return connection;
        } else {
            CustomDialog customDialog = new CustomDialog(APP.Context);
            customDialog.setMessageTitleAndShow("Hata", "İnternet Bağlantınızı Kontrol Ediniz.");
        }
        return null;

    }

    private static void createDatabaseConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.201:1521/XEPDB1", "YASINS", "ys");
            Log.e("Başarılı", "Veritabanına Bağlantı Kuruldu");
        } catch (Exception e) {
            Log.e("Başarısız", "Veritabanına Bağlantı kurulamadı");
        }
    }

    private static boolean isConnectionValid() {
        if (connection == null)
            return false;
        try {
            return !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }


    public ProcessResult createUser(String name, String password, String email, String playerName) {
        try {
            return new CreateUser().execute(name, password, email, playerName).get();
        } catch (ExecutionException | InterruptedException e) {
            return new ProcessResult(false, "Kayıt işlemi Başarısız");
        }
    }

    public static class CreateUser extends AsyncTask<String, Void, ProcessResult> {

        Connection connection1;

        @Override
        protected ProcessResult doInBackground(String... params) {
            try {

                String username = params[0];
                String password = params[1];
                String email = params[2];
                String playerName = params[3];

                connection1 = getConnection();

                if (connection1 == null) {
                    return new ProcessResult(false, "İnternet Bağlantınızı Kontrol edin");
                }



                String sql4 = "SELECT COUNT(*) FROM LUNO_USER WHERE NAME = ? OR E_MAIL = ?";
                PreparedStatement statement4 = connection1.prepareStatement(sql4);
                statement4.setString(1, username);
                statement4.setString(2, email);
                ResultSet resultSet4 = statement4.executeQuery();
                if (resultSet4.next() && resultSet4.getInt(1) > 0) {
                    return new ProcessResult(false, "Bu Kullanıcı Adı Ya Da E-posta  Daha Önceden Alınmış");
                }

                String sql = "SELECT COUNT(*) FROM PLAYER WHERE NAME = ? ";
                PreparedStatement statement = connection1.prepareStatement(sql);
                statement.setString(1, playerName);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next() && resultSet.getInt(1) > 0) {
                    return new ProcessResult(false, "Bu Oyuncu Adı Daha Önceden Alınmış");
                }

                String sql2 = "INSERT INTO LUNO_USER (NAME,PASSWORD,E_MAIL) VALUES (?,?,?)";
                PreparedStatement preparedStatement2 = connection1.prepareStatement(sql2);
                preparedStatement2.setString(1, username);
                preparedStatement2.setString(2, password);
                preparedStatement2.setString(3, email);
                int affectedRows = preparedStatement2.executeUpdate();
                preparedStatement2.close();

                if (affectedRows < 1) {
                    return new ProcessResult(false, "Kayıt işlemi Başarısız");
                }

                String sql3 = "INSERT INTO PLAYER (NAME) VALUES (?)";
                PreparedStatement preparedStatement3 = connection1.prepareStatement(sql3);
                preparedStatement3.setString(1, playerName);
                int affectedRows2 = preparedStatement3.executeUpdate();
                preparedStatement3.close();

                if (affectedRows2 < 1) {
                    return new ProcessResult(false, "Kayıt işlemi Başarısız");
                }


            } catch (Exception e) {
                return new ProcessResult(false, "Kayıt işlemi Başarısız");
            }
            return new ProcessResult(false, "Kullanıcı başarıyla eklendi");
        }

        @Override
        protected void onPostExecute(ProcessResult result) {
            super.onPostExecute(result);
        }
    }
    public ProcessResult Login(String name , String password){

        try {
            return new LoginCheck().execute(name,password).get();
        } catch (Exception e){
            return  new ProcessResult(false,"Giriş İşlemi Başarısız");
        }
    }

    public static class LoginCheck extends   AsyncTask<String, Void, ProcessResult> {
        Connection connection2;
        @Override
        protected ProcessResult doInBackground(String... params) {
            try {

                String Username = params[0];
                String Password = params[1];

                connection2 = getConnection();

                if (connection2 == null) {
                    Log.e("Hata", "İnternet Bağlantısını Kontrol Ediniz Lütfen");
                }


                String sql = "SELECT COUNT(*) FROM LUNO_USER WHERE NAME = ? AND PASSWORD = ?";
                PreparedStatement statement = connection2.prepareStatement(sql);
                statement.setString(1, Username);
                statement.setString(2, Password);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next() && resultSet.getInt(1) > 0) {
                    return new ProcessResult(true,"Giriş Başarılı");
                } else{
                    return new ProcessResult(false,"Giriş Başarısız");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        @Override
        protected void onPostExecute(ProcessResult result) {
            super.onPostExecute(result);
        }
    }


}























