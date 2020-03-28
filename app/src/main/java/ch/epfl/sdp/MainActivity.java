package ch.epfl.sdp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import ch.epfl.sdp.map.MapSelectionActivity;
import ch.epfl.sdp.timetable.Timetable;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawer;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_topright, menu);
        return true;
    }

    private void toolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
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

        //for navigation bar
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,
                R.string.navigation_draw_open,R.string.navigation_draw_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed(){
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
