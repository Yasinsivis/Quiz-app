package com.example.luno;


import android.os.AsyncTask;
import android.os.Looper;
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

    private static Connection getConnection(){
        if (isConnectionValid())
            return connection;
        //Veritabanına bağlantı oluşturulan metotumuz.
        createDatabaseConnection();
        if (isConnectionValid()) {
            return connection;
        } else {
            CustomDialog customDialog = new CustomDialog(APP.Context);
            customDialog.setMessageTitleAndShow("Hata", "İnternet Bağlantınızı Kontrol Ediniz.");
        }
        return null;
        //Log.e("Başarılı","Veritabanına Bağlantı Kuruldu.");
    }

    private static void createDatabaseConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.101:1521/XEPDB1", "YASINS", "ys");
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
            return new ProcessResult(false,"Kayıt işlemi Başarısız");;
        }
    }

    public static class CreateUser extends AsyncTask<String, Void, ProcessResult> { //Veritabanına yeni kullanıcı ekleyen metotumuz.

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
                    return new ProcessResult(false,"İnternet Bağlantınızı Kontrol edin");
                }


                //Veritabanına bağlanmamızı sağlayan metot.

                String sql = "SELECT COUNT(*) FROM PLAYER WHERE NAME = ? ";
                PreparedStatement statement = connection1.prepareStatement(sql);
                statement.setString(1, username);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next() && resultSet.getInt(1)>0) {
                    return new ProcessResult(false,"Bu Kullanıcı Adı Daha Önceden Alınmış");
                }

                String sql2 = "INSERT INTO LUNO_USER (NAME,PASSWORD,E_MAIL) VALUES (?,?,?)"; //Sql dilinde yazılan veritabanı komutumuz.
                PreparedStatement preparedStatement2 = connection1.prepareStatement(sql2);
                preparedStatement2.setString(1, username);  //kullanıcıdan aldığımız veriyi eklemek için girilen parametreler. username-password
                preparedStatement2.setString(2, password);
                preparedStatement2.setString(3, email);
                int affectedRows = preparedStatement2.executeUpdate();
                preparedStatement2.close();

                if (affectedRows < 1) {
                    return new ProcessResult(false,"Kayıt işlemi Başarısız");
                }

                String sql3 = "INSERT INTO PLAYER (NAME) VALUES (?)";
                PreparedStatement preparedStatement3 = connection1.prepareStatement(sql3);
                preparedStatement3.setString(1, playerName);
                int affectedRows2 = preparedStatement3.executeUpdate();
                preparedStatement3.close();

                if (affectedRows2 < 1) {
                    return new ProcessResult(false,"Kayıt işlemi Başarısız");
                }


            } catch (Exception e) {
                return new ProcessResult(false,"Kayıt işlemi Başarısız");
            }
            return new ProcessResult(false,"Kullanıcı başarıyla eklendi");;
        }

        @Override
        protected void onPostExecute(ProcessResult result) {
            super.onPostExecute(result);
        }
    }
}















