package com.askle.askle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaEscolhaInicial extends AppCompatActivity {
    Button btEscolha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_escolha_inicial);
        getSupportActionBar().hide();
        btEscolha = (Button) findViewById(R.id.btAreaCliente);

        btEscolha.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //codigo para exibir tela somente na primeira vez
                SharedPreferences settings = getSharedPreferences("PREFS_NAME", 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("PrefUsuario", "");
                //confirmar a gravação dos dados
                editor.commit();

                Intent it = new Intent(TelaEscolhaInicial.this, MainActivity.class);
                startActivity(it);
            }
        });
    }
}
