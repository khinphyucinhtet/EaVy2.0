package com.example.eavy20.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

// DAO class for user-related database operations
public class UserDao {

    private DBHelper dbHelper;

    public UserDao(Context context) {
        dbHelper = new DBHelper(context);
    }

    // ================= CREATE (REGISTER USER) =================
    public boolean registerUser(String fullName, String email, String username, String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(DBHelper.COL_FULLNAME, fullName);
        cv.put(DBHelper.COL_EMAIL, email);
        cv.put(DBHelper.COL_USERNAME, username);
        cv.put(DBHelper.COL_PASSWORD, password);

        long result = db.insert(DBHelper.TABLE_USER, null, cv);
        return result != -1;
    }

    // ================= READ (LOGIN USER) =================
    public boolean loginUser(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(
                DBHelper.TABLE_USER,
                null,
                DBHelper.COL_USERNAME + "=? AND " + DBHelper.COL_PASSWORD + "=?",
                new String[]{username, password},
                null,
                null,
                null
        );

        boolean success = cursor.moveToFirst();
        cursor.close();
        return success;
    }

    // ================= READ (GET FULL NAME BY USERNAME) =================
    public String getFullNameByUsername(String username) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(
                DBHelper.TABLE_USER,
                new String[]{DBHelper.COL_FULLNAME},
                DBHelper.COL_USERNAME + "=?",
                new String[]{username},
                null,
                null,
                null
        );

        String fullName = null;

        if (cursor.moveToFirst()) {
            fullName = cursor.getString(
                    cursor.getColumnIndexOrThrow(DBHelper.COL_FULLNAME)
            );
        }

        cursor.close();
        return fullName;
    }

    // ================= READ (VIEW ALL USERS – DEBUG) =================
    public Cursor getAllUsers() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + DBHelper.TABLE_USER, null);
    }

    // ================= DELETE USER =================
    public void deleteUser(String username) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(
                DBHelper.TABLE_USER,
                DBHelper.COL_USERNAME + "=?",
                new String[]{username}
        );
    }
}
