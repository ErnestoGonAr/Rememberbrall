package com.example.ernesto.rememberbrall;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ernesto on 21/05/16.
 */
public class BdHandler extends SQLiteOpenHelper{
    private static final String DB_NAME= "Prestamos.sqlite";
    private static final int VERSION = 1;

    public BdHandler(Context context) {
        super(context,DB_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(DbManager.CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

}
