package com.example.ernesto.rememberbrall;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

//import static com.example.ernesto.rememberbrall.R.layout.Prestamo;

/**
 * Created by ernesto on 20/05/16.
 */
public class Prestamo extends Activity implements OnClickListener {
    private BaseDatos db;

    private EditText fromDateEtxt;
    private EditText toDateEtxt;
    private EditText nombret;
    private EditText prot;
    private EditText cart;
    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;

    private SimpleDateFormat dateFormatter;
    private Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prestamo);

        dateFormatter = new SimpleDateFormat("yyyy-MM-DD", Locale.US);

        findViewsById();

        setDateTimeField();
    }


    @Override
    public void onClick(View v) {

        if(v == toDateEtxt) {
            toDatePickerDialog.show();
        }
    }

    private void findViewsById() {

        toDateEtxt = (EditText) findViewById(R.id.etxt_todate);
        //toDateEtxt.setInputType(InputType.TYPE_NULL);

        nombret = (EditText) findViewById(R.id.n);
        prot = (EditText) findViewById(R.id.p);
        cart = (EditText) findViewById(R.id.c);

    }

    private void setDateTimeField() {
        toDateEtxt.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        toDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                toDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private boolean validar(){
        toast.setText(nombret.getText());
        toast.show();
        if(nombret.getText().toString().length()!=0 && cart.getText().toString().length()!=0 && prot.getText().toString().length()!=0)return true;
        return false;
    }

    public void insertar(View view){

        toast=Toast.makeText(getApplicationContext(),"TU CULO", Toast.LENGTH_LONG);
        toast.show();

        /*ContentValues nuevoRegistro = new ContentValues();
        nuevoRegistro.put("NombrePersona",nombret.getText().toString());
        nuevoRegistro.put("NombreObjeto",prot.getText().toString());
        nuevoRegistro.put("DescripcionObjeto",cart.getText().toString());
        nuevoRegistro.put("FechaD",toDateEtxt.getText().toString());
        nuevoRegistro.put("Status","NO ENTREGADO");*/

        String[] data= {nombret.getText().toString(),
                prot.getText().toString(),
                cart.getText().toString(),
                prot.getText().toString(),
                cart.getText().toString(),
                toDateEtxt.getText().toString(),
                "NO ENTREGADO"};

        db.insertarP(data);

    }


}
