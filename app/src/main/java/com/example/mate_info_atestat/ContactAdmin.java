package com.example.mate_info_atestat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;


public class ContactAdmin extends AppCompatActivity {
    TextInputEditText nume, mesaj;
    Button trimite;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_admin);

        nume = (TextInputEditText) findViewById(R.id.numeContact);
        mesaj = (TextInputEditText) findViewById(R.id.mesajContact);
        trimite = (Button) findViewById(R.id.sendbtn);

        trimite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (Intent.ACTION_SEND);
                intent.setType("message/html");
                intent.putExtra(Intent.EXTRA_EMAIL, new String ("rares_cotoi@cnmvturda.ro"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Întrebare privind aplicația Mate-Info");
                intent.putExtra(Intent.EXTRA_TEXT, "Nume: "+nume.getText()+"\n Mesaj: "+ mesaj.getText());
                try{
                    startActivity(Intent.createChooser(intent, "Selectează o adresă de email"));
                }
                catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(ContactAdmin.this, "Nu a fost selectată o adresă de email", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}