package com.example.ernesto.rememberbrall;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by ernesto on 21/05/16.
 */
public class Consultatodo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consultatodo);
    }

    ListView lista = (ListView) findViewById(R.id.Lista);
    ArrayList<String> list = new ArrayList<String>();
    list.add("Nothis");

}
