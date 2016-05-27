package com.example.ernesto.rememberbrall;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ernesto on 21/05/16.
 */
public class Detalle extends AppCompatActivity {
    Cursor c;
    ListView list;
    DbManager db;
    SimpleCursorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle);
        db = new DbManager(this);
        llenar();
    }
    private void llenar() {
        list = (ListView) findViewById(R.id.item);
        c=db.leerRegistros(Consulta.nom);
        String[] from = new String[]{db.NombrePersona, db.Objeto, db.Descripcion, db.Fecha, db.Status};
        int[] to = new int[]{R.id.Persona, R.id.Objeto, R.id.Descripcion, R.id.Fecha, R.id.Status};
        adapter = new SimpleCursorAdapter(this, R.layout.item, c, from, to);
        list.setAdapter(adapter);
    }

    public void entregado(View view){
        db.eliminar(c.getString(0));
        Toast.makeText(this, "Se ha eliminado el registro!", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(Detalle.this, Consulta.class);
        startActivity(i);
    }

}