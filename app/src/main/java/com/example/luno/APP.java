package com.example.luno;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class APP extends Application {

    @SuppressLint("StaticFieldLeak")
    public static Context Context;
    public static OracleDatabaseHelper Database;

    public static List<Test> TestList;

    public void onCreate() {
        super.onCreate();
        Context = getApplicationContext();
        Database = new OracleDatabaseHelper();
        TestList = new ArrayList<>();
    }




}
