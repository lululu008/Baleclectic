package ch.epfl.sdp.map;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ch.epfl.sdp.R;
import ch.epfl.sdp.timetable.TimetableAdapter;

public class MeetingPointFriendList extends AppCompatActivity {

    MeetingPoint meetingPoint;
    private String friendList[];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_friends);

        RecyclerView recyclerView;

        recyclerView = findViewById(R.id.recyclerView);
        ShowFriendRecyclerViewAdaptor myAdapter = new ShowFriendRecyclerViewAdaptor(this, meetingPoint);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
