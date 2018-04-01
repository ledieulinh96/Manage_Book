package com.example.phuth.manage_book.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.phuth.manage_book.Model.Account;
import com.example.phuth.manage_book.SQLiteHelper.TaoDatabase;

/**
 * Created by phuth on 4/1/2018.
 */

public class AccountDAO {
    SQLiteDatabase database;
    TaoDatabase taoDatabase;
    String[] columnAccount={TaoDatabase.ID_ACCOUNT, TaoDatabase.USERNAME_ACCOUNT, TaoDatabase.PASSWORD_ACCOUNT};

    public AccountDAO(Context context){
        taoDatabase = new TaoDatabase(context);
    }

    public void open(){
        database = taoDatabase.getWritableDatabase();
    }

    public void close(){
        taoDatabase.close();
    }

    public boolean checkAccount(Account account){
        String cautruyvan = "select * from " + TaoDatabase.TABLE_ACCOUNT + " where "+ TaoDatabase.USERNAME_ACCOUNT +
                " = '" + account.getUsername() + "' and " + TaoDatabase.PASSWORD_ACCOUNT + " = '" + account.getPassword()+ "'";
        Cursor cursor = database.rawQuery(cautruyvan,null);

        return cursor.moveToFirst();
    }

    public boolean addAccount(Account account){
        ContentValues contentValues = new ContentValues();
//        contentValues.put(TaoDatabase.ID_TB,""); bởi vì tự động tăng
        contentValues.put(TaoDatabase.USERNAME_ACCOUNT,account.getUsername().toString());
        contentValues.put(TaoDatabase.PASSWORD_ACCOUNT,account.getPassword().toString());

        long id_ = database.insert(TaoDatabase.TABLE_ACCOUNT,null,contentValues);

        if(id_ != 0){
            return true;
        }
        return false;
    }


}
