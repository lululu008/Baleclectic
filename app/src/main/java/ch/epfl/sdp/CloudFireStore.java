package ch.epfl.sdp;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import ch.epfl.sdp.bean.User;

public class CloudFireStore {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void addUser(){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        User newUser = new User(user.getDisplayName());
        newUser.setEmail(user.getEmail());
        newUser.setScheduleId("a1");

        DocumentReference newUserRef = db.collection("users").document("test");

        newUserRef.set(newUser);
    }

    public void updateUser(){
        DocumentReference newUserRef = db.collection("users").document("test");

        newUserRef.update("email", "123456@gamil.com");
    }

    public void getUser(){
        DocumentReference newUserRef = db.collection("users").document("test");

        newUserRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User user = documentSnapshot.toObject(User.class);
            }
        });
    }

    public void deleteUser(){
        db.collection("users").document("test").delete();
    }
}
