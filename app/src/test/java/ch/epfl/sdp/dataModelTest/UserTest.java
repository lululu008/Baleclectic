package ch.epfl.sdp.dataModelTest;

import org.junit.Test;
import static org.junit.Assert.*;

import ch.epfl.sdp.dataModel.User;

public class UserTest {

    @Test
    public void testGetterAndSetter() {
        User user = new User(userName, gender, dateDD, dateMM, "John");
        User friend = new User(userName, gender, dateDD, dateMM, "Tom");
        user.addFriends(friend);
        user.setEmail("123@gmail.com");
        user.setScheduleId("a1b2c3");

        assertEquals("John", user.getName());
        assertEquals("a1b2c3", user.getScheduleId());
        assertEquals("123@gmail.com", user.getEmail());
        assertEquals("Tom", user.getFriends().get(0).getName());
    }

}