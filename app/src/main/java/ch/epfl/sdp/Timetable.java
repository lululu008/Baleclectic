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

        ItemTouchHelper.Callback callback = new SwipeController(mAdapter);
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
