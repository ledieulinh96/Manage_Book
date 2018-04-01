package com.example.phuth.manage_book.SQLiteHelper;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by phuth on 4/1/2018.
 */

public class TaoDatabase extends SQLiteOpenHelper {
    public static final String DB_MANAGEBOOK ="ManageBook";
    public static final int DB_VERSION = 1;
    public static final String TABLE_ACCOUNT = "tblAccount";
    public static final String ID_ACCOUNT = "_id";
    public static final String USERNAME_ACCOUNT = "username";
    public static final String PASSWORD_ACCOUNT = "password";

    public TaoDatabase(Context context) {
        super(context, DB_MANAGEBOOK, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String cautruyvan = "CREATE TABLE " +  TABLE_ACCOUNT + " ( " + ID_ACCOUNT +
                " INTEGER PRIMARY KEY AUTOINCREMENT," + USERNAME_ACCOUNT  + "TEXT,"  + PASSWORD_ACCOUNT  + "TEXT);";
        db.execSQL(cautruyvan);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ACCOUNT);
        onCreate(db);
    }
}
