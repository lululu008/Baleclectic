package ch.epfl.sdp;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import ch.epfl.sdp.dataModel.User;

public class CloudFireStore {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser user = mAuth.getCurrentUser();
    private User mUser;

    public void addNewUser(User newUser){

        newUser.setEmail(user.getEmail());
        newUser.setScheduleId("NA");

        DocumentReference newUserRef = db.collection("users").document(user.getEmail());

        newUserRef.set(newUser);
    }

    public void updateUser(){
        DocumentReference newUserRef = db.collection("users").document(user.getEmail());

        newUserRef.update("email", "123456@gamil.com");
    }

    public User getUser(){

        DocumentReference newUserRef = db.collection("users").document(user.getEmail());

        newUserRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                mUser = documentSnapshot.toObject(User.class);
            }
        });

        return mUser;
    }

    public void deleteUser(){
        db.collection("users").document(user.getEmail()).delete();
    }
}
