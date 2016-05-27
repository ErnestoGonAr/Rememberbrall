
package com.example.ernesto.rememberbrall;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.String.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by Edgar on 21/05/16.
 */
public class Consulta extends Activity implements View.OnClickListener {

    DbManager db;
    Cursor c;
    SimpleCursorAdapter adapter;
    private ListView list;
    ImageButton consulta;
    EditText textoNombre;
    public static String q="";
    public static String nom="";
    public static String ob="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta);
        inicializar();
        db = new DbManager(this);
        llenar();
    }

    private void llenar() {
        list = (ListView) findViewById(R.id.Lista);

        try {
            c = db.leerRegistros();
            c.moveToFirst();
            String[] datos = new String[5];
            do {
                datos[0]= c.getString(1);
                datos[1]= c.getString(2);
                datos[2]= c.getString(3);
                datos[3]= c.getString(4);
                datos[4]= c.getString(5);

                String[] fechaP = datos[3].split("-");
                int añoP = Integer.parseInt(fechaP[0])*365;
                int mesP = Integer.parseInt(fechaP[1])*30;
                int diasP = Integer.parseInt(fechaP[2]);

                Calendar date = Calendar.getInstance();
                int año = date.get(Calendar.YEAR)*365;
                int mes = (date.get(Calendar.MONTH)+1)*30;
                int dias = date.get(Calendar.DAY_OF_MONTH);

                int fechaPrestamo = añoP+mesP+diasP;
                int fechaActual = año+mes+dias;

                if(fechaActual>fechaPrestamo){
                    datos[4] = "RETRASADO";
                    db.modificar(c.getString(0),datos);
                }else {
                    datos[4] = "NO ENTREGADO";
                    db.modificar(c.getString(0),datos);
                }
            } while (c.moveToNext());
        }catch (CursorIndexOutOfBoundsException e){
            Toast.makeText(this, "No hay registros", Toast.LENGTH_SHORT).show();
        }

        String[] from = new String[]{db.NombrePersona, db.Objeto, db.Descripcion, db.Fecha, db.Status};
        int[] to = new int[]{R.id.Persona, R.id.Objeto, R.id.Descripcion, R.id.Fecha, R.id.Status};
        adapter = new SimpleCursorAdapter(this, R.layout.item, c, from, to);
        list.setAdapter(adapter);
    }
    private void llenar2() {
        list = (ListView) findViewById(R.id.Lista);
        TextView n = (TextView) findViewById(R.id.name);
        String x = n.getText().toString();

        c=db.leerRegistros(x);

        String[] from = new String[]{db.NombrePersona, db.Objeto, db.Descripcion, db.Fecha, db.Status};

        int[] to = new int[]{R.id.Persona, R.id.Objeto, R.id.Descripcion, R.id.Fecha, R.id.Status};

        adapter = new SimpleCursorAdapter(this, R.layout.item, c, from, to);

        list.setAdapter(adapter);
    }
    public void inicializar(){
        consulta=(ImageButton)findViewById(R.id.consultor);
        textoNombre=(EditText) findViewById(R.id.name);
    }
    public void detalle(View view){
        TextView persona = (TextView) view.findViewById(R.id.Persona);
        nom = persona.getText().toString();
        TextView Objeto = (TextView) view.findViewById(R.id.Objeto);
        ob = persona.getText().toString();

        Intent i = new Intent(Consulta.this, Detalle.class);
        startActivity(i);
    }
    @Override
    public void onClick(View v) {
        llenar2();
    }

}


