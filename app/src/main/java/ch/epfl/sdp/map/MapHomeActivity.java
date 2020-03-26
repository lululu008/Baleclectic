package ch.epfl.sdp.map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import ch.epfl.sdp.R;

public class MapHomeActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_home);

        intent = getIntent();

        initToolbar();

        initButtons();
    }

    private void initToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle(intent.getStringExtra("title") + " Home");
    }

    private void initButtons() {
        Button showMapBtn = findViewById(R.id.showMapBtn);
        showMapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferIntent(MapsActivity.class);
            }
        });

        Button showDistanceBtn = findViewById(R.id.showDistanceBtn);
        showDistanceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferIntent(DistanceActivity.class);
            }
        });

        Button showList = findViewById(R.id.findMyFriends);
        showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transferIntent(MapMeetingPointsListActivity.class);
            }
        });
    }

    private void transferIntent(Class cls) {

        Intent startIntent = new Intent(getApplicationContext(),  cls);

        Bundle extras = intent.getExtras();
        if (extras != null) {
            startIntent.putExtra("points", extras.getSerializable("points"));
            startIntent.putExtra("title", extras.getString("title"));
            if (extras.containsKey("isMock")) {
                startIntent.putExtra("isMock", extras.getBoolean("isMock"));
            }
            startActivity(startIntent);
        }

    }
}
