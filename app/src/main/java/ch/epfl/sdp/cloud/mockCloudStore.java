package ch.epfl.sdp.cloud;

import ch.epfl.sdp.cloud.CloudStoreInterface;
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
    public User getUser(String address) {
        return new User();
    }

    @Override
    public Boolean checkCreateProfile() {
        return true;
    }
}
