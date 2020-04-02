package ch.epfl.sdp.dataModel;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class User {

    private String name;
    private String email;
    private String scheduleId;
    private int gender;
    private Date birthday;
    private ArrayList<String> friendsId = new ArrayList<>();
    private ArrayList<MainEvent> joinedEvents = new ArrayList<MainEvent>();
    private ArrayList<MainEvent> createdEvents = new ArrayList<MainEvent>();

    public User() {
    }

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

    public int getGender() {
        return gender;
    }

    @SuppressLint("SimpleDateFormat")
    public String getBirthday() {
        return new SimpleDateFormat("dd/MM/yyyy").format(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void addFriends(User friend) {
        this.friendsId.add(friend.getEmail());
    }

    public void setFriendsId(ArrayList<String> friendsId) {
        this.friendsId = friendsId;
    }

    public ArrayList<String> getFriendsId() {
        return friendsId;
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

    public ArrayList<MainEvent> getJoinedEvents() {
        return joinedEvents;
    }

    public void setJoinedEvents(ArrayList<MainEvent> joinedEvents) {
        this.joinedEvents = joinedEvents;
    }

    public ArrayList<MainEvent> getCreatedEvents() {
        return createdEvents;
    }

    public void setCreatedEvents(ArrayList<MainEvent> createdEvents) {
        this.createdEvents = createdEvents;
    }

    public Map<String, Object> toMap() {
        HashMap<String, Object> m = new HashMap<>();
        m.put("name", name);
        m.put("email", email);
        m.put("scheduleId", scheduleId);
        m.put("gender", gender);
        m.put("birthday", birthday);
        m.put("friendsId", friendsId);

        ArrayList<String> createdEventsId = new ArrayList<>();
        for (MainEvent e: createdEvents) {
            createdEventsId.add(e.getId());
        }
        m.put("createdEvents", createdEventsId);

        ArrayList<String> joinedEventsId = new ArrayList<>();
        for (MainEvent e: joinedEvents) {
            joinedEventsId.add(e.getId());
        }
        m.put("joinedEvents", joinedEventsId);

        return m;
    }

    public void setFromMap(Map m) {
        setName((String) m.get("name"));
        setEmail((String) m.get("email"));
        setScheduleId((String) m.get("scheduleId"));
        setGender((int) m.get("gender"));
        setBirthday((Date) m.get("birthday"));
        setFriendsId((ArrayList<String>) m.get("friendsId"));
        setCreatedEvents((ArrayList<MainEvent>) m.get("createdEvents"));
        setJoinedEvents((ArrayList<MainEvent>) m.get("joinedEvents"));
    }
}

