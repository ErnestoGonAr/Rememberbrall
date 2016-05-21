package com.example.ernesto.rememberbrall;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ernesto on 21/05/16.
 */
public class BaseDatos {


    BDHandler baseDedatos;
    SQLiteDatabase db = baseDedatos.getWritableDatabase();

    public static String NombrePersona="NombrePersona TEXT";
    public static String NombreObjeto="NombreObjeto TEXT";
    public static String DescripcionObjeto="DescripcionObjeto TEXT";
    public static String FechaD="FechaD DATE";
    public static String Status="Status TEXT";

    final public static String crearTablaP = "CREATE TABLE Prestamo " +
            "(idPrestamo INTEGER PRIMARY KEY AUTOINCREMENT," +

            NombrePersona + ","+
            NombreObjeto +"," +
            DescripcionObjeto +","+
            FechaD +","+
            Status +")";

    public void insertarP(String[] data) {
        String insertP = ("INSERT INTO Prestamo ("+NombrePersona+","+
                NombreObjeto+"," +
                DescripcionObjeto+"," +
                FechaD+"," +
                Status+")" +
                "VALUES (" + data[0] + ", " + data[1] + ", " + data[2] + ", " + data[3] + ", " + data[4] + ");");
        db.execSQL(insertP);
    }


    public void eliminar(int id){
        String deleteP = "DELETE FROM Prestamo WHERE idPrestamo="+id+");";
        db.execSQL(deleteP);
    }

    public void actualizarStatus(int id,String status){
        String updateStatus= "UPDATE Prestamo SET status = '"+status + "' WHERE id = "+id+");";

        db.execSQL(updateStatus);
    }

    public void actualizarDatosPrestamo(int id, String[] data){
        String updateData = ("UPDATE Prestamo SET"+ NombrePersona+ "="+data[0]+
                ","+ NombreObjeto+ "="+data[1]+
                "," +DescripcionObjeto+"="+data[2]+
                "," +FechaD+"="+data[3]+
                "," +Status+ "= "+data[4]+"');");

        db.execSQL(updateData);
    }


    public Cursor leerPrestamos(){

        return db.rawQuery("SELECT"+
                NombrePersona+","+
                NombreObjeto+","+
                DescripcionObjeto+","+
                FechaD+","+
                " FROM Prestamo;", null);
    }


}
