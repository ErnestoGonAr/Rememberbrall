
package com.example.ernesto.rememberbrall;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;



/**
 * Created by Edgar on 21/05/16.
 */
public class Consulta extends AppCompatActivity {

    DbManager db;
    Cursor c;
    SimpleCursorAdapter adapter;
    private ListView list;
    public static String nom="";
    public static String ob="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta);

        db = new DbManager(this);
        llenar();

    }

    private void llenar() {
        list = (ListView) findViewById(R.id.Lista);

        c = db.leerRegistros();

        String[] from = new String[]{ db.Objeto,db.NombrePersona, db.Descripcion, db.Fecha, db.Status};

        int[] to = new int[]{R.id.Objeto,R.id.Persona, R.id.Descripcion, R.id.Fecha, R.id.Status};

        adapter = new SimpleCursorAdapter(this, R.layout.item, c, from, to);

        list.setAdapter(adapter);
    }


    public void detalle(View view){
        TextView persona = (TextView) view.findViewById(R.id.Persona);
        nom = persona.getText().toString();
        TextView Objeto = (TextView) view.findViewById(R.id.Objeto);
        ob = persona.getText().toString();

        Intent i = new Intent(Consulta.this, Item.class);
        startActivity(i);
    }

}

