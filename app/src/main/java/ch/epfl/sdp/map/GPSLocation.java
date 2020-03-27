package ch.epfl.sdp.map;

import android.Manifest;
import android.app.Activity;
import android.location.Location;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import pub.devrel.easypermissions.EasyPermissions;

public class GPSLocation implements LocationProvider {

    private FusedLocationProviderClient fusedLocationClient;
    private Location userLocation;
    private Activity activity;

    public GPSLocation(Activity activity) {

        this.activity = activity;
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity);
        updateLocation();

    }

    public void updateLocation() {
        if (hasLocation()) {
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(activity, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                // Logic to handle location object and update distances
                                userLocation = location;
                            }
                        }
                    });
        }
    }

    @Override
    public boolean isInit() {
        return (userLocation != null);

    }
    @Override
    public double getLatitude() {
        return userLocation.getLatitude();

    }

    @Override
    public double getLongitude() {
        return userLocation.getLongitude();
    }

    private boolean hasLocation() {
        return EasyPermissions.hasPermissions(activity, Manifest.permission.ACCESS_FINE_LOCATION);
    }
}
