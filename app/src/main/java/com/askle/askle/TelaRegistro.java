package com.askle.askle;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
import com.google.firebase.database.FirebaseDatabase;

public class TelaRegistro extends AppCompatActivity {

    Button btRegistro, btTermos;
    FirebaseAuth autenticacao;
    Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_registro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("");     //Titulo para ser exibido na sua Action Bar em frente à seta

        btRegistro = (Button) findViewById(R.id.btRegistrar);
        btTermos = (Button) findViewById(R.id.btTermosReg);

        autenticacao = FirebaseAuth.getInstance();



        btTermos.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent(TelaRegistro.this, TelaTermos.class);
                startActivity(intent);
            }
        });

        btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtNome = (EditText) findViewById(R.id.txtNomeReg);
                EditText edtSobrenome = (EditText) findViewById(R.id.txtSobrenomeReg);
                EditText edtEmail = (EditText) findViewById(R.id.txtEmail);
                EditText edtSenha= (EditText) findViewById(R.id.txtSenhaReg);
                EditText edtConfirmarSenha= (EditText) findViewById(R.id.txtConfSenhaReg);

                usuario = new Usuario(edtNome.getText().toString(), edtSenha.getText().toString(), edtEmail.getText().toString());


                autenticacao.createUserWithEmailAndPassword(usuario.getEmail(), usuario.getSenha())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
                                        databaseReference.child("Usuarios").child(usuario.getId()).setValue(usuario);
                                        apagarComponentes();
                                        Toast.makeText(TelaRegistro.this, "Conta efetuada com sucesso.", Toast.LENGTH_LONG).show();
                                        finish();
                                    } else {
                                        Toast.makeText(TelaRegistro.this, "Algo deu errado. Tente novamente em breve...", Toast.LENGTH_LONG).show();
                                        Log.e("Erro", "onComplete: Failed=" + task.getException().getMessage());
                                    }
                                }
                            }) ;

            }
        });
    }
    public void apagarComponentes(){
        EditText edtNome = (EditText) findViewById(R.id.txtNomeReg);
        EditText edtSobrenome = (EditText) findViewById(R.id.txtSobrenomeReg);
        EditText edtEmail = (EditText) findViewById(R.id.txtEmail);
        EditText edtSenha= (EditText) findViewById(R.id.txtSenhaReg);
        EditText edtConfirmarSenha= (EditText) findViewById(R.id.txtConfSenhaReg);


        edtNome.setText("");
        edtSobrenome.setText("");
        edtEmail.setText("");
        edtSenha.setText("");
        edtConfirmarSenha.setText("");
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
