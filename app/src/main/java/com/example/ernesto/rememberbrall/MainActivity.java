package com.example.ernesto.rememberbrall;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toast toast;
    BDHandler bd = new BDHandler(this);
    SQLiteDatabase db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventana_principal);
    }


   /* public void lanzar() {
        //Crear un nuevo intent
        Intent intent = new Intent(this,Ventana_principal.class);
        //Iniciar actividad
        startActivity(intent);
    }*/


}
