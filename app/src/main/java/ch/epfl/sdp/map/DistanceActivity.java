package ch.epfl.sdp.map;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.List;
import java.util.Objects;

import ch.epfl.sdp.R;
import pub.devrel.easypermissions.EasyPermissions;

public class DistanceActivity extends AppCompatActivity {

    private Intent intent;
    private boolean locationNecessary;
    private TextView distanceText;
    private DistanceCalculator distanceCalc;
    private LocationProvider locationProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);

        intent = getIntent();

        initProvider();
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

    private void initProvider() {
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("isMock") || extras.getBoolean("isMock")) {
            locationProvider = new MockLocation(this);
            locationNecessary = false;

        }
        else {
            locationProvider = new GPSLocation(this);
            locationNecessary = true;
        }
    }

    private void initToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(intent.getStringExtra("title") + " Distance");
    }

    public void setLocationProvider(LocationProvider newProvider) {
        locationProvider = newProvider;
    }

    public void setLocationNecessary(boolean necessary) {
        locationNecessary = necessary;
    }

    private void getLocation() {
        if (hasLocation() || (!locationNecessary)) {
            new LocationUpdateTask().execute();
        }
        else {
            Toast.makeText(this, "No location permission", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean hasLocation() {
        return EasyPermissions.hasPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION);
    }

    @SuppressLint("StaticFieldLeak")
    private class LocationUpdateTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            locationProvider.updateLocation();
            //Use another thread to wait until location is available
            while(!locationProvider.isInit());
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            distanceCalc.updateDistances(locationProvider.getLatitude(), locationProvider.getLongitude());
            distanceText.setText(distanceCalc.toString());
        }
    }
}
