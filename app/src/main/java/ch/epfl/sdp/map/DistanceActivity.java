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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ch.epfl.sdp.Pair;
import ch.epfl.sdp.R;
import pub.devrel.easypermissions.EasyPermissions;

public class DistanceActivity extends AppCompatActivity {

    private Intent intent;
    private FusedLocationProviderClient fusedLocationClient;
    private Location lastLocation;
    private TextView distanceText;
    private List<MeetingPoint> points;

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
        points = meetingPoints.getAll();
        getLocation();

    }

    private void initToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(intent.getStringExtra("title") + " Distance");
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
                                updateDistances();
                            }
                        }
                    });
        }
        else {
            Toast.makeText(this, "No location permission", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateDistances() {

        ArrayList<Pair<String, Float>> distances = new ArrayList<>();

        for (MeetingPoint p : points) {
            distances.add(new Pair(p.getName(), p.getDistance(lastLocation)));
        }

        sortByDistance(distances);

        distanceText.setText(toString(distances));


    }



    private void sortByDistance(ArrayList<Pair<String, Float>> distances) {
        Collections.sort(distances, new Comparator<Pair<String, Float>>() {
            @Override
            public int compare(final Pair<String, Float> o1, final Pair<String, Float> o2) {
                if (o1.getSecond() > o2.getSecond()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
    }

    private String toString(ArrayList<Pair<String, Float>> distances) {
        StringBuilder sb = new StringBuilder();

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(0);

        for (Pair<String, Float> p : distances) {
            sb.append(" ").append(p.getFirst()).append(": ")
                    .append(df.format(p.getSecond())).append(" m").append("\n");
        }

        return sb.toString();
    }



    private boolean hasLocation() {
        return EasyPermissions.hasPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION);
    }
}
