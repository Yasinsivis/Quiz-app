package com.example.luno;


import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            connection = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.105:1521/XEPDB1", "YASINS", "ys");
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

    public ProcessResult Login(String name, String password) {

        try {
            return new LoginCheck().execute(name, password).get();
        } catch (Exception e) {
            return new ProcessResult(false, "Giriş İşlemi Başarısız");
        }
    }

    public static class LoginCheck extends AsyncTask<String, Void, ProcessResult> {
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
                    return new ProcessResult(true, "Giriş Başarılı");
                } else {
                    return new ProcessResult(false, "Giriş Başarısız");
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

    public ProcessResult fetchEnglishWordData() {
        String query = "SELECT * FROM ENGLISH_WORD ORDER BY DBMS_RANDOM.RANDOM FETCH FIRST 1 ROWS ONLY";
        try {
            return new FetchEnglishWordData().execute(query).get();
        } catch (ExecutionException | InterruptedException e) {
            return new ProcessResult(false, "Veri çekme işlemi başarısız");
        }
    }

    public static class FetchEnglishWordData extends AsyncTask<String, Void, ProcessResult> {
        Connection connection3;

        @Override
        protected ProcessResult doInBackground(String... params) {
            StringBuilder result = new StringBuilder();
            try {
                String query = params[0];

                connection3 = getConnection();
                if (connection3 == null) {
                    return new ProcessResult(false, "İnternet Bağlantınızı Kontrol edin");
                }

                Statement stmt = connection3.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                int wordId = -1;
                if (rs.next()) {
                    wordId = rs.getInt("ID");  // Kelimenin ID'sini alın
                    String word = rs.getString("NAME"); // Kelimeyi alın
                    result.append(word).append("\n");
                }

                rs.close();
                stmt.close();

                // Eğer kelime bulunduysa, bu kelimenin ID'si ile ilgili soruları çekin
                if (wordId != -1) {
                    Questions question = fetchQuestionByWordId(wordId);
                    if (question != null) {
                        result.append("QUESTION: ").append(question.getId()).append("\n");
                        return new ProcessResult(true, "Başarılı");
                    } else {
                        return new ProcessResult(false, "İlgili soru bulunamadı.");
                    }
                } else {
                    return new ProcessResult(false, "Kelime bulunamadı.");
                }
            } catch (SQLException e) {
                return new ProcessResult(false, "Veri çekme işlemi başarısız: " + e.getMessage());
            } finally {
                try {
                    if (connection3 != null && !connection3.isClosed()) {
                        connection3.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void onPostExecute(ProcessResult result) {
            super.onPostExecute(result);
        }

        // `wordId` ile ilgili soruyu ve seçenekleri çekmek için yeni metot
        public Questions fetchQuestionByWordId(int wordId) {
            Questions question = null;
            Connection connection4 = getConnection();

            try {
                if (connection4 == null) {
                    Log.e("Hata", "Veritabanı Bağlantısı Oluşturulmadı.");
                }

                String query = "SELECT q.ENGLISH_WORD_ID, q.POINT, q.CLUE, " +
                        "a1.NAME AS ANSWER_ID_1, a2.NAME AS ANSWER_ID_2, " +
                        "a3.NAME AS ANSWER_ID_3, a4.NAME AS ANSWER_ID_4, " +
                        "ac.NAME AS CORRECT_ANSWER_ID " +
                        "FROM QUESTION q " +
                        "JOIN ANSWER a1 ON q.ANSWER_ID_1 = a1.id " +
                        "JOIN ANSWER a2 ON q.ANSWER_ID_2 = a2.id " +
                        "JOIN ANSWER a3 ON q.ANSWER_ID_3 = a3.id " +
                        "JOIN ANSWER a4 ON q.ANSWER_ID_4 = a4.id " +
                        "JOIN ANSWER ac ON q.CORRECT_ANSWER_ID = ac.id " +
                        "WHERE q.ENGLISH_WORD_ID = ?";

                PreparedStatement stmt = connection4.prepareStatement(query);
                stmt.setInt(1, wordId);
                ResultSet rs = stmt.executeQuery();
                System.out.println("Sorgu Yürütüldü");


                if (rs.next()) {


                    System.out.println("Veri Bulundu");


                    //String questionText = rs.getString("NAME");
                    String optionA = rs.getString("ANSWER_ID_1");
                    String optionB = rs.getString("ANSWER_ID_2");
                    String optionC = rs.getString("ANSWER_ID_3");
                    String optionD = rs.getString("ANSWER_ID_4");
                    String correctOption = rs.getString("CORRECT_ANSWER_ID");
                    int points = rs.getInt("POINT");
                    String hint = rs.getString("CLUE");


                    question = new Questions(wordId , optionA, optionB, optionC, optionD, correctOption, points, hint);
                } else {
                    System.out.println("Sonuç Bulunmadı");
                }

                rs.close();
                stmt.close();
                connection4.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL Error: " + e.getMessage());
            }
            return question;
        }
    }


}























