package com.askle.askle;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class TelaCadastroClinica extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro_clinica);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão
        getSupportActionBar().setTitle("");     //Titulo para ser exibido na sua Action Bar em frente à seta


        TextView txtEndereco = (TextView) findViewById(R.id.txtEndereco);


    }

    public LatLng pegarCoordenada(String endereco){
        Geocoder geoCoder = new Geocoder(this, Locale.getDefault());
        try{
            List<Address> enderecos = geoCoder.getFromLocationName(endereco, 5);

            if(enderecos.size()>0){
                Double lat = (Double) (enderecos.get(0).getLatitude());
                Double lon = (Double) (enderecos.get(0).getLongitude());
                Log.d("lat-long", "" + lat + "......." + lon);

                return new LatLng(lat, lon);

            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
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
