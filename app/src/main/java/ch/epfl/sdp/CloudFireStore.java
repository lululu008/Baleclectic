package ch.epfl.sdp;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import ch.epfl.sdp.dataModel.User;

public class CloudFireStore implements CloudStoreInterface{
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private FirebaseUser currentUser = mAuth.getCurrentUser();


    public void addNewUser(User newUser){
        String address = currentUser.getEmail();
        newUser.setEmail(address);
        DocumentReference newUserRef = db.collection("users").document(address);
        newUserRef.set(newUser);
    }

    public void getUser(String address){
        DocumentReference newUserRef = db.collection("users").document(address);
        newUserRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                User user = documentSnapshot.toObject(User.class);
            }
        });
    }
}
