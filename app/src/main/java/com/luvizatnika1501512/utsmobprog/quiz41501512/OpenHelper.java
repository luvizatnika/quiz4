package com.luvizatnika1501512.utsmobprog.quiz41501512;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;


public class OpenHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "dbQuiz4.db";
    public static final String TABLE_CREATE =
            "CREATE TABLE BAYAR (ID INTEGER PRIMARY KEY AUTOINCREMENT, KODE_BAYAR TEXT, JUMLAH_BAYAR TEXT)";

    public OpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS BAYAR");
    }
}
