package com.example.ernesto.rememberbrall;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ernesto on 21/05/16.
 */
public class BdHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "Prestamos.sqlite";
<<<<<<< HEAD
    private static final int VERSION = 2;
=======
    private static final int VERSION = 3;
>>>>>>> 7252aeed4cd31cf133db748e27ccf757d8f31d63

    public BdHandler(Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(DbManager.CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        bd.execSQL("DROP TABLE IF EXIST Prestamo");
        onCreate(bd);
    }

}