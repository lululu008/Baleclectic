package ch.epfl.sdp.map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MeetingPoints implements Serializable {

    private ArrayList<MeetingPoint> points;

    public MeetingPoints() {
        points =  new ArrayList<>();
    }
    public MeetingPoints(List<MeetingPoint> points) {

        this.points = new ArrayList<>(points);

    }

    public MeetingPoints add(MeetingPoint point) {
        points.add(point);

        return this;
    }

    public MeetingPoint get(int index) {
        return points.get(index);
    }

    public int getSize() {
        return points.size();
    }

    public ArrayList<MeetingPoint> getPoints() {
        return new ArrayList<>(points);
    }

    public void setPoints(ArrayList<MeetingPoint> points) {
        this.points = points;
    }
}
