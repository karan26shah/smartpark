package com.example.karan.smartpark;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class extend2 extends AppCompatActivity implements View.OnClickListener{


    private Button reserve;
    private Button navi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extend);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        navi = (Button) findViewById(R.id.navigate);
        reserve = (Button) findViewById(R.id.reservation);
        navi.setOnClickListener(this);
        reserve.setOnClickListener(this);
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
    public void onClick(View view) {
        if (view == navi) {
            navigation1();
        }
        if (view == reserve) {
            reservation1();
        }
    }

    private void navigation1() {
        Intent intent2 = new Intent(this, navigation2.class);
        startActivity(intent2);
    }

    private void reservation1() {
        Intent intent2 = new Intent(this, reservation.class);
        startActivity(intent2);
    }
}