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
    private Button pres;
    private Button consul;
    private Button verto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventana_principal);

        inicializando();

        pres.setOnClickListener(new View.OnClickListener(){
            @Override
              public void onClick(View v){
                setContentView(R.layout.prestamo);
                Intent i = new Intent(MainActivity.this, Prestamo.class);
                startActivity(i);

            }
        });
    }




    public void inicializando(){
        pres = (Button) findViewById(R.id.Np);
        consul = (Button) findViewById(R.id.btn_consultar);
        verto = (Button) findViewById(R.id.Con);
    }
   /* public void lanzar() {
        //Crear un nuevo intent
        Intent intent = new Intent(this,Ventana_principal.class);
        //Iniciar actividad
        startActivity(intent);
    }*/


}
