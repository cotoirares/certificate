package com.example.mate_info_atestat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Inregistrare extends AppCompatActivity {
    TextInputEditText emailInput, parolaInput, cfParola, numeInput;
    Button haveAcc, inreg;
    String EmailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inregistrare);
        haveAcc = findViewById(R.id.haveacc);
        inreg = findViewById(R.id.inreg);
        numeInput = findViewById(R.id.numeFull);
        parolaInput = findViewById(R.id.parola);
        emailInput = findViewById(R.id.mail);
        cfParola = findViewById(R.id.confirmaparola);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        haveAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Inregistrare.this, Login.class);
                startActivity(intent);
            }
        });

        inreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerformAuth();
            }
        });
    }

    private void PerformAuth() {
        String email = emailInput.getText().toString();
        String parola = parolaInput.getText().toString();
        String confirmaParola = cfParola.getText().toString();
        if (!email.matches(EmailPattern)){
            emailInput.setError("Adresa de email nu este corectă");
        }
        else if (parola.isEmpty() || parola.length()<8){
            parolaInput.setError("Introduceți o parolă mai puternică (minim 8 caractere)");
        }
        else if (!parola.equals(confirmaParola)){
            cfParola.setError("Cele două parole nu corespund");
        }
        else{
            progressDialog.setMessage("Înregistrarea se efectuează...");
            progressDialog.setTitle("Înregistrare");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email, parola).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();
                        nextactivity();
                        Toast.makeText(Inregistrare.this, "Înregistrare realizată cu succes", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        progressDialog.dismiss();
                        Toast.makeText(Inregistrare.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void nextactivity() {
        Intent intent = new Intent(Inregistrare.this, Dashboard.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}