package com.example.mate_info_atestat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SfarsitExamen extends AppCompatActivity {
    private TextView nota;
    private AppCompatButton inapoi;
    private float value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sfarsit_examen);

        nota = (TextView) findViewById(R.id.nota);
        Bundle extras = getIntent().getExtras();
        if (extras!= null)
            value = extras.getFloat("nota");
        nota.setText(""+value);
        inapoi = (AppCompatButton) findViewById(R.id.iesi);

        inapoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SfarsitExamen.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }
}