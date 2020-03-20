package ch.epfl.sdp.userProfileTest;

import org.junit.Test;

import ch.epfl.sdp.userProfile.Event;

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
