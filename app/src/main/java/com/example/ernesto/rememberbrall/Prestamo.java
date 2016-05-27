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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.ernesto.rememberbrall.R.layout.prestamo;

/**
 * Created by ernesto on 20/05/16.
 */
public class Prestamo extends Activity implements OnClickListener {

    public DbManager bd;
    public EditText toDateEtxt;
    public EditText nombret;
    public EditText prot;
    public EditText cart;
    public DatePickerDialog toDatePickerDialog;
    public SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prestamo);
        bd = new DbManager(this);
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
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
        nombret = (EditText) findViewById(R.id.n);
        prot = (EditText) findViewById(R.id.p);
        cart = (EditText) findViewById(R.id.c);
        toDateEtxt = (EditText) findViewById(R.id.etxt_todate);
        toDateEtxt.setInputType(InputType.TYPE_NULL);

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


    public boolean validaVacio(){
        String  campo=((TextView)findViewById(R.id.c)).getText().toString();
        String  campo2=((TextView)findViewById(R.id.n)).getText().toString();
        String  campo3=((TextView)findViewById(R.id.p)).getText().toString();
        String  campo4=((TextView)findViewById(R.id.etxt_todate)).getText().toString();
        if (campo.equals("")|| campo2.equals("")|| campo3.equals("") || campo4.equals("")){
            Toast.makeText(this, "Ha dejado campos vacios",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        return true;

    }

    public void insertar(View view){
        if(validaVacio()){
            String[] data= new String[5];
            data[0]=nombret.getText().toString();
            data[1]=prot.getText().toString();
            data[2]=cart.getText().toString();
            data[3]=toDateEtxt.getText().toString();
            data[4]="NO ENTREGADO";
            bd.insertar(data);
            Toast.makeText(this, "Se ha insertado prestamo!!",
                    Toast.LENGTH_LONG).show();
            clean();
        }
    }

    private void clean(){
        nombret.setText("");
        prot.setText("");
        cart.setText("");
        toDateEtxt.setText("Devolucion");
    }


}
