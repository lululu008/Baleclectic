package ch.epfl.sdp.cloud;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ch.epfl.sdp.login.ProfileActivity;
import ch.epfl.sdp.R;
import ch.epfl.sdp.dataModel.User;

public class CreateUserProfile extends AppCompatActivity {

    public String dateDD,dateMM,dateYY;
    public String userName;
    public Date birthday;
    public int gender = 10;
    public boolean correct = true;
    private CloudStoreInterface cloudStore;

    ImageButton add_photo;
    EditText user_name;
    RadioButton gender_male;
    RadioButton gender_female;
    EditText date_day;
    EditText date_month;
    EditText date_year;
    Button register;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createprofile);
        setUp();
        CloudFireStore cloudFireStore = new CloudFireStore();
        setCloudStore(cloudFireStore);
    }

    @SuppressLint("SimpleDateFormat")
    public void registerUser() throws ParseException {
        retrieveInput();
        checkInput();
        if(!correct) return;
        String date_full = dateDD + "/" +dateMM + "/" + dateYY;
        birthday =new SimpleDateFormat("dd/MM/yyyy").parse(date_full);
        updateInfo();
    }

    private void updateInfo(){
        User newUser = new User(userName, gender, birthday);
        cloudStore.addNewUser(newUser);
        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
    }

    private void retrieveInput(){
        correct = true;
        userName = user_name.getText().toString().trim();
        dateDD = date_day.getText().toString().trim();
        dateMM = date_month.getText().toString().trim();
        dateYY = date_year.getText().toString().trim();
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

    private void checkInput(){
        if (userName.isEmpty()){
            user_name.setError("User name required");
            user_name.requestFocus();
            correct = false;
        }
        checkBirthday();
        if (gender == 10){
            gender_female.requestFocus();
            gender_female.setError("Gender required");
            correct = false;
        }
    }

    private void checkBirthday(){
        if (dateDD.length() != 2){
            setDateError(date_day);
        }
        if (dateMM.length() != 2){
            setDateError(date_month);
        }
        if (dateYY.length() != 4){
            setDateError(date_year);
        }
    }

    public void setCloudStore(CloudStoreInterface cloudStore){
        this.cloudStore = cloudStore;
    }

    private void setDateError(EditText errorField){
        errorField.setTextColor(Color.RED);
        errorField.setError("Incorrect date");
        errorField.requestFocus();
        correct = false;
    }
}
