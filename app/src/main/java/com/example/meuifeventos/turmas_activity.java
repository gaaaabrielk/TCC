package com.example.meuifeventos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class turmas_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_turmas);

        Button priInf = findViewById(R.id.btnPriInf);
        Button segInf = findViewById(R.id.btnSegInf);


        priInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(turmas_activity.this, calendar_activity.class);
                startActivity(intent);

            }

            });


        segInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(turmas_activity.this, calendar_activity.class);
                startActivity(intent);

            }

        });

    }
}