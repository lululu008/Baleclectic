package ch.epfl.sdp;

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

    public String getName() {
        return name;
    }
}
