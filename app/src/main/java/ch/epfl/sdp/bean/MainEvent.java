package ch.epfl.sdp.bean;

import android.graphics.Picture;

import java.util.ArrayList;
import java.util.Date;

public class MainEvent {

    private String name;
    private String description;
    private String id;
//    private Latlng location;
//    private MeetingPoints meetingPoints;
    private User creator;
    private Picture profile;
    private ArrayList<Event> events = new ArrayList<Event>();
    private boolean is_open;
    private Date date;

    public MainEvent(String id, String name, User creator){
        this.id = id;
        this.name = name;
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void addEvents(Event event) {
        this.events.add(event);
    }

    public boolean isOpen() {
        return is_open;
    }

    public void setOpen(boolean is_open) {
        this.is_open = is_open;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Picture getProfile() {
        return profile;
    }

    public void setProfile(Picture profile) {
        this.profile = profile;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public Latlng getLocation() {
//        return location;
//    }
//
//    public void setLocation(Latlng location) {
//        this.location = location;
//    }
//
//    public MeetingPoints getMeetingPoints() {
//        return meetingPoints;
//    }
//
//    public void setMeetingPoints(MeetingPoints meetingPoints) {
//        this.meetingPoints = meetingPoints;
//    }
}
