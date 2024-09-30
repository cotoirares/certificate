package com.example.mate_info_atestat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ExamLobby extends AppCompatActivity {
    AppCompatButton startTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_lobby);

        startTest = (AppCompatButton) findViewById(R.id.startbtn);

        startTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ExamLobby.this, ExamDefault.class);
                startActivity(intent);
            }
        });
    }
}