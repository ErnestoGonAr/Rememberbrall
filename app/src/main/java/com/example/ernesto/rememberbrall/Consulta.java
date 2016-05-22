
package com.example.ernesto.rememberbrall;

import android.app.Activity;
<<<<<<< HEAD
import android.content.DialogInterface;
=======
import android.content.Context;
>>>>>>> 7252aeed4cd31cf133db748e27ccf757d8f31d63
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
import android.text.Editable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
=======
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
>>>>>>> 7252aeed4cd31cf133db748e27ccf757d8f31d63
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;



/**
 * Created by Edgar on 21/05/16.
 */
<<<<<<< HEAD
public class Consulta extends Activity implements View.OnClickListener {
=======
public class Consulta extends AppCompatActivity {
>>>>>>> 7252aeed4cd31cf133db748e27ccf757d8f31d63

    DbManager db;
    Cursor c;
    SimpleCursorAdapter adapter;
    private ListView list;
<<<<<<< HEAD
    Button consulta;
    TextView textoNombre;
    Editable p;
    String q;
=======
    public static String nom="";
    public static String ob="";

>>>>>>> 7252aeed4cd31cf133db748e27ccf757d8f31d63
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulta);

<<<<<<< HEAD
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
=======
        db = new DbManager(this);
        llenar();

    }

>>>>>>> 7252aeed4cd31cf133db748e27ccf757d8f31d63
    private void llenar() {
        list = (ListView) findViewById(R.id.Lista);

        c = db.leerRegistros();

<<<<<<< HEAD
        String[] from = new String[]{db.NombrePersona, db.Objeto, db.Descripcion, db.Fecha, db.Status};

        int[] to = new int[]{R.id.Persona, R.id.Objeto, R.id.Descripcion, R.id.Fecha, R.id.Status};
=======
        String[] from = new String[]{ db.Objeto,db.NombrePersona, db.Descripcion, db.Fecha, db.Status};

        int[] to = new int[]{R.id.Objeto,R.id.Persona, R.id.Descripcion, R.id.Fecha, R.id.Status};
>>>>>>> 7252aeed4cd31cf133db748e27ccf757d8f31d63

        adapter = new SimpleCursorAdapter(this, R.layout.item, c, from, to);

        list.setAdapter(adapter);
    }
<<<<<<< HEAD
    public void inicializar(){
        Button consulta=(Button)findViewById(R.id.consultor);
        TextView textoNombre=(TextView) findViewById(R.id.name);
    }

    @Override
    public void onClick(View v) {
        llenar2();
    }
=======


    public void detalle(View view){
        TextView persona = (TextView) view.findViewById(R.id.Persona);
        nom = persona.getText().toString();
        TextView Objeto = (TextView) view.findViewById(R.id.Objeto);
        ob = persona.getText().toString();

        Intent i = new Intent(Consulta.this, Item.class);
        startActivity(i);
    }

>>>>>>> 7252aeed4cd31cf133db748e27ccf757d8f31d63
}

