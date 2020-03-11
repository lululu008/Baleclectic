package ch.epfl.sdp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MapSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_selection);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Map Selection");

        Button map1Btn = (Button)findViewById(R.id.mapSelect1Btn);


        map1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MeetingPoints map1MeetingPoints = map1MeetingPoints();
                Intent startIntent = new Intent(getApplicationContext(), MapsActivity.class);
                startIntent.putExtra("points", map1MeetingPoints);
                startIntent.putExtra("title", "Map 1");
                startActivity(startIntent);
            }
        });

        Button map2Btn = (Button)findViewById(R.id.mapSelect2Btn);
        map2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MeetingPoints map2MeetingPoints = new MeetingPoints();
                Intent startIntent = new Intent(getApplicationContext(), MapsActivity.class);
                startIntent.putExtra("points", map2MeetingPoints);
                startIntent.putExtra("title", "Map 2");
                startActivity(startIntent);
            }
        });

    }

    private MeetingPoints map1MeetingPoints() {

        MeetingPoints points = new MeetingPoints();

        MeetingPoint p1 = new MeetingPoint(46.5186, 6.5659, "Point 1");
        MeetingPoint p2 = new MeetingPoint(46.5199, 6.5661, "Point 2");
        MeetingPoint p3 = new MeetingPoint(46.5194, 6.5688, "Point 3");
        MeetingPoint p4 = new MeetingPoint(46.5184, 6.5681, "Point 4");

        points.add(p1).add(p2).add(p3).add(p4);

        return points;
    }
}
