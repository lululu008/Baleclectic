package ch.epfl.sdp.map;

import android.location.Location;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ch.epfl.sdp.Pair;

public class DistanceCalculator {

    private ArrayList<MeetingPoint> points;
    private ArrayList<Pair<String, Float>> distances;

    public DistanceCalculator(List<MeetingPoint> points) {
        this.points = new ArrayList<>(points);
        distances = new ArrayList<>();

    }
    public void updateDistances(Location loc) {

        distances = new ArrayList<>();

        for (MeetingPoint p : points) {
            distances.add(new Pair<>(p.getName(), p.getDistance(loc)));
        }

        sortByDistance(distances);
    }

    private void sortByDistance(ArrayList<Pair<String, Float>> distances) {
        Collections.sort(distances, new Comparator<Pair<String, Float>>() {
            @Override
            public int compare(final Pair<String, Float> o1, final Pair<String, Float> o2) {
                return o1.getSecond().compareTo(o2.getSecond());
            }
        });
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(0);

        for (Pair<String, Float> p : distances) {
            sb.append(" ").append(p.getFirst()).append(": ")
                    .append(df.format(p.getSecond())).append(" m").append("\n");
        }

        return sb.toString();
    }
}
