package ch.epfl.sdp.bean_test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ch.epfl.sdp.bean.Event;
import ch.epfl.sdp.bean.MainEvent;
import ch.epfl.sdp.bean.User;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainEventTest {

    @Test
    public void testGetterAndSetter() throws ParseException {

        User creator = new User(userName, gender, dateDD, dateMM, "John");
        Event event = new Event("sing");
        String sDate="10/03/2020";
        Date date =new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
        MainEvent mainEvent = new MainEvent("123", "Baleclectic", creator);
        mainEvent.setDate(date);
        mainEvent.setDescription("Have fun");
        mainEvent.setOpen(true);
        mainEvent.addEvents(event);

        assertEquals("Baleclectic", mainEvent.getName());
        assertEquals("123", mainEvent.getId());
        assertEquals("John", mainEvent.getCreator().getName());
        assertEquals(date, mainEvent.getDate());
        assertEquals("Have fun", mainEvent.getDescription());
        assertTrue(mainEvent.isOpen());
        assertEquals("sing", mainEvent.getEvents().get(0).getName());
    }
}
