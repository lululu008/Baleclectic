package ch.epfl.sdp.map;

import android.app.Activity;

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
