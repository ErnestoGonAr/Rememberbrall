package com.example.ernesto.rememberbrall;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by ernesto on 21/05/16.
 */
public class DbManager {

    public static final String NOMBRET = "Prestamo";
    public static final String ID = "_id";
    public static final String NombrePersona = "NombrePersona";
    public static final String Objeto = "Objeto";
    public static final String Descripcion = "Descripcion";
    public static final String Fecha = "Fecha";
    public static final String Status = "Status";

    public static final String CREAR_TABLA = "CREATE TABLE " + NOMBRET + " ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NombrePersona + " TEXT NOT NULL,"
            + Objeto + " TEXT NOT NULL,"
            + Descripcion + " TEXT NOT NULL,"
            + Fecha + " DATE NOT NULL,"
            + Status + " TEXT NOT NULL);";

    private BdHandler bd;
    private SQLiteDatabase db;

    public DbManager(Context context) {
        bd = new BdHandler(context);
        db = bd.getWritableDatabase();
    }

    public boolean insertar(String[] data){
        if(db.insert(NOMBRET,null, generarValores(data))==-1)return false;
        return true;
    }

    private ContentValues generarValores(String[] data){
        ContentValues contenedor = new ContentValues();
            contenedor.put(NombrePersona,data[0]);
            contenedor.put(Objeto,data[1]);
            contenedor.put(Descripcion,data[2]);
            contenedor.put(Fecha,data[3]);
            contenedor.put(Status,data[4]);
        return contenedor;
    }

    public boolean eliminar(String id){
        if(db.delete(NOMBRET, ID+"=?",new String[]{id})==-1)return false;
        return true;
    }

    public void modificarStatus(String id, String status){
        db.execSQL("UPDATE Prestamo SET Status="+status+"WHERE id="+id+";");
    }

    public Cursor leerRegistros(){
        String[] campos= new String[]{ID, NombrePersona,Objeto,Descripcion,Fecha,Status};
        return db.query(NOMBRET, campos,null,null,null,null,null);
    }

}