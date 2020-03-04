package ch.epfl.sdp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
        MyAdapter myAdapter = new MyAdapter(this, activities_name, description, images);
        //set adapter in ownCreate method
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Swipe button
        SwipeController swipeController = new SwipeController();
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
