package com.example.ernesto.rememberbrall; /**
 * Created by ernesto on 11/05/16.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLException;

public class BDHandler  extends SQLiteOpenHelper {
    public String NombrePersona="NombrePersona";
    public String NombreObjeto="NombreObjeto";
    public String DescripcionObjeto="DescripcionObjeto";
    public String FechaP="FechaP";
    public String FechaD="FechaD";
    public String Status="Status";

    private static final int DATABASE_VERSION = 1; //Version de la base de datos

    private static final String DATABASE_NAME = "Bd.db"; //Nombre de la base de datos

    public BDHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //Creacion de las tablas que vamos a utilizar

        String crearTablaP = "CREATE TABLE Prestamo " +
                "(idPrestamo INTEGER PRIMARY KEY AUTOINCREMENT," +
<<<<<<< HEAD
                NombrePersona + ","+
                NombreObjeto +"," +
                DescripcionObjeto +","+
                FechaP +","+
                FechaD +","+
                Status +")";
=======
                "NombrePersona TEXT," +
                "NombreObjeto TEXT," +
                "DescripcionObjeto TEXT," +
                "FechaD TEXT," +
                "Status TEXT);";
>>>>>>> cdda8e5c2698f662a1d94f595877881399a1cc46

        db.execSQL(crearTablaP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + "Prestamo.TABLE;");

        // Create tables again
        onCreate(db);
    }

    //************OPERACIONES EN LA BD***********************

    public void insertarP(SQLiteDatabase db, String[] data) {
        String insertP = ("INSERT INTO Prestamo ("+NombrePersona+","+
                NombreObjeto+"," +
                DescripcionObjeto+"," +
                FechaP+","+
                FechaD+"," +
                Status+")" +
                "VALUES ('" + data[0] + "', '" + data[1] + "', '" + data[2] + "', '" + data[3] + "', '" + data[4] + "', '" + data[5] + ");");
        db.execSQL(insertP);
    }


    public void eliminar(SQLiteDatabase db, int id){
        String deleteP = "DELETE FROM Prestamo WHERE idPrestamo="+id+");";

        db.execSQL(deleteP);
    }

    public void actualizarStatus(SQLiteDatabase db, int id,String status){
        String updateStatus= "UPDATE Prestamo SET status = '"+status + "' WHERE id = "+id+");";

        db.execSQL(updateStatus);
    }

    public void actualizarDatosPrestamo(SQLiteDatabase db, int id, String[] data){
        String updateData = ("UPDATE Prestamo SET"+ NombrePersona+ "="+data[0]+
                ","+ NombreObjeto+ "="+data[1]+
                "," +DescripcionObjeto+"="+data[2]+
                "," +FechaP+"="+data[3]+
                "," +FechaD+"="+data[4]+
                "," +Status+ "= "+data[5]+"');");

        db.execSQL(updateData);
    }

    //*******************CONSULTAS EN LA BD**************

    private Cursor getPrestamos(SQLiteDatabase db, int usuario){
        String tabla="Prestamo";
        String[] columnas = new String[] {NombrePersona, NombreObjeto, DescripcionObjeto, FechaP, FechaD, Status};
        String where = null;
        String[] args =null;
        String groupBy = null;
        String having=null;
        String orderBy= null;
        String limit= "100";

        return db.query(tabla, columnas, where, args, groupBy, having, orderBy, limit);
    }

    public Cursor leerPrestamos(){
        SQLiteDatabase db = getReadableDatabase();

        return db.rawQuery("SELECT"+
                NombrePersona+","+
                NombreObjeto+","+
                DescripcionObjeto+","+
                FechaD+","+
                FechaP+" FROM Prestamo;", null);
    }


}