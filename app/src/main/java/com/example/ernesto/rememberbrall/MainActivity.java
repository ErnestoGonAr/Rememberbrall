package com.example.ernesto.rememberbrall;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toast toast;
    DbManager db;
    Cursor c;
    SimpleCursorAdapter adapter;
    private ListView list;
    private Button pres;
    private Button consul;
    private Button verto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventana_principal);

        db = new DbManager(this);

        c= db.leerRegistros();

        inicializando();

        pres.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, Prestamo.class);
                startActivity(i);
            }
        });
        consul.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, Consulta.class);
                startActivity(i);
            }
        });


    }

    public void inicializando(){
        pres = (Button) findViewById(R.id.Np);
        consul = (Button) findViewById(R.id.btn_consultar);
        verto = (Button) findViewById(R.id.Con);
    }


}