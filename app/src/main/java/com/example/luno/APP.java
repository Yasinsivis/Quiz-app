package com.example.luno;

import android.app.Application;
import android.content.Context;

public class APP extends Application {

    public static Context Context;
    public static OracleDatabaseHelper Database;

    public void onCreate() {
        super.onCreate();
        Context = getApplicationContext();
        Database = new OracleDatabaseHelper();
    }




}
