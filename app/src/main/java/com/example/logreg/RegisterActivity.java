package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText etFelhasznalonev,etEmail,etJelszo,etTeljesnev;
    Button btnVissza,btnRegisztracio;
    DBhelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        btnVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent vissza = new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });


        btnRegisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }



    private void init() {

        btnVissza = findViewById(R.id.btn_rehist_vissza);
        btnRegisztracio = findViewById(R.id.btn_regist_regist);
        etEmail = findViewById(R.id.et_regist_email);
        etFelhasznalonev = findViewById(R.id.et_main_felhasznalonev);
        etJelszo = findViewById(R.id.et_main_jelszo);
        etTeljesnev = findViewById(R.id.et_regist_teljesnev);
        adatbazis = new DBhelper(RegisterActivity.this);
    }
}