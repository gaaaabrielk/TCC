package com.example.meuifeventos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class calendar_activity extends AppCompatActivity {

    private int anoAtual = 0;
    private int mesAtual = 0;
    private int diaAtual = 0;

    private int Salvos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calendar);

        CalendarView calendarView = findViewById(R.id.calendarView);


        List<String> textoCalendario = new ArrayList<>();
        final int numeroDias = 2000;
        final int[] diaS = new int[numeroDias];
        final int[] mesS = new int[numeroDias];
        final int[] anoS = new int[numeroDias];


        final EditText NomeEvento = findViewById(R.id.NomeEvento);
        final View conteudoDia = findViewById(R.id.conteudoDia);



        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int ano, int mes, int dia) {
                anoAtual = ano;
                mesAtual = mes;
                diaAtual = dia;
                if(conteudoDia.getVisibility() == View.GONE){
                    conteudoDia.setVisibility(View.VISIBLE);
                }
                for(int y = 0; y < Salvos; y++) {
                    if(anoS[y] == anoAtual){
                        for(int i = 0; i < Salvos; i++) {
                            if (diaS[i] == diaAtual) {
                                for (int j = 0; j < Salvos; j++) {
                                    if (mesS[j] == mesAtual && anoS[j] == anoAtual && diaS[j] == diaAtual) {
                                        NomeEvento.setText(textoCalendario.get(j));
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
                NomeEvento.setText("");


            }
        });

        final Button SalvarEventoButton = findViewById(R.id.SalvarEvento);

        SalvarEventoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diaS[Salvos] = diaAtual;
                mesS[Salvos] = mesAtual;
                anoS[Salvos] = anoAtual;
                textoCalendario.add(Salvos, NomeEvento.getText().toString());
                NomeEvento.setText("");
                Salvos++;
                conteudoDia.setVisibility(View.GONE);



            }
        });

        final Button VoltarHoje = findViewById(R.id.Hoje);

        VoltarHoje.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calendarView.setDate(calendarView.getDate());

            }
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });





    }
}