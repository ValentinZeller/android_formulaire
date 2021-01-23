package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Reception extends AppCompatActivity {

    TextView nom;
    TextView prenom;
    TextView email;
    TextView genre;
    TextView prog;
    TextView heure;

    final String EXTRA_USER = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Form);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reception);

        nom = (TextView)findViewById(R.id.nomTxt);
        prenom = (TextView)findViewById(R.id.prenomTxt);
        email = (TextView)findViewById(R.id.emailTxt);
        genre = (TextView)findViewById(R.id.genreTxt);
        prog = (TextView)findViewById(R.id.progTxt);
        heure = (TextView)findViewById(R.id.heureTxt);

        Intent intent = getIntent();
        User user = intent.getParcelableExtra(EXTRA_USER);

        nom.setText(user.getNom());
        prenom.setText(user.getPrenom());
        email.setText(user.getEmail());
        genre.setText(user.getGenre());
        prog.setText(user.getProg());
        heure.setText(String.valueOf(user.getHeure()));

    }
}