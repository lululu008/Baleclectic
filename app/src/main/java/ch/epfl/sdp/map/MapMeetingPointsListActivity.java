package ch.epfl.sdp.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import ch.epfl.sdp.R;


public class MapMeetingPointsListActivity extends AppCompatActivity {

    private static int selectMeetingPoint = 0;

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
                setSelectMeetingPoint(0);
                Intent startIntent = new Intent(getApplicationContext(), MeetingPointFriendList.class);
                startActivity(startIntent);
            }
        });

        Button MP2 = findViewById(R.id.listMP2);
        MP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectMeetingPoint(1);
                Intent startIntent = new Intent(getApplicationContext(), MeetingPointFriendList.class);
                startActivity(startIntent);
            }
        });

        Button MP3 = findViewById(R.id.listMP3);
        MP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectMeetingPoint(3);
                Intent startIntent = new Intent(getApplicationContext(), MeetingPointFriendList.class);
                startActivity(startIntent);
            }
        });

        Button MP4 = findViewById(R.id.listMP4);
        MP1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setSelectMeetingPoint(4);
                Intent startIntent = new Intent(getApplicationContext(), MeetingPointFriendList.class);
                startActivity(startIntent);
            }
        });
    }

    public static int setSelectMeetingPoint(int index) {
        selectMeetingPoint = index;
        return index;
    }

    public static int getSelectMeetingPoint() { return selectMeetingPoint; }

}

