package com.example.mate_info_atestat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Dashboard extends AppCompatActivity {

    ImageView logofaq, logocontact, logodoc, logoteste, logoantrenament;
    TextView textfaq, textcontact, textdoc, textteste, textantrenament;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);

        logocontact = (ImageView) findViewById(R.id.ic_support);
        textcontact = (TextView) findViewById(R.id.textView8);
        logodoc = (ImageView) findViewById(R.id.ic_documentatie);
        textdoc = (TextView) findViewById(R.id.textView7);
        logoteste = (ImageView) findViewById(R.id.logoteste);
        textteste = (TextView) findViewById(R.id.textView4);
        logoantrenament = (ImageView) findViewById(R.id.ic_antrenament);
        textantrenament = (TextView) findViewById(R.id.textView5);


        logocontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, ContactAdmin.class);
                startActivity(intent);
            }
        });

        textcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, ContactAdmin.class);
                startActivity(intent);
            }
        });

        logodoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flipsnack.com/AE76A577C6F/atestat-rare-cotoi-aplica-ia-mate-info.html")));
            }
        });

        textdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.flipsnack.com/AE76A577C6F/atestat-rare-cotoi-aplica-ia-mate-info.html")));
            }
        });
        logoteste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, ExamLobby.class);
                startActivity(intent);
            }
        });
        textteste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, ExamLobby.class);
                startActivity(intent);
            }
        });
        logoantrenament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Practice.class);
                startActivity(intent);
            }
        });
        textantrenament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Practice.class);
                startActivity(intent);
            }
        });
    }
}