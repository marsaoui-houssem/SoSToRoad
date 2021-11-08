package tn.esprit.sostotoroadapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

public class mapsgoogleActivity extends AppCompatActivity {

    Spinner sptype;
    Button btFinder;
    SupportMapFragment supportMapFragment;
    GoogleMap googleMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapsgoogle);
        sptype= findViewById(R.id.sp_type);
        btFinder= findViewById(R.id.bt_finder);
        supportMapFragment= (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.google_map);

        String[] placeTypeliste ={"sos"};
        String[] placenameliste ={"SOS"};

        sptype.setAdapter(new ArrayAdapter<>(mapsgoogleActivity.this,
                android.R.layout.simple_spinner_dropdown_item,placenameliste));
    }
}