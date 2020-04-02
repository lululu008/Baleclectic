package ch.epfl.sdp.map;

import org.junit.Test;

import java.util.ArrayList;

import ch.epfl.sdp.dataModel.Pair;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DistanceCalculatorTest {
    @Test
    public void emptyStringIsGiven() {

        ArrayList<MeetingPoint> l = new ArrayList<>();



        MeetingPoint p1 = new MeetingPoint(1, 1, "test 1");
        MeetingPoint p2 = new MeetingPoint(-10, -20, "test 2");
        l.add(p1);
        l.add(p2);

        DistanceCalculator distCalc = new DistanceCalculator(l);
        assertEquals(distCalc.toString(), "");
    }

    @Test
    public void sortByDistanceSortsArrayCorrectly() {

        Pair<String, Float> mp1 = new Pair<>("mp1", 0.0f);
        Pair<String, Float> mp2 = new Pair<>("mp2", 1.0f);
        Pair<String, Float> mp3 = new Pair("mp3", 2.5f);

        ArrayList<Pair<String, Float>> mp = new ArrayList<>();
        mp.add(mp2);
        mp.add(mp3);
        mp.add(mp1);

        DistanceCalculator.sortByDistance(mp);

        assertEquals(mp1, mp.get(0));
        assertEquals(mp2, mp.get(1));
        assertEquals(mp3, mp.get(2));

    }
}