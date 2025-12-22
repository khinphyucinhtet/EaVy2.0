package com.example.eavy20.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Database helper class for managing SQLite database
public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "eavy.db";
    private static final int DATABASE_VERSION = 1;

    // USER TABLE
    public static final String TABLE_USER = "users";
    public static final String COL_ID = "id";
    public static final String COL_FULLNAME = "fullName";
    public static final String COL_EMAIL = "email";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Create table (RUNS ON FIRST INSTALL)
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USER_TABLE =
                "CREATE TABLE " + TABLE_USER + " (" +
                        COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COL_FULLNAME + " TEXT, " +
                        COL_EMAIL + " TEXT, " +
                        COL_USERNAME + " TEXT UNIQUE, " +
                        COL_PASSWORD + " TEXT)";

        db.execSQL(CREATE_USER_TABLE);
    }

    // Called when DB version changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(db);
    }
}
