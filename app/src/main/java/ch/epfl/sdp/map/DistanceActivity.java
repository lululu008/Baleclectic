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
    private boolean isMock;
    private double mockLat = 0.0;
    private double mockLng = 0.0;
    private TextView distanceText;
    private DistanceCalculator distanceCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        intent = getIntent();
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        mockCheck();

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

    private void mockCheck() {
        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.containsKey("isMock")) {
                isMock = extras.getBoolean("isMock");
            }
            else {
                isMock = false;
            }
        }
    }

    public void getLocation() {
        if (!isMock) {
            if (hasLocation()) {
                fusedLocationClient.getLastLocation()
                        .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                            @Override
                            public void onSuccess(Location location) {
                                // Got last known location. In some rare situations this can be null.
                                if (location != null) {
                                    // Logic to handle location object and update distances
                                    distanceCalc.updateDistances(location.getLatitude(), location.getLongitude());
                                    distanceText.setText(distanceCalc.toString());
                                }
                            }
                        });
            } else {
                Toast.makeText(this, "No location permission", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            // If mock, set latitude and longitude to 0.0 all the time, then update distances
            mockLat += 0.1 ;
            mockLng += 0.1;
            distanceCalc.updateDistances(mockLat, mockLng);
            distanceText.setText(distanceCalc.toString());
        }

    }

    private boolean hasLocation() {
        return EasyPermissions.hasPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION);
    }
}
