package com.example.ernesto.rememberbrall;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    DbManager db;
    Cursor c;
    private ImageButton pres;
    private ImageButton consul;
    private TextView r;
    String[] random = {"Follow your Dreams", "Do you even read this?","Have a nice day smile emoticon",
            "Fijate y Fijate bien", "No te preocupes, ocupate"
            ,"Eso por que? No mas?","Las ratas no pueden vomitar",
            "Hace un billon de años los dias duraban 18 horas","Hexakoisiohexekontahexefobia miedo al 666"
            ,"El músculo más potente del cuerpo humano es la lengua.","Los delfines duermen con un ojo abierto.",
            "Los toros son daltónicos","Los osos polares son zurdos.","Las hormigas no duermen.",
            "Las estrellas de mar no tienen cerebro","Los cocodrilos no pueden sacar la lengua",
            "La panofobia es el miedo a todo.","Un pulpo tiene 3 corazones.",
            "Los leones pueden tener sexo hasta 50 veces por día.","La vida necesita un +1"};


    Random s =new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventana_principal);

        db = new DbManager(this);
        c= db.leerRegistros();
        inicializando();
        randomThis();

        pres.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
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
        pres = (ImageButton) findViewById(R.id.Np);
        consul = (ImageButton) findViewById(R.id.btn_consultar);
        r = (TextView) findViewById(R.id.Random);
        }

    private void randomThis(){
        r.setText(pickItem());
    }

    private String pickItem(){
        return random[s.nextInt(random.length)];
    }

}




