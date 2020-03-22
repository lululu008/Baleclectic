package ch.epfl.sdp;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;

import ch.epfl.sdp.bean.User;

public class CloudFireStore {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();

    public void addNewUser(String userName, int gender, Date birthday){

        User newUser = new User(userName, gender, birthday);
        newUser.setEmail(user.getEmail());
        newUser.setScheduleId("na");

        DocumentReference newUserRef = db.collection("users").document(user.getEmail());

        newUserRef.set(newUser);
    }

    public void updateUser(){
        DocumentReference newUserRef = db.collection("users").document(user.getEmail());

        newUserRef.update("email", "123456@gamil.com");
    }

    public void getUser(){
        DocumentReference newUserRef = db.collection("users").document(user.getEmail());

        newUserRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User user = documentSnapshot.toObject(User.class);
            }
        });
    }

    public void deleteUser(){
        db.collection("users").document(user.getEmail()).delete();
    }
}
