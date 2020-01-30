package com.example.steevegpsappclient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/* The google play services allows for programmers to make connections between apps so that the user
does not need to physically switch apps to turn on things such as access to locations from the
settings. The Fused Location Provider client combines different data to give an app the user's
 location.*/

public class MainActivity extends AppCompatActivity implements LocationListener {
    // Initialize widgets
    Button gl;
    TextView lon, lat, lon_num, la_num;
    LocationManager lm;
    LocationListener ll;
    Location l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //assigns identities to variables
        setContentView(R.layout.activity_main);
        gl = findViewById(R.id.button);
        lon = findViewById(R.id.textView);
        lat = findViewById(R.id.textView2);
        lon_num = findViewById(R.id.textView3);
        la_num = findViewById(R.id.textView4);
        // this is the location manager
        lm = (LocationManager) getSystemService(LOCATION_SERVICE);
// the intent below opens setting so that the user can turn on location
//        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//        startActivity(intent);
        // checks if the permissions are on for fine or coarse location
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
        }
        // request the user's longitude and latitude in this activity by referencing the location manager
        // if it detects that the user has moves in this activity in a certain time for x value, it will
        // check the listener, save the new location value, then execute an action (in this case, displaying long. and lat.
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, this);
        // it's a button that that displays the longitude and longitude
        gl.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View view) {
                                      la_num.setText(String.valueOf(l.getLatitude()));
                                      lon_num.setText(String.valueOf(l.getLongitude()));

                                  }
                              }

        );


    }
    // this detects if location has changed
    @Override
    public void onLocationChanged(Location location) {
        // this variable makes the parameter global so that it can be used in the button's method above
        l = location;

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
