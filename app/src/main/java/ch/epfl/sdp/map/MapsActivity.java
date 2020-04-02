
package ch.epfl.sdp.map;

import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import ch.epfl.sdp.R;
import pub.devrel.easypermissions.EasyPermissions;

public class MapsActivity extends AppCompatActivity implements OnMyLocationButtonClickListener,
        OnMyLocationClickListener,
        OnMapReadyCallback {

    private GoogleMap mMap;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        intent = getIntent();

        initToolbar();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void initToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(intent.getStringExtra("title"));
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

        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);

        showMeetingPoints();
        setLocation();
    }

    public void showMeetingPoints() {

        MeetingPoints meetingPoints = (MeetingPoints) intent.getSerializableExtra("points");
        List<MeetingPoint> points = meetingPoints.getPoints();

        if (!points.isEmpty()) {

            for (MeetingPoint p: points) {
                mMap.addMarker(new MarkerOptions().position(p.getPos()).title(p.getName()));
            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(points.get(0).getPos(), 15));
        }
        else {
            // Add a marker in Sydney and move the camera
            LatLng sydney = new LatLng(-34, 151);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }

    }

    public void setLocation() {

        if (hasLocation()) {
            if (mMap != null) {
                mMap.setOnMyLocationButtonClickListener(this);
                mMap.setMyLocationEnabled(true);
                mMap.setOnMyLocationClickListener(this);
            }
        }
    }

    private boolean hasLocation() {
        return EasyPermissions.hasPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION);
    }

    @Override
    public boolean onMyLocationButtonClick() {

        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();

        //Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }
}
