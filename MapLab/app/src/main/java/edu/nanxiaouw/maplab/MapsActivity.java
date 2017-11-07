package edu.nanxiaouw.maplab;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    static final LatLng MARY_GATES = new LatLng(47.653804, -122.307804);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        Marker drumhellerFountain = mMap.addMarker(new MarkerOptions()
                .position(MARY_GATES)
                .title("Drumheller Fountain")
                .snippet("The ducks like to chill here")
                .alpha(0.7f)
                .icon(BitmapDescriptorFactory.defaultMarker(268)));

        PolylineOptions polyLine = new PolylineOptions()
                .add(new LatLng(47.653804, -122.307804))
                .add(new LatLng(47.653704, -122.307704))
                .add(new LatLng(47.653804, -122.307604))
                .add(new LatLng(47.653704, -122.307504))
                .add(new LatLng(47.653804, -122.307404))
                .width(25)
                .color(Color.WHITE);
        mMap.addPolyline(polyLine);
    }
}
