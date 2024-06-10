package com.example.luno;


import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class OracleDatabaseHelper {

    private static Future<Connection> connectionFuture;

    private static final ExecutorService executorService = Executors.newFixedThreadPool(4);

    public OracleDatabaseHelper() {

    }

    private static Connection getConnection()  {
        if (connectionFuture == null || connectionFuture.isDone() || connectionFuture.isCancelled()) {
            connectionFuture = executorService.submit(OracleDatabaseHelper::createDatabaseConnection);
        }
        try {
            return connectionFuture.get();
        } catch (Exception e) {
            return null;
        }
    }

    private static Connection createDatabaseConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//192.168.1.204:1521/XEPDB1", "YASINS", "yasin1234.");
            Log.e("Başarılı", "Veritabanına Bağlantı Kuruldu");
            return connection;
        } catch (Exception e) {
            Log.e("Başarısız", "Veritabanına Bağlantı kurulamadı");
            return null;

        }
    }

   /* private static boolean isConnectionValid() {
        if (connection == null)
            return false;
        try {
            return !connection.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }*/


    public ProcessResult createUser(String name, String password, String email, String playerName) {
        try {
            return new CreateUser().execute(name, password, email, playerName).get();
        } catch (ExecutionException | InterruptedException e) {
            return new ProcessResult(false, "Kayıt işlemi Başarısız");
        }
    }

    public ProcessResult getTests() {
        try {
            return new GetTests().execute().get();
        } catch (ExecutionException | InterruptedException e) {
            return new ProcessResult(false, "Test Çekme işlemi Başarısız");
        }
    }

    public ProcessResult login(String name, String password) {
        try {
            return new LoginCheck().execute(name, password).get();
        } catch (Exception e) {
            return new ProcessResult(false, "Giriş İşlemi Başarısız");
        }
    }

    public ProcessResult getQuestions() {
        try {
            return new GetQuestions().execute().get();
        } catch (ExecutionException | InterruptedException e) {
            return new ProcessResult(false, "Veri çekme işlemi başarısız");
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

                String sql5 = "SELECT ID FROM LUNO_USER WHERE NAME = ?";
                int UserID = 0;
                PreparedStatement statement2 = connection1.prepareStatement(sql5);
                statement2.setString(1, username);
                ResultSet resultSet2 = statement2.executeQuery();
                if (resultSet2.next()) {
                    UserID = resultSet2.getInt("ID");
                }

                String sql3 = "INSERT INTO PLAYER (NAME,USER_ID) VALUES (?,?)";
                PreparedStatement preparedStatement3 = connection1.prepareStatement(sql3);
                preparedStatement3.setString(1, playerName);
                preparedStatement3.setInt(2, UserID);
                int affectedRows2 = preparedStatement3.executeUpdate();
                preparedStatement3.close();

                if (affectedRows2 < 1) {
                    return new ProcessResult(false, "Kayıt işlemi Başarısız");
                }

               /* String sql6 = "CREATE OR REPLACE TRIGGER player_insert_trigger " +
                        "AFTER INSERT ON PLAYER " +
                        "FOR EACH ROW " +
                        "BEGIN " +
                        "    INSERT INTO LUNO_USER (PLAYER_ID) " +
                        "    VALUES (:NEW.ID); " +
                        "END;";
                PreparedStatement statement3 = connection1.prepareStatement(sql6);
                statement3.execute(); */


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

    public static class GetTests extends AsyncTask<Void, Void, ProcessResult> {

        Connection connection1;

        @Override
        protected ProcessResult doInBackground(Void... voids) {
            try {
                List<Test> testList = new ArrayList<>();

                connection1 = getConnection();
                if (connection1 == null) {
                    return new ProcessResult(false, "İnternet Bağlantınızı Kontrol edin");
                }

                String sql4 = "SELECT * FROM TEST ";
                PreparedStatement statement = connection1.prepareStatement(sql4);
                ResultSet resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    Test test = new Test();

                    test.setId(resultSet.getInt("ID"));
                    test.setName(resultSet.getString("NAME"));
                    testList.add(test);
                }
                APP.TestList = testList;
            } catch (Exception e) {
                return new ProcessResult(false, "Test Çekme Başarısız");
            }
            return new ProcessResult(false, "Test Çekme Başarılı");
        }

        @Override
        protected void onPostExecute(ProcessResult result) {
            super.onPostExecute(result);
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
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        protected void onPostExecute(ProcessResult result) {
            super.onPostExecute(result);
        }
    }

    public static class GetQuestions extends AsyncTask<Void, Void, ProcessResult> {
        Connection connection3;

        @Override
        protected ProcessResult doInBackground(Void... params) {
            StringBuilder result = new StringBuilder();
            try {
                List<Integer> testIdList = APP.TestList.stream().map(obj -> new Integer(obj.getId())).collect(Collectors.toList());

                connection3 = getConnection();
                if (connection3 == null) {
                    return new ProcessResult(false, "İnternet Bağlantınızı Kontrol edin");
                }

                for (Integer testId : testIdList) {
                    List<Question> questionList = new ArrayList<>();

                    String query = "SELECT q.ENGLISH_WORD_ID, q.POINT, q.CLUE, " +
                            "a1.NAME AS ANSWER_NAME_1, a2.NAME AS ANSWER_NAME_2, " +
                            "a3.NAME AS ANSWER_NAME_3, a4.NAME AS ANSWER_NAME_4, " +
                            "a1.ID AS ANSWER_ID_1, a2.ID AS ANSWER_ID_2, " +
                            "a3.ID AS ANSWER_ID_3, a4.ID AS ANSWER_ID_4, " +
                            "ac.NAME AS CORRECT_ANSWER_NAME, ac.ID AS CORRECT_ANSWER_ID," +
                            "ew.NAME AS ENGLISH_WORD_NAME, ew.ID AS ENGLISH_WORD_ID " +
                            "FROM QUESTION q " +
                            "JOIN ANSWER a1 ON q.ANSWER_ID_1 = a1.ID " +
                            "JOIN ANSWER a2 ON q.ANSWER_ID_2 = a2.ID " +
                            "JOIN ANSWER a3 ON q.ANSWER_ID_3 = a3.ID " +
                            "JOIN ANSWER a4 ON q.ANSWER_ID_4 = a4.ID " +
                            "JOIN ANSWER ac ON q.CORRECT_ANSWER_ID = ac.ID " +
                            "JOIN ENGLISH_WORD ew ON q.ENGLISH_WORD_ID = ew.ID " +
                            "WHERE q.TEST_ID = ?";

                    PreparedStatement stmt = connection3.prepareStatement(query);
                    stmt.setInt(1, testId);
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        Question question = new Question();
                        question.setAnswer_1(new Answer(rs.getInt("ANSWER_ID_1"),rs.getString("ANSWER_NAME_1")));
                        question.setAnswer_2(new Answer(rs.getInt("ANSWER_ID_2"),rs.getString("ANSWER_NAME_2")));
                        question.setAnswer_3(new Answer(rs.getInt("ANSWER_ID_3"),rs.getString("ANSWER_NAME_3")));
                        question.setAnswer_4(new Answer(rs.getInt("ANSWER_ID_4"),rs.getString("ANSWER_NAME_4")));
                        question.setCorrectAnswer(new Answer(rs.getInt("CORRECT_ANSWER_ID"),rs.getString("CORRECT_ANSWER_NAME")));
                        question.setEnglishWord(new EnglishWord(rs.getInt("ENGLISH_WORD_ID"),rs.getString("ENGLISH_WORD_NAME")));
                        question.setPoint(rs.getInt("POINT"));
                        question.setClue(rs.getString("CLUE"));

                        questionList.add(question);
                    }

                    if (questionList.isEmpty())
                        continue;

                    for (Test test: APP.TestList) {
                        if(test.getId() == testId) {
                            test.setQuestionList(questionList);
                        }
                    }

                    rs.close();
                    stmt.close();
                }

                connection3.close();

            } catch (Exception e) {
                return new ProcessResult(false, "Soru Çekme işlemi başarısız: " + e.getMessage());
            }
            return new ProcessResult(false, "Soru Çekme işlemi Başarılı: ");
        }

        @Override
        protected void onPostExecute(ProcessResult result) {
            super.onPostExecute(result);
        }

    }
}























