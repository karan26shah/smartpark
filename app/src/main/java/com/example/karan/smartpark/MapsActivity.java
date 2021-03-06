package com.example.karan.smartpark;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Marker mMarker;
    private Marker current;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


   /*public void onMapSearch(View view) {
        EditText locationSearch = (EditText) findViewById(R.id.TFaddress);
        String location = locationSearch.getText().toString();
        List<Address> addressList = null;

        if (location != null || !location.equals("")) {
            Geocoder geocoder = new Geocoder(this);
            try {
                addressList = geocoder.getFromLocationName(location, 1);

            } catch (IOException e) {
                e.printStackTrace();
            }
            Address address = addressList.get(0);
            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Marker"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        }
    }*/

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

        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            mMap.moveCamera(CameraUpdateFactory.zoomBy(16));
            //mMap.moveCamera(CameraUpdateFactory.zoomIn());
        }

      /*  mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                LatLng my = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(my).title("Mylocation"));
            }
        });*/

        LatLng place = new LatLng(22.6793261, 72.8809315);
        mMap.addMarker(new MarkerOptions().position(place).title("park").snippet("college ddu"));
        LatLng place1 = new LatLng(22.689126, 72.871636);
        mMap.addMarker(new MarkerOptions().position(place1).title("park1").snippet("college ddu"));
        LatLng place2 = new LatLng(22.667926, 72.889428);
        mMap.addMarker(new MarkerOptions().position(place2).title("park2").snippet("college ddu"));
        LatLng place3 = new LatLng(22.700829, 72.844667);
        mMap.addMarker(new MarkerOptions().position(place3).title("park3").snippet("college ddu"));
        float zoomLevel = 13; //This goes up to 21
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(place, zoomLevel));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker arg0) {
                if (arg0.getTitle().equals("park")) // if marker source is clicked
                {
                    Toast.makeText(MapsActivity.this, arg0.getSnippet(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MapsActivity.this, extend.class);
                    startActivity(intent);
                    return true;
                } else if (arg0.getTitle().equals("park1")) // if marker source is clicked
                {
                    Toast.makeText(MapsActivity.this, arg0.getSnippet(), Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(MapsActivity.this, extend2.class);
                    startActivity(intent1);
                    return true;
                } else if (arg0.getTitle().equals("park2")) // if marker source is clicked
                {
                    Toast.makeText(MapsActivity.this, arg0.getSnippet(), Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(MapsActivity.this, extend2.class);
                    startActivity(intent2);
                    return true;
                } else if (arg0.getTitle().equals("park3")) // if marker source is clicked
                {
                    Toast.makeText(MapsActivity.this, arg0.getSnippet(), Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(MapsActivity.this, extend2.class);
                    startActivity(intent3);
                    return true;
                }
            return true;
            }
        });

        }
}

