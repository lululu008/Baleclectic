package ch.epfl.sdp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class MainLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        Button signin_main = (Button)findViewById(R.id.signin_main);
        signin_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(startIntent);
            }
        });

        main_login_toolbar();
    }

    private void main_login_toolbar() {
        Toolbar logtool = findViewById(R.id.toolbar);
        logtool.setTitle("Sign In");
        logtool.setSubtitle("Sign in with Google or email");

        setSupportActionBar(logtool);

        //set press back button
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
