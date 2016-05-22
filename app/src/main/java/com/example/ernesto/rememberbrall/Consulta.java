package com.example.ernesto.rememberbrall;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

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

        String[] from = new String[]{db.NombrePersona, db.Objeto, db.Descripcion, db.Fecha, db.Status};

        int[] to = new int[]{R.id.Persona, R.id.Objeto, R.id.Descripcion, R.id.Fecha, R.id.Status};

        adapter = new SimpleCursorAdapter(this, R.layout.item, c, from, to);

        list.setAdapter(adapter);
    }
}
