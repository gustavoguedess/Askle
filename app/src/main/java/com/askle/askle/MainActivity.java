package com.askle.askle;


import android.app.DownloadManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.internal.NavigationMenuItemView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView.*;
import android.widget.TextView;

import com.askle.askle.classes.*;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.auth.FirebaseAuth;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

    static Usuario usuario;
    private FragmentManager fragmentManager;
    Button btPerfil;
    Button btLogin;
    //responsavel por gerenciar fragmentos da aplicação

    FirebaseAuth autenticador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autenticador = FirebaseAuth.getInstance();

        if(autenticador.getCurrentUser() != null){
            String apresentacao = "Olá, " + autenticador.getCurrentUser().getEmail() + ".";
            NavigationView NavView = (NavigationView) findViewById(R.id.nav_view);

        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.conteiner, new MapsFragment(), "MapsFragment");

        transaction.commitAllowingStateLoss();

        //NAO FUNCIONOU, JA FOI SUBSTITUIDO
        //RoundedImageView image = RoundedImageView.class.cast(findViewById(R.id.imgUsu));
        //image.setImageResource(R.mipmap.ic_launcher);



    }

    //barra de pesquisa ***TESTE***


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //codigo que ficava aqui antes: getMenuInflater().inflate(R.menu.main, menu);
        super.onCreateOptionsMenu(menu);
        //botão de pesquisa

        SearchView sv = new SearchView(this);
        sv.setOnQueryTextListener(new SearchFiltro());

        MenuItem m1 = menu.add(0, 0, 0, "Item 1");
        m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        m1.setActionView(sv);


        return true;
    }

    //faz parte do botão de pesquisa
    private class SearchFiltro implements OnQueryTextListener, SearchView.OnQueryTextListener {

        //quando está sendo digitado
        @Override
        public boolean onQueryTextSubmit(String query) {
            Log.i("Script","onQueryTextSubmit ->"+ query);
            return false;
        }
        //quando já é enviado
        @Override
        public boolean onQueryTextChange(String newText) {
            Log.i("Script","onQueryTextChange ->"+newText);
            return false;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.pesquisa) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.btEntrar) {
            Intent it = new Intent(MainActivity.this, TelaLogin.class);
            it.putExtra("usuario", (Serializable) usuario);
            startActivity(it);
        } else if (id == R.id.btRegistro) {
            Intent it = new Intent(MainActivity.this, TelaRegistro.class);
            startActivity(it);

        } else if (id == R.id.btLoginCons) {
            Intent it = new Intent(MainActivity.this, TelaLoginConsultorio.class);
            startActivity(it);

        } else if (id == R.id.btConfig) {
            Intent it = new Intent(MainActivity.this, TelaConfig.class);
            startActivity(it);

        } else if (id == R.id.btTermos) {
            Intent it = new Intent(MainActivity.this, TelaTermos.class);
            startActivity(it);
        } else if (id == R.id.btFeedback) {
            Intent it = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(it);
        } else if (id == R.id.btSobre){
            Intent it = new Intent(MainActivity.this, TelaSobre.class);
            startActivity(it);
        } else if (id == R.id.btCadCons){
        Intent it = new Intent(MainActivity.this, TelaCadastroClinica.class);
        startActivity(it);
    }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
