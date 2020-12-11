package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity<DBhelper> extends AppCompatActivity {

    Button btnBejelentkezes,btnRegisztracio;
    EditText felhasznalonev,jelszo;
    DBhelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnRegisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regiszt = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(regiszt);
                finish();
            }
        });

        btnBejelentkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String felhasznalon =felhasznalonev.getText().toString().trim();
                String jelszoo =jelszo.getText().toString().trim();

                if (felhasznalon.isEmpty()) {
                    Toast.makeText(this,"Felhasznalonév megadása kötelető !!!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (jelszoo.isEmpty()) {
                    Toast.makeText(this,"Jelszó megadása kötelető !!!",Toast.LENGTH_SHORT).show();
                    return;
                }

            }
        });

    }

    private void init() {

        btnBejelentkezes = findViewById(R.id.btn_main_bejelentkezes);
        btnRegisztracio = findViewById(R.id.btn_main_reg);
        felhasznalonev = findViewById(R.id.et_main_felhasznalonev);
        jelszo = findViewById(R.id.et_main_jelszo);
        adatbazis = new DBhelper(MainActivity.this);


    }
}