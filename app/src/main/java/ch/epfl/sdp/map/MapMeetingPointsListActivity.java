package ch.epfl.sdp.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import ch.epfl.sdp.MainLoginActivity;
import ch.epfl.sdp.R;

public class MapMeetingPointsListActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_meeting_points_list);

        initButtons();
    }

    private void initButtons() {
        Button MP1 = findViewById(R.id.listMP1);
        MP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MeetingPointFriendList.class);
                startActivity(startIntent);
            }
        });

        Button MP2 = findViewById(R.id.listMP2);
        MP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MeetingPointFriendList.class);
                startActivity(startIntent);
            }
        });

        Button MP3 = findViewById(R.id.listMP3);
        MP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MeetingPointFriendList.class);
                startActivity(startIntent);
            }
        });

        Button MP4 = findViewById(R.id.listMP4);
        MP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MeetingPointFriendList.class);
                startActivity(startIntent);
            }
        });
    }

}

