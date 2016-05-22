
package com.example.ernesto.rememberbrall;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;



/**
 * Created by Edgar on 21/05/16.
 */
public class Consulta extends Activity implements View.OnClickListener {

    DbManager db;
    Cursor c;
    SimpleCursorAdapter adapter;
    private ListView list;
    Button consulta;
    TextView textoNombre;
    Editable p;
    String q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta);

        inicializar();
        db = new DbManager(this);
        llenar();

        /*consulta.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                llenar2();
            }
        });*/


    }


    private void llenar2() {
        list = (ListView) findViewById(R.id.Lista);
        q=textoNombre.getText().toString();
        c = db.leerRegistros(q);

        String[] from = new String[]{db.NombrePersona, db.Objeto, db.Descripcion, db.Fecha, db.Status};

        int[] to = new int[]{R.id.Persona, R.id.Objeto, R.id.Descripcion, R.id.Fecha, R.id.Status};

        adapter = new SimpleCursorAdapter(this, R.layout.item, c, from, to);

        list.setAdapter(adapter);
    }
    private void llenar() {
        list = (ListView) findViewById(R.id.Lista);

        c = db.leerRegistros();

        String[] from = new String[]{db.NombrePersona, db.Objeto, db.Descripcion, db.Fecha, db.Status};

        int[] to = new int[]{R.id.Persona, R.id.Objeto, R.id.Descripcion, R.id.Fecha, R.id.Status};

        adapter = new SimpleCursorAdapter(this, R.layout.item, c, from, to);

        list.setAdapter(adapter);
    }
    public void inicializar(){
        Button consulta=(Button)findViewById(R.id.consultor);
        TextView textoNombre=(TextView) findViewById(R.id.name);
    }

    @Override
    public void onClick(View v) {
        llenar2();
    }
}

