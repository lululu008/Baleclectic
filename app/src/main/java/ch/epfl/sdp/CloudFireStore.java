package ch.epfl.sdp;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import ch.epfl.sdp.bean.User;

public class CloudFireStore {
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    public void addUser(){
        User user = new User("John");
        user.setEmail("123@gmail.com");
        user.setScheduleId("a1");

        DocumentReference newUserRef = db.collection("users").document();

        newUserRef.set(user);
    }

    public void getUser(){
        DocumentReference newUserRef = db.collection("users").document();

        newUserRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User user = documentSnapshot.toObject(User.class);
            }
        });
    }
}
