package com.askle.askle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends SupportMapFragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    //definir limite movimentação da camera OBS: APP TRAVOU AO USAR COMANDO
    //private LatLngBounds limiteManaus;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //hhabilitar botoes de zoom no app
        mMap.getUiSettings().setZoomControlsEnabled(true);

        //predios em 3d
        mMap.setBuildingsEnabled(false);

        //nivel de zoom minimo
        mMap.setMinZoomPreference(11);

        //delimitar area de visualização do mapa ########## OBS: APP TRAVOU AO USAR COMANDO
        //   definindo a latitude o longitude limite
        //limiteManaus = new LatLngBounds(new LatLng(-2.928529,-60.118748), new LatLng(-3.152113, -59.819260));
        //      restringir os limites da camera para limiteManaus
        //mMap.setLatLngBoundsForCameraTarget(limiteManaus);
        TelaCadastroClinica telinha = new TelaCadastroClinica();
        // Add a marker in Manaus and IFAM and move the camera
        LatLng manaus = new LatLng(-3.0722618, -59.9877961);
        LatLng ifam = new LatLng(-3.134108, -60.012815);
        LatLng Teatro = telinha.pegarCoordenada("Rua 7 de setembro centro, 1975, manaus");
        //MarkerOptions marker = new MarkerOptions();
        MarkerOptions markerIF = new MarkerOptions();

        markerIF.position(Teatro);
        markerIF.title("Exemplo: IFAM");
        markerIF.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.asklemarker));
        //marker.position(manaus);
        //marker.title("Exemplo: Manaus");
        //marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.asklemarker));

        //mMap.addMarker(marker);
        mMap.addMarker(markerIF);
        //para adicionar mais marcadores, fazer mais markers com outras informaçoes
        //outra maneira: mMap.addMarker(new MarkerOptions().position(manaus).title("Exemplo Manaus"));

        /*ALGUNS EXEMPLOS DE USO DO MARKER OPTIONS
        Marker melbourne = mMap.addMarker(new MarkerOptions()
                .position(MELBOURNE)
                .title("Melbourne")
                .snippet("Population: 4,137,400")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.AskleMarker)));
        */
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(manaus, 12));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener(){
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent it = new Intent(MapsFragment.this.getActivity(), TelaInfoConsultorio.class);
                startActivity(it);
            }
        });


        /*   ABRIR ACTIVITY AO CLICAR NO MARCADOR  ( FUNCIONANDO )
        mMap.setOnMarkerClickListener(
                new GoogleMap.OnMarkerClickListener(){
                    @Override
                    public boolean onMarkerClick(Marker marker){
                        Intent it = new Intent(MapsFragment.this.getActivity(), TelaInfoConsultorio.class);
                        startActivity(it);
                        return false;
                    }
                }
        );
        */

    }



}
