package com.example.luno;

import static oracle.net.aso.C05.e;

import android.content.Context;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OracleDatabaseHelper {







    public static Connection getDatabaseConnection() throws ClassNotFoundException, SQLException{ //Veritabanına bağlantı oluşturulan metotumuz.
            Connection connection=null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.101:1521/XEPDB1", "YASINS", "ys");
            Log.e("Başarılı","Veritabanına Bağlantı Kuruldu");
            return  connection;

           //Log.e("Başarılı","Veritabanına Bağlantı Kuruldu.");


    }






    public static void UserAdd(final Context context, final String username, final String password, final String E_mail) { //Veritabanına yeni kullanıcı ekleyen metotumuz.

        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                try {

                    Connection connection=null;
                    connection = getDatabaseConnection(); //Veritabanına bağlanmamızı sağlayan metot.
                    if(connection != null) {
                        String sql = "INSERT INTO LUNO_USER (NAME,PASSWORD,E_MAIL) VALUES (?,?,?)"; //Sql dilinde yazılan veritabanı komutumuz.
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, username);  //kullanıcıdan aldığımız veriyi eklemek için girilen parametreler. username-password
                        preparedStatement.setString(2, password);
                        preparedStatement.setString(3,E_mail);
                        int affectedRows = preparedStatement.executeUpdate();
                        preparedStatement.close();
                        connection.close();


                        if (affectedRows > 0) {

                            Log.i("OracleDatabaseHelper", "Kullanıcı başarıyla eklendi."); //Veritabanı bağlantısı ve diğer tüm işler gerçekleştikten sonra döndürülen mesaj.
                        } else {
                            Log.e("OracleDatabaseHelper", "Kullanıcı eklenemdi.");
                        }
                    }
                    else{
                        Log.e("OracleDatabaseHelper","Veritabanı Bağlanasıtı null");
                    }

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

    public static void PlayerNameAdd(final Context context, final String playername) { //Kullanıcının oyunda ki  kullanacağı nickname adını veritabanına  ekleyen metot.
        AsyncTask<Void, Void, Void> task = new AsyncTask<Void, Void, Void>() {

            @Override
            protected Void doInBackground(Void... voids) {
                Connection connection=null;
                try {

                    // Veritabanı işlemleri
                    connection = getDatabaseConnection();
                    if(connection != null){
                        String sql = "INSERT INTO PLAYER (NAME) VALUES (?)";
                        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setString(1, playername);
                        int affectedRows = preparedStatement.executeUpdate();
                        preparedStatement.close();
                        connection.close();
                    }
                    else{
                        Log.e("OracleDatabaseHelper","Veritabanı Bağlanasıtı null");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        task.execute();
    }



    public static void checkPlayerLogin(final String username,final OnLoginCheckedListener listener ) { //Kullanıcın oluşturduğu nickname'in veritabanında daha önce oluşturulup oluşturulmadığını kontrol eden metottur.

        AsyncTask<Void, Void, Boolean> task = new AsyncTask<Void, Void, Boolean>() {
            @Override
            protected Boolean doInBackground(Void... voids) {
               boolean result = false;
                Connection connection = null;
                try {

                    connection = getDatabaseConnection();
                    if(connection != null){

                        String sql = "SELECT COUNT(*) FROM PLAYER WHERE NAME = ? ";
                        PreparedStatement statement = connection.prepareStatement(sql);
                        statement.setString(1, username);
                        ResultSet resultSet = statement.executeQuery();
                        while (resultSet.next()) {

                            result = true;
                        }

                    } else{
                        Log.e("OracleDatabaseHelper","Veritabanı Bağlanasıtı null");
                    }


                }catch (Exception ex) {
                    return false;

                } finally {
                    if(connection == null){
                        return result;
                    }
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                }

                return result;
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















