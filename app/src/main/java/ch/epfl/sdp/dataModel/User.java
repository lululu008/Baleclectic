package ch.epfl.sdp.dataModel;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class User {

    private String name;
    private String email;
    private String scheduleId;
    private int gender;
    private Date birthday;
    private ArrayList<User> friends = new ArrayList<User>();

    public User(String userName, int gender, Date birthday) {
        this.name = userName;
        this.gender = gender;
        this.birthday = birthday;
    }

    public User(String userName) {
        this.name = userName;
    }

    public boolean isMale() {
        return gender == 1;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @SuppressLint("SimpleDateFormat")
    public String getBirthday() {
        return new SimpleDateFormat("dd/MM/yyyy").format(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

