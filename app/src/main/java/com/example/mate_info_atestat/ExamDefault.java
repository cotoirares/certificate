package com.example.mate_info_atestat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class ExamDefault extends AppCompatActivity {

    private TextView leftQ, leftTime;
    private ImageView intrebare;
    private AppCompatButton variantaA, variantaB, variantaC, variantaD;
    private int numarIntrebare = 0, intrebariParcurse = 0;
    private float notaDinamic = 1;
    private String raspCorect;
    public boolean usedQuestions[]={false, false, false, false, false};
    private StorageReference storageReference;
    private Firebase grilaRef, variantaAref, variantaBref, variantaCref, variantaDref, raspCorectref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_default);
        Firebase.setAndroidContext(this);

        intrebare = (ImageView)  findViewById(R.id.intrebare);
        leftQ = (TextView) findViewById(R.id.leftQ);
        leftTime = (TextView) findViewById(R.id.timeleft);
        variantaA = (AppCompatButton) findViewById(R.id.choice1);
        variantaB = (AppCompatButton) findViewById(R.id.choice2);
        variantaC = (AppCompatButton)  findViewById(R.id.choice3);
        variantaD = (AppCompatButton)  findViewById(R.id.choice4);
        new CountDownTimer (10800000, 1000){
            public void onTick(long milisUntilFinished){
                leftTime.setText("Timp rămas: "+(milisUntilFinished/(1000*60*60))%24+" ore, "+(milisUntilFinished/60000)%60+"minute");
            }
            public void onFinish(){
                sfarsitTest();
            }
        }.start();
        updateQ();
        //Varianta A
        variantaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variantaA.getText().equals(raspCorect)) {
                    notaDinamic += 0.375;
                    updateQ();
                }
                else updateQ();
            }
        });

        //Varianta B
        variantaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variantaB.getText().equals(raspCorect)) {
                    notaDinamic += 0.375;
                    updateQ();
                }
                else updateQ();
            }
        });

        //Varianta C
        variantaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variantaC.getText().equals(raspCorect)) {
                    notaDinamic += 0.375;
                    updateQ();
                }
                else updateQ();
            }
        });

        //Varianta D
        variantaD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variantaD.getText().equals(raspCorect)) {
                    notaDinamic += 0.375;
                    updateQ();
                }
                else updateQ();
            }
        });
    }

    private void updateQ(){
        leftQ.setText(""+ (24-intrebariParcurse));
        numarIntrebare = ThreadLocalRandom.current().nextInt(0, 7);
        while (usedQuestions[numarIntrebare] != false) {
            boolean ok = true;
            for (int i=0;i<7;++i) {
                if (usedQuestions[numarIntrebare] == false)
                    ok = false;
            }
            if (ok == false)
                numarIntrebare = ThreadLocalRandom.current().nextInt(0, 5);
            else sfarsitTest();
        }
        usedQuestions[numarIntrebare] = true;
        grilaRef = new Firebase("https://mateinfo-atestat-default-rtdb.europe-west1.firebasedatabase.app/"+ numarIntrebare +"/enunt");
        grilaRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /*String intr = dataSnapshot.getValue(String.class);
                intrebare.setText(intr);*/
                String imageurl = dataSnapshot.getValue(String.class);
                Glide.with(getApplicationContext())
                        .load(imageurl)
                        .into(intrebare);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        variantaAref = new Firebase("https://mateinfo-atestat-default-rtdb.europe-west1.firebasedatabase.app/"+ numarIntrebare +"/a");
        variantaAref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String var = dataSnapshot.getValue(String.class);
                variantaA.setText(var);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        variantaBref = new Firebase("https://mateinfo-atestat-default-rtdb.europe-west1.firebasedatabase.app/"+ numarIntrebare +"/b");
        variantaBref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String var = dataSnapshot.getValue(String.class);
                variantaB.setText(var);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        variantaCref = new Firebase("https://mateinfo-atestat-default-rtdb.europe-west1.firebasedatabase.app/"+ numarIntrebare +"/c");
        variantaCref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String var = dataSnapshot.getValue(String.class);
                variantaC.setText(var);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });

        variantaDref = new Firebase("https://mateinfo-atestat-default-rtdb.europe-west1.firebasedatabase.app/"+ numarIntrebare +"/d");
        variantaDref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String var = dataSnapshot.getValue(String.class);
                variantaD.setText(var);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
        raspCorectref = new Firebase("https://mateinfo-atestat-default-rtdb.europe-west1.firebasedatabase.app/"+ numarIntrebare +"/corect");
        raspCorectref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                raspCorect = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        intrebariParcurse++;
    }

    private void sfarsitTest() {
        Intent intent = new Intent(ExamDefault.this, SfarsitExamen.class);
        intent.putExtra("nota", notaDinamic);
        startActivity(intent);
    }
}