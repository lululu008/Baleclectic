package ch.epfl.sdp.map;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import ch.epfl.sdp.R;

public class MeetingPointFriendList extends AppCompatActivity {

    MeetingPoint meetingPoint;
    private String friendList[];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_friends);

        RecyclerView recyclerView;

        int checkMeetingPoint = MapMeetingPointsListActivity.getSelectMeetingPoint();
        if (checkMeetingPoint == 1) {
            meetingPoint = new MeetingPoint(46.5186, 6.5659, "Place Cosandey");
        } else if (checkMeetingPoint == 2) {
            meetingPoint = new MeetingPoint(46.5199, 6.5661, "Esplanade");
        } else if (checkMeetingPoint == 3) {
            meetingPoint = new MeetingPoint(46.5194, 6.5688, "Avenue Piccard");
        } else {
            meetingPoint = new MeetingPoint(46.5184, 6.5681, "Rolex Learning Center");
        }

        recyclerView = findViewById(R.id.recyclerView);
        ShowFriendRecyclerViewAdaptor myAdapter = new ShowFriendRecyclerViewAdaptor(this, meetingPoint);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
