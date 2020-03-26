package ch.epfl.sdp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ch.epfl.sdp.dataModel.User;

public class CreateUserProfile extends AppCompatActivity {

    public String dateDD,dateMM,dateYY;
    public String userName;
    public Date birthday;
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
    private FirebaseUser currentUser;
    //private static final String TAG = "CustomAuthActivity";
    private String mCustomToken;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference newUserRef = db.collection("users").document("test");

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofile);
        mAuth.getInstance(); //initialize
        currentUser = mAuth.getCurrentUser();
        setUp();
    }

    public void registerUser() throws ParseException {
        retrieveInput();
        if(!checkInput())
            return;
        updateInfo();
    }

    private void updateInfo(){
        User newUser = new User(userName, gender, birthday);
        CloudFireStore cloudFireStore = new CloudFireStore();
        String address = currentUser.getEmail();
        cloudFireStore.addNewUser(newUser, address);
        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
    }

    @SuppressLint("SimpleDateFormat")
    private void retrieveInput() throws ParseException {
        userName = user_name.getText().toString().trim();
        dateDD = date_day.getText().toString().trim();
        dateMM = date_month.getText().toString().trim();
        dateYY = date_year.getText().toString().trim();
        String date_full = dateDD + "/" +dateMM + "/" + dateYY;
        birthday =new SimpleDateFormat("dd/MM/yyyy").parse(date_full);
    }

    private void setUp(){
        add_photo=findViewById(R.id.add);
        user_name=findViewById(R.id.user_name_edit);
        gender_male=findViewById(R.id.male);
        gender_female=findViewById(R.id.female);
        date_day=findViewById(R.id.date_dd);
        date_month=findViewById(R.id.date_mm);
        date_year=findViewById(R.id.date_yy);
        register=findViewById(R.id.register_button);

        setupButton();
    }

    private void setupButton(){
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    registerUser();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
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

    private boolean checkInput(){
        boolean correct = true;
        if (userName.isEmpty()){
            user_name.setError("User name required");
            user_name.requestFocus();
            correct = false;
        }
        if(!checkBirthday()) correct = false;
        if (gender == 10){
            gender_female.requestFocus();
            correct = false;
        }
        return correct;
    }

    private boolean checkBirthday(){
        boolean correct = true;
        if (dateDD.length() != 2){
            date_day.setTextColor(Color.RED);
            date_day.requestFocus();
            correct = false;
        }
        if (dateMM.length() != 2){
            date_month.setTextColor(Color.RED);
            date_month.requestFocus();
            correct = false;
        }
        if (dateYY.length() != 4){
            date_year.setTextColor(Color.RED);
            date_year.requestFocus();
            correct = false;
        }
        return correct;
    }
}
