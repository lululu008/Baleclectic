package ch.epfl.sdp.dataModelTest;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

import ch.epfl.sdp.dataModel.User;

public class UserTest {

    @Test
    public void testGetterAndSetter() throws ParseException {
        Date birthday =new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1999");
        User user = new User("John", 1, birthday);
        User friend = new User("Tom", 1, birthday);
        user.addFriends(friend);
        user.setEmail("123@gmail.com");
        user.setScheduleId("a1b2c3");
        user.setBirthday(birthday);
        user.setGender(0);

        assertEquals("John", user.getName());
        assertEquals("a1b2c3", user.getScheduleId());
        assertEquals("123@gmail.com", user.getEmail());
        assertEquals("Tom", user.getFriends().get(0).getName());
        assertEquals("01/01/1999", user.getBirthday());
        assertFalse(user.isMale());
    }

}