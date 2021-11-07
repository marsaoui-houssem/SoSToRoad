package tn.esprit.sostotoroadapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button login ;
    private Button signup ;
    private Button mapbtn ;
    private Button aboutUs ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.login);
        signup= findViewById(R.id.signup);
        mapbtn= findViewById(R.id.mapbtn);
        aboutUs= findViewById(R.id.aboutUsbtn);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frameLayout, new Login())
                .commit();

        login.setOnClickListener(view -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, new Login())
                    .commit();
        });

        signup.setOnClickListener(view -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, new Inscription())
                    .commit();
        });

        mapbtn.setOnClickListener(view -> {
            Fragment fragment = new MapsFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, fragment)
                    .commit();
        });
        aboutUs.setOnClickListener(view -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout, new AboutUs())
                    .commit();
        });

    }
}