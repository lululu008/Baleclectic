package ch.epfl.sdp.timetable;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

import ch.epfl.sdp.R;

public class Timetable extends AppCompatActivity {

    RecyclerView recyclerView;

    String activities_name[], description[];
    int images[] = {R.drawable.ac_dc,R.drawable.green_day, R.drawable.guns_and_roses, R.drawable.kiss,
    R.drawable.metallica, R.drawable.ministry, R.drawable.rh, R.drawable.sex_pistoles};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        recyclerView = findViewById(R.id.recyclerView);

        activities_name = getResources().getStringArray(R.array.activities_list);
        description = getResources().getStringArray(R.array.activities_description);


        // initialize the class inside the activity
        TimetableAdapter myAdapter = new TimetableAdapter(this, activities_name, description, images);
        //set adapter in ownCreate method
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Swipe button
        SwipeController swipeController = new SwipeController();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        toolbar();
    }

    private void toolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Timetable");
        toolbar.setSubtitle("View timetable here");

        setSupportActionBar(toolbar);

        //set press back button
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
