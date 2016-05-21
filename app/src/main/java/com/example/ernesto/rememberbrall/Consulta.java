package com.example.ernesto.rememberbrall;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;



/**
 * Created by Edgar on 21/05/16.
 */
        public class Consulta extends AppCompatActivity {

            ListView li;
            ArrayList<BeanPrestamo> lista = new ArrayList<BeanPrestamo>();
            BeanPrestamo prestamo;
        public String Convertir(Date FechaD){
            FechaD=new Date();
            return FechaD.toString();
        }


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.consulta);

                li=(ListView)findViewById(R.id.Lista);
                BDHandler baseDedatos = new BDHandler(getApplicationContext());
                SQLiteDatabase db = baseDedatos.getWritableDatabase();

                Cursor c=db.rawQuery("SELECT * FROM Prestamo;", null);
                if(c.moveToFirst()){
                    do{
                        prestamo=
                                new BeanPrestamo(
                                        c.getColumnName(0),c.getColumnName(1),c.getColumnName(2),c.getColumnName(3),c.getColumnName(4));
                        lista.add(prestamo);
                    }while(c.moveToNext());
                }
                ArrayAdapter<BeanPrestamo> tuano= new ArrayAdapter<BeanPrestamo>(getApplicationContext(),R.layout.item,lista);
                li.setAdapter(tuano);
            }





        }