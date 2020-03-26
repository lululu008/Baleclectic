package ch.epfl.sdp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.graphics.Canvas;

import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Timetable extends AppCompatActivity {
    private MyAdapter mAdapter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        setMyAdapter();
        setupRecyclerView();
    }

    private void setMyAdapter() {
        // read data set
        List<Performance> performances = new ArrayList<>();
        try {
            InputStreamReader is = new InputStreamReader(getAssets().open("MusicFestival.csv"));
            BufferedReader reader = new BufferedReader(is);
            reader.readLine();
            String line;
            String[] st;
            while ((line = reader.readLine()) != null) {
                // split the data by ","
                st = line.split(",");
                Performance performance = new Performance();
                performance.setArtist(st[0]);
                performance.setDate(st[1]);
                performance.setStage(st[4]);
                performances.add(performance);
            }
        } catch (IOException e) {

        }

        mAdapter = new MyAdapter(performances);
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(mAdapter);
    }

    /*
    RecyclerView recyclerView;
    private MyAdapter mAdapter;
    SwipeController swipeController = null;

    String[] activities_name;
    String[] description;
    int[] images = {R.drawable.ac_dc,R.drawable.green_day, R.drawable.guns_and_roses, R.drawable.kiss,
    R.drawable.metallica, R.drawable.ministry, R.drawable.rh, R.drawable.sex_pistoles};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        setupRecyclerView();

        activities_name = getResources().getStringArray(R.array.activities_list);
        description = getResources().getStringArray(R.array.activities_description);

        // initialize the class inside the activity
        mAdapter = new MyAdapter(this, activities_name, description, images);
    }

    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter);

        // !!!
        swipeController = new SwipeController(new SwipeControllerActions() {
            @Override
            public void onRightClicked(int position) {
                mAdapter.players.remove(position);
                mAdapter.notifyItemRemoved(position);
                mAdapter.notifyItemRangeChanged(position, mAdapter.getItemCount());
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeController);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                swipeController.onDraw(c);
            }
        });
    }
    */
}
