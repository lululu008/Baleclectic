package ch.epfl.sdp.map;

import android.location.Location;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DistanceCalculatorTest {
    @Test
    public void basicTest() {

        ArrayList<MeetingPoint> l = new ArrayList<>();



        MeetingPoint p1 = new MeetingPoint(1, 1, "test 1");
        MeetingPoint p2 = new MeetingPoint(-10, -20, "test 2");
        l.add(p1);
        l.add(p2);

        DistanceCalculator distCalc = new DistanceCalculator(l);
        assertEquals(distCalc.toString(), "");


    }

    //TODO create mock location and add more tests
}