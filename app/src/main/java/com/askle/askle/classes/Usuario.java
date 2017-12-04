package com.askle.askle.classes;

import android.media.Image;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

/**
 * Created by ismae on 23/11/2017.
 */

public class Usuario {
    String nome;
    String senha;
    String email;
    String numTel;
    String cpf;
    String endereco;
    String id;
    static int proxId;

    public DatabaseReference databaseReference;


    public Usuario(String nome, String senha, String email) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        id=UUID.randomUUID().toString();
    }

    public Usuario(String nome, String senha, String email, String numTel, String cpf, String endereco) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.numTel = numTel;
        this.cpf = cpf;
        this.endereco = endereco;
        id=UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}


