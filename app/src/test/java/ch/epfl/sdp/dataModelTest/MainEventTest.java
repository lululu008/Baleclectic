package ch.epfl.sdp.dataModelTest;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ch.epfl.sdp.dataModel.Event;
import ch.epfl.sdp.dataModel.MainEvent;
import ch.epfl.sdp.dataModel.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainEventTest {

    @Test
    public void testGetterAndSetter() throws ParseException {

        User creator = new User("John");
        User newCreator = new User("not John");
        Event event = new Event("sing");
        String sDate="10/03/2020";
        Date date =new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
        MainEvent mainEvent = new MainEvent("Baleclectic", creator);
        mainEvent.setCreatorId(newCreator.getEmail());
        mainEvent.setId("456");
        mainEvent.setDate(date);
        mainEvent.setDescription("Have fun");
        mainEvent.setOpen(true);
        mainEvent.addEvents(event);

        assertEquals("Baleclectic", mainEvent.getName());
        assertEquals("456", mainEvent.getId());
        assertEquals("not John", mainEvent.getCreatorId().getName());
        assertEquals(date, mainEvent.getDate());
        assertEquals("Have fun", mainEvent.getDescription());
        assertTrue(mainEvent.isOpen());
        assertEquals("sing", mainEvent.getEvents().get(0).getName());
    }
}
