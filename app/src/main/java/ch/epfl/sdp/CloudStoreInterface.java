package ch.epfl.sdp;

import ch.epfl.sdp.dataModel.User;

public interface CloudStoreInterface {

    public void addNewUser(User newUser);
    public void getUser(String address);

}
