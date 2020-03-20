package ch.epfl.sdp.map;

import android.Manifest;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;
import java.util.Objects;

import ch.epfl.sdp.R;
import pub.devrel.easypermissions.EasyPermissions;

public class DistanceActivity extends AppCompatActivity {

    private Intent intent;
    private FusedLocationProviderClient fusedLocationClient;
    private Location lastLocation;
    private TextView distanceText;
    private DistanceCalculator distanceCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        intent = getIntent();
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        initToolbar();

        Button updateLocBtn = findViewById(R.id.updateLocationButton);
        updateLocBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getLocation();
            }
        });

        distanceText = findViewById(R.id.textView);

        MeetingPoints meetingPoints = (MeetingPoints) intent.getSerializableExtra("points");
        assert meetingPoints != null;
        List<MeetingPoint> points = meetingPoints.getAll();

        distanceCalc = new DistanceCalculator(points);
        getLocation();

    }

    private void initToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(intent.getStringExtra("title") + " Distance");
    }

    public void getLocation() {

        if (hasLocation()) {
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                // Logic to handle location object
                                lastLocation = location;

                                //Update distances once new location has been received
                                distanceCalc.updateDistances(lastLocation);
                                distanceText.setText(distanceCalc.toString());
                            }
                        }
                    });
        }
        else {
            Toast.makeText(this, "No location permission", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean hasLocation() {
        return EasyPermissions.hasPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION);
    }
}
