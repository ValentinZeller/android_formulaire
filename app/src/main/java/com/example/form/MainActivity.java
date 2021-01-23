package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    TextView textView = null;
    EditText editNom = null;
    EditText editPrenom = null;
    TextView email = null;
    RadioGroup genre = null;
    EditText editHeure = null;
    CheckBox java = null;
    CheckBox cplus = null;
    CheckBox javascript = null;
    Button raz = null;
    Button valider = null;
    Button random = null;
    ImageView img = null;

    final String EXTRA_USER = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Form);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(getString(R.string.app_name),"Application formulaire");

        textView = (TextView)findViewById(R.id.date);
        editNom = (EditText)findViewById(R.id.editNom);
        editPrenom = (EditText)findViewById(R.id.editPrenom);
        email = (TextView)findViewById(R.id.email);
        genre = (RadioGroup)findViewById(R.id.genre);
        editHeure = (EditText)findViewById(R.id.editTextNumber);
        java = (CheckBox)findViewById(R.id.java);
        cplus = (CheckBox)findViewById(R.id.cplus);
        javascript = (CheckBox)findViewById(R.id.javascript);
        raz = (Button)findViewById(R.id.raz);
        valider = (Button)findViewById(R.id.valider);
        random = (Button)findViewById(R.id.imgRandom);
        img = (ImageView)findViewById(R.id.imageView);

        //Date affichage jour/mois/année
        Date today = (Date) Calendar.getInstance().getTime();//getting date
        @SuppressLint("SimpleDateFormat") SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); // formating
        String date = formatter.format(today);
        textView.setText("Date actuelle : "+date);

        // Date systeme
        //textView.setText("Date actuelle : "+System.currentTimeMillis());

        random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color= ((int)(Math.random()*16777215)) | (0xFF << 24);
                img.setBackgroundColor(color);
            }
        });

        editNom.addTextChangedListener(this);
        editPrenom.addTextChangedListener(this);

        genre.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (group.getCheckedRadioButtonId() == R.id.radioButton) {
                    Toast.makeText(MainActivity.this, "Bonjour madame "+editNom.getText().toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Bonjour monsieur "+editNom.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        editHeure.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!editHeure.getText().toString().equals("")) {
                    int heure = Integer.parseInt(editHeure.getText().toString());
                    String msg = "";
                    int color = Color.BLACK;
                    if (heure <= 10) {
                        msg = "Correct";
                        color = getResources().getColor(R.color.green);
                        editHeure.setTextColor(getResources().getColor(R.color.green));
                    } else if (heure > 10 && heure < 20) {
                        msg = "Attention";
                        color = getResources().getColor(R.color.orange);
                        editHeure.setTextColor(getResources().getColor(R.color.orange));
                    } else {
                        msg = "Addict : faites attention au temps passé dans un jeu vidéo";
                        color = getResources().getColor(R.color.red);
                        editHeure.setTextColor(getResources().getColor(R.color.red));
                    }
                    Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT);
                    View view = toast.getView();
                    view.setBackgroundColor(Color.WHITE);

                    TextView text = view.findViewById(android.R.id.message);
                    text.setShadowLayer(0, 0, 0, Color.TRANSPARENT);
                    text.setTextColor(color);
                    toast.show();
                }
            }
        });

        editHeure.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus){
                    if (!editHeure.getText().toString().equals("")) {
                        int heure = Integer.parseInt(editHeure.getText().toString());
                        String msg = "";
                        int color = Color.BLACK;
                        if (heure <= 10) {
                            msg = "Correct";
                            color = getResources().getColor(R.color.green);
                            editHeure.setTextColor(getResources().getColor(R.color.green));
                        } else if (heure > 10 && heure < 20) {
                            msg = "Attention";
                            color = getResources().getColor(R.color.orange);
                            editHeure.setTextColor(getResources().getColor(R.color.orange));
                        } else {
                            msg = "Addict : faites attention au temps passé dans un jeu vidéo";
                            color = getResources().getColor(R.color.red);
                            editHeure.setTextColor(getResources().getColor(R.color.red));
                        }
                        Toast toast = Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT);
                        View view = toast.getView();
                        view.setBackgroundColor(Color.WHITE);

                        TextView text = view.findViewById(android.R.id.message);
                        text.setShadowLayer(0, 0, 0, Color.TRANSPARENT);
                        text.setTextColor(color);
                        toast.show();
                    }
                }
            }
        });

        raz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNom.setText("");
                editPrenom.setText("");
                email.setText("");
                genre.check(R.id.radioButton);
                editHeure.setText("");
                java.setChecked(false);
                cplus.setChecked(false);
                javascript.setChecked(false);
            }
        });

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = editNom.getText().toString();
                String prenom = editPrenom.getText().toString();
                String emailS = email.getText().toString();

                String prog = "";
                if (java.isChecked()) {
                    prog += "Java";
                }
                if (cplus.isChecked()) {
                    prog+= " C++";
                }
                if (javascript.isChecked()) {
                    prog+= " Javascript";
                }
                String g = "";
                if (genre.getCheckedRadioButtonId() == R.id.radioButton) {
                    g = "F";
                } else {
                    g = "H";
                }
                Log.i("VALIDATION","Nom : "+nom+"\nPrenom : "+prenom+"\nEmail : "+emailS+"\nGenre : "+g+"\nLangage de programation : "+prog+"\nHeure : "+editHeure.getText()
                );

                int heure = Integer.parseInt(editHeure.getText().toString());

                Intent intent = new Intent(MainActivity.this,Reception.class);
                User user = new User(nom,prenom,emailS,g,prog,heure);
                intent.putExtra(EXTRA_USER,user);
                startActivity(intent);
            }
        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (!editNom.getText().toString().isEmpty() && !editPrenom.getText().toString().isEmpty()) {
            String nom_mail = editNom.getText().charAt(0) + "." + editPrenom.getText().toString();
            email.setText(nom_mail.toLowerCase() + "@" + getResources().getString(R.string.ludus));
        }
    }
}