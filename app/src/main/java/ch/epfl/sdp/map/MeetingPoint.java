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

    public float getDistance(Location loc) {

        Location pointLocation = new Location("");
        pointLocation.setLatitude(lat);
        pointLocation.setLongitude(lng);

        return loc.distanceTo(pointLocation);

    }

    public String getName() {
        return name;
    }
}
