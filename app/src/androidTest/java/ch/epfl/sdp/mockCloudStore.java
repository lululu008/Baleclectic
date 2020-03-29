package ch.epfl.sdp;

import ch.epfl.sdp.dataModel.User;

public class mockCloudStore implements CloudStoreInterface {
    @Override
    public void addNewUser(User newUser) {
        int test1 = 1;
        int test2 = 0;
        int test3 = test1 + test2;
        newUser.setGender(test3);
    }

    @Override
    public void getUser(String address) {

    }
}
