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

<<<<<<< HEAD:app/src/test/java/ch/epfl/sdp/bean_test/MainEventTest.java
        User creator = new User(userName, gender, dateDD, dateMM, "John");
=======
        User creator = new User("John");
        User newCreator = new User("not John");
>>>>>>> master:app/src/test/java/ch/epfl/sdp/dataModelTest/MainEventTest.java
        Event event = new Event("sing");
        String sDate="10/03/2020";
        Date date =new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
        MainEvent mainEvent = new MainEvent("123", "Baleclectic", creator);
        mainEvent.setCreator(newCreator);
        mainEvent.setId("456");
        mainEvent.setDate(date);
        mainEvent.setDescription("Have fun");
        mainEvent.setOpen(true);
        mainEvent.addEvents(event);

        assertEquals("Baleclectic", mainEvent.getName());
        assertEquals("456", mainEvent.getId());
        assertEquals("not John", mainEvent.getCreator().getName());
        assertEquals(date, mainEvent.getDate());
        assertEquals("Have fun", mainEvent.getDescription());
        assertTrue(mainEvent.isOpen());
        assertEquals("sing", mainEvent.getEvents().get(0).getName());
    }
}
