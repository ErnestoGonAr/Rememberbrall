package com.example.ernesto.rememberbrall;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ernesto on 21/05/16.
 */
public class Item extends AppCompatActivity {

    Cursor c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalle);

        DbManager db = new DbManager(this);
        c = db.leerRegistros(Consulta.nom,Consulta.ob);
        llenar();

    }

    private void llenar(){

    }

}
