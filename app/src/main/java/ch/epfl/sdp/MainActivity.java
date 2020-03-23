package ch.epfl.sdp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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
                Intent startIntent = new Intent(getApplicationContext(),MapSelectionActivity.class);
                startActivity(startIntent);
            }
        });

        NewFunctions();

   }

    private void NewFunctions() {
        loginBtn();
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
}


