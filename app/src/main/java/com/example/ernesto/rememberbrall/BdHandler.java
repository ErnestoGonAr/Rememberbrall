package com.example.ernesto.rememberbrall;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ernesto on 21/05/16.
 */
public class BdHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "Prestamo.sqlite";
    private static final int VERSION = 6;

    public BdHandler(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(DbManager.CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        bd.execSQL("DROP TABLE IF EXISTS Prestamos;");
        bd.execSQL(DbManager.CREAR_TABLA);
    }

}