package ch.epfl.sdp;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;

import ch.epfl.sdp.dataModel.User;

public class MeetingPoint implements Serializable {

    // Can't use LatLng directly because it isn't serializable
    private double lat;
    private double lng;
    private String name;
    private ArrayList<User> meetingUsers = new ArrayList<User>();

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

    public ArrayList<User> getMeetingUsers(){
        return meetingUsers;
    }

    public void addMeetingUser(User user){
        this.meetingUsers.add(user);
    }
}
