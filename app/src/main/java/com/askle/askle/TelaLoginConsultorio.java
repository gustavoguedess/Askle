package com.askle.askle;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.askle.askle.classes.Usuario;

public class TelaLoginConsultorio extends AppCompatActivity {

    Button btLogCons;
    EditText logCons;
    EditText passCons;
    Button btNovaConta, btEsqueciSenha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login_consultorio);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("");     //Titulo para ser exibido na sua Action Bar em frente à seta

        btLogCons = (Button)findViewById(R.id.btEntrarCons);
        btNovaConta = (Button) findViewById(R.id.btCadastreCons);
        btEsqueciSenha = (Button) findViewById(R.id.btEsqueciSenhaCons);
        btLogCons.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(TelaLoginConsultorio.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        btNovaConta.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(TelaLoginConsultorio.this, TelaCadastroClinica.class);
                startActivity(intent);
            }
        });
        btEsqueciSenha.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(TelaLoginConsultorio.this, TelaEsqueciSenha.class);
                startActivity(intent);
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

}
