package ch.epfl.sdp.bean_test;

import org.junit.Test;

import java.sql.Time;

import ch.epfl.sdp.bean.Event;
import ch.epfl.sdp.bean.User;

import static org.junit.Assert.assertEquals;

public class EventTest {

    @Test
    public void testGetterAndSetter() {

        Event event = new Event("sing");
        event.setDescription("Just sing");
        event.setStartTime("14:00");
        event.setEndTime("15:00");

        assertEquals("sing", event.getName());
        assertEquals("Just sing", event.getDescription());
        assertEquals("14:00", event.getStartTime());
        assertEquals("15:00", event.getEndTime());
    }
}
