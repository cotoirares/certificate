package com.example.mate_info_atestat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import java.util.concurrent.ThreadLocalRandom;

import java.io.File;

public class Practice extends AppCompatActivity {

    private TextView nota;
    private ImageView intrebare;
    private AppCompatButton variantaA, variantaB, variantaC, variantaD, quit;
    private int numarIntrebare = 0;
    private float notaDinamic = 1;
    private String raspCorect;
    private StorageReference storageReference;
    private Firebase grilaRef, variantaAref, variantaBref, variantaCref, variantaDref, raspCorectref;
    public boolean usedQuestions[]={false, false, false, false, false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        Firebase.setAndroidContext(this);

        intrebare = (ImageView)  findViewById(R.id.intrebare);

        variantaA = (AppCompatButton) findViewById(R.id.choice1);
        variantaB = (AppCompatButton) findViewById(R.id.choice2);
        variantaC = (AppCompatButton)  findViewById(R.id.choice3);
        variantaD = (AppCompatButton)  findViewById(R.id.choice4);
        quit = (AppCompatButton) findViewById(R.id.quit);
        updateQ();
        //Varianta A
        variantaA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variantaA.getText().equals(raspCorect)) {
                    Toast.makeText(Practice.this, "Raspuns Corect!", Toast.LENGTH_SHORT).show();
                    updateQ();
                }
                else {
                    Toast.makeText(Practice.this, "Raspuns Gresit. Încearcă din nou", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Varianta B
        variantaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variantaB.getText().equals(raspCorect)) {
                    Toast.makeText(Practice.this, "Raspuns Corect!", Toast.LENGTH_SHORT).show();
                    updateQ();
                }
                else {
                    Toast.makeText(Practice.this, "Raspuns Gresit. Încearcă din nou", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Varianta C
        variantaC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variantaC.getText().equals(raspCorect)) {
                    Toast.makeText(Practice.this, "Raspuns Corect!", Toast.LENGTH_SHORT).show();
                    updateQ();
                }
                else {
                    Toast.makeText(Practice.this, "Raspuns Gresit. Încearcă din nou", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Varianta D
        variantaD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variantaD.getText().equals(raspCorect)) {
                    Toast.makeText(Practice.this, "Raspuns Corect!", Toast.LENGTH_SHORT).show();
                    updateQ();
                }
                else {
                    Toast.makeText(Practice.this, "Raspuns Gresit. Încearcă din nou", Toast.LENGTH_SHORT).show();
                }
            }
        });
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Practice.this, Dashboard.class);
                startActivity(intent);
            }
        });
    }

    private void updateQ(){
        numarIntrebare = ThreadLocalRandom.current().nextInt(0, 7);
        while (usedQuestions[numarIntrebare] != false)
            numarIntrebare = ThreadLocalRandom.current().nextInt(0, 7);
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
    }
}