package ch.epfl.sdp.bean;

import java.util.ArrayList;

public class User {

    private String name;
    private String email;
    private String scheduleId;
    private ArrayList<User> friends = new ArrayList<User>();

    public User(String userName, int gender, String dateDD, String dateMM, String name){
        this.name = name;
    }

    public void addFriends(User friend) {
        this.friends.add(friend);
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public String getName() {
        return name;
    }

    public void setName(String userName) {
        this.name = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }
}

