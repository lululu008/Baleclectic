package ch.epfl.sdp.cloud;

import ch.epfl.sdp.dataModel.User;

public interface CloudStoreInterface {

    public void addNewUser(User newUser);
    public User getUser(String address);
    public Boolean checkCreateProfile();

}
