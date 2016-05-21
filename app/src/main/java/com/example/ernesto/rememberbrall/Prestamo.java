package com.example.ernesto.rememberbrall;

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
import android.widget.DatePicker;
import android.widget.EditText;

//import static com.example.ernesto.rememberbrall.R.layout.Prestamo;

/**
 * Created by ernesto on 20/05/16.
 */
public class Prestamo extends Activity implements OnClickListener {
    private EditText fromDateEtxt;
    private EditText toDateEtxt;
    private EditText nombret;
    private EditText prot;
    private EditText cart;
    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;

    private SimpleDateFormat dateFormatter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prestamo);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        findViewsById();

        setDateTimeField();

        nombret.setOnKeyListener(new View.OnKeyListener(){
            public boolean onKey(View v, int keyCode, KeyEvent event){
                if(keyCode == KeyEvent.KEYCODE_ENTER){
                    prot.requestFocus();
                    return true;
                }
                return false;
            }
        });

        prot.setOnKeyListener(new View.OnKeyListener(){
            public boolean onKey(View v, int keyCode, KeyEvent event){
                if(keyCode == KeyEvent.KEYCODE_ENTER){
                    cart.requestFocus();
                    return true;
                }
                return false;
            }
        });

        cart.setOnKeyListener(new View.OnKeyListener(){
            public boolean onKey(View v, int keyCode, KeyEvent event){
                if(keyCode == KeyEvent.KEYCODE_ENTER){
                    cart.clearFocus();
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onClick(View v) {

        if(v == fromDateEtxt) {
            fromDatePickerDialog.show();
        } else if(v == toDateEtxt) {
            toDatePickerDialog.show();
        }
    }

    private void findViewsById() {
        fromDateEtxt = (EditText) findViewById(R.id.etxt_fromdate);
        fromDateEtxt.setInputType(InputType.TYPE_NULL);
        fromDateEtxt.requestFocus();

        toDateEtxt = (EditText) findViewById(R.id.etxt_todate);
        toDateEtxt.setInputType(InputType.TYPE_NULL);

        nombret = (EditText) findViewById(R.id.editText);
        prot = (EditText) findViewById(R.id.p);
        cart = (EditText) findViewById(R.id.c);

    }

    private void setDateTimeField() {
        fromDateEtxt.setOnClickListener(this);
        toDateEtxt.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(this, new OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                toDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

}
