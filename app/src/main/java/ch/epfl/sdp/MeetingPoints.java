package ch.epfl.sdp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MeetingPoints implements Serializable {

    private ArrayList<MeetingPoint> pointsList;

    public MeetingPoints() {
        pointsList =  new ArrayList<>();
    }
    public MeetingPoints(List<MeetingPoint> pointsList) {

        this.pointsList = new ArrayList<>(pointsList);

    }

    public MeetingPoints add(MeetingPoint point) {
        pointsList.add(point);

        return this;
    }

    public MeetingPoint get(int index) {
        return pointsList.get(index);
    }

    public List<MeetingPoint> getAll() {
        return new ArrayList<>(pointsList);
    }

    public int getSize() {
        return pointsList.size();
    }

}
