package ch.epfl.sdp.cloud;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import ch.epfl.sdp.login.Firebase;
import ch.epfl.sdp.login.FirebaseInterface;
import ch.epfl.sdp.dataModel.User;

public class CloudFireStore implements CloudStoreInterface{
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private FirebaseInterface firebase = new Firebase();
    private Boolean result;

    public void addNewUser(User newUser){
        String address = firebase.getUserEmail();
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

    public Boolean checkCreateProfile(){
        DocumentReference docIdRef = db.collection("users").document(firebase.getUserEmail());
        docIdRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) { result = true; } else { result = false; }
                } else { result = false; }
            }
        });
        return result;
    }
}
