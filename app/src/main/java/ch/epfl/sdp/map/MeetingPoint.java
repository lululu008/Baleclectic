package ch.epfl.sdp.map;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class MeetingPoint implements Serializable {

    // Can't use LatLng directly because it isn't serializable
    private double lat;
    private double lng;
    private String name;

    public MeetingPoint(double lat, double lng, String name) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
    }

    public LatLng getPos() {
        return new LatLng(lat, lng);
    }

    public float getDistance(double otherLat, double otherLng) {

        float[] results = new float[1];
        Location.distanceBetween(lat, lng, otherLat, otherLng, results);
        return results[0];
    }

    public String getName() {
        return name;
    }
}
