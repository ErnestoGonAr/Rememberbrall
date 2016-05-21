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

<<<<<<< HEAD
=======
    EditText txtUsuario;
    EditText txtContraseña;
    Button btnSend;
    Toast toast1;
    BDHandler bd = new BDHandler(this);
    SQLiteDatabase db;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        txtUsuario = (EditText) findViewById(R.id.cb1);
        txtContraseña = (EditText) findViewById(R.id.cb2);
        final Button boton1 = (Button) findViewById(R.id.button);

        boton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!validar()) {
                    toast1 = Toast.makeText(getApplicationContext(), "no se pudo ingresar", Toast.LENGTH_SHORT);
                    toast1.show();
                }
                else{lanzar();}

            }

        });

    }

    private boolean validar(){
        if(txtUsuario.getText().length()==0 || txtContraseña.getText().length()==0)return false;
        db = bd.getReadableDatabase();
        c = bd.getUsuarios(db);



        return true;
    }

    public void lanzar() {
        //Crear un nuevo intent
        Intent intent = new Intent(this,Ventana_principal.class);
        //Iniciar actividad
        startActivity(intent);
    }

>>>>>>> d802310e266b5f63548accb1fb7c5e8e82e60e23
}
