package com.example.calendar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.health.connect.datatypes.ActiveCaloriesBurnedRecord;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {



    final List<String> textoCalendario = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView verCalendario = findViewById(R.id.verCalendario);


        verCalendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int ano, int mes, int dia) {
                view.getDate();

            }
        });



        final Button salvar = findViewById(R.id.salvar);
        final EditText addEvento = findViewById(R.id.addEvento);


        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textoCalendario.add(String.valueOf(verCalendario.getDate()));
                textoCalendario.add(addEvento.getText().toString());
                addEvento.setText("");







            }
        });















    }
}