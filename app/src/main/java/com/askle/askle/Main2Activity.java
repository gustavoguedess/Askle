package com.askle.askle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {
    Button btPerfilCons, btSairCons, btSolicCons, btConfigCons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btPerfilCons = (Button) findViewById(R.id.btPerfilCons);
        btSairCons = (Button) findViewById(R.id.btSairCons);
        btSolicCons = (Button) findViewById(R.id.btSolicCons);
        btConfigCons = (Button) findViewById(R.id.btConfCons);

        btPerfilCons.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Main2Activity.this, TelaPerfilCons.class);
                startActivity(it);
                //finishAffinity();
            }
        });

        btSairCons.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
        btSolicCons.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Main2Activity.this, TelaSolicitacoesClinica.class);
                startActivity(it);
                //finishAffinity();
            }
        });
        btConfigCons.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Main2Activity.this, TelaConfigClinica.class);
                startActivity(it);
                //finishAffinity();
            }
        });
        btSairCons.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent it = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(it);
                //finishAffinity();
            }
        });

    }
}
