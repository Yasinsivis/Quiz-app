package com.example.luno;

import android.os.AsyncTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OracleDatabaseHelper extends AsyncTask<Void, Void, Connection> {

    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@//192.168.1.104:1521/XEPDB1";
    String username = "YASINS";
    String password = "ys";
    private ConnectionListener connectionListener;

    public OracleDatabaseHelper(ConnectionListener connectionListener) {
        this.connectionListener = connectionListener;
    }
   /*public void insertData(Connection connection, String value1, String value2) {
        // Veritabanına veri eklemek için SQL sorgusu
        String sql = "INSERT INTO USER (NAME, PASSWORD) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // SQL sorgusunda belirtilen parametrelere verileri atama
            preparedStatement.setString(1, value1);
            preparedStatement.setString(2, value2);

            // SQL sorgusunu çalıştırma
            preparedStatement.executeUpdate();

            System.out.println("Data inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    @Override
    protected Connection doInBackground(Void... voids) {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    protected void onPostExecute(Connection connection) {
        if (connection != null) {
            connectionListener.onConnectionSuccess(connection);
        } else {
            connectionListener.onConnectionError(new SQLException("Failed to connect to database"));
        }
    }



    public interface ConnectionListener {
        void onConnectionSuccess(Connection connection);

        void onConnectionError(SQLException e);
    }




}





