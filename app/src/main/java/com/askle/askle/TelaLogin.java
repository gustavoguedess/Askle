package com.askle.askle;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.askle.askle.classes.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class TelaLogin extends AppCompatActivity {
    Button btLog;
    EditText logUs;
    EditText passUs;
    Button btNovaConta, btEsqueciSenha;

    FirebaseAuth autenticador;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        //parte pra pegar o objeto usuario do MainActivity
        Bundle extras = getIntent().getExtras();
        Usuario usuario = null;
        //if(extras != null && extras.contains("usuario")){
          //  usuario = (Usuario) extras.getSerializable("usuario");
        //}

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("");     //Titulo para ser exibido na sua Action Bar em frente à seta

        btLog = (Button) findViewById(R.id.btEntrar);
        logUs = (EditText) findViewById(R.id.txtLog);
        passUs = (EditText) findViewById(R.id.txtPass);
        btEsqueciSenha = (Button) findViewById(R.id.btEsqueciSenha);
        btNovaConta = (Button) findViewById(R.id.btCadastre);
        autenticador = FirebaseAuth.getInstance();

        btLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = logUs.getText().toString();
                String senha = passUs.getText().toString();
                autenticador.signInWithEmailAndPassword(email, senha)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                finish();
                                Intent it = new Intent(TelaLogin.this, MainActivity.class);
                                startActivity(it);
                            }
                        }
                    });

            }
        });

        btNovaConta.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent it = new Intent(TelaLogin.this, TelaRegistro.class);
                startActivity(it);

            }
        });

        btEsqueciSenha.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent it = new Intent(TelaLogin.this, TelaEsqueciSenha.class);
                startActivity(it);

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
