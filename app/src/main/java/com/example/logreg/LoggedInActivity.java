package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoggedInActivity extends AppCompatActivity {

    Button btnVisza;
    TextView tvMegjelenit;
    DBhelper adatbazis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        init();


        btnVisza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent Kijelentkezes = new Intent(LoggedInActivity.this,MainActivity.class);
                startActivity(Kijelentkezes);
                finish();
            }
        });
    }

    private  void adatLekerdezes(){
        Cursor adatok = adatbazis.adatLekerdezes();
        if (adatok == null){
            Toast.makeText(this,"Sikertelen lekérdezés !!!",Toast.LENGTH_SHORT).show();
        }if (adatok.getCount()==0){
            Toast.makeText(this," Még nincs adat !!!",Toast.LENGTH_SHORT).show();
        }

        StringBuilder sb = new StringBuilder();
        while (adatok.moveToNext()) {

            sb.append("TELJES NEV: ").append(adatok.getInt(0)).append("\n");
        }

        tvMegjelenit.setText(sb.toString());
    }

    private void init() {

        btnVisza = findViewById(R.id.btn_loggedin_Kijelent);
        tvMegjelenit = findViewById(R.id.tv_loggedin_nevMegjelenit);
        tvMegjelenit.setMovementMethod(new ScrollingMovementMethod());
        adatbazis = new DBhelper(LoggedInActivity.this);
    }
}