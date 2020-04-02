package ch.epfl.sdp.login;

public class MockFirebase implements FirebaseInterface {
    @Override
    public String getUserEmail() {
        return "test";
    }

    @Override
    public String getUserName() {
        return "test";
    }
}
