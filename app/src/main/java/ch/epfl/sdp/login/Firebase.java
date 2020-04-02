package ch.epfl.sdp.login;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Firebase implements FirebaseInterface {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();
    @Override
    public String getUserEmail() {
        String email = "";
        if (user != null) { email = user.getEmail();}
        return email;
    }

    @Override
    public String getUserName() {
        String name = "";
        if (user != null) { name = user.getDisplayName();}
        return name;
    }
}
