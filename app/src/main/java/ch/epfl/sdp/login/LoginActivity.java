package ch.epfl.sdp.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;

import java.util.Arrays;
import java.util.List;

import ch.epfl.sdp.R;
import ch.epfl.sdp.cloud.CloudFireStore;
import ch.epfl.sdp.cloud.CloudStoreInterface;
import ch.epfl.sdp.cloud.CreateUserProfile;
import ch.epfl.sdp.cloud.mockCloudStore;

public class LoginActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 123;
    private CloudStoreInterface cloudStore;
    private static final String TAG = "BalclecticLogin";
    private FirebaseInterface firebase;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intent = getIntent();
        initFirebaseAndCLoud();
        createSignInIntent();
    }
    public void createSignInIntent() {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.EmailBuilder().build());
        startActivityForResult(AuthUI.getInstance()
                .createSignInIntentBuilder().setIsSmartLockEnabled(true)
                .setAvailableProviders(providers)
                .build(),RC_SIGN_IN);
    }

    // [START auth_fui_result]
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                Toast.makeText(this, "Signed in", Toast.LENGTH_SHORT).show();
                if(cloudStore.checkCreateProfile()){
                    startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                } else {
                    startActivity(new Intent(getApplicationContext(), CreateUserProfile.class));
                }
            } else {
                Toast.makeText(this, ""+response.getError().getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }


    // [END auth_fui_result]

    private void initFirebaseAndCLoud(){
        Bundle extras = intent.getExtras();
        if (extras != null && extras.containsKey("isMock")) {
            firebase = new MockFirebase();
            cloudStore = new mockCloudStore();
        }
        else {
            firebase = new Firebase();
            cloudStore = new CloudFireStore();
        }
    }
}
