package ch.epfl.sdp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import ch.epfl.sdp.bean.User;

public class CreateUserProfile extends AppCompatActivity {

    public String dateDD,dateMM,dateYY;
    public String userName;
    public int gender = 10;

    ImageButton add_photo;
    EditText user_name;
    RadioButton gender_male;
    RadioButton gender_female;
    EditText date_day;
    EditText date_month;
    EditText date_year;
    Button register;

    private FirebaseAuth mAuth;
    //private static final String TAG = "CustomAuthActivity";
    private String mCustomToken;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference newUserRef = db.collection("users").document("test");

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofile);
        mAuth.getInstance(); //initialize

        add_photo=findViewById(R.id.add);
        user_name=findViewById(R.id.user_name_edit);
        gender_male=findViewById(R.id.male);
        gender_female=findViewById(R.id.female);
        date_day=findViewById(R.id.date_dd);
        date_month=findViewById(R.id.date_mm);
        date_year=findViewById(R.id.date_yy);
        register=findViewById(R.id.register_button);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        gender_male.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gender = 1;
            }
        });

        gender_female.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gender = 0;
            }
        });
    }

    public void registerUser(){
        userName = user_name.getText().toString().trim();
        dateDD = date_day.getText().toString().trim();
        dateMM = date_month.getText().toString().trim();
        dateYY = date_year.getText().toString().trim();

        if (userName.isEmpty()){
            user_name.setError("User name required");
            user_name.requestFocus();
            return;
        }
        if (dateDD.isEmpty() || dateDD.length()!=2){
            date_day.setTextColor(Color.RED);
            date_day.requestFocus();
            return;
        }
        if (dateMM.isEmpty()||dateMM.length()!=2){
            date_month.setTextColor(Color.RED);
            date_month.requestFocus();
            return;
        }
        if (dateYY.isEmpty()||dateYY.length()!=4){
            date_year.setTextColor(Color.RED);
            date_year.requestFocus();
            return;
        }
        if (gender == 10){
            gender_female.requestFocus();
            return;
        }

        mAuth.signInWithCustomToken(mCustomToken)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                             User user = new User(userName, gender, dateDD, dateMM, dateYY);
                            FirebaseDatabase.getInstance().getReference('users').child(
                                    FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                                    }else {
                                        Toast.makeText(CreateUserProfile.this, "Create Profile failed.",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                            //Log.d(TAG, "signInWithCustomToken:success");
                            //FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithCustomToken:failure", task.getException());
                            Toast.makeText(CreateUserProfile.this, "Create Profile failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }





}
