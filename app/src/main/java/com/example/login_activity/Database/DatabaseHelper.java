package com.example.login_activity.Database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class DatabaseHelper extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "TRAIN_TIME_TABLE.db";
    private static int VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null ,VERSION);
    }

}
