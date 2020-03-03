package ch.epfl.sdp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    String activities_name[],description[];
    int[] images = {R.drawable.sex_pistoles, R.drawable.ministry, R.drawable.metallica, R.drawable.kiss, R.drawable.guns_and_roses,
            R.drawable.ac_dc, R.drawable.green_day, R.drawable.rh};
    RecyclerView recyclerView;

    card_swipe_controll swipeController = new card_swipe_controll();
    ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
    itemTouchHelper.attachToRecyclerView(recyclerView);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        activities_name = getResources().getStringArray(R.array.activities_list);
        description = getResources().getStringArray(R.array.activities_description);

        // initialize the class inside the activity
        MyAdapter myAdapter = new MyAdapter(this, activities_name, description, images);
        //set adapter in ownCreate method
        recyclerView.setAdapter(myAdapter);
        //list of repeating views in the recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // timetable button
        Button timetableBtn = (Button)findViewById(R.id.timetableBtn);
        timetableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Timetable.class);
                startActivity(startIntent);
            }
        });
   }
}


