package ch.epfl.sdp.dataModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import ch.epfl.sdp.map.MeetingPoints;

public class MainEvent {

    private String name;
    private String description;
    private String id;
    private double lat;
    private double lng;
    private MeetingPoints meetingPoints;
    private String creatorId;
    private ArrayList<Event> events = new ArrayList<Event>();
    private boolean open;
    private Date date;

    public MainEvent() {}

    public MainEvent(String name, User creator){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.creatorId = creator.getEmail();
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
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public MeetingPoints getMeetingPoints() {
        return meetingPoints;
    }

    public void setMeetingPoints(MeetingPoints meetingPoints) {
        this.meetingPoints = meetingPoints;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    public Map toMap() {
        //TODO
        return null;
    }

    public void setFromMap(Map m) {
        //TODO

    }
}
