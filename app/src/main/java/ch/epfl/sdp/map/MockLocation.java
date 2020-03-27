package ch.epfl.sdp.map;

import android.Manifest;
import android.app.Activity;
import android.location.Location;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import pub.devrel.easypermissions.EasyPermissions;

public class MockLocation implements LocationProvider {

    private Activity activity;
    private double latitude = 0.0;
    private double longitude = 0.0;

    public MockLocation(Activity activity) {

        this.activity = activity;

    }

    public void updateLocation() {
        latitude += 0.5;
        longitude -= 0.5;
    }

    @Override
    public boolean isInit() {
        return true;

    }
    @Override
    public double getLatitude() {
        return latitude;

    }

    @Override
    public double getLongitude() {
        return longitude;
    }
}
