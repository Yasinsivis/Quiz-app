package com.example.luno;

public class UserSession {
    private static int userID;

    public static int getUserID() {
        return userID;
    }

    public static void setUserID(int userID) {
        UserSession.userID = userID;
    }
}
