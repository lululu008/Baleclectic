package ch.epfl.sdp.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import ch.epfl.sdp.R;


public class SelectMyLocationMeetingPoint extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_my_location_meeting_point);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser getCurrentUser = mAuth.getCurrentUser();


        initButtons();

    }

    private void initButtons() {
        MeetingPoints selectMPs;

        Button MP1 = findViewById(R.id.myListMP1);
        MP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                selectMPs = MapSelectionActivity.map1MeetingPoints();



                //Intent startIntent = new Intent(getApplicationContext(), MeetingPointFriendList.class);
                //startActivity(startIntent);
            }
        });

        Button MP2 = findViewById(R.id.myListMP2);
        MP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent startIntent = new Intent(getApplicationContext(), MeetingPointFriendList.class);
                //startActivity(startIntent);
            }
        });

        Button MP3 = findViewById(R.id.myListMP3);
        MP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent startIntent = new Intent(getApplicationContext(), MeetingPointFriendList.class);
                //startActivity(startIntent);
            }
        });

        Button MP4 = findViewById(R.id.myListMP4);
        MP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent startIntent = new Intent(getApplicationContext(), MeetingPointFriendList.class);
                //startActivity(startIntent);
            }
        });
    }

    //public static int getSelectMeetingPoint() { return selectMeetingPoint; }



}
