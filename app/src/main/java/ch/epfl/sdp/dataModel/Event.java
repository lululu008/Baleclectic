package ch.epfl.sdp.dataModel;

import java.util.Map;

public class Event {

    private String name;
    private String startTime;
    private String endTime;
    private String description;

    public Event() {}

    public Event(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map toMap() {
        //TODO
        return null;
    }

    public void setFromMap() {
        //TODO
    }

}
