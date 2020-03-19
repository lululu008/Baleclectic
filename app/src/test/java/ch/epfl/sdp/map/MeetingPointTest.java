package ch.epfl.sdp.map;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class MeetingPointTest {
    @Test
    public void emptyMeetingsPointsIsEmpty() {
        MeetingPoints emptyPoints = new MeetingPoints();
        assertEquals(emptyPoints.getSize(), 0);
    }

    @Test
    public void meetingPointsConstructorFromList() {

        ArrayList<MeetingPoint> l = new ArrayList<>();

        MeetingPoint p1 = new MeetingPoint(1, 1, "test 1");
        MeetingPoint p2 = new MeetingPoint(-1, -2, "test 2");
        l.add(p1);
        l.add(p2);

        MeetingPoints meetingPoints = new MeetingPoints(l);

        assertEquals(p1, meetingPoints.get(0));
        assertEquals(l.size(), meetingPoints.getSize());
        assertEquals(l, meetingPoints.getAll());
    }
}