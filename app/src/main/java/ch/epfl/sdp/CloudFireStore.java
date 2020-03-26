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

    public void addNewUser(User newUser, String address){

        newUser.setEmail(address);
        newUser.setScheduleId("NA");

        DocumentReference newUserRef = db.collection("users").document(address);

        newUserRef.set(newUser);
    }

    public void updateUser(FirebaseUser user){
        DocumentReference newUserRef = db.collection("users").document(user.getEmail());

        newUserRef.update("email", "123456@gamil.com");
    }

    public void getUser(FirebaseUser user){
        DocumentReference newUserRef = db.collection("users").document(user.getEmail());

        newUserRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User user = documentSnapshot.toObject(User.class);
            }
        });
    }

    public void deleteUser(String address){
        db.collection("users").document(address).delete();
    }
}
