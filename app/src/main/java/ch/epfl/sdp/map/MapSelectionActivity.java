package ch.epfl.sdp.map;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

import ch.epfl.sdp.R;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MapSelectionActivity extends AppCompatActivity {

    /**
     * Request code for location permission request.
     *
     * @see #onRequestPermissionsResult(int, String[], int[])
     */
    private static final int RC_ACCESS_FINE_LOCATION = 123;

    private Button locPermissionBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_selection);

        initToolbar();

        requireLocation();

        initButtons();
    }

    private void initToolbar() {
        Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Map Selection");
    }

    private void initButtons() {
        initMapButtons();

        locPermissionBtn = findViewById(R.id.locPermissionBtn);
        updateLocationButton(locPermissionBtn);

        locPermissionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!hasLocation()) {
                    requireLocation();
                };
            }
        });
    }

    private void initMapButtons() {
        Button map1Btn = findViewById(R.id.mapSelect1Btn);
        map1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapIntent(map1MeetingPoints(), "Map 1", false);
            }
        });

        Button map2Btn = findViewById(R.id.mapSelect2Btn);
        map2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapIntent(new MeetingPoints(), "Map 2", false);
            }
        });

        Button mockMapBtn = findViewById(R.id.mockMapSelectBtn);
        mockMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mapIntent(map1MeetingPoints(), "Mock Map", true);
            }
        });

    }

    private void mapIntent(MeetingPoints points, String title, boolean mock) {

        Intent startIntent = new Intent(getApplicationContext(), MapHomeActivity.class);
        startIntent.putExtra("points", points);
        startIntent.putExtra("title", title);
        startIntent.putExtra("isMock", mock);
        startActivity(startIntent);

    }

    private MeetingPoints map1MeetingPoints() {

        MeetingPoints points = new MeetingPoints();

        MeetingPoint p1 = new MeetingPoint(46.5186, 6.5659, "Place Cosandey");
        MeetingPoint p2 = new MeetingPoint(46.5199, 6.5661, "Esplanade");
        MeetingPoint p3 = new MeetingPoint(46.5194, 6.5688, "Avenue Piccard");
        MeetingPoint p4 = new MeetingPoint(46.5184, 6.5681, "Rolex Learning Center");

        points.add(p1).add(p2).add(p3).add(p4);

        return points;
    }

    private void updateLocationButton(Button btn) {

        if (hasLocation()) {
            btn.setText(R.string.loc_access_granted);
        }
        else {
            btn.setText(R.string.loc_permission_request);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);

        if (hasLocation()) {
            updateLocationButton(locPermissionBtn);
        }
    }

    @AfterPermissionGranted(RC_ACCESS_FINE_LOCATION)
    private void requireLocation() {
        String perm = Manifest.permission.ACCESS_FINE_LOCATION;
        if (hasLocation()) {
            // Already have permission, do the thing

        } else {
            // Do not have permissions, request them now
            EasyPermissions.requestPermissions(this, getString(R.string.location_rationale),
                    RC_ACCESS_FINE_LOCATION, perm);
        }
    }

    private boolean hasLocation() {
        return EasyPermissions.hasPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION);
    }
}
