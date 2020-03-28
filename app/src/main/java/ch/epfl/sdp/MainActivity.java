package ch.epfl.sdp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import ch.epfl.sdp.map.MapSelectionActivity;
import ch.epfl.sdp.timetable.Timetable;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // timetable button
        Button timetableBtn = (Button)findViewById(R.id.timetableBtn);
        timetableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Timetable.class);
                startActivity(startIntent);
            }
        });

        Button mapBtn = (Button)findViewById(R.id.mapBtn);
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MapSelectionActivity.class);
                startActivity(startIntent);
            }
        });

        NewFunctions();

   }

    private void NewFunctions() {
        loginBtn();
        toolbar();
    }

    private void loginBtn() {
        Button mainloginBtn = (Button)findViewById((R.id.mainloginBtn));
        mainloginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), MainLoginActivity.class);
                startActivity(startIntent);
            }
        });
    }

    private void toolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar_mainActivity);
        toolbar.setTitle("Home Page");
        toolbar.setSubtitle("SubTitle");
        //set the logo on top
        toolbar.setLogo((R.mipmap.ic_launcher));

        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.ic_menu);

        //actions of popup menu
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_notifications:
                        Toast.makeText(MainActivity.this, "Notifications !", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_settings:
                        Toast.makeText(MainActivity.this, "Settings !", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_about:
                        Toast.makeText(MainActivity.this, "About !", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

}
