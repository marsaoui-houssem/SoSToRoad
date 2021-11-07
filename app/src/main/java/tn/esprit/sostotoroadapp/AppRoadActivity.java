package tn.esprit.sostotoroadapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.widget.Button;

public class AppRoadActivity extends AppCompatActivity {
    private Button profilbtn ;
    private Button mapbtnapp ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_road);

        profilbtn = findViewById(R.id.profilbtn);
        mapbtnapp= findViewById(R.id.mapbtnapp);


        profilbtn.setOnClickListener(view -> {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout2, new ProfileFragment())
                    .commit();
        });

        mapbtnapp.setOnClickListener(view -> {
            Fragment fragment = new MapsFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frameLayout2, fragment)
                    .commit();
        });
    }
}