package com.example.ernesto.rememberbrall; /**
 * Created by ernesto on 11/05/16.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

public class BDHandler  extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1; //Version de la base de datos

    private static final String DATABASE_NAME = "Bd.db"; //Nombre de la base de datos

    public BDHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creacion de las tablas que vamos a utilizar
<<<<<<< HEAD

        String crearTablaP = "CREATE TABLE Prestamo " +
                "(idPrestamo INTEGER PRIMARY KEY AUTOINCREMENT," +

                NombrePersona + ","+
                NombreObjeto +"," +
                DescripcionObjeto +","+
                FechaP +","+
                FechaD +","+
                Status +")";

             /*   "NombrePersona TEXT," +
                "NombreObjeto TEXT," +
                "DescripcionObjeto TEXT," +
                "FechaD TEXT," +
                "Status TEXT);";*/


        db.execSQL(crearTablaP);
=======
        db.execSQL(BaseDatos.crearTablaP);
>>>>>>> 4557f70f0112bf2b9bb2730f603f9fd7b97c2ce5
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if exists
        db.execSQL("DROP TABLE IF EXISTS " + "Prestamo;");
        // Create tables again
        onCreate(db);
    }

}